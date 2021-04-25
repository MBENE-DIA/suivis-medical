package com.ut.sn.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ut.sn.Modeles.Consultation;
import com.ut.sn.Modeles.Dossier_medical;


@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {


	Collection<Consultation> findByDossierMedical(Dossier_medical dossier_medical);
}
