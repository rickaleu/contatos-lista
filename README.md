# Desafio Lista de Contatos

<p>
  <img src="gif_pp.gif" align="center" width=150>
</p>

O aplicativo `Lista de Contatos` foi desenvolvido a partir do projeto default, adicionando assim, uma reestruturação e melhorias sugeridas.

### Tecnologias utilizadas
Foram utilizadas as seguintes tecnologias:
* arquitetura de apresentação com [MVVM](https://developer.android.com/jetpack/guide?hl=pt-br)
* Injeção de dependência com [Koin](https://insert-koin.io/)
* Persistência de dados com [Room](https://developer.android.com/training/data-storage/room)
* Requisições a API com [Retrofit](https://square.github.io/retrofit/)
* Referência de navegação com [Jetpack Navigation](https://developer.android.com/guide/navigation)
* Testes unitários com [Mockk](https://mockk.io/)
* Programação assíncrona com [Flow](https://developer.android.com/kotlin/flow?hl=pt-br) e [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
* Carregamento de imagens com [Glide](https://bumptech.github.io/glide/)

### Próximas etapas
* Testes instrumentados
* Navegação com demais telas
* Correção de inserção de dados locais

================================================================

# PicPay - Desafio Android

<img src="https://github.com/mobilepicpay/desafio-android/blob/master/desafio-picpay.gif" width="300"/>

Um dos desafios de qualquer time de desenvolvimento é lidar com código legado e no PicPay isso não é diferente. Um dos objetivos de trazer os melhores desenvolvedores do Brasil é atacar o problema. Para isso, essa etapa do processo consiste numa proposta de solução para o desafio abaixo e você pode escolher a melhor forma de resolvê-lo, de acordo com sua comodidade e disponibilidade de tempo:
- Resolver o desafio previamente, e explicar sua abordagem no momento da entrevista.
- Discutir as possibilidades de solução durante a entrevista, fazendo um pair programming (bate-papo) interativo com os nossos devs.

Com o passar do tempo identificamos alguns problemas que impedem esse aplicativo de escalar e acarretam problemas de experiência do usuário. A partir disso elaboramos a seguinte lista de requisitos que devem ser cumpridos ao melhorar nossa arquitetura:

- Em mudanças de configuração o aplicativo perde o estado da tela. Gostaríamos que o mesmo fosse mantido.
- Nossos relatórios de crash têm mostrado alguns crashes relacionados a campos que não deveriam ser nulos sendo nulos e gerenciamento de lifecycle. Gostaríamos que fossem corrigidos.
- Gostaríamos de cachear os dados retornados pelo servidor.
- Haverá mudanças na lógica de negócios e gostaríamos que a arquitetura reaja bem a isso.
- Haverá mudanças na lógica de apresentação. Gostaríamos que a arquitetura reaja bem a isso.
- Com um grande número de desenvolvedores e uma quantidade grande de mudanças ocorrendo testes automatizados são essenciais.
  - Gostaríamos de ter testes unitários testando nossa lógica de apresentação, negócios e dados independentemente, visto que tanto a escrita quanto execução dos mesmos são rápidas.
  - Por outro lado, testes unitários rodam em um ambiente de execução diferenciado e são menos fiéis ao dia-a-dia de nossos usuários, então testes instrumentados também são importantes.

Boa sorte! =)

Ps.: Fique à vontade para editar o projeto inteiro, organização de pastas e módulos, bem como as dependências utilizadas
