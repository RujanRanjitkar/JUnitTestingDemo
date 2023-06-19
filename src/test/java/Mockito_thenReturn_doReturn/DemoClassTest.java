package Mockito_thenReturn_doReturn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Test for mockito thenReturn and doReturn")
class DemoClassTest {

    @Test
    @DisplayName("Test for thenReturn")
    public void getValueTest() {
        DemoClass demoMock = mock(DemoClass.class);
        when(demoMock.getValue()).thenReturn(10);
        int result = demoMock.getValue();
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Test for donothing")
    public void setValueTest() {
        DemoClass demoMock = mock(DemoClass.class);
        doNothing().when(demoMock).setValue(10);
        demoMock.setValue(10);
        verify(demoMock, times(1)).setValue(10);
    }
}