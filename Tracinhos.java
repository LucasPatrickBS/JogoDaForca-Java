public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
        if(qtd <= 0)
            throw new Exception ("valor invalido");
            
        texto = new char[qtd];
        for(int i = 0; i < this.texto.length; i++)
        {
            this.texto[i] = '_';
        }
    }

    public void revele (int posicao, char letra) throws Exception
    {

        if(posicao < 0 || posicao >= this.texto.length)
        {
            throw new Exception ("Valor inválido");
        }
        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos ()
    {
        for(int i = 0;i<this.texto.length;i++){  
		    if (texto[i] == '_'){ 
                return true;
            }
        }
        return false;
    }

    public Tracinhos (Tracinhos t) throws Exception
    {
        if (t==null)
            throw new Exception ("Tracinho ausente");
        
        this.texto = t.texto;
    }

    @Override
    public Object clone ()
    {
        Tracinhos ret=null;
        
        try
        {
            ret = new Tracinhos (this);
        }
        catch (Exception erro)
        {}
        
        return ret;
    }

    @Override
    public String toString ()
    {
        String palavra = "";
        for(int i = 0;i<this.texto.length;i++){  
            palavra += Character.toString(texto[i]) + " ";
        }
        return palavra;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (this==obj) return true;

        if (obj==null) return false;
        
        if (obj.getClass() != Tracinhos.class) return false;
        
        if (this.texto != ((Tracinhos)obj).texto) return false;
        
        return true;
    }

    @Override
    public int hashCode ()
    {
        int  ret = 1;
        ret = 13*ret + new String (this.texto).hashCode();
        
        if (ret<0) 
            ret = -ret;

        return ret;
    }
}