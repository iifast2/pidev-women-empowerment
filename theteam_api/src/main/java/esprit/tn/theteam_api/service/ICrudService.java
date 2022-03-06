package esprit.tn.theteam_api.service;

import java.util.List;

public interface ICrudService<T> {
    public T save (T t) ;
    public T Update(T t) ;
    public List<T> findAll() ;
    public T findById(Long id) ;
    public void deleteById(Long id) ;

}
