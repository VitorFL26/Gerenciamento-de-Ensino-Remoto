package syncmeet;

import java.awt.Desktop;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Syncmeet {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int op = 0;
        int opc = 0;
        int op1 = 0;
        int op2 = 0;
        int op3 = 0;
        int op4 = 0;
        int op5 = 0;
        int op6 = 0;
        int op7 = 0;
        int c = 0; // contador da equipe
        int t = 0; // contador de tarefas
        Equipe equipe[] = new Equipe[5];
        Tarefa tarefa[] = new Tarefa[5];
        String esc;
        String arq3 = "C:\\Users\\vitor\\OneDrive\\Documentos\\Equipes.txt";
        String arq4 = "C:\\Users\\vitor\\OneDrive\\Documentos\\Tarefa.txt";
        String arq5 = "C:\\Users\\vitor\\OneDrive\\Documentos\\TarefasEnviadas.txt";
        String arq6 = "C:\\Users\\vitor\\OneDrive\\Documentos\\NomeDasTarefasEnviadas.txt";
        String arq7 = "C:\\Users\\vitor\\OneDrive\\Documentos\\AlunoEquipes.txt";
        String arq8 = "C:\\Users\\vitor\\OneDrive\\Documentos\\Aulas.txt";
        String arq9 = "C:\\Users\\vitor\\OneDrive\\Documentos\\Notas.txt";
        String arq10 = "C:\\Users\\vitor\\OneDrive\\Documentos\\Faltas.txt";
        do {
            System.out.println("1. Cadastrar");
            System.out.println("2. Logar");
            System.out.println("3. Sair");
            op = leitor.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Voce é professor ou aluno: ");
                    String relacao = leitor.next();
                    if ("professor".equals(relacao)) {
                        String arq = "C:\\Users\\vitor\\OneDrive\\Documentos\\LoginProfessor.txt";
                        System.out.println("Digite seu Usuario: ");
                        String usuario = leitor.next();
                        System.out.println("Digite um Email: ");
                        String email = leitor.next();
                        System.out.println("Digite uma senha confiável: ");
                        String senha = leitor.next();
                        String print = usuario + ";" + email + ";" + senha;
                        Arquivo.Write(arq, print);
                        //professor[i] = new Professor(usuario, email, senha);
                        System.out.println("Usuario Cadastrado!");
                        //i++;
                    } else if ("aluno".equals(relacao)) {
                        String arq2 = "C:\\Users\\vitor\\OneDrive\\Documentos\\LoginAluno.txt";
                        System.out.println("Digite seu Usuario: ");
                        String usuario = leitor.next();
                        System.out.println("Digite um Email: ");
                        String email = leitor.next();
                        System.out.println("Digite uma senha confiável: ");
                        String senha = leitor.next();
                        String print2 = usuario + ";" + email + ";" + senha;
                        Arquivo.Write(arq2, print2);
                        //aluno[j] = new Aluno(usuario, email, senha);
                        System.out.println("Usuario Cadastrado!");
                        //j++;
                    }
                    break;
                case 2:
                    System.out.println("Você é aluno ou professor? ");
                    relacao = leitor.next();
                    if ("professor".equals(relacao)) {
                        System.out.println("Digite o email: ");
                        String email = leitor.next();
                        System.out.println("Digite a senha: ");
                        String senha = leitor.next();
                        leitor.nextLine();
                        if (verificarCredenciaisProfessor(email, senha)) {
                            System.out.println("LOGADO!!!");
                            System.out.println("LOGADO!!!");
                            System.out.println("==================");
                            do {
                                System.out.println("Escolha um opção: ");
                                System.out.println("1. Crie sua própria equipe ");
                                System.out.println("2. Já possuo equipe");
                                System.out.println("3. Lancar faltas");
                                System.out.println("4. Deslogar");
                                opc = leitor.nextInt();
                                switch (opc) {
                                    case 1:
                                        System.out.println("Digite o nome da sua equipe: ");
                                        String nomequipe = leitor.next();
                                        leitor.nextLine();
                                        String print3 = email + ";" + nomequipe; //email irá servir como id para identificar as equipes
                                        Arquivo.Write(arq3, print3);
                                        //equipe[c] = new Equipe(nomequipe);
                                        System.out.println("Parabéns!! Você criou uma equipe com o nome " + nomequipe + ".");
                                        System.out.println("OK! Você está na equipe " + nomequipe);
                                        do {
                                            System.out.println("1. Desejo criar uma tarefa");
                                            System.out.println("2. Desejo postar uma aula");
                                            System.out.println("3. Desejo ver os alunos que já enviaram a tarefa");
                                            System.out.println("4. Desejo mandar uma mensagem no chat");
                                            System.out.println("5. Desejo ler as mensagens do chat");
                                            System.out.println("6. Deslogar");
                                            op5 = leitor.nextInt();
                                            switch (op5) {
                                                case 1:
                                                    System.out.println("Escreva o nome da tarefa: ");
                                                    String NomeTarefa = leitor.next();
                                                    //tarefa[t].setNomeDaTarefa(NomeTarefa);
                                                    System.out.println("Defina a data de entrega: DD/MM/AAAA");
                                                    String DataTarefa = leitor.next();
                                                    //tarefa[t].setDataDaTarefa(DataTarefa);
                                                    System.out.println("Coloque o link do arquivo .pdf que está no google drive: ");
                                                    String link = leitor.next();
                                                    String print4 = nomequipe + ";" + NomeTarefa + ";" + DataTarefa + ";" + link;
                                                    Arquivo.Write(arq4, print4);
                                                    System.out.println("Tarefa criada! E já disponível para seus alunos");
                                                    break;
                                                case 2:
                                                    System.out.println("Coloque o link do arquivo .pdf que está no google drive: ");
                                                    String caminho = leitor.next();
                                                    leitor.nextLine();
                                                    System.out.println("Digite o nome da aula: ");
                                                    String aula = leitor.next();
                                                    if (professorEquipes(email)) {
                                                        System.out.println("Para qual equipe você vai postar a aula: ");
                                                        String aequipe = leitor.next();
                                                        String print = aequipe + ";" + aula + ";" + caminho;
                                                        Arquivo.Write(arq8, print);
                                                        System.out.println("AULA POSTADA!!!");
                                                    }
                                                    break;
                                                case 3:
                                                    if (professorEquipes(email)) {
                                                        System.out.println("Digite o nome da equipe: ");
                                                        String nome = leitor.next();
                                                        if (nomeDasTarefas(nome)) {
                                                            System.out.println("Digite o nome do trabalho que deseja ver quais aluno já enviaram:");
                                                            String nomtrab = leitor.next();
                                                            leitor.nextLine();
                                                            if (nomeDasTarefas(nome)) {
                                                                if (EnviaramTarefa(nomtrab)) {
                                                                    System.out.println("Digite o email do aluno que deseja abrir a tarefa: ");
                                                                    String emailaluno = leitor.next();
                                                                    if (abrirtarefaEnviadas(emailaluno)) {
                                                                        do {
                                                                            System.out.println("1. Enviar Nota do Trabalho: ");
                                                                            System.out.println("2. Voltar");
                                                                            op7 = leitor.nextInt();

                                                                            switch (op7) {
                                                                                case 1:
                                                                                    System.out.println("Digite o email do aluno: ");
                                                                                    String aluemail = leitor.next();
                                                                                    leitor.nextLine();
                                                                                    System.out.println("Digite a nota do seu trabalho: ");
                                                                                    int alunota = leitor.nextInt();
                                                                                    String print = nomtrab + ";" + aluemail + ";" + alunota;
                                                                                    Arquivo.Write(arq9, print);
                                                                            }
                                                                        } while (op7 != 2);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Digite sua mensagem: ");
                                                    leitor.nextLine();
                                                    String mensagem = leitor.nextLine();
                                                    Chat.enviarMensagem(nomequipe, email, mensagem);
                                                    System.out.println("Mensagem Enviada");
                                                    break;
                                                case 5:
                                                    if (associaEquipeProfessor(nomequipe, email)) {
                                                        System.out.println("Digite o nome da sua equipe: ");
                                                        String nomeequipe = leitor.next();
                                                        System.out.println("Essas são as mensagens:");
                                                        Chat.exibirMensagens(nomeequipe);
                                                    }
                                                    break;
                                            }
                                        } while (op5 != 6);
                                    case 2:
                                        //String nomeequipe = equipe[c].getNomedaEquipe();
                                        do {
                                            System.out.println("1. Desejo criar uma tarefa");
                                            System.out.println("2. Desejo postar uma aula");
                                            System.out.println("3. Desejo ver os aluno que enviaram as tarefas: ");
                                            System.out.println("4. Desejo mandar uma mensagem no chat");
                                            System.out.println("5. Desejo ler as mensagens do chat");
                                            System.out.println("6. Voltar");
                                            op6 = leitor.nextInt();

                                            switch (op6) {
                                                case 1:
                                                    System.out.println("Deseja criar uma tarefa? sim ou nao?");
                                                    String escol = leitor.next();
                                                    if ("sim".equals(escol)) {
                                                        if (professorEquipes(email)) {
                                                            System.out.println("Digite para qual equipe você quer enviar uma tarefa: ");
                                                            String nomeequipe = leitor.next();
                                                            System.out.println("Escreva o nome da tarefa: ");
                                                            String NomeTarefa = leitor.next();
                                                            //tarefa[t].setNomeDaTarefa(NomeTarefa);
                                                            System.out.println("Defina a data de entrega: DD/MM/AAAA");
                                                            String DataTarefa = leitor.next();
                                                            //tarefa[t].setDataDaTarefa(DataTarefa);
                                                            System.out.println("Coloque o link do arquivo .pdf que está no google drive: ");
                                                            String link = leitor.next();
                                                            String print4 = nomeequipe + ";" + NomeTarefa + ";" + DataTarefa + ";" + link;
                                                            Arquivo.Write(arq4, print4);
                                                            System.out.println("Tarefa criada! E já disponível para seus alunos");
                                                            do {
                                                                System.out.println("1. Desejo mandar uma mensagem no chat ");
                                                                System.out.println("2. Desejo ler as mensagens do chat");
                                                                System.out.println("3. Desejo voltar");
                                                                op2 = leitor.nextInt();
                                                                switch (op2) {
                                                                    case 1:
                                                                        System.out.println("Digite sua mensagem: ");
                                                                        leitor.nextLine();
                                                                        String mensagem = leitor.nextLine();
                                                                        Chat.enviarMensagem(nomeequipe, email, mensagem);
                                                                        System.out.println("Mensagem Enviada");
                                                                        break;
                                                                    case 2:
                                                                        if (associaEquipeProfessor(nomeequipe, email)) {
                                                                            System.out.println("Digite o nome da sua equipe: ");
                                                                            String noequipe = leitor.next();
                                                                            System.out.println("Essas são as mensagens:");
                                                                            Chat.exibirMensagens(noequipe);
                                                                        }
                                                                }
                                                            } while (op2 != 3);
                                                            break;
                                                        }
                                                    } else if ("nao".equals(escol)) {
                                                        do {
                                                            System.out.println("1. Desejo mandar uma mensagem no chat ");
                                                            System.out.println("2. Desejo ler as mensagens do chat");
                                                            System.out.println("3. Desejo deslogar");
                                                            op3 = leitor.nextInt();

                                                            switch (op3) {
                                                                case 1:
                                                                    if (professorEquipes(email)) {
                                                                        System.out.println("Escolha uma equipe para mandar mensagem:");
                                                                        String equipemen = leitor.next();
                                                                        System.out.println("Digite sua mensagem: ");
                                                                        leitor.nextLine();
                                                                        String mensagem = leitor.nextLine();
                                                                        Chat.enviarMensagem(equipemen, email, mensagem);
                                                                        System.out.println("Mensagem Enviada");
                                                                        break;
                                                                    }
                                                                case 2:
                                                                    if (professorEquipes(email)) {
                                                                        System.out.println("Escreva o nome da equipe que deseja ver o chat: ");
                                                                        String chat = leitor.next();
                                                                        System.out.println("Essas são as mensagens do chat");
                                                                        Chat.exibirMensagens(chat);
                                                                    }
                                                                    break;
                                                            }
                                                        } while (op3 != 3);
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Instruções para postar a aula:");
                                                    System.out.println("1º Clique com o botão direito em cima do arquivo .PDF que deseja mandar");
                                                    System.out.println("2º Vá na opção copiar caminho");
                                                    System.out.println("3º Cole o caminho aqui sem aspas");
                                                    String caminho = leitor.next();
                                                    System.out.println("Digite o nome da aula: ");
                                                    String aula = leitor.next();
                                                    if (professorEquipes(email)) {
                                                        System.out.println("Para qual equipe você vai postar a aula: ");
                                                        String aequipe = leitor.next();
                                                        String print = aequipe + ";" + aula + ";" + caminho;
                                                        Arquivo.Write(arq8, print);
                                                        System.out.println("AULA POSTADA!!!");
                                                    }
                                                    break;
                                                case 3:
                                                    if (professorEquipes(email)) {
                                                        System.out.println("Digite o nome da equipe que deseja ver os trabalhos enviados: ");
                                                        String nome = leitor.next();
                                                        if (nomeDasTarefas(nome)) {
                                                            System.out.println("Digite o nome do trabalho que deseja ver quais aluno já enviaram:");
                                                            String nomtrab = leitor.next();
                                                            if (EnviaramTarefa(nomtrab)) {
                                                                System.out.println("Digite o email do aluno que deseja abrir a tarefa: ");
                                                                String emailaluno = leitor.next();
                                                                if (abrirtarefaEnviadas(emailaluno)) {
                                                                    do {
                                                                        System.out.println("1. Enviar Nota do Trabalho: ");
                                                                        System.out.println("2. Voltar");
                                                                        op7 = leitor.nextInt();
                                                                        switch (op7) {
                                                                            case 1:
                                                                                System.out.println("Digite o email do aluno: ");
                                                                                String aluemail = leitor.next();
                                                                                leitor.nextLine();
                                                                                System.out.println("Digite a nota do seu trabalho: ");
                                                                                int alunota = leitor.nextInt();
                                                                                String print = nomtrab + ";" + aluemail + ";" + alunota;
                                                                                Arquivo.Write(arq9, print);
                                                                        }
                                                                    } while (op7 != 2);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    if (professorEquipes(email)) {
                                                        System.out.println("Digite o nome da equipe que deseja ver o chat:");
                                                        String nomeequipe = leitor.next();
                                                        System.out.println("Digite sua mensagem: ");
                                                        leitor.nextLine();
                                                        String mensagem = leitor.nextLine();
                                                        Chat.enviarMensagem(nomeequipe, email, mensagem);
                                                        System.out.println("Mensagem Enviada");
                                                    }
                                                    break;
                                                case 5:
                                                    if (professorEquipes(email)) {
                                                        System.out.println("Escreva o nome da equipe que deseja ver o chat: ");
                                                        String chat = leitor.next();
                                                        System.out.println("Essas são as mensagens do chat");
                                                        Chat.exibirMensagens(chat);
                                                    }
                                                    break;
                                            }
                                        } while (op6 != 6);
                                        break;
                                    case 3:
                                        System.out.println("Digite o email do aluno: ");
                                        String emai = leitor.next();
                                        leitor.nextLine();
                                        System.out.println("Digite as faltas do aluno: ");
                                        int alufalt = leitor.nextInt();
                                        String printfalt = "Aluno: " + emai + " tem " + alufalt + " faltas.";
                                        Arquivo.Write(arq10, printfalt);
                                        System.out.println("Faltas adicionadas!");
                                        break;
                                }
                            } while (opc != 4);
                            break;
                        } else {
                            System.out.println("Credenciais inválidas!");
                        }
                        break;
                    } else if ("aluno".equals(relacao)) {
                        System.out.println("Digite o email: ");
                        String email = leitor.next();
                        System.out.println("Digite a senha: ");
                        String senha = leitor.next();
                        if (verificarCredenciaisAluno(email, senha)) {
                            System.out.println("LOGADO!!!");
                            System.out.println("LOGADO!!!");
                            System.out.println("==================");
                            System.out.println("Entre em alguma equipe: Professor;NomeDaEquipe\n");
                            System.out.println(Arquivo.Read(arq3));
                            System.out.println("Digite nome da equipe que deseja entrar: ");
                            String nome = leitor.next();
                            leitor.nextLine();
                            String print = email + ";" + nome;
                            Arquivo.Write(arq7, print);
                            if (verificarEquipes(nome)) {
                                System.out.println("Seja Bem-Vindo a equipe " + nome + "!!!\n");
                                do {
                                    System.out.println("1. Enviar mensagem para equipe");
                                    System.out.println("2. Ver as mensagens da equipe");
                                    System.out.println("3. Desejo fazer as tarefas da equipe");
                                    System.out.println("4. Desejo ver as aulas");
                                    System.out.println("5. Ver nota");
                                    System.out.println("6. Deslogar");
                                    op4 = leitor.nextInt();
                                    switch (op4) {
                                        case 1:
                                            if (alunoEquipes(email)) {
                                                System.out.println("Escolha uma equipe para mandar mensagem:");
                                                String equipemen = leitor.next();
                                                System.out.println("Digite sua mensagem: ");
                                                leitor.nextLine();
                                                String mensagem = leitor.nextLine();
                                                Chat.enviarMensagem(equipemen, email, mensagem);
                                                System.out.println("Mensagem Enviada");
                                                break;
                                            }
                                            break;
                                        case 2:
                                            if (alunoEquipes(email)) {
                                                System.out.println("Escreva o nome da equipe que deseja ver o chat: ");
                                                String chat = leitor.next();
                                                System.out.println("Essas são as mensagens do chat");
                                                Chat.exibirMensagens(chat);
                                            }
                                            break;
                                        case 3:
                                            if (associaEquipeTarefa(nome)) {
                                                System.out.println("Deseja fazer as tarefas? sim/nao");
                                                String esc6 = leitor.next();
                                                if ("sim".equals(esc6)) {
                                                    System.out.println("Deseja fazer qual tarefa? \n");
                                                    if (nomeDasTarefas(nome)) {
                                                        System.out.println("==========================================");
                                                        System.out.println("Escreva o nome da tarefa que deseja fazer ");
                                                        String esctarefa = leitor.next();
                                                        Arquivo.Write(arq6, esctarefa);
                                                        System.out.println("Você escolheu a tarefa de nome: " + esctarefa);
                                                        System.out.println("Deseja abrir a tarefa? sim ou nao");
                                                        String abrirTarefa = leitor.next();
                                                        if ("sim".equals(abrirTarefa)) {
                                                            if (abrirtarefa(esctarefa)) {

                                                            }
                                                        } else {
                                                            break;
                                                        }
                                                        if (exercicio(esctarefa)) {
                                                            System.out.println("Faça a tarefa e envie o link do arquivo .pdf no google drive: ");
                                                            String linkTarefa = leitor.next();
                                                            String print5 = esctarefa + ";" + linkTarefa + ";" + email + ";" + nome;
                                                            Arquivo.Write(arq5, print5);
                                                            System.out.println("Tarefa Enviada!");
                                                            System.out.println("==========================");
                                                            System.out.println("Deseja continuar? sim/nao");
                                                            esc = leitor.next();
                                                            do {
                                                                if (verificaTarefasEnviadas(esctarefa, nome)) {
                                                                    if ("sim".equals(esc)) {
                                                                        System.out.println("Escreva o nome do trabalho que deseja fazer ");
                                                                        esctarefa = leitor.next();
                                                                        Arquivo.Write(arq6, esctarefa);
                                                                        System.out.println("Você escolheu a tarefa de nome: " + esctarefa);
                                                                        if (exercicio(esctarefa)) {
                                                                            System.out.println("Faça a tarefa e envie: ");
                                                                            linkTarefa = leitor.next();
                                                                            print5 = esctarefa + ";" + linkTarefa;
                                                                            Arquivo.Write(arq5, print5);
                                                                            System.out.println("Tarefa Enviada!");
                                                                            System.out.println("==========================");
                                                                            System.out.println("Deseja continuar? sim/nao");
                                                                            esc = leitor.next();
                                                                        }
                                                                    }
                                                                }
                                                            } while (!"nao".equals(esc));   // Depois de deseja continuar aparecer os nomes dos trabalhos que ainda faltam e fazer um looping mostrando as que ainda faltam até escolher que não deseja mais fazer ou acabar as tarefas
                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.println("Não existe essa equipe!");
                                            }
                                            break;
                                        case 4:
                                            if (alunoEquipes(email)) {
                                                System.out.println("Digite o nome da equipe que deseja ver as aulas");
                                                String equipea = leitor.next();
                                                if (aulasPostadas(equipea)) {
                                                    System.out.println("Digite o nome da aula que deseja ver: ");
                                                    String aula = leitor.next();
                                                    if (mostrarAula(aula)) {
                                                    }
                                                }
                                            }
                                        case 5:
                                            if (verNotas(email)) {

                                            }
                                    }
                                } while (op4 != 6);

                            } else {
                                System.out.println("Credenciais inválidas!");
                            }
                            break;
                        }
                    }

            }
        } while (op != 3);
    }

    public static boolean verificarCredenciaisProfessor(String email, String senha) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\LoginProfessor.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String emailSalvo = partes[1];
                String senhaSalva = partes[2];
                if (email.equals(emailSalvo) && senha.equals(senhaSalva)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verificarCredenciaisAluno(String email, String senha) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\LoginAluno.txt"))) {//cria o objeto BufferedReader para ler o arquivo "loginaluno"
            String linha; // usada para armazenar cada linha lida
            while ((linha = br.readLine()) != null) {//le cada linha do arquivo até que nao haja mais linhas
                String[] partes = linha.split(";"); //le até o ";" e armazena em uma array chamadas partes
                String emailSalvo = partes[1]; // salva a segunda parte na string que é o email
                String senhaSalva = partes[2]; // salva a terceira parte na string que é a senha
                if (email.equals(emailSalvo) && senha.equals(senhaSalva)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verificarEquipes(String nome) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Equipes.txt"))) {//cria o objeto BufferedReader para ler o arquivo "Equipes"
            String linha; // usada para armazenar cada linha lida
            while ((linha = br.readLine()) != null) { //le cada linha do arquivo ate que não haja mais linhas
                String[] partes = linha.split(";"); // le até o ";" e armazena em uma array chamada partes
                String nomedaEquipe = partes[1];//salva a segunda parte da string que é o nome da equipe
                if (nome.equals(nomedaEquipe)) {//verifica se o nome da equipe digitada é igual o nome da equipe já existente
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean associaEquipeTarefa(String nome) {
        List<String> tarefas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Tarefa.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String nomedaEquipe = partes[0];
                String data = partes[2];
                String tarefa = partes[1];
                if (nome.equals(nomedaEquipe)) {
                    String tarefaCompleta = "Data de entrega: [" + data + "] | Tarefa: " + tarefa;
                    tarefas.add(tarefaCompleta);
                }
            }
            if (!tarefas.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Tarefas da sua equipe:");
                for (String tarefa : tarefas) {
                    System.out.println(tarefa);
                }
                System.out.println("==========================================");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean nomeDasTarefas(String nome) {
        List<String> nometarefas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Tarefa.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String nomedaTarefa = partes[1];
                String tarefa = partes[2];
                if (nome.equals(partes[0])) {
                    String nomeTarefa = nomedaTarefa;
                    nometarefas.add(nomeTarefa);
                }
            }
            if (!nometarefas.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Tarefas da sua equipe:");
                for (String nomeTarefa : nometarefas) {
                    System.out.println(nomeTarefa);
                }

                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean exercicio(String esctarefa) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Tarefa.txt"))) {//cria o objeto BufferedReader para ler o arquivo "Tarefas"
            String linha; // usada para armazenar cada linha lida
            while ((linha = br.readLine()) != null) { //le cada linha do arquivo ate que não haja mais linhas
                String[] partes = linha.split(";"); // le até o ";" e armazena em uma array chamada partes
                String nomedatarefa = partes[1];//salva a terceira parte da string que é o que fazer na tarefa escolhida
                String tarefa = partes[3];
                if (esctarefa.equals(nomedatarefa)) {//verifica se o nome da tarefa digitada é igual o nome da equipe já existente
                    System.out.println("==========================================");
                    System.out.println("= Exercicio:                             ");
                    System.out.println("= " + nomedatarefa + "         ");
                    System.out.println("==========================================");
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verificaTarefasEnviadas(String esctarefa, String nome) {
        List<String> tarefasenviadas = new ArrayList<>();
        String tarefaenviada;
        String nomedaEquipe;
        String nomedoTrabalho;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Tarefa.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                nomedaEquipe = partes[0];
                nomedoTrabalho = partes[1];
                if (nome.equals(nomedaEquipe) && !esctarefa.equals(nomedoTrabalho)) {
                    String tarefaCompleta = nomedoTrabalho;
                    tarefasenviadas.add(tarefaCompleta);
                }
            }
            if (!tarefasenviadas.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Tarefas que ainda não foram feitas: ");
                for (String tarefa : tarefasenviadas) {
                    System.out.println(tarefa);
                }
                System.out.println("==========================================");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean associaEquipeProfessor(String nomeequipe, String email) {
        List<String> equipes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Tarefa.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String nomeusuario = partes[0];
                String nomedaequipe = partes[1];
                if (nomeusuario.equals(email) && nomedaequipe.equals(nomeequipe)) {
                    String tarefaCompleta = "Equipes " + nomedaequipe;
                    equipes.add(tarefaCompleta);
                }
            }
            if (!equipes.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Suas Equipes:");
                for (String equipe : equipes) {
                    System.out.println(equipe);
                }
                System.out.println("==========================================");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean professorEquipes(String email) {
        List<String> equipes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Equipes.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String nomemail = partes[0];
                String nomedaequipe = partes[1];
                if (nomemail.equals(email)) {
                    String equipe = nomedaequipe;
                    equipes.add(equipe);
                }
            }
            if (!equipes.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Suas Equipes:");
                for (String equipe : equipes) {
                    System.out.println(equipe);
                }
                System.out.println("==========================================");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean alunoEquipes(String email) {
        List<String> equipes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\AlunoEquipes.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String nomemail = partes[0];
                String nomedaequipe = partes[1];
                if (nomemail.equals(email)) {
                    String equipe = nomedaequipe;
                    equipes.add(equipe);
                }
            }
            if (!equipes.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Suas Equipes:");
                for (String equipe : equipes) {
                    System.out.println(equipe);
                }
                System.out.println("==========================================");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean aulasPostadas(String equipea) {
        List<String> naulas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Aulas.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String nomequipe = partes[0];
                String nomeaula = partes[1];
                String link = partes[2];
                if (nomequipe.equals(equipea)) {
                    String aulas = nomeaula;
                    naulas.add(aulas);
                }
            }
            if (!naulas.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Aulas:");
                for (String aula : naulas) {
                    System.out.println(aula);
                }
                System.out.println("==========================================");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean mostrarAula(String aula) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Aulas.txt"))) {//cria o objeto BufferedReader para ler o arquivo "Tarefas"
            String linha; // usada para armazenar cada linha lida
            while ((linha = br.readLine()) != null) { //le cada linha do arquivo ate que não haja mais linhas
                String[] partes = linha.split(";"); // le até o ";" e armazena em uma array chamada partes                
                String nomedaaula = partes[1];//salva a terceira parte da string que é o que fazer na tarefa escolhida
                String link = partes[2];
                if (nomedaaula.equals(aula)) {//verifica se o nome da tarefa digitada é igual o nome da equipe já existente
                    PDF.PDF(link);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean EnviaramTarefa(String nomtrab) {
        List<String> tarefas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\TarefasEnviadas.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String nomedoTrabalho = partes[0];
                String email = partes[2];
                String tarefa = partes[1];
                if (nomedoTrabalho.equals(nomtrab)) {
                    String tarefaEnviada = "Email: [" + email + "]";
                    tarefas.add(tarefaEnviada);
                }
            }
            if (!tarefas.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Tarefas Enviadas:");
                for (String tarefa : tarefas) {
                    System.out.println(tarefa);
                }
                System.out.println("==========================================");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verNotas(String email) {
        List<String> notas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Notas.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String nomedoTrab = partes[0];
                String aluemail = partes[1];
                String alnotas = partes[2];
                if (email.equals(aluemail)) {
                    String Notaluno = "Nome do trabalho: [" + nomedoTrab + "] | Nota: " + alnotas;
                    notas.add(Notaluno);
                }
            }
            if (!notas.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Sua(s) nota(s):");
                for (String nota : notas) {
                    System.out.println(nota);
                }
                System.out.println("==========================================");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean abrirtarefa(String esctarefa) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\Tarefa.txt"))) {//cria o objeto BufferedReader para ler o arquivo "Tarefas"
            String linha; // usada para armazenar cada linha lida
            while ((linha = br.readLine()) != null) { //le cada linha do arquivo ate que não haja mais linhas
                String[] partes = linha.split(";"); // le até o ";" e armazena em uma array chamada partes                
                String nomedatarefa = partes[1];//salva a terceira parte da string que é o que fazer na tarefa escolhida
                String link = partes[3];
                if (nomedatarefa.equals(esctarefa)) {//verifica se o nome da tarefa digitada é igual o nome da equipe já existente
                    PDF.PDF(link);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean abrirtarefaEnviadas(String emailaluno) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\OneDrive\\Documentos\\TarefasEnviadas.txt"))) {//cria o objeto BufferedReader para ler o arquivo "Tarefas"
            String linha; // usada para armazenar cada linha lida
            while ((linha = br.readLine()) != null) { //le cada linha do arquivo ate que não haja mais linhas
                String[] partes = linha.split(";"); // le até o ";" e armazena em uma array chamada partes                
                String emailAluno = partes[2];//salva a terceira parte da string que é o que fazer na tarefa escolhida
                String link = partes[1];
                if (emailAluno.equals(emailaluno)) {//verifica se o nome da tarefa digitada é igual o nome da equipe já existente
                    PDF.PDF(link);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}