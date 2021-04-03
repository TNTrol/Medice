package App.Repository;

import App.Interface.Dao;
import App.Models.Medicament;
import App.Models.TypeMedicament;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class MedicamentRepositoryDAO implements Dao<Medicament>
{
    private List<Medicament> medicaments = Arrays.asList(new Medicament[]{
            new Medicament("medicament1", TypeMedicament.ANTIBIOTIC, 10d),
            new Medicament("medicament2", TypeMedicament.NEUROTROPIC, 12d),
            new Medicament("medicament3", TypeMedicament.ANTIBIOTIC, 30d),
            new Medicament("medicament4", TypeMedicament.DIAGNOSTIC, 24d)});
    @Override
    public Medicament get(long id)
    {
        for(Medicament medicament : medicaments)
            if(medicament.getId() == id)
                return  medicament;
        return null;
    }

    @Override
    public List<Medicament> getAll()
    {
        return medicaments;
    }

    @Override
    public void save(Medicament medicament)
    {
        medicaments.add(medicament);
    }

    @Override
    public void update(Medicament medicament)
    {
        Medicament medicament1 = get(medicament.getId());
        if(medicament1 == null)
            return;
        medicament1.setName(medicament.getName());
        medicament1.setPrice(medicament.getPrice());
        medicament1.setType(medicament.getType());
    }

    @Override
    public void delete(Medicament medicament)
    {
        medicaments.remove(medicament);
    }
}
