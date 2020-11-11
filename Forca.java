import java.io.*;

public class Forca
{
    public static void main (String args [])
    {
        char continuar = ' ';

        do
        {
            try
            {
                Palavra palavra =
                BancoDePalavras.getPalavraSorteada();
                Tracinhos tracinhos =
                new Tracinhos (palavra.getTamanho());

                ControladorDeLetrasJaDigitadas
                controladorDeLetrasJaDigitadas =
                new ControladorDeLetrasJaDigitadas ();
                
                ControladorDeErros controladorDeErros =
                new ControladorDeErros ((int)(palavra.getTamanho()*0.6));

                while (tracinhos.isAindaComTracinhos() &&
                      !controladorDeErros.isAtingidoMaximoDeErros())
                {
                    System.out.println ("Palavra...: "+tracinhos);
                    System.out.println ("Digitadas.: "+controladorDeLetrasJaDigitadas);
                    System.out.println ("Erros.....: "+controladorDeErros);

                    System.out.print   ("Qual letra? ");
                    char letra = Character.toUpperCase (Teclado.getUmChar());

                    if (controladorDeLetrasJaDigitadas.isJaDigitada (letra))
                        System.err.println ("Essa letra ja foi digitada!\n");
                    else
                    {
                        controladorDeLetrasJaDigitadas.registre (letra);

                        int qtd = palavra.getQuantidade (letra);

                        if (qtd==0)
                        {
                            System.err.println ("A palavra nao tem essa letra!\n");
                            controladorDeErros.registreUmErro ();
                        }
                        else
                        {
                            for (int i=0; i<qtd; i++)
                            {
                                int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,letra);
                                tracinhos.revele (posicao, letra);
							}
                            System.out.println ();
                        }
                    }
                }

                if (controladorDeErros.isAtingidoMaximoDeErros ())
                    System.out.println ("Que pena! Voce perdeu! A palavra era "+palavra+"\n");
                else
                    System.out.println ("Parabens! Voce ganhou! A palavra era mesmo "+palavra+"\n");

                for(;;)
                {
                    try
                    {
                        System.out.print ("Deseja jogar de novo (S/N)? ");
                        continuar = Character.toUpperCase (Teclado.getUmChar());
                        if (continuar!='S' && continuar!='N')
                            System.err.println ("Opcao invalida! Tente novamente...");
                        else
                            break;
                    }
                    catch (Exception erro)
                    {
                        System.err.println ("Opcao invalida! Tente novamente...");
                    }
                }
            }
            catch (Exception erro)
            {
                System.err.println (erro.getMessage());
            }
        }
        while (continuar=='S');
    }
}