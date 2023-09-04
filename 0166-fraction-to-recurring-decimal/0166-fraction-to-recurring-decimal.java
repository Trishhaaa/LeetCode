class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if(numerator==0){
            return "0";
        }
        if(denominator==0){
            return "";
        }
        int sign=1;
        if((numerator<0 && denominator>0)|| (numerator>0 && denominator<0)){
            sign=-1;
        }
        StringBuilder result= new StringBuilder();
        if(sign==-1){
            result.insert(0,"-");
        }
        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);

        //Integral part
        result.append(num/den);
        num%=den;

        //fractional part
        if(num!=0){
            result.append(".");
            Map<Long, Integer> map= new HashMap<>();
            map.put(num,result.length());

            while(num!=0){
                num*=10;
                result.append(num/den);
                num%=den;

                if(map.containsKey(num)){
                    int index=map.get(num);
                    result.insert(index,"(");
                    result.append(")");
                    break;
                }
                else{
                    map.put(num,result.length());
                }
            }
        }

        return result.toString();
    }
}