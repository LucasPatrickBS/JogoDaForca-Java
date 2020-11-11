public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        if(qtdMax < 0 )
            throw new Exception ("Valor inválido");
        this.qtdMax = qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        if (this.qtdErr == this.qtdMax)
        {
            throw new Exception ("Valor inválido");
        }
        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        if (this.qtdErr == this.qtdMax)
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception
    {
        if (c==null)
            throw new Exception ("Tracinho ausente");
    
        this.qtdMax = c.qtdMax;
        this.qtdErr = c.qtdErr;
    }

    @Override
    public Object clone ()
    {
        ControladorDeErros ret=null;
        
        try
        {
            ret = new ControladorDeErros (this);
        }
        catch (Exception erro)
        {}
        
        return ret;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (this==obj) return true;

        if (obj==null) return false;
        
        if (obj.getClass() != ControladorDeErros.class) return false;
        
        if (this.qtdMax != ((ControladorDeErros)obj).qtdMax) return false;
        if (this.qtdErr != ((ControladorDeErros)obj).qtdErr) return false;
        
        return true;
    }

    @Override
    public int hashCode ()
    {
        int  ret = 1;
        ret = 13*ret + new Integer(this.qtdMax).hashCode();
        ret = 13*ret + new Integer(this.qtdErr).hashCode();
        
        if (ret<0)
            ret = -ret;

        return ret;        
    }
}