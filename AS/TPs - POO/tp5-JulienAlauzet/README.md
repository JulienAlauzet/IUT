# ![](ressources/logo.jpeg) Bases de la programmation orientée objet 

### IUT Montpellier-Sète – Département Informatique

* **Cours:** [M2103](http://cache.media.enseignementsup-recherche.gouv.fr/file/25/09/7/PPN_INFORMATIQUE_256097.pdf) - support [ici](https://github.com/IUTInfoMontp-M2103/Ressources)
* **Enseignants:** [Marin Bougeret](mailto:marin.bougeret@umontpellier.fr), [Sébastien Gagné](mailto:sebastien.gagne@umontpellier.fr), [Victor Poupet](mailto:victor.poupet@umontpellier.fr), [Petru Valicov](mailto:petru.valicov@umontpellier.fr), [Bruno Yun](mailto:bruno.yun@umontpellier.fr) 
* Le [forum Piazza](https://piazza.com/class/jpv7gf0lltk4kc) de ce cours pour poser vos questions
* [Email](mailto:petru.valicov@umontpellier.fr) pour une question d'ordre privée concernant le cours.
* Le [sujet du TP](http://pageperso.lif.univ-mrs.fr/~petru.valicov/Cours/M2103/TP5.pdf) en format .pdf téléchargeable et imprimable.

Avant de démarrer le TP, vérifiez que vous n'avez pas atteint votre quota d'espace de stockage autorisé :

* placez-vous dans votre `$HOME` et utilisez les commandes suivantes :
    * `du -sh` pour voir combien d'espace vous avez déjà utilisé
    * `du -sh *` pour voir combien d'espace vous avez déjà utilisé pour chaque fichier (sans fichiers cachés)
    * `du -sch .[!.]* *` pour voir combien d'espace vous avez déjà utilisé pour chaque fichier, y compris les fichiers cachés
* Supprimez les fichiers inutiles.
* Pour éviter des problèmes durant vos TPs d'informatique, vous devriez toujours **garder 300-400 Mo d'espace libre**.


### Consignes
- Vous respecterez toutes les [consignes](https://github.com/IUTInfoMontp-M2103/TP4#consignes) indiquées dans le TP précédent
- Dans ce TP, un principe important que vous devriez essayer de respecter dans votre code est le principe
[DRY](https://fr.wikipedia.org/wiki/Ne_vous_r%C3%A9p%C3%A9tez_pas)



## TP5
#### _Thème : Héritage - réutiliser, mais sans en abuser_

Cliquez sur le lien ci-dessous pour faire votre fork privé du TP :

https://classroom.github.com/a/ZHgcAjxK

Date limite de rendu de votre code sur le dépôt GitHub : **Dimanche 24 février à 23h00**

Vous êtes chargés de proposer une application de gestion des employés dans une entreprise.
L’objectif est de développer votre application de manière incrémentale, en ajoutant les fonctionnalités demandées au fur
et à mesure __sans modifier les fonctionnalités écrites précédemment__. Ce que l'on considère ici comme _modification_
c'est effacer et/ou réécrire du code précédemment écrit. _Ajouter_ du code sans modifier le code précédent est donc
une opération valide. On dira ici, que pour chaque modification de votre programme (effacement et réécriture) la
[dette](https://fr.wikipedia.org/wiki/Dette_technique) de votre logiciel augmente.
Afin de respecter les divers principes en programmation orientée objets (encapsulation, DRY, YAGNI etc.), vous essayerez
d'éviter au maximum de _modifier_ le programme écrit précédemment pour ne pas trop augmenter cette dette...

# Exercice 1

1. Dans un premier temps vous devez modéliser les employés qui sont représentés par les données suivantes : numéro de
   sécurité sociale, nom, prénom, échelon (entier naturel). Implémentez la classe `Employe`
   correspondante et ajoutez-y un constructeur approprié. Le constructeur ayant beaucoup de paramètres, il vous est également
    demandé de proposer un builder pour une construction plus souple (cf.
    [question 5, Exercice 3 du TP3](https://github.com/IUTInfoMontp-M2103/tp3#exercice-3-bonus)).
    Vous pouvez générer le builder de manière automatique avec l'outil de refactoring d'IntelliJ IDEA :
   * clic droit sur le nom du constructeur de votre classe &rightarrow; _Refactor_ &rightarrow;
   _Replace Constructor with Builder_ :
   ![](ressources/GenerationBuilder.png)
   * Dans la fenêtre qui s'affiche vous cocherez tous les paramètres comme indiqué dans le dessin ci-dessous et cliquerez
    sur le bouton _Refactor_ :
   
   ![](ressources/ParametresBuilder.png)

2. On souhaite pouvoir calculer le salaire brut et le salaire net d'un employé.  Le salaire brut de l’employé se calcule
 de la manière suivante : `base * nbHeures`, où `base` et `nbHeures` seront des attributs de type `double`.
 Le salaire net représentera toujours 80% du salaire brut. Ajoutez le code nécessaire pour intégrer ces fonctionnalités.
 
3. Redéfinissez la méthode `toString()` dans la classe `Employe` pour afficher les informations concernant un employé
(y compris ses salaires brut et net).
 
4. Votre client vous demande de changer (modifier donc) la formule de calcul du salaire brut car l'entreprise vient de
revoir sa politique salariale. La nouvelle formule de calcul du salaire brut est : `base * nbHeures * 1.05` .
Combien de modifications devez-vous faire pour que votre programme continue de fonctionner correctement ?
Est-ce que vous pouvez faire mieux ?
   
5. Vérifiez votre solution dans le programme principal (la classe `GestionEmployes`). Vous y instancierez plusieurs
employés (avec le builder) et afficherez les informations les concernant.


# Exercice 2

1. Maintenant votre client se rend compte qu’une séparation des traitements est nécessaire pour les différents types
d'employés. Il faut spécifier les cas des _Commerciaux_, _Fabricants_, et les autres employés qu’on appellera
_Techniciens_.
   * Un `Commercial` a comme attributs `chiffreAffaires` et `tauxCommission`  (tous les deux de type `double`).
   * Un `Fabricant` a comme attributs `nbUnitesProduites` et `tauxCommissionUnite` (type `int`et `double` respectivement).
   * Un `Technicien` n'a pour l'instant aucun nouveau attribut, ni aucune nouvelle méthode.
 Implémentez les classes correspondantes en les faisant hériter de la classe `Employe`.

2. Un commercial peut négocier des transactions (avec la méthode `negocierTransaction()`), un fabricant fabrique des
produits (méthode `fabriquerProduit()`), un technicien effectue les autres tâches dans l’entreprise
(méthode `effectuerTacheTechnique()`). Chacune de ces méthodes sont de type `void` et se contentent
d'afficher un message approprié pour illustrer leur bon fonctionnement. Par exemple, la méthode `negocierTransaction()`
devra afficher ”_Je négocie une transaction_”.

3. Vérifiez votre programme dans la classe principale, en instanciant un objet pour chaque nouveau type d'employé et en
appelant sa fonction spécifique. 

4. On souhaite varier le calcul des salaires bruts des différents types d’employés :
    * Le salaire brut d’un technicien est composé de son salaire brut en tant qu’employé + une majoration
    en fonction de son échelon. Dans notre exemple, le résultat de ce calcul devrait correspondre à 
    `base ∗ nbHeures + echelon ∗ 100`.
    * Le salaire brut d’un commercial dépend du chiffre d’affaires qu’il réalise. Ainsi, le salaire brut se calcule
    suivant la formule `base + chiffreAffaires ∗ tauxCommission`.
    * Le salaire brut d’un fabricant est calculé de la même manière que le salaire brut d’un employé en ajoutant une
    rémunération supplémentaire en fonction du rendement. Dans notre exemple, le résultat de ce calcul devrait
    correspondre à `base ∗ nbHeures + nbUnitesProduites ∗ tauxCommissionUnite`.
    * **Important :** La modalité de calcul du salaire net demeure inchangée pour tous les employés (à savoir 80% du
    salaire brut).
    
   _Redéfinissez_ la méthode calcul de salaire brut dans chaque classe d'employé spécifique pour prendre en compte
   ces nouvelles formules. Vous ajouterez le code qui vous paraît nécessaire à la classe `Employe` mais sans modifier
   le code précédemment écrit.

5. Le patron est devenu plus généreux et a décidé d’ajouter 100€ au salaire brut de tous ses employés ! Combien de
modifications devez-vous apporter à votre code, pour que ça fonctionne ?

6. Maintenant, votre client se rend compte qu’un `Commercial` ne peut pas être un simple commercial (donc ne peut pas être
instancié en tant que tel), mais doit être distingué en tant que _vendeur_ ou _représentant_.
Ajoutez les deux classes correspondantes en faisant un héritage de `Commercial`. Vous ajouterez également à la classe
`Commercial`, le code nécessaire afin que cette classe ne soit pas instanciable.

7. Pour terminer, faites en sorte que la méthode de calcul du salaire brut d'un vendeur soit la même que la méthode
de calcul du salaire brut d'un commercial, alors que la formule de calcul du salaire brut des représentants soit la même
que celle utilisée pour le salaire brut des _techniciens_. Ajoutez cette fonctionnalité dans votre application.

   **Attention** à ne pas dupliquer du code (principe [DRY](https://fr.wikipedia.org/wiki/Ne_vous_r%C3%A9p%C3%A9tez_pas))
   et à ne pas modifier le code précédemment écrit ! Sinon la [dette](https://fr.wikipedia.org/wiki/Dette_technique)
   de votre logiciel va augmenter. :smirk:

8. Quels sont les avantages et inconvénients de votre approche ?

8. **Question facultative** : dessinez le diagramme de classes afin de mieux comprendre votre solution.
