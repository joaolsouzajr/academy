#include <stdint.h>
#include "stm32f4xx.h"

// Demostrating Uage of CMSIS Core APIs

int main(void)
{
	// Get and Set the special purpose registers com CMSIS APIs	
	uint32_t val;
	
	val = __get_PRIMASK();
	__set_PRIMASK(1);
	
		val = __get_FAULTMASK();
	__set_FAULTMASK(1);
	
	val = __get_BASEPRI();
	__set_BASEPRI(0x80);

	val = __get_MSP();
	__set_MSP(val+4);
	
	val = __get_PSP();
	__set_PSP(val+4);
	
	return 0;
}