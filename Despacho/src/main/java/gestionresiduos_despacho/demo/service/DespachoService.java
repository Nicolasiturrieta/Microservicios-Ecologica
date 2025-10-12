package gestionresiduos_despacho.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gestionresiduos_despacho.demo.model.AsignacionHR;
import gestionresiduos_despacho.demo.model.EstadoHoja;
import gestionresiduos_despacho.demo.model.EstadoOS;
import gestionresiduos_despacho.demo.model.HojaRuta;
import gestionresiduos_despacho.demo.model.OrdenServicio;
import gestionresiduos_despacho.demo.repository.AsignacionHRRepository;
import gestionresiduos_despacho.demo.repository.HojaRutaRepository;
import gestionresiduos_despacho.demo.repository.OrdenServicioRepository;

@Service
public class DespachoService {
  private final HojaRutaRepository h;
  private final AsignacionHRRepository a;
  private final OrdenServicioRepository o;

  public DespachoService(
    HojaRutaRepository h,
    AsignacionHRRepository a,
    OrdenServicioRepository o)
    { this.h=h; this.a=a; this.o=o; }

  public HojaRuta crearHoja(Long rutaId, LocalDate fecha)
  { return h.save(new HojaRuta(null,rutaId,fecha,EstadoHoja.BORRADOR)); }

  public AsignacionHR asignar(Long hojaId, Long choferId, Long vehiculoId){
    var asig=new AsignacionHR(null,hojaId,choferId,vehiculoId);
    var r=a.save(asig);
    h.findById(hojaId).ifPresent(hr->{ hr.setEstado(EstadoHoja.PUBLICADA); h.save(hr); });
    return r;
  }
  
  @Transactional
  
  public List<OrdenServicio> generarOS(Long hojaId, List<Long> puntos){
    List<OrdenServicio> res=new ArrayList<>();
    for (Long punto : puntos) {
      OrdenServicio osEntity = new OrdenServicio();
      osEntity.setEstado(EstadoOS.PENDIENTE);
      res.add(o.save(osEntity));
    }
    return res;
  }
  public List<OrdenServicio> listarOs(Long hojaId){ return o.findByHojaRutaId(hojaId); }
  public OrdenServicio iniciarOS(Long osId){
    var os=o.findById(osId).orElseThrow(); os.setEstado(EstadoOS.EN_CURSO); os.setHoraLlegada(LocalDateTime.now()); return o.save(os);
  }
  public OrdenServicio cerrarOS(Long osId, BigDecimal peso, String obs){
    var os=o.findById(osId).orElseThrow();
    os.setEstado(EstadoOS.CERRADA);
    os.setHoraSalida(LocalDateTime.now());
    os.setPesoKg(peso);
    os.setObservaciones(obs);
    return o.save(os);}
}
