class Solution {
    public String convert(String s, int numRows) {

        if(numRows==1||s.length()<=numRows){
            return s;
        }        
        String rows[]= new String[numRows];
        Arrays.fill(rows,"");
        int currRow=0;
        boolean down=false;
        for(char c :s.toCharArray()){
            rows[currRow]+=c;
            if(currRow==0 || currRow==numRows-1){
                down=!down;
            }
            currRow+=down?1:-1;
        }

        String result="";
        for(String row : rows){
            result+=row;
        }

        return result;

    }
}