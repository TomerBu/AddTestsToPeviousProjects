package edu.tomerbu.addteststopeviousprojects;

import edu.tomerbu.addteststopeviousprojects.algorithms.searching.BinarySearchImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AddTestsToPeviousProjectsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(AddTestsToPeviousProjectsApplication.class, args);


        BinarySearchImpl<Integer> binarySearch = app.getBean(BinarySearchImpl.class);
        BinarySearchImpl<Integer> binarySearch2 = app.getBean(BinarySearchImpl.class);
        int index = binarySearch.search(new Integer[]{1, 2, 3}, 2);
        System.out.println(index);

        System.out.println(binarySearch);
        System.out.println(binarySearch2);
        System.out.println(binarySearch == binarySearch2);
    }

}
