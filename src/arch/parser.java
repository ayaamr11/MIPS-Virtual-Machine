package arch;
import java.util.*;

public class parser {
    public static Vector code= new Vector();
    public Map<String,Integer> lables= new HashMap<String,Integer>(); 
    public Vector<String> op=new Vector<String>();
    public Vector<Vector> args=new Vector<Vector>();
//------------------------------------------------------------------------------
    private enum AVreg{$at,$a0,$a1,$a2,$a3,$v0,$v1};
    private enum Sreg{$s0,$s1,$s2,$s3,$s4,$s5,$s6,$s7};
    private enum Treg{$0,$t0,$t1,$t2,$t3,$t4,$t5,$t6,$t7,$t8,$t9};      
//------------------------------------------------------------------------------
    public boolean parser(String input){
        Scanner scanner = new Scanner(input);
        //read whole code
        if(code.isEmpty()){
            new implementation().regs(); //Intialize Registers
            new implementation().mem(); //Intialize Memory
            
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();   
                code.add(line);
            }
            scanner.close();
        
            readcode();
   
            //check validation 
            for(int i=0; i<code.size(); i++){ //check all instruction
                String x= this.op.get(i);
                Vector y=this.args.get(i);
                //System.out.println(x+" "+y);
                if(!check(x,y)){ //return false
                    //System.out.println(x+" fff "+y+" "+code.size());
                    return false;
                }
            }
        }else{
            readcode();
        }
        return true;
    }
//------------------------------------------------------------------------------ 
    private void readcode(){       
        
        for(int i=0; i<code.size(); i++){ //read single line
            String line= (String)code.get(i);
            String word="", op=""; Vector args=new Vector();
            
            for(int j=0; j<line.length(); j++){ //split line   
                String curr= String.valueOf(line.charAt(j));
                if(!curr.equals(" ")){ //read until find space
                    word+=curr;
                }
                else{ //word completed
                    if(word.charAt(word.length()-1)==':'){ //read lable
                        //check
                        word=word.substring(0,word.length()-1);
                        lables.put(word, i); 
                    }
                    else if(op.equals("")){ //read op
                        op=word;
                    }
                    else{ //read args
                        word=word.substring(0,word.length()-1);
                        args.add(word);
                    }
                    
                    word="";
                }
                if(j==line.length()-1){//insert last arg
                    args.add(word);
                }
            }//end line 
            this.op.add(op);
            this.args.add(args); 
        }
        
    }
    
    private boolean check(String op,Vector args){
        
        if(op.equals("lw") || op.equals("sw"))
        {
            if(args.size()==2){
                //check register
                boolean found=false;
                String curr=(String) args.get(0);
                for(Sreg c : Sreg.values()){
                    if (c.name().equals(curr)){found=true;}
                }
                for(Treg c : Treg.values()){
                    if (c.name().equals(curr)){found=true;}
                }
                if(found==false){return false;}    
                //check offset
                return true;
            }
        }
        else if(op.equals("add") || op.equals("sub") || op.equals("and")
                || op.equals("or") || op.equals("slt") )
        {
            if(args.size()==3){
                for(int i=0; i<args.size(); i++){
                    boolean found=false;
                    String curr=(String) args.get(i);
                    for(Sreg c : Sreg.values()){
                        if (c.name().equals(curr)){found=true;}
                    }
                    for(Treg c : Treg.values()){
                        if (c.name().equals(curr)){found=true;}
                    }
                    if(found==false){return false;}
                }
                return true;
            }
        }
        else if(op.equals("addi") || op.equals("andi") || op.equals("ori")
                || op.equals("sll") || op.equals("slti") )
        {
            if(args.size()==3){
                //check registers
                for(int i=0; i<args.size()-1; i++){
                    boolean found=false;
                    String curr=(String) args.get(i);
                    for(Sreg c : Sreg.values()){
                        if (c.name().equals(curr)){found=true;}
                    }
                    for(Treg c : Treg.values()){
                        if (c.name().equals(curr)){found=true;}
                    }
                    if(found==false){System.out.println(555);return false;}
                }
                //check constatnt
                String constant=(String) args.lastElement();
                for(int i=0; i<constant.length(); i++){
                    int curr= (int)constant.charAt(i);  
                    if(!(curr>=48 && curr<=57)){ //in ASCI=> 0=48, 9=57
                        System.out.println(11111);
                        return false;}
                }
                return true;
            }
        }
        else if(op.equals("lui"))
        {
            if(args.size()==2){
                //check register
                boolean found=false;
                String curr=(String) args.get(0);
                for(Sreg c : Sreg.values()){
                    if (c.name().equals(curr)){found=true;}
                }
                for(Treg c : Treg.values()){
                    if (c.name().equals(curr)){found=true;}
                }
                if(found==false){return false;}        
                //check constatnt
                String constant=(String) args.lastElement();
                for(int i=0; i<constant.length(); i++){
                    int cur= (int)constant.charAt(i);  
                    if(!(cur>=48 && cur<=57)) //in ASCI=> 0=48, 9=57
                        return false;
                }
                return true;
            }
        }
        else if(op.equals("beq") || op.equals("bne"))
        {
            if(args.size()==3){
                //check registers
                for(int i=0; i<args.size()-1; i++){
                    boolean found=false;
                    String curr=(String) args.get(i);
                    for(Sreg c : Sreg.values()){
                        if (c.name().equals(curr)){found=true;}
                    }
                    for(Treg c : Treg.values()){
                        if (c.name().equals(curr)){found=true;}
                    }
                    if(found==false){return false;}
                }
                //check lable
                String lable=(String) args.lastElement();
                if(!(lables.containsKey(lable)))
                    return false;
                
                return true;
            }
        } 
        else if(op.equals("j"))
        {
            if(args.size()==1){
                String lable=(String) args.get(0);
                if(!(lables.containsKey(lable)))
                    return false;
                
                return true;
            }
        } 
        else if(op.equals("jr"))
        {
            if(args.size()==1 && ((String)args.get(0)).equals("$ra"))
               return true;
        } 
        
        return false;
    }

}




