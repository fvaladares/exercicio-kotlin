# Regras de Implementação:

![UML DIAGRAM][https://user-images.githubusercontent.com/4430811/106827068-e505ec00-6666-11eb-82a2-8728ac6ba142.png]

    As classes de domínio podem ser implementadas em arquivos individuais ou num mesmo arquivo
    A classe PessoaRepository deve ser implementada num arquivo individual
    A classe PessoaRepository pode ter várias implementações, utilizando arquivos, bancos de dados ou em memória.
    A implementação desse exercício deve ser feito utilizando os dados em memória
    Criar pelo menos um caso de teste para cada regra de negócio.

# Regras de Negócio:

    Ao adicionar uma person gerar o ID de forma sequencial

    Ao adicionar uma person, o sistema deve realizar as validações

    2.1 o ID nao deve ser informado, pois será gerado automaticamente

    2.2 Regras para o campo "nome" em anexo no final

    2.3 O CPF deve ter 11 digitos numericos

    2.4 O RG deve ter pelo menos 6 digitos numericos

    2.5 Campo telefone é obrigatorio

    2.6 Campo data de nascimento é obrigatorio

    2.7 Campos altura e peso são opcionais

    2.8 Campo telefone deve seguir o padrão 00 0000-0000 ou 00 00000-0000

    Se uma person for removida, o ID não pode ser reaproveitado

    Ao atualizar uma person, se o ID informado não existir deve retornar um erro

    Ao remover uma person e o ID nao existir deve retornar um erro

    

    6.1 Formula: IMC = PESO / ALTURA²
    6.2 Se a person nao tiver peso ou altura cadastrados deve retornar um erro com a mensagem informado qual ou quais campos estão ausentes

    O sistema nao deve aceitar adicionar um CPF que já existe

# Anexo

Regras para o campo nome

    Deve ter pelo menos duas palavras
    Deve ter pelo menos uma palavra com mais de 2 letras
    Só aceitar alguma palavra com uma letra se o nome tiver mais de 2 palavras
    A primeira palavra deve ter mais de uma letra e iniciar maiuscula
    Palavras com mais de duas letras devem iniciar com maiuscula
    Exemplos:

Nome | Resultado
--- | ---
A L | Incorreto
A L Sousa |    Incorreto
Ada Li |    Correto
Ada li |    Incorreto
Ada L |    Incorreto
Ada L Sousa |    Correto
Ada de Sousa |    Correto  