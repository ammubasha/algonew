package com.algo.batch;

import javax.sql.DataSource;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

//@Configuration
public class BatchConfiguration {
	

		//volume reader
		@Bean
		public FlatFileItemReader<VolumeVO> volReader() {
		
			return new FlatFileItemReaderBuilder<VolumeVO>()
				.name("volumeItemReader")
				.resource(new ClassPathResource("volgain.csv"))
				.delimited()
				.names(new String[]{"stockSymbol", "stockDesc","stockVolume"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<VolumeVO>() {{
					setTargetType(VolumeVO.class);
				}})
				.build();
		}

		//volumejpawriter
		@Bean
		public ItemWriter<VolumeEntity> volJPAWriter(EntityManagerFactory entityManagerFactory) {
		    			
			JpaItemWriter<VolumeEntity> writer = new JpaItemWriter<>();
			
		    writer.setEntityManagerFactory(entityManagerFactory);
		    return writer;
		}
		
		
		
		@Bean
		public VolumeProcessor volProcessor() {
			return new VolumeProcessor();
		}

		//volume import voume
		@Bean
		public Job imporVolumeJob(JobRepository jobRepository,
				VolumeJobCompletionListener listener, Step stepVolumeJPAInsert) {
			return new JobBuilder("imporVolumeJob", jobRepository)
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(stepVolumeJPAInsert)
			//	.flow(stepVolumeInsert)
				.end()
				.build();
		}

		
		@Bean
		public Step stepVolumeJPAInsert(JobRepository jobRepository,
				PlatformTransactionManager transactionManager, ItemWriter<VolumeEntity> writer) {
			return new StepBuilder("stepVolumeInsert", jobRepository)
				.<VolumeVO, VolumeEntity> chunk(10, transactionManager)
				.reader(volReader())
				.processor(volProcessor())
				.writer(writer)
				.build();
		}

		@Bean
		public PersonItemProcessor processor() {
			return new PersonItemProcessor();
		}

	
	

}
