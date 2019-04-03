import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {

        List<Event> events =  Arrays.asList(
                new Event(91,"F",new Location(1,"AA", new City(1,"AAA"))),
                new Event(12,"C",new Location(2,"BB", new City(2,"BBB"))),
                new Event(23,"Y",new Location(3,"CC", new City(3,"CCC"))),
                new Event(43,"A",new Location(4,"DD", new City(4,"EEE"))),
                new Event(51,"E",new Location(5,"EE", new City(5,"DDD"))),
                new Event(22,"X",new Location(23,"YY", new City(82,"YYY"))),
                new Event(34,"Q",new Location(37,"QQ", new City(33,"QQQ"))),
                new Event(14,"S",new Location(34,"SS", new City(54,"SSS"))),
                new Event(25,"U",new Location(25,"UU", new City(57,"UUU")))
            );

        //Recorrer la lista y ordenarlos.
        List<Event> eventsSort = getFirstFive(events).stream()
              .sorted(Comparator.comparing(o -> ( o.getName() )))
              .collect(Collectors.toList());


        System.out.println("\nPrimeros 5 elementos:\n " + getFirstFive(events));
        System.out.println("\nLista ordenada por Nombre de evento alfabeticamente :\n " + eventsSort);
        System.out.println("\nObjeto NO encontrado:\n" + Optional.ofNullable(getEventById(events,1)));
        System.out.println("\nObjeto encontrado:\n" + Optional.ofNullable(getEventById(events,51)));


    }

    public static List<Event> getFirstFive(List<Event> e)
    {
        return e.stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    public static Event getEventById(List<Event> e,int id){
        return  e.stream()
                .filter(event -> event.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
