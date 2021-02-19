using System;
using System.Globalization;

namespace introducao
{
    class Program
    {
        static void Main(string[] args)
        {
           Pessoal pI,pII;

           pI = new Pessoal();
           pII = new Pessoal();

           Console.WriteLine("Dados da primeira pessoa:");
           Console.WriteLine("Nome:");
           pI.nome = Console.ReadLine();
           Console.WriteLine("Idade:");
           pI.idade = int.Parse(Console.ReadLine());
           Console.WriteLine("Dados da segunda pessoa:");
           Console.WriteLine("Nome:");
           pII.nome = Console.ReadLine();
           Console.WriteLine("Idade:");
           pII.idade = int.Parse(Console.ReadLine());

           if(pI.idade > pII.idade)
           {
                Console.WriteLine("Pessoa mais velha: {0}",pI.nome);
           }
           else
           {
               Console.WriteLine("Pessoa mais velha: {0}",pII.nome);
           }

           Console.WriteLine("--------------------------------------");
           Console.WriteLine("Dados do primeiro funcionário:");
           Console.WriteLine("Nome:");
           pI.nome = Console.ReadLine();
           Console.WriteLine("Salário:");
           pI.salario = double.Parse(Console.ReadLine(), CultureInfo.InvariantCulture);
           Console.WriteLine("Dados do segundo funcionário:");
           Console.WriteLine("Nome:");
           pII.nome = Console.ReadLine();
           Console.WriteLine("Salário:");
           pII.salario = double.Parse(Console.ReadLine(), CultureInfo.InvariantCulture);

           double sal_media = (pI.salario + pII.salario)/2;

           Console.WriteLine("Salário médio: {0}",sal_media.ToString("F2",CultureInfo.InvariantCulture));

        }
    }
}
