package com.algorithms.debruijn;

/**
 * Due to its length, this De-Bruijn squence is located in a different file.
 *  
 * @author yaron
 */
public class DeBruijnSquence4_10 {

	public static String data = 
			"000010002000300040005000600070008000900110012001300140015001600170018001900210" + 
					"022002300240025002600270028002900310032003300340035003600370038003900410042004" + 
					"300440045004600470048004900510052005300540055005600570058005900610062006300640" + 
					"065006600670068006900710072007300740075007600770078007900810082008300840085008" + 
					"600870088008900910092009300940095009600970098009901010201030104010501060107010" + 
					"801090111011201130114011501160117011801190121012201230124012501260127012801290" + 
					"131013201330134013501360137013801390141014201430144014501460147014801490151015" + 
					"201530154015501560157015801590161016201630164016501660167016801690171017201730" + 
					"174017501760177017801790181018201830184018501860187018801890191019201930194019" + 
					"501960197019801990202030204020502060207020802090211021202130214021502160217021" + 
					"802190221022202230224022502260227022802290231023202330234023502360237023802390" + 
					"241024202430244024502460247024802490251025202530254025502560257025802590261026" + 
					"202630264026502660267026802690271027202730274027502760277027802790281028202830" + 
					"284028502860287028802890291029202930294029502960297029802990303040305030603070" + 
					"308030903110312031303140315031603170318031903210322032303240325032603270328032" + 
					"903310332033303340335033603370338033903410342034303440345034603470348034903510" + 
					"352035303540355035603570358035903610362036303640365036603670368036903710372037" + 
					"303740375037603770378037903810382038303840385038603870388038903910392039303940" + 
					"395039603970398039904040504060407040804090411041204130414041504160417041804190" + 
					"421042204230424042504260427042804290431043204330434043504360437043804390441044" + 
					"204430444044504460447044804490451045204530454045504560457045804590461046204630" + 
					"464046504660467046804690471047204730474047504760477047804790481048204830484048" + 
					"504860487048804890491049204930494049504960497049804990505060507050805090511051" + 
					"205130514051505160517051805190521052205230524052505260527052805290531053205330" + 
					"534053505360537053805390541054205430544054505460547054805490551055205530554055" + 
					"505560557055805590561056205630564056505660567056805690571057205730574057505760" + 
					"577057805790581058205830584058505860587058805890591059205930594059505960597059" + 
					"805990606070608060906110612061306140615061606170618061906210622062306240625062" + 
					"606270628062906310632063306340635063606370638063906410642064306440645064606470" + 
					"648064906510652065306540655065606570658065906610662066306640665066606670668066" + 
					"906710672067306740675067606770678067906810682068306840685068606870688068906910" + 
					"692069306940695069606970698069907070807090711071207130714071507160717071807190" + 
					"721072207230724072507260727072807290731073207330734073507360737073807390741074" + 
					"207430744074507460747074807490751075207530754075507560757075807590761076207630" + 
					"764076507660767076807690771077207730774077507760777077807790781078207830784078" + 
					"507860787078807890791079207930794079507960797079807990808090811081208130814081" + 
					"508160817081808190821082208230824082508260827082808290831083208330834083508360" + 
					"837083808390841084208430844084508460847084808490851085208530854085508560857085" + 
					"808590861086208630864086508660867086808690871087208730874087508760877087808790" + 
					"881088208830884088508860887088808890891089208930894089508960897089808990909110" + 
					"912091309140915091609170918091909210922092309240925092609270928092909310932093" + 
					"309340935093609370938093909410942094309440945094609470948094909510952095309540" + 
					"955095609570958095909610962096309640965096609670968096909710972097309740975097" + 
					"609770978097909810982098309840985098609870988098909910992099309940995099609970" + 
					"998099911112111311141115111611171118111911221123112411251126112711281129113211" + 
					"331134113511361137113811391142114311441145114611471148114911521153115411551156" + 
					"115711581159116211631164116511661167116811691172117311741175117611771178117911" + 
					"821183118411851186118711881189119211931194119511961197119811991212131214121512" + 
					"161217121812191222122312241225122612271228122912321233123412351236123712381239" + 
					"124212431244124512461247124812491252125312541255125612571258125912621263126412" + 
					"651266126712681269127212731274127512761277127812791282128312841285128612871288" + 
					"128912921293129412951296129712981299131314131513161317131813191322132313241325" + 
					"132613271328132913321333133413351336133713381339134213431344134513461347134813" + 
					"491352135313541355135613571358135913621363136413651366136713681369137213731374" + 
					"137513761377137813791382138313841385138613871388138913921393139413951396139713" + 
					"981399141415141614171418141914221423142414251426142714281429143214331434143514" + 
					"361437143814391442144314441445144614471448144914521453145414551456145714581459" + 
					"146214631464146514661467146814691472147314741475147614771478147914821483148414" + 
					"851486148714881489149214931494149514961497149814991515161517151815191522152315" + 
					"241525152615271528152915321533153415351536153715381539154215431544154515461547" + 
					"154815491552155315541555155615571558155915621563156415651566156715681569157215" + 
					"731574157515761577157815791582158315841585158615871588158915921593159415951596" + 
					"159715981599161617161816191622162316241625162616271628162916321633163416351636" + 
					"163716381639164216431644164516461647164816491652165316541655165616571658165916" + 
					"621663166416651666166716681669167216731674167516761677167816791682168316841685" + 
					"168616871688168916921693169416951696169716981699171718171917221723172417251726" + 
					"172717281729173217331734173517361737173817391742174317441745174617471748174917" + 
					"521753175417551756175717581759176217631764176517661767176817691772177317741775" + 
					"177617771778177917821783178417851786178717881789179217931794179517961797179817" + 
					"991818191822182318241825182618271828182918321833183418351836183718381839184218" + 
					"431844184518461847184818491852185318541855185618571858185918621863186418651866" + 
					"186718681869187218731874187518761877187818791882188318841885188618871888188918" + 
					"921893189418951896189718981899191922192319241925192619271928192919321933193419" + 
					"351936193719381939194219431944194519461947194819491952195319541955195619571958" + 
					"195919621963196419651966196719681969197219731974197519761977197819791982198319" + 
					"841985198619871988198919921993199419951996199719981999222232224222522262227222" + 
					"822292233223422352236223722382239224322442245224622472248224922532254225522562" + 
					"257225822592263226422652266226722682269227322742275227622772278227922832284228" + 
					"522862287228822892293229422952296229722982299232324232523262327232823292333233" + 
					"423352336233723382339234323442345234623472348234923532354235523562357235823592" + 
					"363236423652366236723682369237323742375237623772378237923832384238523862387238" + 
					"823892393239423952396239723982399242425242624272428242924332434243524362437243" + 
					"824392443244424452446244724482449245324542455245624572458245924632464246524662" + 
					"467246824692473247424752476247724782479248324842485248624872488248924932494249" + 
					"524962497249824992525262527252825292533253425352536253725382539254325442545254" + 
					"625472548254925532554255525562557255825592563256425652566256725682569257325742" + 
					"575257625772578257925832584258525862587258825892593259425952596259725982599262" + 
					"627262826292633263426352636263726382639264326442645264626472648264926532654265" + 
					"526562657265826592663266426652666266726682669267326742675267626772678267926832" + 
					"684268526862687268826892693269426952696269726982699272728272927332734273527362" + 
					"737273827392743274427452746274727482749275327542755275627572758275927632764276" + 
					"527662767276827692773277427752776277727782779278327842785278627872788278927932" + 
					"794279527962797279827992828292833283428352836283728382839284328442845284628472" + 
					"848284928532854285528562857285828592863286428652866286728682869287328742875287" + 
					"628772878287928832884288528862887288828892893289428952896289728982899292933293" + 
					"429352936293729382939294329442945294629472948294929532954295529562957295829592" + 
					"963296429652966296729682969297329742975297629772978297929832984298529862987298" + 
					"829892993299429952996299729982999333343335333633373338333933443345334633473348" + 
					"334933543355335633573358335933643365336633673368336933743375337633773378337933" + 
					"843385338633873388338933943395339633973398339934343534363437343834393444344534" + 
					"463447344834493454345534563457345834593464346534663467346834693474347534763477" + 
					"347834793484348534863487348834893494349534963497349834993535363537353835393544" + 
					"354535463547354835493554355535563557355835593564356535663567356835693574357535" + 
					"763577357835793584358535863587358835893594359535963597359835993636373638363936" + 
					"443645364636473648364936543655365636573658365936643665366636673668366936743675" + 
					"367636773678367936843685368636873688368936943695369636973698369937373837393744" + 
					"374537463747374837493754375537563757375837593764376537663767376837693774377537" + 
					"763777377837793784378537863787378837893794379537963797379837993838393844384538" + 
					"463847384838493854385538563857385838593864386538663867386838693874387538763877" + 
					"387838793884388538863887388838893894389538963897389838993939443945394639473948" + 
					"394939543955395639573958395939643965396639673968396939743975397639773978397939" + 
					"843985398639873988398939943995399639973998399944445444644474448444944554456445" + 
					"744584459446544664467446844694475447644774478447944854486448744884489449544964" + 
					"497449844994545464547454845494555455645574558455945654566456745684569457545764" + 
					"577457845794585458645874588458945954596459745984599464647464846494655465646574" + 
					"658465946654666466746684669467546764677467846794685468646874688468946954696469" + 
					"746984699474748474947554756475747584759476547664767476847694775477647774778477" + 
					"947854786478747884789479547964797479847994848494855485648574858485948654866486" + 
					"748684869487548764877487848794885488648874888488948954896489748984899494955495" + 
					"649574958495949654966496749684969497549764977497849794985498649874988498949954" + 
					"996499749984999555565557555855595566556755685569557655775578557955865587558855" + 
					"895596559755985599565657565856595666566756685669567656775678567956865687568856" + 
					"895696569756985699575758575957665767576857695776577757785779578657875788578957" + 
					"965797579857995858595866586758685869587658775878587958865887588858895896589758" + 
					"985899595966596759685969597659775978597959865987598859895996599759985999666676" + 
					"668666966776678667966876688668966976698669967676867696777677867796787678867896" + 
					"797679867996868696877687868796887688868896897689868996969776978697969876988698" +
					"969976998699977778777977887789779877997878797888788978987899797988798979987999" +
					"8888988998989999000";
}
