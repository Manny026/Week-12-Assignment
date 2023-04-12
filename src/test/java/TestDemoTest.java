import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
	
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		 testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(-2, -1, 0, true),
				arguments(0, 0, 0, true),
				arguments(Integer.MAX_VALUE, 1, Integer.MIN_VALUE, false),
				arguments(Integer.MIN_VALUE, -1, Integer.MAX_VALUE, true)
				);
				
		
	}
	@Test
	void assertThatNumberSqaureIsCorrect() {
		TestDemo mockDemo = spy(new TestDemo());
		doReturn(5).when(mockDemo).getRandomInt();
		
		int actual = mockDemo.randomNumberSquared();
		int expected = 25;
		
		assertThat(actual).isEqualTo(expected);
		
	}


	}


