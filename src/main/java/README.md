ETAPA 1:

S'han implementat les classes Client, Fabricant, Carret, Venda i Component així com tots els mètodes que es demanaven. En el carret s'han implementat mètodes per buscar productes així com per borrar-los; sempre tenint en compte possibles excepcions com que el producte no existeixi o el carret estigui buit.
També s'ha substituit la classe data inicial per la classe data que ofereix java, permetent així que també es registri l'hora. 

ETAPA 2: 

S'ha modificat la classe Component S'ha creat la interficie Component per poder gestionar tots els productes que hi hagi a la botiga. L'antiga classe Component s'ha renombrat com a ComponentBase, i d'aquesta s'han derivat totes les classes dels components específics. Totes aquestes classes implementen la interfície. S'ha decidit treballar amb la interfície per, si en un futur es vol incloure productes que no puguin heredad de la classe ComponentBase, no s'hagi de modificar l'estructura de la resta de codi.

S'ha creat la classe ProducteEnStock que inclou un atribut de tipus Component així com les unitats reservades i en stock.

S'ha implementat la classe botiga online. Els clients i fabricants es gestionen amb una llista, els carrets i l'inventari es gestionen mitjançant taules de hash, que d'una banda ha servit per aprendre a treballar amb un nou tipus d'estructura de dades i per l'altra ha facilitat els processos de búsqueda, reduint la complexitat algorítmica temporal. Finalment, la gestió de les vendes s'ha implementar mitjançant una ArrayList ja que al ser una estructura dinàmica no ens limita en relació al tamany i a més ens simplifica la ordenació i la insercció de nous elements. S'han implementat tots els mètodes que es demanava. Per crear la classe s'ha utilitzat el patró Singleton ja que no volem tenir mai dues instàncies d'aquesta classe perquè ens suposaria un problema.

Pel que fa a les opcions adicionals, s'han implementat totes.

S'han generat 3 tests per facilitar el testeig mitjançant la consola. El test 1 comprova les funcionalitats de l'etapa 1, el test 2 comprova la funcionalitat de l'etapa 2 però només amb productes bàsics. Finalment, el test 3 comprova la funcionalitat de els nous tipus de productes així com de les funcionalitats adicionals que s'han implementat.

