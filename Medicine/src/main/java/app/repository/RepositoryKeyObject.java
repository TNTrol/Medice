package app.repository;

import java.util.List;

public interface RepositoryKeyObject<T, K> extends IRepository<T>
{
    List<T> getAllBy(K k);
}
