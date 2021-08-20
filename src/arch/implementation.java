package arch;
import java.util.*;

public class implementation {
    parser p= new parser();
    private gui form= new gui();
     
    static Vector reg= new Vector();
    static Vector<Integer> reg_val = new Vector<Integer>();
    
    public static int storedc=50,instc=0;
    static HashMap<String,Integer> stored  = new HashMap<>(); //fisrt for name ,2nd for index in mem
    static Vector<String>mem_val= new Vector(); //from 0 to 50 for instructions 
    static Vector mem= new Vector();
 //------------------------------------------------------------------------------
    public void implementation(String input, String flag){
        if(p.parser(input)){
            if(flag!=null){ //execute next instruction; 
                int pc=Integer.parseInt(flag);
                String op= p.op.get(pc);
                Vector args=p.args.get(pc);
                int idx=execute(op, args);
                    if(idx!= -1){form.pc=idx;} //jumb

            }else{
                for(int i=0; i<p.code.size(); i++){
                    String op= p.op.get(i);
                    Vector args=p.args.get(i);
                    int idx=execute(op, args);
                    if(idx!= -1){i=idx;} //jumb
                }         
            }
        }else{
            System.out.println("Error!, Invaild Instruction");
        }        
    }
    
    private int execute(String op, Vector args){
        if(op.equals("addi")){
            int result_idx= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int x= Integer.parseInt((String)args.get(2));
            
            reg_val.set(result_idx,(r1+x));
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result_idx)+"= "+reg_val.get(result_idx));
            
            //memory update
            String opp="001000";
            String rt=check_zero(Integer.toBinaryString(result_idx),5);
            String rs= check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String imm=check_zero(Integer.toBinaryString(x),16);
            
