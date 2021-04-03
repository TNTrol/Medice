package App.Interface;

import java.util.List;

public interface DaoKeyObject<T, K> extends Dao<T>
{
    List<T> getAllBy(K k);
}
