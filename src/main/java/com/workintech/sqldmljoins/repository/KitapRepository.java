package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KitapRepository extends JpaRepository<Kitap, Long> {

    //Dram ve Hikaye türündeki kitapları listeleyin. JOIN kullanmadan yapın.
    String QUESTION_1 = "select k.* from kitap as k, tur as t where k.turno = t.turno and t.ad in ('Hikaye', 'Dram')";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Kitap> findBooks();


    String QUESTION_10 = "";
    @Query(value = QUESTION_10, nativeQuery = true)
    Double findAvgPointOfBooks();

    /*
    select * from tur, kitap
    where tur.turno = kitap.turno
    and tur.turno = (select turno from tur
    where tur.ad='Hikaye')

    select * from tur, kitap
    where tur.turno = kitap.turno
    and tur.ad = (select ad from tur
    where tur.ad ilike 'Dram' or  tur.ad ilike 'Hikaye')
    */
}
