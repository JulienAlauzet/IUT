<!DOCTYPE html>
<html>
    <head>
        <?php require_once "../view/general/inclusions.php"; ?>
        <meta charset="UTF-8">
        <title>Détail du trajet</title>
    </head>
    <body>
        <?php
			require "../view/general/navigation.php";
            echo '<p> Voiture ' . $v->getImmatriculation() . ' de marque ' . $v->getMarque() . ' (couleur ' . $v->getCouleur() . ').</p>';
        ?>
    </body>
</html>