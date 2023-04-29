package com.algo.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class VolumeProcessor implements ItemProcessor<VolumeVO, VolumeEntity> {

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

	public VolumeEntity process(VolumeVO volume) throws Exception {
		// TODO Auto-generated method stub
		/*final String firstName = person.getFirstName().toUpperCase();
		final String lastName = person.getLastName().toUpperCase();

		final Person transformedPerson = new Person(firstName, lastName);*/

		log.info("Converting (" + volume + ") into (" + volume + ")");

		VolumeEntity volEntity = new VolumeEntity(volume.getStockSymbol(),volume.getStockDesc(),Integer.valueOf(volume.getStockvolume()));
		return volEntity;
	}
}
