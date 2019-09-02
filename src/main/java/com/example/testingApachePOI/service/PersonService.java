package com.example.testingApachePOI.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import com.example.testingApachePOI.entity.Person;
import lombok.Cleanup;

@Service
public class PersonService {

    public List<Person> createPerson() throws IOException {

        @Cleanup FileInputStream fileInputStream = new FileInputStream("src/main/resources/PersonAge.xlsx");

        List<Person> people = new ArrayList<>();

        Workbook wbs = WorkbookFactory.create(fileInputStream);

        Sheet sheet = wbs.getSheetAt(0);

        List<Row> rows = (List<Row>) toList(sheet.rowIterator());

        rows.remove(0);

        rows.forEach(row ->{

           List<Cell> cells = (List<Cell>) toList(row.cellIterator());


           Person person = Person.builder()
               .name(cells.get(0).getStringCellValue())
               .age(cells.get(1).getStringCellValue())
               .build();

           people.add(person);
        });

        return people;
    }

    public List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }



}
