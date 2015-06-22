package com.suddtech.easyshop.service.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.suddtech.easyshop.model.Report;
@Service("itemProcessor")
public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {

		System.out.println("Processing..." + item);
		return item;
	}

}