package com.ohmin839.jplgr.web.api.domain.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.ohmin839.jplgr.web.api.config.DatabaseConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DatabaseConfig.class})
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class
})
@DbUnitConfiguration(databaseConnection = "dataSource")
@Transactional
public class TRawWordRepositoryTest {

    @Autowired
    TRawWordRepository tRawWordRepository;

    @Nested
    class InsertWordsTest {
        @Test
        @DatabaseSetup(
            value = "TRawWordRepositoryTestSetup.xml"
        )
        @ExpectedDatabase(
            value = "TRawWordRepositoryTestExpected.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT
        )
        void testInsertWords() throws Exception {
            List<String> words = List.of("ἄνθρωπος", "τέχνη");
            int resultCount = tRawWordRepository.insertWords(words);
            assertEquals(1, resultCount);
        }
    }
}
