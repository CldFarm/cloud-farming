package com.agricloud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.agricloud.model.PlotModel;
import com.agricloud.repository.PlotRepository;
import com.agricloud.response.GeneralResponse;

public class PlotServiceTests {
    
    private PlotRepository plotRepository;
    private PlotService plotService;

    @BeforeEach
    void setUp() {
        plotRepository = mock(PlotRepository.class);
        plotService = new PlotService(plotRepository);
    }

    @Test
    void testCreatePlotNotNull() {
        // Arrange
        PlotModel plot = new PlotModel();
        when(plotRepository.save(plot)).thenReturn(plot);

        // Act
        GeneralResponse response = plotService.create(plot);

        // Assert
        verify(plotRepository).save(plot);
        assertEquals(plot, response.getBody());
        assertEquals("Successfully saved plot", response.getStatus());
    }

    @Test
    void testCreatePlotNull() {
        // Arrange
        PlotModel plot = null;

        // Act
        GeneralResponse response = plotService.create(plot);

        // Assert
        verifyNoInteractions(plotRepository);
        assertEquals("Plot cannot be null", response.getStatus());
    }

    @Test
    void testCreateErrorSavingPlot() {
        // Arrange
        PlotModel plot = new PlotModel();
        when(plotRepository.save(plot)).thenThrow(new RuntimeException("Error saving plot"));

        // Act
        GeneralResponse response = plotService.create(plot);

        // Assert
        verify(plotRepository).save(plot);
        assertEquals("Error occured with saving plot", response.getStatus());
    }

    @Test
    void testInfoPlotExists() {
        // Arrange
        Integer plotID = 1;
        PlotModel plot = new PlotModel();
        plot.setPlotID(plotID);
        when(plotRepository.findById(plotID)).thenReturn(Optional.of(plot));

        // Act
        GeneralResponse response = plotService.info(plotID);

        // Assert
        verify(plotRepository).findById(plotID);
        assertEquals(plot, response.getBody());
        assertEquals("Successfully retrieved plot", response.getStatus());
    }

    @Test
    void testInfoPlotNotExists() {
        // Arrange
        Integer plotID = 1;
        when(plotRepository.findById(plotID)).thenReturn(Optional.empty());

        // Act
        GeneralResponse response = plotService.info(plotID);

        // Assert
        verify(plotRepository).findById(plotID);
        assertEquals("Plot doesn't exist with ID " + plotID, response.getStatus());
    }

    @Test
    void testInfoError() {
        // Arrange
        Integer plotID = 1;
        when(plotRepository.findById(plotID)).thenThrow(new RuntimeException("Error retrieving plot"));

        // Act
        GeneralResponse response = plotService.info(plotID);

        // Assert
        verify(plotRepository).findById(plotID);
        assertEquals("Error occured while saving plot", response.getStatus());
    }

    @Test
    void testTerminatePlotExists() {
        // Arrange
        Integer plotID = 1;
        PlotModel plot = new PlotModel();
        plot.setPlotID(plotID);
        when(plotRepository.findById(plotID)).thenReturn(Optional.of(plot));

        // Act
        GeneralResponse response = plotService.terminate(plotID);

        // Assert
        verify(plotRepository).findById(plotID);
        verify(plotRepository).save(plot);
        assertEquals(plot, response.getBody());
        assertEquals("Successfully terminated plot", response.getStatus());
    }

    @Test
    void testTerminatePlotNotExists() {
        // Arrange
        Integer plotID = 1;
        when(plotRepository.findById(plotID)).thenReturn(Optional.empty());

        // Act
        GeneralResponse response = plotService.terminate(plotID);

        // Assert
        verify(plotRepository).findById(plotID);
        verifyNoMoreInteractions(plotRepository);
        assertEquals("Plot doesn't exist with plotid: " + plotID, response.getStatus());
    }

    @Test
    void testTerminateErrorSavingPlot() {
        // Arrange
        Integer plotID = 1;
        when(plotRepository.findById(plotID)).thenThrow(new RuntimeException("Error saving plot"));

        // Act
        GeneralResponse response = plotService.terminate(plotID);

        // Assert
        verify(plotRepository).findById(plotID);
        verifyNoMoreInteractions(plotRepository);
        assertEquals("Error occured while saving plot", response.getStatus());
    }

}