            String instruc= opp+rs+rt+imm;
            
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("add")){
            int result= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int r2= reg_val.get(reg.indexOf(args.get(2)));
            
            reg_val.set(result,(r1+r2));
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result)+"= "+reg_val.get(result));
            
            //memory update
            String zero6="000000"; String zero5="00000";
            String rd=check_zero(Integer.toBinaryString(result),5); 
            String rs = check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String rt= check_zero(Integer.toBinaryString(reg.indexOf(args.get(2))),5);
            String func = check_zero(Integer.toBinaryString(32),6); 
           
            String instruc =zero6 +rs +rt+rd +zero5+func;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("sub")){
            int result= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int r2= reg_val.get(reg.indexOf(args.get(2)));
            
            reg_val.set(result,(r1-r2));
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result)+"= "+reg_val.get(result));
            
            //memory update
            String zero6="000000"; String zero5="00000";
            String rd=check_zero(Integer.toBinaryString(result),5); 
            String rs = check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String rt= check_zero(Integer.toBinaryString(reg.indexOf(args.get(2))),5);
            String func = check_zero(Integer.toBinaryString(34),6); 
           
            String instruc =zero6 +rs +rt+rd +zero5+func;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("and")){
            int result= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int r2= reg_val.get(reg.indexOf(args.get(2)));
            
            reg_val.set(result,(r1&r2));
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result)+"= "+reg_val.get(result));
            
            //memory update
            String zero6="000000"; String zero5="00000";
            String rd=check_zero(Integer.toBinaryString(result),5); 
            String rs = check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String rt= check_zero(Integer.toBinaryString(reg.indexOf(args.get(2))),5);
            String func = "100100"; 
           
            String instruc =zero6 +rs +rt+rd +zero5+func;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("or")){
            int result= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int r2= reg_val.get(reg.indexOf(args.get(2)));
            
            reg_val.set(result,(r1|r2));
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result)+"= "+reg_val.get(result));
            
            //memory update
            String zero6="000000"; String zero5="00000";
            String rd=check_zero(Integer.toBinaryString(result),5); 
            String rt = check_zero(Integer.toBinaryString(reg.indexOf(args.get(2))),5);
            String rs= check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String func = "100101"; 
           
            String instruc =zero6 +rs +rt+rd +zero5+func;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("andi")){
            int result_idx= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int x = Integer.valueOf((String)args.get(2));
            
            reg_val.set(result_idx,(r1&x));
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result_idx)+"= "+reg_val.get(result_idx)); 
            
            //memory update
            String opp="001100";
            String rt=check_zero(Integer.toBinaryString(result_idx),5);
            String rs= check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String imm=check_zero(Integer.toBinaryString(x),16);
            
            String instruc= opp+rs+rt+imm;
            
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("ori")){
            int result_idx= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int x = Integer.valueOf((String)args.get(2));
            
            reg_val.set(result_idx,(r1|x));
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result_idx)+"= "+reg_val.get(result_idx));
            
            //memory update
            String opp="001101";
            String rt=check_zero(Integer.toBinaryString(result_idx),5);
            String rs= check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String imm=check_zero(Integer.toBinaryString(x),16);
            
            String instruc= opp+rs+rt+imm;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("sll")){
            int result_idx= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int x = Integer.valueOf((String)args.get(2));
            
            reg_val.set(result_idx,(r1<<x));
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result_idx)+"= "+reg_val.get(result_idx));
            
            //memory update
            String zero6="000000";
            String rd=check_zero(Integer.toBinaryString(result_idx),5); 
            String rs = "000000";
            String rt = check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String sa=check_zero(Integer.toBinaryString(x),5);
           
            String func = "000000"; 
           
            String instruc =zero6 +rs +rt+rd +sa+func;
            
             //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else  if(op.equals("slt")){
            int result_idx= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int r2= reg_val.get(reg.indexOf(args.get(2)));
            if (r1<r2) {
            	reg_val.set(result_idx,1);
            }
            else {
            	reg_val.set(result_idx,0);
            }
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result_idx)+"= "+reg_val.get(result_idx));
           
            //memory update
            String zero6="000000"; String zero5="00000";
            String rd=check_zero(Integer.toBinaryString(result_idx),5); 
            String rs = check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String rt= check_zero(Integer.toBinaryString(reg.indexOf(args.get(2))),5);
            String func = "101010"; 
           
            String instruc =zero6 +rs +rt+rd +zero5+func;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("slti")){
            int result_idx= reg.indexOf(args.get(0));
            int r1= reg_val.get(reg.indexOf(args.get(1)));
            int x = Integer.valueOf((String)args.get(2));
            if(r1<x) {
            	reg_val.set(result_idx,1);
            }
            else {
            	reg_val.set(result_idx,0);
            }
            
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result_idx)+"= "+reg_val.get(result_idx)); 
            
            //memory update
            String opp="001101";
            String rt=check_zero(Integer.toBinaryString(result_idx),5);
            String rs= check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
            String imm=check_zero(Integer.toBinaryString(x),16);
            
            String instruc= opp+rs+rt+imm;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("lui")){
            int result_idx= reg.indexOf(args.get(0));
            int x = Integer.valueOf((String)args.get(1));
            
            reg_val.set(result_idx,(x<<16));
            form.addreg(reg, reg_val);
            System.out.println(op+" "+reg.get(result_idx)+"= "+reg_val.get(result_idx));
            
            //memory update
            String opp="001111";
            String rt=check_zero(Integer.toBinaryString(result_idx),5);
            String rs= "000000";
            String imm=check_zero(Integer.toBinaryString(x),16);
            
            String instruc= opp+rs+rt+imm;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
        }
        else if(op.equals("j")){
            String lable = (String)args.get(0);
            int idx=p.lables.get(lable);
           
            //memory update
            String opp="000010";
            String add=check_zero(Integer.toBinaryString(idx),26);
            
            String instruc= opp+add;
          
            
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
            form.addmemo(mem,mem_val);
            
            return idx-1;
            
        }
        else if(op.equals("beq")){
            int r1= reg_val.get(reg.indexOf(args.get(0)));
            int r2= reg_val.get(reg.indexOf(args.get(1)));
            String lable = (String)args.get(2);
            int idx=p.lables.get(lable);
            if(r1==r2){
                System.out.println("True, "+args.get(0)+"="+args.get(1));
          
                //memory update
                String opp="000100";
                String rs=check_zero(Integer.toBinaryString(reg.indexOf(args.get(0))),5);
                String rt= check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
                String imm=check_zero(Integer.toBinaryString(idx),16);
                String instruc= opp+rs+rt+imm;


                //add to memory
                Long decimal = Long.parseLong(instruc,2);
                String hex = Long.toString(decimal,16);
                mem_val.set(instc, hex);
                instc++;
                form.addmemo(mem,mem_val);
                return idx-1;
                
            }else{//limited code size
                System.out.println("False, "+args.get(0)+"!="+args.get(1));
                p.code.remove(idx);
                
                //memory update
                String opp="000100";
                String rs=check_zero(Integer.toBinaryString(reg.indexOf(args.get(0))),5);
                String rt= check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
                String imm=check_zero(Integer.toBinaryString(idx),16);
                String instruc= opp+rs+rt+imm;


                //add to memory
                Long decimal = Long.parseLong(instruc,2);
                String hex = Long.toString(decimal,16);
                mem_val.set(instc, hex);
                instc++;
                form.addmemo(mem,mem_val);
            }
        }
        else if(op.equals("bne")){
            int r1= reg_val.get(reg.indexOf(args.get(0)));
            int r2= reg_val.get(reg.indexOf(args.get(1)));
            String lable = (String)args.get(2);
            int idx=p.lables.get(lable);
            if(r1!=r2){
                System.out.println("True, "+args.get(0)+"!="+args.get(1));
                
                //memory update
                String opp="000101";
                String rs=check_zero(Integer.toBinaryString(reg.indexOf(args.get(0))),5);
                String rt= check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
                String imm=check_zero(Integer.toBinaryString(idx),16);
                String instruc= opp+rs+rt+imm;

                //add to memory
                Long decimal = Long.parseLong(instruc,2);
                String hex = Long.toString(decimal,16);
                mem_val.set(instc, hex);
                instc++;
                form.addmemo(mem,mem_val);
                
                return idx-1;
                
            }else{//limited code size
                System.out.println("False, "+args.get(0)+"="+args.get(1));
                p.code.remove(idx);
                
                //memory update
                String opp="000101";
                String rs=check_zero(Integer.toBinaryString(reg.indexOf(args.get(0))),5);
                String rt= check_zero(Integer.toBinaryString(reg.indexOf(args.get(1))),5);
                String imm=check_zero(Integer.toBinaryString(idx),16);
                String instruc= opp+rs+rt+imm;

                //add to memory
                Long decimal = Long.parseLong(instruc,2);
                String hex = Long.toString(decimal,16);
                mem_val.set(instc, hex);
                instc++;
                form.addmemo(mem,mem_val);
            }
        }
        else if (op.equals("lw")) { //start to load or store drom 100
            int result_idx= reg.indexOf(args.get(0)); //target
            String name=(String) args.get(1);
            int index=stored.get(name);
            reg_val.set(result_idx,Integer.parseInt(mem_val.get(index)) );
            //memory update
            String opp="100011";
            String rt=check_zero(Integer.toBinaryString(result_idx),5);
            String rs= "000000";
            String imm=check_zero(Integer.toBinaryString(index),16);

            String instruc= opp+rs+rt+imm;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;

        }
        else if (op.equals("sw")) {
            int r= reg_val.get(reg.indexOf(args.get(0))); //source
            String name=(String) args.get(1);
            mem_val.set(storedc,String.valueOf(r));
            stored.put(name,storedc);
            storedc++;

            //memory update
            String opp="101011";
            String rt=check_zero(Integer.toBinaryString(reg.indexOf(args.get(0))),5);
            String rs= "000000";
            String imm=check_zero(Integer.toBinaryString(storedc-1 ),16);

            String instruc= opp+rs+rt+imm;
            //add to memory
            Long decimal = Long.parseLong(instruc,2);
            String hex = Long.toString(decimal,16);
            mem_val.set(instc, hex);
            instc++;
        }
        
        return -1;
    }
