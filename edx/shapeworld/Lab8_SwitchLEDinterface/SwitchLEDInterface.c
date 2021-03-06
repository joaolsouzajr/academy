// ***** 0. Documentation Section *****
// SwitchLEDInterface.c for Lab 8
// Runs on LM4F120/TM4C123
// Use simple programming structures in C to toggle an LED
// while a button is pressed and turn the LED on when the
// button is released.  This lab requires external hardware
// to be wired to the LaunchPad using the prototyping board.
// January 15, 2016
//      Jon Valvano and Ramesh Yerraballi

// ***** 1. Pre-processor Directives Section *****
#include "TExaS.h"
//#include "inc/tm4c123gh6pm.h"

#define SYSCTL_RCGC2_R          (*((volatile unsigned long *)0x400FE108))
#define GPIO_PORTE_DATA_R       (*((volatile unsigned long *)0x400243FC))
#define PE0											(*((volatile unsigned long *)0x40024004))
#define PE1											(*((volatile unsigned long *)0x40024008))
#define GPIO_PORTE_DIR_R        (*((volatile unsigned long *)0x40024400))
#define GPIO_PORTE_AFSEL_R      (*((volatile unsigned long *)0x40024420))
#define GPIO_PORTE_DEN_R        (*((volatile unsigned long *)0x4002451C))
#define GPIO_PORTE_AMSEL_R      (*((volatile unsigned long *)0x40024528))
#define GPIO_PORTE_PCTL_R       (*((volatile unsigned long *)0x4002452C))

// ***** 2. Global Declarations Section *****
//unsigned long In; // input from PE0

// FUNCTION PROTOTYPES: Each subroutine defined
void DisableInterrupts(void); // Disable interrupts
void EnableInterrupts(void);  // Enable interrupts

// ***** 3. Subroutines Section *****
void PortE_Init(void);
void delayms(unsigned long ms);


// PE0, PB0, or PA2 connected to positive logic momentary switch using 10k ohm pull down resistor
// PE1, PB1, or PA3 connected to positive logic LED through 470 ohm current limiting resistor
// To avoid damaging your hardware, ensure that your circuits match the schematic
// shown in Lab8_artist.sch (PCB Artist schematic file) or 
// Lab8_artist.pdf (compatible with many various readers like Adobe Acrobat).
int main(void){ 
//**********************************************************************
// The following version tests input on PE0 and output on PE1
//**********************************************************************
  TExaS_Init(SW_PIN_PE0, LED_PIN_PE1, ScopeOn);  // activate grader and set system clock to 80 MHz
  PortE_Init();
	
  EnableInterrupts();           // enable interrupts for the grader
	PE1 = 0x02;
  while(1){
		delayms(100);			// 100ms delay makes a 5Hz period
		if(PE0){
			PE1 ^= 0x02;		// toggle output
		}else{
      PE1 = 0x02; 		// LED on
    }
  }
  
}

void PortE_Init(void){
	volatile unsigned long delay;
	SYSCTL_RCGC2_R |= 0x10;           // Port E clock
  delay = SYSCTL_RCGC2_R;           // wait 3-5 bus cycles
  GPIO_PORTE_DIR_R = 0x02;        // PE0 input 
  GPIO_PORTE_AFSEL_R = 0x00;      // not alternative
  GPIO_PORTE_AMSEL_R = 0x00;      // no analog
  GPIO_PORTE_PCTL_R = 0x00000000; // bits for PE4,PE2,PE1,PE0
  GPIO_PORTE_DEN_R = 0x03;         // enable PE4,PE2,PE1,PE0
}

// Subroutine to delay in units of 1 msec
// Inputs: Number of ms to delay
// Outputs: None
void delayms(unsigned long ms){
  unsigned long count;
  while(ms > 0 ) { // repeat while there are still ms to delay
    count = 16000; // number of counts to delay 1ms at 80MHz
    while (count > 0) { 
      count--;
    } // This while loop takes approximately 3 cycles
    ms--;
  }
}

