public class warmup {

    public static void main(String[] args) {

        System.out.println(transcribe("GGAAUU"));

    }

    public static String transcribe(String dnaStrand) {
        StringBuilder rnaComp = new StringBuilder();
        for (int i = 0; i < dnaStrand.length(); i++) {
            if (dnaStrand.charAt(i) == 'A') {
                rnaComp.append('U');
            } else if (dnaStrand.charAt(i) == 'U') {
                rnaComp.append('A');
            } else if (dnaStrand.charAt(i) == 'C') {
                rnaComp.append('G');
            } else if (dnaStrand.charAt(i) == 'G') {
                rnaComp.append('C');
            }
        }
        return rnaComp.toString();
    }
}