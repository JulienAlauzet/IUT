<!DOCTYPE html>
<html>
    <head>
        <?php require_once "../view/general/inclusions.php"; ?>
        <meta charset="UTF-8">
        <title>Détail de l'utilisateur</title>
    </head>
    <body>
        <?php
			require "../view/general/navigation.php";
            echo '<p>' . $u->getLogin() . '</p>
			<p> Nom : ' . $u->getNom() .
			'<br />Prénom : ' . $u->getPrenom() . '</p>';
        ?>
    </body>
</html>