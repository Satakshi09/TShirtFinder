package com.nagarro.trainee;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.comparator.PriceComprator;
import com.nagarro.comparator.RatingComparator;
import com.nagarro.entities.Cloth;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadFromCsv extends TimerTask {

	private String color;
	private String size;
	private String gender;
	private String outputPreference;
	private Timer timer;

	public ReadFromCsv() {
		// TODO Auto-generated constructor stub4
	}

	public ReadFromCsv(String color, String size, String gender, String outputPreference, Timer timer) {

		this.color = color;
		this.size = size;
		this.gender = gender;
		this.outputPreference = outputPreference;
		this.timer = timer;
	}

	List<Cloth> cloths = new ArrayList<Cloth>();

	HashSet<String> set = new HashSet<>();

	public Boolean getData() {

		File dir = new File("C:\\Users\\satakshi\\Desktop\\CsvFiles");

		String[] file = dir.list();

		if (file == null) {
			System.out.println("Either dir does not exist or is not a directory");
		} else {
			for (int i = 0; i < file.length; i++) {
				String filename = file[i];

				readDataLineByLine("C:\\Users\\satakshi\\Desktop\\CsvFiles\\" + filename);

			}

			List<Cloth> listCloth = new ArrayList<>();

			for (Cloth cl : cloths) {
				if (cl.getColour().equals(color) && cl.getSize().equals(size)
						&& cl.getGenderRecommendation().equals(gender)) {
					listCloth.add(cl);
				}

			}

			if (outputPreference.equals("Price")) {

				Collections.sort(listCloth, new PriceComprator());

			}

			else if (outputPreference.equals("Rating")) {

				Collections.sort(listCloth, new RatingComparator());
			}

			else if (outputPreference.equals("both")) {

				Collections.sort(listCloth, new PriceComprator().thenComparing(new RatingComparator()));

			}

			else {
				System.out.println("Wrong choice");
				return true;
			}

			if (listCloth.size() == 0 && Helper.firstVisit) {

				System.out.println("no tshirt found");

				Helper.firstVisit = false;

			} else if (listCloth.size() > 0) {

				for (Cloth cl : listCloth) {
					System.out.println(cl);
				}

				return true;

			}

		}
		return false;

	}

	public void readDataLineByLine(String file) {

		try {

			FileReader filereader = new FileReader(file);

			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();

			CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();

			List<String[]> allData = csvReader.readAll();

			int i = 0;

			for (String[] row : allData) {
				if (i == 0) {
					i = 1;
					continue;
				}

				Cloth cloth = new Cloth();

				int j = 0;
				Boolean idContainInset = false;

				for (String cell : row) {

					if (j == 5 || j == 6) {
						if (j == 5) {
							cloth.setPrice(Double.parseDouble(cell));
						} else {
							cloth.setRating(Double.parseDouble(cell));
						}
					} else {
						if (j == 0) {

							if (!set.contains(cell)) {

								cloth.setId(cell);

								set.add(cell);

							} else {
								idContainInset = true;

							}

						} else if (j == 1) {
							cloth.setName(cell);
						} else if (j == 2) {
							cloth.setColour(cell);
						} else if (j == 3) {
							cloth.setGenderRecommendation(cell);
						} else if (j == 4) {
							cloth.setSize(cell);
						} else if (j == 7) {
							cloth.setAvailability(cell);
						}

					}

					j++;

				}

				if (!idContainInset)
					cloths.add(cloth);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		synchronized (this) {

			if (getData()) {
				timer.cancel();
			}

		}

	}
}