<!DOCTYPE html>
<html>
    <head>
        <?php require_once "../view/general/inclusions.php"; ?>
        <meta charset="UTF-8">
        <title>Liste des utilisateurs</title>
    </head>
    <body>
        <?php
        require "../view/general/navigation.php";
        foreach ($tab_u as $u) {
            $login=$u->getLogin();
            echo '<p>Utilisateur ' . "<a href='routeur.php?action=read&login=$login&controller=ControllerUtilisateur'> $login </a>" . '</p>';
        }
        ?>
    </body>
</html>