//------------------------------------------------------------------------------    
    public void regs(){ //intialize regs and ref_val
        reg.add("$0");reg.add("$at");reg.add("$v0");reg.add("$v1");
        reg.add("$a0");reg.add("$a1");reg.add("$a2");reg.add("$a3");
        reg.add("$t0");reg.add("$t1");reg.add("$t2");reg.add("$t3");
        reg.add("$t4");reg.add("$t5");reg.add("$t6");reg.add("$t7");
        reg.add("$s0");reg.add("$s1");reg.add("$s2");reg.add("$s3");
        reg.add("$s4");reg.add("$s5");reg.add("$s6");reg.add("$s7");
        reg.add("$t8");reg.add("$t9"); reg.add("$k0");reg.add("$k1");
        reg.add("$gb");reg.add("$sb"); reg.add("$fb");reg.add("$ra");

        for(int i=0; i<reg.size(); i++)
            reg_val.add(i,0);
 
    }
         
    public void mem() { //intialize memory vals
        mem.add("0x00000190");
        mem.add("0x0000018C");
        mem.add("0x00000188");
        mem.add("0x00000184");
        mem.add("0x00000180");
        mem.add("0x0000017C");
        mem.add("0x00000178");
        mem.add("0x00000174");
        mem.add("0x00000170");
        mem.add("0x0000016C");
        mem.add("0x00000168");
        mem.add("0x00000164");
        mem.add("0x00000160");
        mem.add("0x0000015C");
        mem.add("0x00000158");
        mem.add("0x00000154");
        mem.add("0x00000150");
        mem.add("0x0000014C");
        mem.add("0x00000148");
        mem.add("0x00000144");
        mem.add("0x00000140");
        mem.add("0x0000013C");
        mem.add("0x00000138");
        mem.add("0x00000134");
        mem.add("0x00000130");
        mem.add("0x0000012C");
        mem.add("0x00000128");
        mem.add("0x00000124");
        mem.add("0x00000120");
        mem.add("0x0000011C");
        mem.add("0x00000118");
        mem.add("0x00000114");
        mem.add("0x00000110");
        mem.add("0x0000010C");
        mem.add("0x00000108");
        mem.add("0x00000104");
        mem.add("0x00000100");
        mem.add("0x000000FC");
        mem.add("0x000000F8");
        mem.add("0x000000F4");
        mem.add("0x000000F0");
        mem.add("0x000000EC");
        mem.add("0x000000E8");
        mem.add("0x000000E4");
        mem.add("0x000000E0");
        mem.add("0x000000DC");
        mem.add("0x000000D8");
        mem.add("0x000000D4");
        mem.add("0x000000D0");
        mem.add("0x000000CC");
        mem.add("0x000000C8");
        mem.add("0x000000C4");        
        mem.add("0x000000C0");
        mem.add("0x000000BC");
        mem.add("0x000000B8");
        mem.add("0x000000B4");
        mem.add("0x000000B0");
        mem.add("0x000000AC");
        mem.add("0x000000A8");
        mem.add("0x000000A4");
        mem.add("0x000000A0");
        mem.add("0x000000C4");
        mem.add("0x000000C0");
        mem.add("0x000000BC");
        mem.add("0x000000B8");
        mem.add("0x000000B4");
        mem.add("0x000000B0");
        mem.add("0x000000AC");
        mem.add("0x000000A8");
        mem.add("0x000000A4");
        mem.add("0x000000A0");
        mem.add("0x0000009C");
        mem.add("0x00000098");
        mem.add("0x00000094");
        mem.add("0x00000090");
        mem.add("0x0000008C");
        mem.add("0x00000088");
        mem.add("0x00000084");
        mem.add("0x00000080");
        mem.add("0x0000007C");
        mem.add("0x00000078");
        mem.add("0x00000074");
        mem.add("0x00000070");
        mem.add("0x0000006C");
        mem.add("0x00000068");
        mem.add("0x00000064");
        mem.add("0x00000060");
        mem.add("0x0000005C");
        mem.add("0x00000058");
        mem.add("0x00000054");
        mem.add("0x00000050");
        mem.add("0x0000004C");
        mem.add("0x00000048");
        mem.add("0x00000044");
        mem.add("0x00000040");
        mem.add("0x0000003C");
        mem.add("0x00000038");
        mem.add("0x00000034");
        mem.add("0x00000030");
        mem.add("0x0000002C");
        mem.add("0x00000028");
        mem.add("0x00000024");
        mem.add("0x00000020");
        mem.add("0x0000001C");
        mem.add("0x00000018");
        mem.add("0x00000014");
        mem.add("0x00000010");
        mem.add("0x0000000C");
        mem.add("0x00000008");
        mem.add("0x00000004");
        mem.add("0x00000000");
        
    	for(int i=0; i<mem.size(); i++)
            mem_val.add(i,"0");
    }

    private String check_zero(String code , int base ) {
    	int c= base-code.length();
    	for(int i=0;i<c;i++) {
    		code ="0"+code;
    	}
    	return code;
    }
}
