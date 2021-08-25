package edu.tomerbu.addteststopeviousprojects.algorithms.searching;

import edu.tomerbu.addteststopeviousprojects.AddTestsToPeviousProjectsApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//Load the context: (Replaces @RunWith from JUnit 4)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AddTestsToPeviousProjectsApplication.class)
class BinarySearchImplTest {

    @Autowired
    BinarySearchImpl<Integer> binarySearch;

    @Test
    void testSearchBasicScenario() {
        int index = binarySearch.search(new Integer[]{1, 2, 3, 4}, 3);
        Assertions.assertEquals(2, index);
    }
}