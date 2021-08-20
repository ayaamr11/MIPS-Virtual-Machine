# MIPS-Virtual-Machine
The virtual machine simulates the structure of MIPS-32 processor and can run the machine language program produced by the assembler. Our machine is able to do the following: 
<br>1- Provide a GUI to allow the user to see the status of the Program Counter, MIPS registers (or at least the important ones), the relevant part of the memory (were used variables are stored) and the currently executing instructions and its type (R, I, J), parts like opcode, registers, etc. </br>
<br>2- The machine will have buttons to execute the next instruction or the entire program.</br>
<br>3- Make the following assumptions: 	</br>
      <br>  Memory has only two segments: Text (Program) segment and Data segment. 	</br>
      <br>  The program is always loaded starting from memory location 0. (Start of text segment)</br> 	
      <br>  Data is stored starting from memory location 0x00001000. (Start of Data segment)</br>
