package com.kaikaku.stacks.service.company;

import com.kaikaku.stacks.exception.company.StacksNotFoundException;
import com.kaikaku.stacks.repository.company.StacksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {
    @InjectMocks
    private CompanyService companyService;

    @Mock
    private StacksRepository stacksRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllStacks_EmptyList_ThrowsStacksNotFoundException() {
        // given
        when(stacksRepository.findAll()).thenReturn(Arrays.asList());

        // when / then
        StacksNotFoundException exception = assertThrows(StacksNotFoundException.class, () -> {
            companyService.findAllStacks();
        });
        assertEquals("Loading Error", exception.getMessage());
        verify(stacksRepository, times(1)).findAll();
    }
}