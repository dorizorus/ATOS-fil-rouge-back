package atos.bdd.model.relation;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Cle_Besoins_Competences implements Serializable {

    @Column(name = "id_besoin")
    private long idBesoin;

    @Column(name = "id_competence")
    private long idCompetence;


    //equals() & hashCode() ont besoin d'être définis dans la classe

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cle_Besoins_Competences that = (Cle_Besoins_Competences) o;
        return idBesoin == that.idBesoin &&
                idCompetence == that.idCompetence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBesoin, idCompetence);
    }
}
