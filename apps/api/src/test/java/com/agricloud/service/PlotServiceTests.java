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
import com.agricloud.repository.PlotDataRepository;
import com.agricloud.repository.PlotRepository;
import com.agricloud.response.GeneralResponse;

public class PlotServiceTests {
    
    private PlotRepository plotRepository;
    private PlotDataRepository plotDataRepository;
    private PlotService plotService;

    @BeforeEach
    void setUp() {
        plotRepository = mock(PlotRepository.class);
        plotDataRepository = mock(PlotDataRepository.class);
        plotService = new PlotService(plotRepository, plotDataRepository);
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
        String plotName = "test plot";
        Integer accID = 1;
        PlotModel plot = new PlotModel();
        plot.setPlotName(plotName);
        plot.setAccountID(accID);
        when(plotRepository.findPlotModelByAccountIDAndPlotName(accID, plotName)).thenReturn(Optional.of(plot));

        // Act
        GeneralResponse response = plotService.info(plotName, accID);

        // Assert
        verify(plotRepository).findPlotModelByAccountIDAndPlotName(accID, plotName);
        assertEquals(plot, response.getBody());
        assertEquals("Successfully retrieved plot", response.getStatus());
    }

    @Test
    void testInfoPlotNotExists() {
        // Arrange
        String plotName = "test plot";
        Integer accID = 1;
        when(plotRepository.findPlotModelByAccountIDAndPlotName(accID, plotName)).thenReturn(Optional.empty());

        // Act
        GeneralResponse response = plotService.info(plotName, accID);

        // Assert
        verify(plotRepository).findPlotModelByAccountIDAndPlotName(accID, plotName);
        assertEquals("Plot doesn't exist with name " + plotName, response.getStatus());
    }

    @Test
    void testInfoError() {
        // Arrange
        String plotName = "test plot";
        Integer accID = 1;
        when(plotRepository.findPlotModelByAccountIDAndPlotName(accID, plotName)).thenThrow(new RuntimeException("Error retrieving plot"));

        // Act
        GeneralResponse response = plotService.info(plotName, accID);

        // Assert
        verify(plotRepository).findPlotModelByAccountIDAndPlotName(accID, plotName);
        assertEquals("Error occured while retrieving plot", response.getStatus());
    }

    @Test
    void testTerminatePlotExists() {
        // Arrange
        String plotName = "test plot";
        Integer accID = 1;
        PlotModel plot = new PlotModel();
        plot.setPlotName(plotName);
        plot.setAccountID(accID);
        when(plotRepository.findPlotModelByAccountIDAndPlotName(accID, plotName)).thenReturn(Optional.of(plot));

        // Act
        GeneralResponse response = plotService.terminate(plotName, accID);

        // Assert
        verify(plotRepository).findPlotModelByAccountIDAndPlotName(accID, plotName);
        verify(plotRepository).save(plot);
        assertEquals(plot, response.getBody());
        assertEquals("Successfully terminated plot", response.getStatus());
    }

    @Test
    void testTerminatePlotNotExists() {
        // Arrange
        String plotName = "test plot";
        Integer accID = 1;
        when(plotRepository.findPlotModelByAccountIDAndPlotName(accID, plotName)).thenReturn(Optional.empty());

        // Act
        GeneralResponse response = plotService.terminate(plotName, accID);

        // Assert
        verify(plotRepository).findPlotModelByAccountIDAndPlotName(accID, plotName);
        verifyNoMoreInteractions(plotRepository);
        assertEquals("Plot doesn't exist with plot name: " + plotName, response.getStatus());
    }

    @Test
    void testTerminateErrorSavingPlot() {
        // Arrange
        String plotName = "test plot";
        Integer accID = 1;
        when(plotRepository.findPlotModelByAccountIDAndPlotName(accID, plotName)).thenThrow(new RuntimeException("Error saving plot"));

        // Act
        GeneralResponse response = plotService.terminate(plotName, accID);

        // Assert
        verify(plotRepository).findPlotModelByAccountIDAndPlotName(accID, plotName);
        verifyNoMoreInteractions(plotRepository);
        assertEquals("Error occured while saving plot", response.getStatus());
    }

    

}
