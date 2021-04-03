package App.Repository;

import App.Interface.Dao;
import App.Models.Score;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ScoreRepositoryDAO implements Dao<Score>
{
    private List<Score> scores = new ArrayList<>();
    @Override
    public Score get(long id)
    {
        for (Score score : scores)
            if(score.getId() == id)
                return score;
        return null;
    }

    @Override
    public List<Score> getAll()
    {
        return scores;
    }

    @Override
    public void save(Score score)
    {
        scores.add(score);
    }

    @Override
    public void update(Score score)
    {
        Score score1 = get(score.getId());
        if(score1 == null)
            return;
        //score1.setCustomer(score.getCustomer());
        score1.setCost(score.getCost());
        score1.setDate(score.getDate());
        score1.setMedicament(score.getMedicament());
    }

    @Override
    public void delete(Score score)
    {
        scores.remove(score);
    }
}
