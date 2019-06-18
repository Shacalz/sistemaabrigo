package util;

public class validarCPFeCNPJ {
   private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
   private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

   private static int calcularDigito(String str, int[] peso) {
      int soma = 0;
      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
         digito = Integer.parseInt(str.substring(indice,indice+1));
         soma += digito*peso[peso.length-str.length()+indice];
      }
      soma = 11 - soma % 11;
      return soma > 9 ? 0 : soma;
   }

   public static boolean isValidCPF(String cpf) {
       String cpf1 = "11111111111";
       String cpf2 = "22222222222";
       String cpf3 = "33333333333";
       String cpf4 = "44444444444";
       String cpf5 = "55555555555";
       String cpf6 = "66666666666";
       String cpf7 = "77777777777";
       String cpf8 = "88888888888";
       String cpf9 = "99999999999";
       
      if ((cpf==null) || (cpf.equals(cpf1)) || (cpf.equals(cpf2)) || (cpf.equals(cpf3)) || (cpf.equals(cpf4)) || (cpf.equals(cpf5)) || (cpf.equals(cpf6)) || (cpf.equals(cpf7)) || (cpf.equals(cpf8)) || (cpf.equals(cpf9)) || (cpf.length()!=11)) {
          return false;
      }

      Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
      Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
      return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
   }

   public static boolean isValidCNPJ(String cnpj) {
      if ((cnpj==null)||(cnpj.length()!=14) || cnpj.matches(cnpj.charAt(0) + "{14}")) return false;

      Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
      Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
      return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
   }
   
  public static String removeMask(String str){
    	StringBuffer pkWithoutMask = new StringBuffer("");
    	String pk = str;
    	try {
    		if (pk != null) {
    	    	for (int i = 0; pk.length() > i; i++) {
    	    		if (pk.charAt(i) != '.' && pk.charAt(i) != '-' && pk.charAt(i) != '/') {
    	    			pkWithoutMask.append(pk.charAt(i));
    	    		}
    		    }
    	    }
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return pkWithoutMask.toString().trim();
    }
}
