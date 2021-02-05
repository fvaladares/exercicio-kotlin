#  

**[Regras de Implementação](https://github.com/fmarlon/exercicios-kotlin/commit/0b904271956468ea3fb11db60d0788cf5c1959ac "Regras de implementação")**


TODO
---

* **Passar as validações para o repositório??**
* check if the personList is empty (PersonRepository.kt)

* Mascarar padrão 00 0000-0000 ou 00 00000-0000
* Mascarar CPF


Exemplos:

Input       |   Result
---         | :---:  
A L         |   (Incorreto)
A L Sousa   |   (Incorreto)
Ada Li      |   (Correto)
Ada li      |   (Incorreto)
Ada L       |   (Incorreto)
Ada L Sousa |   (Correto)

* PeopleRepositoy.kt
    * Remover pessoa
    * Atualizar pessoa _(exceção, ID inexistente)_
    * Remover pessoa _(exceção, ID inexistente)_

DOING
---





DONE
---

* ~~Transformar pessoa em DataClass~~
* ~~Alterar o retorno da lista de pessoas~~
* ~~Telefone:~~
    * ~~Validar valor informado~~
* Validar Nome:
    * Regras para o campo nome
        * deve ter pelo menos duas palavras
        * deve ter pelo menos uma palavra com mais de 2 letras
        * Só aceitar alguma palavra com uma letra se o nome tiver mais de 2 palavras.
        * A primeira palavra deve ter mais de uma letra.
        * Palavras com mais duas letras ou mais devem iniciar com maiúscula.    

