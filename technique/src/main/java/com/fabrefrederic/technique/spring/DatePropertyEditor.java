package com.fabrefrederic.technique.spring;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Voir page 71 Les classes utilis�es comme des types de propri�t�s n'ont pas forc�ment toutes vocation � �tre g�r�es
 * sous forme de Beans par le conteneur l�ger. Il peut �tre plus int�ressant de les traiter comme des valeurs simples,
 * initialis�es via une cha�ne de caract�res. Inconnus de Spring, ces types doivent �tre accompagn�s d'un transcodeur, �
 * m�me de faire la conversion entre la cha�ne de caract�res et les attributs du type.
 * 
 * @author frederic.fabre
 * 
 */
public class DatePropertyEditor extends PropertyEditorSupport {
    private String pattern = "yyyy-MM-dd";

    @Override
    public void setAsText(final String text) throws IllegalArgumentException {
        try {
            final Date date = new SimpleDateFormat(pattern).parse(text);
            setValue(date);
        } catch (final ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 
     * @param pattern
     */
    public void setPattern(final String pattern) {
        this.pattern = pattern;
    }
}
