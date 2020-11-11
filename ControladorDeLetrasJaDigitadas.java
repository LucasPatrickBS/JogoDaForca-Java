public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas = "";//Inicia vazio, uma vez que o usuário ainda não digitou.
    }

    public boolean isJaDigitada (char letra)
    {
        char[] letras = new char[15]; //Inicia um array de char, para armazenar as letras já digitadas.
        
        for(int i = 0; i<this.letrasJaDigitadas.length() ; i++){  //for para varrer a string (por conceito, um conjunto de caracteres).
            letras[i] = this.letrasJaDigitadas.charAt(i); //atribui o caractere na posição indicada pelo indice, para que acompanhe a localização da string original.
            if(letras[i] == (letra)) { //verifica se o caractere já existe, retorna uma afirmação
                return true;
            }
        }
        return false; //A negativa é inevitável, caso a afirmativa não seja executada.
    }

    public void registre (char letra) throws Exception
    {
        if(this.isJaDigitada(letra) == true) //Resgata no método anterior, a validação.
            throw new Exception ("Letra já digitada!");

        this.letrasJaDigitadas += letra; //O registro da letra é inevitável, caso passe como falso na verificação.
    }

    @Override
    public String toString ()
    {
        String palavra = ""; //Inicia uma string.

        for(int i = 0;i<this.letrasJaDigitadas.length() ; i++){  
            palavra += letrasJaDigitadas.substring(i,i+1) + ", "; //Concatena a virgula, na string.
        }
        return palavra;
    }

    @Override
    public boolean equals (Object obj) //Faz uma série de validações com o this.
    {
        if (this == obj) return true;

        if (obj == null) return false;
        
        if (obj.getClass()!= ControladorDeLetrasJaDigitadas.class) return false;
        
        if (this.letrasJaDigitadas != ((ControladorDeLetrasJaDigitadas)obj).letrasJaDigitadas) return false;
        
        return true;
    }

    @Override
    public int hashCode () //Calcula o valor do méétodo hashCode para o this.
    {
        int  ret = 1;
        ret = 13*ret + new String(this.letrasJaDigitadas).hashCode();
        
        if (ret<0)
            ret = -ret;

        return ret;
    }

    public ControladorDeLetrasJaDigitadas(ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas) throws Exception
    { //construtor de cópia
        if (controladorDeLetrasJaDigitadas==null)
            throw new Exception ("Tracinho ausente");
        
        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    @Override
    public Object clone () //Método de clone
    {
        ControladorDeLetrasJaDigitadas ret=null;
        
        try{
            ret = new ControladorDeLetrasJaDigitadas (this);
        }
        catch (Exception erro){} //Ignora a possibilidade de erro.
        
        return ret;
    }
}