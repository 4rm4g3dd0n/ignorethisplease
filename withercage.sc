  
// stay loaded
__config() -> (
   m(
      l('stay_loaded','true')
   )
);
__command()->(null);
find_cage(center_x, center_y, center_z, radius) -> 
(
    locations = l();
    scan(center_x, center_y, center_z, radius, 0, radius,

        if(for(rect(_x,_y,_z, 1, 0, 1), _ == 'bedrock')==9,
            locations += l(_x, _y, _z);
            if (length(locations),print(locations);
                for(locations,
                    pos=_-'['-']'-','-',';
                    run('tellraw @p {"text":"'+_+'","clickEvent":{"action":"run_command","value":"/tp @s '+pos+'"}}')
                )
            )
        )
    )
)