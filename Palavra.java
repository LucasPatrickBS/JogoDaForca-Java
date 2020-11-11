public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        if(texto == null)
            throw new Exception ("Insira um texto");

        this.texto = texto;
    }

    public int getQuantidade(char letra) {
        int qtd = 0;
        for(int i = 0; i < this.texto.length(); i++) {
          if(this.texto.charAt(i)==(letra)) {
            qtd++;
          }
        }
        return qtd;
      }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        int[] aparicao = new int[15];
        char[] letras = new char[15];
        int qtdOcorrencia=0;

		for(int contador = 0;contador<this.texto.length();contador++){
            letras[contador] = this.texto.charAt(contador);
            if(letras[contador] == (letra)) {
                aparicao[qtdOcorrencia] = contador;
                qtdOcorrencia++;
            }
        }
        if(qtdOcorrencia == 0)
        {
            throw new Exception ("Iézima aparição não encontrada");
        }
        return aparicao[i];
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
    
    @Override
    public boolean equals (Object obj)
    {
        if (this==obj) return true;

        if (obj==null) return false;
        
        if (obj.getClass() != Palavra.class) return false;
        
        if (this.texto != ((Palavra)obj).texto) return false;
        
        return true;
    }

    @Override
    public int hashCode ()
    {
        int  ret = 1;
        ret = 13*ret + new String(this.texto).hashCode();
        
        if (ret<0)
            ret = -ret;

        return ret;
    }
}