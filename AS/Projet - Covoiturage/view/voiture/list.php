<!DOCTYPE html>
<html>
    <head>
        <?php require_once "../view/general/inclusions.php"; ?>
        <meta charset="UTF-8">
        <title>Liste des voitures</title>
    </head>
    <body>
        <?php
        require "../view/general/navigation.php";
        foreach ($tab_v as $v) {
            $immat=$v->getImmatriculation();
            echo '<p>Voiture d\'immatriculation :' . "<a href='routeur.php?action=read&immat=$immat&controller=ControllerVoiture'> $immat </a>" . '</p>';
        }
        ?>
    </body>
</html>
