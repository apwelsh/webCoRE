/*
 *  webCoRE - Community's own Rule Engine - Web Edition
 *
 *  Copyright 2016 Adrian Caramaliu <ady624("at" sign goes here)gmail.com>
 *
 *  webCoRE Piston
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Last update December 8, 2020 for Hubitat
*/

static String version(){ return 'v0.3.110.20191009' }
static String HEversion(){ return 'v0.3.110.20201015_HE' }

/** webCoRE DEFINITION					**/

static String handle(){ return 'webCoRE' }

import groovy.json.*
import hubitat.helper.RMUtils
import groovy.transform.Field

definition(
	name:handle()+' Piston',
	namespace:'ady624',
	author:'Adrian Caramaliu',
	description:'Do not install this directly, use webCoRE instead',
	category:'Convenience',
	parent:'ady624:'+handle(),
	iconUrl:'https://raw.githubusercontent.com/ady624/webCoRE/master/resources/icons/app-CoRE.png',
	iconX2Url:'https://raw.githubusercontent.com/ady624/webCoRE/master/resources/icons/app-CoRE@2x.png',
	iconX3Url:'https://raw.githubusercontent.com/ady624/webCoRE/master/resources/icons/app-CoRE@3x.png',
	importUrl:'https://raw.githubusercontent.com/imnotbob/webCoRE/hubitat-patches/smartapps/ady624/webcore-piston.src/webcore-piston.groovy'
)

preferences{
	page(name:'pageMain')
	page(name:'pageRun')
	page(name:'pageClear')
	page(name:'pageClearAll')
	page(name:'pageDumpPiston')
	page(name:'pageDumpPiston1')
}

static Boolean eric(){ return false }
static Boolean eric1(){ return false }

@Field static final String sNULL=(String)null
@Field static final String sSNULL='null'
@Field static final String sBOOLN='boolean'
@Field static final String sLONG='long'
@Field static final String sSTR='string'
@Field static final String sINT='integer'
@Field static final String sDCML='decimal'
@Field static final String sDYN='dynamic'
@Field static final String sDTIME='datetime'
@Field static final String sTRUE='true'
@Field static final String sFALSE='false'
@Field static final String sTIME='time'
@Field static final String sDATE='date'
@Field static final String sDEV='device'
@Field static final String sDBL='double'
@Field static final String sNUMBER='number'
@Field static final String sFLOAT='float'
@Field static final String sVARIABLE='variable'
@Field static final String sERROR='error'
@Field static final String sON='on'
@Field static final String sOFF='off'
@Field static final String sSWITCH='switch'
@Field static final String sTRIG='trigger'
@Field static final String sCONDITION='condition'
@Field static final String sDURATION='duration'
@Field static final String sDLLRINDX='$index'
@Field static final String sDLLRDEVS='$devices'
@Field static final String sDLLRDEVICE='$device'
@Field static final String sTEXT='text'
@Field static final String sENUM='enum'
@Field static final String sTHREAX='threeAxis'
@Field static final String sBLK=''
@Field static final String sCOMMA=','
@Field static final String sSPC=' '
@Field static final String sV='v'
@Field static final String sP='p'
@Field static final String sS='s'
@Field static final String sC='c'
@Field static final String sH='h'
@Field static final String sR='r'
@Field static final String sB='b'
@Field static final String sI='i'
@Field static final String sT='t'
@Field static final String sE='e'
@Field static final String sD='d'
@Field static final String sX='x'
@Field static final String sLB='['
@Field static final String sRB=']'
@Field static final String sAT='@'
@Field static final String sDLR='$'
@Field static final String sPEVDATE='$previousEventDate'
@Field static final String sPEVDELAY='$previousEventDelay'
@Field static final String sPEVDEV='$previousEventDevice'
@Field static final String sPEVDEVINDX='$previousEventDeviceIndex'
@Field static final String sPEVATTR='$previousEventAttribute'
@Field static final String sPEVDESC='$previousEventDescription'
@Field static final String sPEVVALUE='$previousEventValue'
@Field static final String sPEVUNIT='$previousEventUnit'
@Field static final String sPEVPHYS='$previousEventDevicePhysical'
@Field static final String sCURDATE='$currentEventDate'
@Field static final String sCURDELAY='$currentEventDelay'
@Field static final String sCURDEV='$currentEventDevice'
@Field static final String sCURDEVINDX='$currentEventDeviceIndex'
@Field static final String sCURATTR='$currentEventAttribute'
@Field static final String sCURDESC='$currentEventDescription'
@Field static final String sCURVALUE='$currentEventValue'
@Field static final String sCURUNIT='$currentEventUnit'
@Field static final String sCURPHYS='$currentEventDevicePhysical'
@Field static final String sAPPJSON='application/json'
@Field static final String sASYNCREP='wc_async_reply'
@Field static final String sLVL='level'
@Field static final String sSTLVL='setLevel'
@Field static final String sIFLVL='infraredLevel'
@Field static final String sSTIFLVL='setInfraredLevel'
@Field static final String sSATUR='saturation'
@Field static final String sSSATUR='setSaturation'
@Field static final String sHUE='hue'
@Field static final String sSHUE='setHue'
@Field static final String sSCLR='setColor'
@Field static final String sCLRTEMP='colorTemperature'
@Field static final String sSCLRTEMP='setColorTemperature'
@Field static final String sZEROS='000000'
@Field static final String sHTTPR='httpRequest'
@Field static final String sSENDE='sendEmail'
@Field static final String sANY='any'
@Field static final String sALL='all'
@Field static final String sAND='and'
@Field static final String sOR='or'
@Field static final String sIF='if'
@Field static final String sWHILE='while'
@Field static final String sREPEAT='repeat'
@Field static final String sFOR='for'
@Field static final String sEACH='each'
@Field static final String sACTION='action'
@Field static final String sEVERY='every'
@Field static final String sRESTRIC='restriction'
@Field static final String sGROUP='group'
@Field static final String sDO='do'
@Field static final String sEVENT='event'
@Field static final String sEXIT='exit'
@Field static final String sBREAK='break'
@Field static final String sEXPR='expression'
@Field static final String sOPER='operator'
@Field static final String sOPERAND='operand'
@Field static final String sFUNC='function'
@Field static final String sONE='1'
@Field static final String sPLUS='+'
@Field static final String sMINUS='-'
@Field static final String sDOT='.'
@Field static final String sORIENT='orientation'
@Field static final String sAXISX='axisX'
@Field static final String sAXISY='axisY'
@Field static final String sAXISZ='axisZ'
@Field static final String sEXPECTING='Expecting '
@Field static final String sINT32='int32'
@Field static final String sINT64='int64'
@Field static final String sBOOL='bool'
@Field static final String sPHONE='phone'
@Field static final String sURI='uri'
@Field static final String sSTOREM='storeMedia'
@Field static final String sIFTTM='iftttMaker'
@Field static final String sDOLARGS='$args'
@Field static final String sEND='end'
@Field static final String sHTTPCONTENT='$httpContentType'
@Field static final String sHTTPSTSCODE='$httpStatusCode'
@Field static final String sHTTPSTSOK='$httpStatusOk'
@Field static final String sIFTTTSTSCODE='$iftttStatusCode'
@Field static final String sIFTTTSTSOK='$iftttStatusOk'
@Field static final String sTSLF='theSerialLockFLD'
@Field static final String sTCCC='theCCC'
@Field static final String sTCL='cacheLock'
@Field static final String sTGBL='theGlobal'
@Field static final String sLCK1='lockOrQueue1'
@Field static final String sLCK2='lockOrQueue2'
@Field static final String sGETTRTD='getTempRtd'
@Field static final String sHNDLEVT='handleEvent'
@Field static final String sVALUEN='(value1, value2, ..., valueN)'
@Field static final String sMULP='*'
@Field static final String sQM='?'
@Field static final String sCOLON=':'
@Field static final String sPWR='**'
@Field static final String sAMP='&'
@Field static final String sBOR='|'
@Field static final String sBXOR='^'
@Field static final String sBNOT='~'
@Field static final String sBNAND='~&'
@Field static final String sBNOR='~|'
@Field static final String sBNXOR='~^'
@Field static final String sLTH='<'
@Field static final String sGTH='>'
@Field static final String sLTHE='<='
@Field static final String sGTHE='>='
@Field static final String sEQ='=='
@Field static final String sNEQ='!='
@Field static final String sNEQA='<>'
@Field static final String sMOD='%'
@Field static final String sMOD1='\\'
@Field static final String sSBL='<<'
@Field static final String sSBR='>>'
@Field static final String sNEG='!'
@Field static final String sDNEG='!!'
@Field static final String sDIV='/'
@Field static final String sLAND='&&'
@Field static final String sLNAND='!&'
@Field static final String sLOR='||'
@Field static final String sLNOR='!|'
@Field static final String sLXOR='^^'
@Field static final String sLNXOR='!^'

/** CONFIGURATION PAGES				**/

def pageMain(){
	return dynamicPage(name:'pageMain', title:'', install:true, uninstall: (Integer)state.build!=null){
		if(parent==null || !(Boolean)parent.isInstalled()){
			section(){
				paragraph 'Sorry you cannot install a piston directly from the HE console; please use the webCoRE dashboard (dashboard.webcore.co) instead.'
			}
			section(sectionTitleStr('Installing webCoRE')){
				paragraph 'If you are trying to install webCoRE please go back one step and choose webCoRE, not webCoRE Piston. You can also visit wiki.webcore.co for more information on how to install and use webCoRE'
				if(parent!=null){
					String t0=(String)parent.getWikiUrl()
					href '', title:imgTitle('https://raw.githubusercontent.com/ady624/webCoRE/master/resources/icons/app-CoRE.png', inputTitleStr('More information')), description:t0, style:'external', url:t0, required:false
				}
			}
		}else{
			section(sectionTitleStr('General')){
				label name:'name', title:'Name', required:true, state:(name ? 'complete':(String)null), defaultValue:(String)parent.generatePistonName(), submitOnChange:true
			}

			section(sectionTitleStr('Dashboard')){
				String dashboardUrl=(String)parent.getDashboardUrl()
				if(dashboardUrl!=(String)null){
					dashboardUrl=dashboardUrl+'piston/'+hashId(app.id)
					href '', title:imgTitle('https://raw.githubusercontent.com/ady624/webCoRE/master/resources/icons/dashboard.png', inputTitleStr('View piston in dashboard')), style:'external', url:dashboardUrl, required:false
				}else paragraph 'Sorry your webCoRE dashboard does not seem to be enabled; please go to the parent app and enable the dashboard if needed.'
			}

			section(sectionTitleStr('Application Info')){
				LinkedHashMap<String,Object> rtD=getTemporaryRunTimeData(now())
				if(!(Boolean)rtD.enabled)paragraph 'Piston is disabled by webCoRE'
				if(!(Boolean)rtD.active)paragraph 'Piston is paused'
				if((String)rtD.bin!=sNULL){
					paragraph 'Automatic backup bin code: '+(String)rtD.bin
				}
				paragraph 'Version: '+version()
				paragraph 'VersionH: '+HEversion()
				paragraph 'Memory Usage: '+mem()
				paragraph 'RunTime History: '+runTimeHis(rtD)
				rtD=null
			}

			section(sectionTitleStr('Recovery')){
				href 'pageRun', title:'Test run this piston'
				href 'pageClear', title:'Clear logs', description:'This will remove logs but no variables'
				href 'pageClearAll', title:'Clear all data', description:'This will reset all data stored in local variables'
			}

			section(){
				input 'dev', "capability.*", title:'Devices', description:'Piston devices', multiple:true
				input 'logging', "enum", title:'Logging Level', options:[0:"None", 1:"Minimal", 2:"Medium", 3:"Full"], description:'Piston logging', defaultValue:state.logging? state.logging.toString() : '0'
				input 'logsToHE', "bool", title:'Piston logs are also displayed in HE console logs?', description:"Logs are available in webCoRE console; also display in HE console 'Logs'?", defaultValue:false
				input 'maxStats', "number", title:'Max number of timing history stats', description:'Max number of stats', range: '2..300', defaultValue:50
				input 'maxLogs', "number", title:'Max number of history logs', description:'Max number of logs', range: '0..300', defaultValue:50
			}
			if(eric() || settings.logging?.toInteger()>2){
				section('Debug'){
					href 'pageDumpPiston', title:'Dump piston structure', description:''
					href 'pageDumpPiston1', title:'Dump cached piston structure', description:''
				}
			}
		}
	}
}

def pageRun(){
	test()
	return dynamicPage(name:'pageRun', title:'', uninstall:false){
		section('Run'){
			paragraph 'Piston tested'
			Map t0=(Map)parent.getWCendpoints()
			String t1="/execute/${hashId(app.id)}?access_token=${t0.at}".toString()
			paragraph "Cloud Execute endpoint ${t0.ep}${t1}".toString()
			paragraph "Local Execute endpoint ${t0.epl}${t1}".toString()
		}
	}
}

private static String sectionTitleStr(String title)	{ return '<h3>'+title+'</h3>' }
private static String inputTitleStr(String title)	{ return '<u>'+title+'</u>' }
//private static String pageTitleStr(String title)	{ return '<h1>'+title+'</h1>' }
//private static String paraTitleStr(String title)	{ return '<b>'+title+'</b>' }

private static String imgTitle(String imgSrc, String titleStr, String color=sNULL, Integer imgWidth=30, Integer imgHeight=0){
	String imgStyle=sBLK
	imgStyle += imgWidth>0 ? 'width: '+imgWidth.toString()+'px !important;':sBLK
	imgStyle += imgHeight>0 ? imgWidth!=0 ? sSPC:sBLK+'height: '+imgHeight.toString()+'px !important;':sBLK
	if(color!=sNULL){ return """<div style="color: ${color}; font-weight: bold;"><img style="${imgStyle}" src="${imgSrc}"> ${titleStr}</img></div>""".toString() }
	else{ return """<img style="${imgStyle}" src="${imgSrc}"> ${titleStr}</img>""".toString() }
}

def pageClear(){
	clear1(false,true,true,false)
	return dynamicPage(name:'pageClear', title:sBLK, uninstall:false){
		section('Clear'){
			paragraph 'All non-essential data has been cleared.'
		}
	}
}

void clear1(Boolean ccache=false, Boolean some=true, Boolean most=false, Boolean all=false,Boolean reset=false){
	String meth='clear1'
	if(some)state.logs=[]
	if(most){ state.trace=[:];state.stats=[:] }
	if(reset){app.clearSetting('maxLogs'); app.clearSetting('maxStats')}
	if(all){
		meth +=' all'
		LinkedHashMap<String,Object> tRtData=getTemporaryRunTimeData(now())
		Boolean act=(Boolean)tRtData.active
		Boolean dis=!(Boolean)tRtData.enabled
		tRtData=null
		state.cache=[:]
		state.vars=[:]
		state.store=[:]
		state.pauses=0L
		clearMyCache(meth)
		String semaName=app.id.toString()
		theSemaphoresFLD[semaName]=0L
		theSemaphoresFLD=theSemaphoresFLD
		theQueuesFLD[semaName]=[]
		theQueuesFLD=theQueuesFLD // this forces volatile cache flush
		if(act && !dis){
			tRtData=getTemporaryRunTimeData(now())
			LinkedHashMap rtD=getRunTimeData(tRtData, null, true, true) //reinitializes cache variables; caches piston
			rtD=null
			tRtData=null
		}
	}
	clearMyCache(meth)
	if(ccache){
		clearMyPiston(meth)
	}
}

def pageClearAll(){
	clear1(true,true,true,true)
	return dynamicPage(name:'pageClearAll', title:sBLK, uninstall:false){
		section('Clear All'){
			paragraph 'All local data has been cleared.'
		}
	}
}

static String dumpListDesc(data, Integer level, List<Boolean> lastLevel, String listLabel, Boolean html=false){
	String str=sBLK
	Integer cnt=1
	List<Boolean> newLevel=lastLevel

	List list1=data?.collect{it}
	Integer sz=(Integer)list1.size()
	list1?.each{ par ->
		Integer t0=cnt-1
		String myStr="${listLabel}[${t0}]".toString()
		if(par instanceof Map){
			Map newmap=[:]
			newmap[myStr]=(Map)par
			Boolean t1= cnt==sz
			newLevel[level]=t1
			str += dumpMapDesc(newmap, level, newLevel, !t1, html)
		}else if(par instanceof List || par instanceof ArrayList){
			Map newmap=[:]
			newmap[myStr]=par
			Boolean t1= cnt==sz
			newLevel[level]=t1
			str += dumpMapDesc(newmap, level, newLevel, !t1, html)
		}else{
			String lineStrt='\n'
			for(Integer i=0; i<level; i++){
				lineStrt += (i+1<level)? (!lastLevel[i] ? '     │' : '      '):'      '
			}
			lineStrt += (cnt==1 && sz>1)? '┌─ ':(cnt<sz ? '├─ ' : '└─ ')
			if(html)str += '<span>'
			str += "${lineStrt}${listLabel}[${t0}]: ${par} (${getObjType(par)})".toString()
			if(html)str += '</span>'
		}
		cnt=cnt+1
	}
	return str
}

static String dumpMapDesc(data, Integer level, List<Boolean> lastLevel, Boolean listCall=false, Boolean html=false){
	String str=sBLK
	Integer cnt=1
	Integer sz=data?.size()
	data?.each{ par ->
		String lineStrt
		List<Boolean> newLevel=lastLevel
		Boolean thisIsLast= cnt==sz && !listCall
		if(level>0){
			newLevel[(level-1)]=thisIsLast
		}
		Boolean theLast=thisIsLast
		if(level==0){
			lineStrt='\n\n • '
		}else{
			theLast= theLast && thisIsLast
			lineStrt='\n'
			for(Integer i=0; i<level; i++){
				lineStrt += (i+1<level)? (!newLevel[i] ? '     │' : '      '):'      '
			}
			lineStrt += ((cnt<sz || listCall) && !thisIsLast) ? '├─ ' : '└─ '
		}
		String objType=getObjType(par.value)
		if(par.value instanceof Map){
			if(html)str += '<span>'
			str += "${lineStrt}${(String)par.key}: (${objType})".toString()
			if(html)str += '</span>'
			newLevel[(level+1)]=theLast
			str += dumpMapDesc((Map)par.value, level+1, newLevel, false, html)
		}
		else if(par.value instanceof List || par.value instanceof ArrayList){
			if(html)str += '<span>'
			str += "${lineStrt}${(String)par.key}: [${objType}]".toString()
			if(html)str += '</span>'
			newLevel[(level+1)]=theLast
			str += dumpListDesc(par.value, level+1, newLevel, sBLK, html)
		}
		else{
			if(html)str += '<span>'
			str += "${lineStrt}${(String)par.key}: (${par.value}) (${objType})".toString()
			if(html)str += '</span>'
		}
		cnt=cnt+1
	}
	return str
}

static String myObj(obj){
	if(obj instanceof String){return 'String'}
	else if(obj instanceof Map){return 'Map'}
	else if(obj instanceof List){return 'List'}
	else if(obj instanceof ArrayList){return 'ArrayList'}
	else if(obj instanceof Integer){return 'Int'}
	else if(obj instanceof BigInteger){return 'BigInt'}
	else if(obj instanceof Long){return 'Long'}
	else if(obj instanceof Boolean){return 'Bool'}
	else if(obj instanceof BigDecimal){return 'BigDec'}
	else if(obj instanceof Float){return 'Float'}
	else if(obj instanceof Byte){return 'Byte'}
	else{ return 'unknown'}
}

static String getObjType(obj){
	return "<span style='color:orange'>"+myObj(obj)+"</span>"
}

static String getMapDescStr(data){
	String str
	List<Boolean> lastLevel=[true]
	str=dumpMapDesc(data, 0, lastLevel, false, true)
	return str!=sBLK ? str:'No Data was returned'
}

def pageDumpPiston1(){
	LinkedHashMap rtD=getRunTimeData()
	LinkedHashMap pis=recreatePiston(true, true)
	rtD.piston=pis
	subscribeAll(rtD, false)
	String message=getMapDescStr(rtD.piston)
	rtD=null
	pis=null
	return dynamicPage(name:'pageDumpPiston1', title:sBLK, uninstall:false){
		section('Cached Piston dump'){
			paragraph message
		}
	}
}

def pageDumpPiston(){
	LinkedHashMap rtD=getRunTimeData()
//	LinkedHashMap pis=recreatePiston(false, true)
	String message=getMapDescStr(rtD.piston)
	rtD=null
	return dynamicPage(name:'pageDumpPiston', title:sBLK, uninstall:false){
		section('Full Piston dump'){
			paragraph message
		}
	}
}

void installed(){
	if(app.id==null)return
	state.created=now()
	state.modified=now()
	state.build=0
	state.vars=(Map)state.vars ?: [:]
	state.subscriptions=(Map)state.subscriptions ?: [:]
	state.logging=0
	initialize()
}

void updated(){
	unsubscribe()
	initialize()
}

void uninstalled(){
	if(eric())log.debug 'uninstalled'
	if(!atomicState.pistonDeleted) Map a=deletePiston()
}

void initialize(){
	String tt1=(String)settings.logging
	Integer tt2=(Integer)state.logging
	String tt3=tt2.toString()
	if(tt1==sNULL)Map a=setLoggingLevel(tt2 ? tt3:'0', false)
	else if(tt1!=tt3)Map a=setLoggingLevel(tt1, false)
	if((Boolean)state.active)Map b=resume()
	else {
		cleanState()
		clearMyCache('initialize')
	}
}

@Field static final List<String> clST=['hash', 'piston', 'cVersion', 'hVersion', 'disabled', 'logPExec', 'settings', 'svSunT', 'temp', 'debugLevel']

void cleanState(){
//cleanups between releases
	for(sph in state.findAll{ (Boolean)((String)it.key).startsWith('sph')})state.remove(sph.key.toString())
	for(String foo in clST)state.remove(foo)
}

/** PUBLIC METHODS					**/

Boolean isInstalled(){
	return (Long)state.created!=null
}

Map get(Boolean minimal=false){ // minimal is backup
	LinkedHashMap rtD=getRunTimeData()
	Map rVal=[
		meta: [
			id: (String)rtD.id,
			author: (String)rtD.author,
			name: (String)rtD.name,
			created: (Long)rtD.created,
			modified: (Long)rtD.modified,
			build: (Integer)rtD.build,
			bin: (String)rtD.bin,
			active: (Boolean)rtD.active,
			category: rtD.category
		],
		piston: (LinkedHashMap)rtD.piston
	]+(minimal ? [:]:[ // use state as getRunTimeData re-initializes these
		systemVars: getSystemVariablesAndValues(rtD),
		subscriptions: (Map)state.subscriptions,
		state: (Map)state.state,
		logging: state.logging!=null ? (Integer)state.logging:0,
		stats: (Map)state.stats,
		logs: (List)state.logs,
		trace: (Map)state.trace,
		localVars: (Map)state.vars,
		memory: mem(),
		lastExecuted: (Long)state.lastExecuted,
		nextSchedule: (Long)state.nextSchedule,
		schedules: (List)state.schedules
	])
	rtD=null
	return rVal
}

Map activity(lastLogTimestamp){
	Map t0=getCachedMaps('activity')
	if(t0==null)return [:]
	List logs=[]+(List)t0.logs
	Integer lsz=(Integer)logs.size()
	Long llt=lastLogTimestamp!=null && lastLogTimestamp instanceof String && ((String)lastLogTimestamp).isLong()? (Long)((String)lastLogTimestamp).toLong():0L
	Integer index=(llt!=0L && lsz>0)? logs.findIndexOf{ it?.t==llt }:0
	index=index>0 ? index:(llt!=0L ? 0:lsz)
	Map rVal=[
		name: (String)t0.name,
		state: (Map)t0.state,
		logs: index>0 ? logs[0..index-1]:[],
		trace: (Map)t0.trace,
		localVars: (Map)t0.vars, // not reporting global or system variable changes
		memory: (String)t0.mem,
		lastExecuted: (Long)t0.lastExecuted,
		nextSchedule: (Long)t0.nextSchedule,
		schedules: (List)t0.schedules,
		systemVars: (Map)t0.cachePersist
	]
	t0=null
	return rVal
}

Map curPState(){
	Map t0=getCachedMaps('curPState',true,false)
	if(t0==null)return null
	Map st=[:] + (Map)t0.state
	st.remove('old')
	Map rVal=[
		a:(Boolean)t0.active,
		c:t0.category,
		t:(Long)t0.lastExecuted,
		n:(Long)t0.nextSchedule,
		z:(String)t0.pistonZ,
		s: st,
		heCached:(Boolean)t0.Cached ?: false
	]
	t0=null
	return rVal
}

Map clearLogs(){
	clear1()
	return [:]
}

static String decodeEmoji(String value){
	return value.replaceAll(/(\:%[0-9A-F]{2}%[0-9A-F]{2}%[0-9A-F]{2}%[0-9A-F]{2}\:)/,{ m -> URLDecoder.decode(m[0].substring(1, 13), 'UTF-8')})
}

@Field static Map<String,Map> thePistonCacheFLD=[:]

private void clearMyPiston(String meth=sNULL){
	String pisName=app.id.toString()
	if((Integer)pisName.length()==0)return
	Boolean cleared=false
	Map pData=(Map)thePistonCacheFLD[pisName]
	if(pData!=null){
		LinkedHashMap t0=(LinkedHashMap)pData.pis
		if(t0){
			List data=t0.collect{ it.key }
			for(item in data)t0.remove((String)item)
			thePistonCacheFLD[pisName].pis=null
			mb()
			cleared=true
		}
		pData=null
	}
	if(cleared && eric())log.debug 'clearing my piston-code-cache '+meth
}

private LinkedHashMap recreatePiston(Boolean shorten=false, Boolean useCache=true){
	if(shorten && useCache){
		String pisName=app.id.toString()
		Map pData=(Map)thePistonCacheFLD[pisName]
		if(pData==null || pData.cnt==null){
			pData=[cnt:0, pis:null]
			thePistonCacheFLD[pisName]=pData
			mb()
		}
		//pData.cnt+=1
		if(pData.pis!=null)return (LinkedHashMap)(pData.pis+[cached:true])
	}

	if(eric())log.debug "recreating piston $shorten $useCache"
	String sdata=sBLK
	Integer i=0
	while(true){
		String s=(String)settings."chunk:$i"
		if(s!=null)sdata += s
		else break
		i++
	}
	if(sdata!=sBLK){
		def data=(LinkedHashMap)new groovy.json.JsonSlurper().parseText(decodeEmoji(new String(sdata.decodeBase64(), 'UTF-8')))
		LinkedHashMap piston=[
			o: data.o ?: [:],
			r: data.r ?: [],
			rn: !!data.rn,
			rop: data.rop ?: sAND,
			s: data.s ?: [],
			v: data.v ?: [],
			z: data.z ?: sBLK
		]
		state.pistonZ=(String)piston.z
		clearMsetIds(piston)
		Integer a=msetIds(shorten, piston)
		return piston
	}
	return [:]
}

Map setup(LinkedHashMap data, chunks){
	if(data==null){
		log.error 'setup: no data'
		return [:]
	}
	clearMyCache('setup')

	String semaName=app.id.toString()
	Boolean aa=getTheLock(semaName, 'setup')

	state.modified=now()
	state.build=(Integer)state.build!=null ? (Integer)state.build+1:1
	LinkedHashMap piston=[
		o: data.o ?: [:],
		r: data.r ?: [],
		rn: !!data.rn,
		rop: data.rop ?: sAND,
		s: data.s ?: [],
		v: data.v ?: [],
		z: data.z ?: sBLK
	]
	String meth='setup'
	clearMyPiston(meth)
	clearMsetIds(piston)
	Integer a=msetIds(false, piston)

	for(chunk in settings.findAll{ (Boolean)((String)it.key).startsWith('chunk:') && !chunks[(String)it.key] }){
		app.clearSetting((String)chunk.key)
	}
	for(chunk in chunks)app.updateSetting((String)chunk.key, [type:sTEXT, value:chunk.value])
	app.updateSetting('bin', [type:sTEXT, value:(String)state.bin ?: sBLK])
	app.updateSetting('author', [type:sTEXT, value:(String)state.author ?: sBLK])

	state.pep=piston.o?.pep ? true:false

	String lbl=(String)data.n
	if(lbl){
		state.svLabel=lbl
		atomicState.svLabel=lbl
		app.updateLabel(lbl)
	}
	state.schedules=[]
	state.vars=(Map)state.vars ?: [:]
	state.modifiedVersion=version()

	state.cache=[:]
	state.logs=[]
	state.trace=[:]

	Map rtD=[:]
	rtD.piston=piston
	releaseTheLock(semaName)
	if((Integer)state.build==1 || (Boolean)state.active)rtD=resume(piston)
	else clearMyCache('setup')
	return [active:(Boolean)state.active, build:(Integer)state.build, modified:(Long)state.modified, state:(Map)state.state, rtData:rtD]
}

private void clearMsetIds(node){
	if(item==null)return
	for(list in node.findAll{ it.value instanceof List }){
		for(item in ((List)list.value).findAll{ it instanceof Map })clearMsetIds(item)
	}
	if(node instanceof Map && node[sDLR]!=null)node.remove(sDLR)

	for(item in node.findAll{ it.value instanceof Map })clearMsetIds(item)
}

private Integer msetIds(Boolean shorten, node, Integer maxId=0, Map<String,Integer> existingIds=[:], List<Map> requiringIds=[], Integer level=0){
	String nodeT=node?.t
	if(nodeT in [sIF, sWHILE, sREPEAT, sFOR, sEACH, sSWITCH, sACTION, sEVERY, sCONDITION, sRESTRIC, sGROUP, sDO, sON, sEVENT, sEXIT, sBREAK]){
		Integer id=node[sDLR]!=null ? (Integer)(node[sDLR]):0
		if(id==0 || existingIds[id.toString()]!=null){
			Boolean a=requiringIds.push(node)
		}else{
			maxId=maxId<id ? id:maxId
			existingIds[id.toString()]=id
		}
		if(nodeT==sIF && (List<Map>)node.ei){
			Boolean a=((List<Map>)node.ei).removeAll{ !it.c && !it.s }
			for(Map elseIf in (List<Map>)node.ei){
				id=elseIf[sDLR]!=null ? (Integer)elseIf[sDLR]:0
				if(id==0 || existingIds[id.toString()]!=null){
					Boolean aa=requiringIds.push(elseIf)
				}else{
					maxId=(maxId<id)? id:maxId
					existingIds[id.toString()]=id
				}
			}
		}
		if(nodeT==sSWITCH && node.cs){
			for(Map _case in (List<Map>)node.cs){
				id=_case[sDLR]!=null ? (Integer)_case[sDLR]:0
				if(id==0 || existingIds[id.toString()]!=null)Boolean a=requiringIds.push(_case)
				else{
					maxId=(maxId<id)? id:maxId
					existingIds[id.toString()]=id
				}
			}
		}
		if(nodeT==sACTION && node.k){
			for(Map task in (List<Map>)node.k){
				id=task[sDLR]!=null ? (Integer)task[sDLR]:0
				if(id==0 || existingIds[id.toString()]!=null)Boolean a=requiringIds.push(task)
				else{
					maxId=(maxId<id)? id:maxId
					existingIds[id.toString()]=id
				}
			}
		}
	}
	for(list in node.findAll{ it.value instanceof List }){
		for(item in ((List)list.value).findAll{ it instanceof Map })maxId=msetIds(shorten, item, maxId, existingIds, requiringIds, level+1)
	}
	if(level==0){
		for(item in requiringIds){
			maxId += 1
			item[sDLR]=maxId
		}
		if(shorten)cleanCode(node)
	}
	return maxId
}

private void cleanCode(item){
	if(item==null || !(item instanceof Map))return

	if((String)item.t in [sC, sS, sV, sE]){ // operand values that don't need g,a
		if((String)item.g=='avg')item.remove('g')
		if(item.a instanceof String)item.remove('a')
	}
	if((String)item.t in [sC, sS, sX, sV, sE]){ // operand values that don't need d
		if(item.d instanceof List)item.remove(sD)
	}
	if((String)item.t in [sS, sX, sV, sE] || ((String)item.t==sC && !((String)item.vt in [sTIME, sDATE, sDTIME])) ){ // operand values that don't need c
		item.remove(sC)
	}
	if(item.t==null && item.size()==4 && item.d instanceof List && !item.d && (String)item.g=='avg' && item.f=='l' && item.vt){
		item.remove(sD);  item.remove('g'); item.remove('f')
	}
	if(item.str!=null)item.remove('str')
	if(item.ok!=null)item.remove('ok')
	if(item.z!=null)item.remove('z')
	if(item.zc!=null)item.remove('zc')
	if(item.e!=null && item.e instanceof String)item.remove(sE)
	if(item.l!=null && item.l instanceof String)item.remove('l')

	if(item.v!=null)cleanCode(item.v)
	if(item.exp!=null)cleanCode(item.exp)
	if(item.lo!=null)cleanCode(item.lo)
	if(item.lo2!=null)cleanCode(item.lo2)
	if(item.lo3!=null)cleanCode(item.lo3)
	if(item.ro!=null){
		if(item.ro instanceof String || fndEmptyOper((Map)item.ro))item.remove('ro')
		else cleanCode(item.ro)
	}
	if(item.ro2!=null){
		if(fndEmptyOper((Map)item.ro2))item.remove('ro2')
		else cleanCode(item.ro2)
	}
	if(item.to!=null){
		if(fndEmptyOper((Map)item.to))item.remove('to')
		else cleanCode(item.to)
	}
	if(item.to2!=null){
		if(fndEmptyOper((Map)item.to2))item.remove('to2')
		else cleanCode(item.to2)
	}
	for(list in item.findAll{ it.value instanceof List }){
		for(itemA in ((List)list.value).findAll{ it instanceof Map })cleanCode(itemA)
	}
}

static Boolean fndEmptyOper(Map oper){
	if((Integer)oper.size()==3 && (String)oper.t==sC && !oper.d && (String)oper.g==sANY)return true
	return false
}

Map deletePiston(){
	String meth='deletePiston'
	if(eric())log.debug meth
	atomicState.pistonDeleted=true
	state.active=false
	clear1(true,true,true,true)	// calls clearMyCache(meth) && clearMyPiston
	return [:]
}

private void checkLabel(Map rtD=null){
	Boolean act=(Boolean)rtD.active
	Boolean dis=!(Boolean)rtD.enabled
	String savedLabel=(String)rtD.svLabel
	if(savedLabel==sNULL){
		log.error "null label"
		return
	}
	String appLbl=savedLabel
	if(savedLabel!=sNULL){
		if(act && !dis){
			app.updateLabel(savedLabel)
		}
		if(!act || dis){
			String tstr='(Paused)'
			if(act && dis) tstr='(Disabled) Kill switch is active'
			String res=appLbl+" <span style='color:orange'>"+tstr+"</span>"
			app.updateLabel(res)
		}
	}
}

void config(Map data){ // creates a new piston
	if(data==null) return
	if((String)data.bin!=sNULL){
		state.bin=(String)data.bin
		app.updateSetting('bin', [type:sTEXT, value:(String)state.bin])
	}
	if((String)data.author!=null){
		state.author=(String)data.author
		app.updateSetting('author', [type:sTEXT, value:(String)state.author])
	}
	if((String)data.initialVersion!=null) state.initialVersion=(String)data.initialVersion
	clearMyCache('config')
}

Map setBin(String bin){
	if(!bin || !!state.bin){
		log.error 'setBin: bad bin'
		return [:]
	}
	state.bin=bin
	app.updateSetting('bin', [type:sTEXT, value:bin])
	String typ='setBin'
	clearMyCache(typ)
	return [:]
}

Map pausePiston(){
	state.active=false
	clearMyCache('pauseP')

	LinkedHashMap rtD=getRunTimeData()
	Map msg=timer 'Piston successfully stopped', rtD, -1
	if((Integer)rtD.logging>0)info 'Stopping piston...', rtD, 0
	state.schedules=[]
	rtD.stats.nextSchedule=0L
	rtD.nextSchedule=0L
	state.nextSchedule=0L
	unsubscribe()
	unschedule()
	state.trace=[:]
	state.subscriptions=[:]
	if((Integer)rtD.logging>0)info msg, rtD
	updateLogs(rtD)
	state.active=false
	state.state=[:]+(Map)rtD.state
	state.remove('lastEvent')
	clear1(true,false,false,false)	// calls clearMyCache(meth) && clearMyPiston
	Map nRtd=shortRtd(rtD)
	rtD=null
	return nRtd
}

Map resume(LinkedHashMap piston=null){
	state.active=true
	state.subscriptions=[:]
	state.schedules=[]
	clearMyCache('resumeP')

	LinkedHashMap<String,Object> tmpRtD=getTemporaryRunTimeData(now())
	Map msg=timer 'Piston successfully started', tmpRtD, -1
	if(piston!=null)tmpRtD.piston=piston
	LinkedHashMap rtD=getRunTimeData(tmpRtD, null, true, false) //performs subscribeAll(rtD); reinitializes cache variables
	if((Integer)rtD.logging>0)info 'Starting piston... ('+HEversion()+')', rtD, 0
	checkVersion(rtD)
	if((Integer)rtD.logging>0)info msg, rtD
	updateLogs(rtD)
	state.state=[:]+(Map)rtD.state
	Map nRtd=shortRtd(rtD)
	nRtd.result=[active:true, subscriptions:(Map)state.subscriptions]
	tmpRtD=null
	rtD=null
	return nRtd
}

static Map shortRtd(Map rtD){
	Map st=[:]+(Map)rtD.state
	st.remove('old')
	Map myRt=[
		id:(String)rtD.id,
		active:(Boolean)rtD.active,
		category:rtD.category,
		stats:[
			nextSchedule:(Long)rtD.nextSchedule
		],
		piston:[
			z:(String)rtD.pistonZ
		],
		state:st,
		Cached:(Boolean)rtD.Cached ?: false
	]
	return myRt
}

Map setLoggingLevel(String level, Boolean clearC=true){
	Integer mlogging=level.isInteger()? level.toInteger():0
	mlogging=Math.min(Math.max(0,mlogging),3)
	app.updateSetting('logging', [type:sENUM, value:mlogging.toString()])
	state.logging=mlogging
	if(mlogging==0)state.logs=[]
	if(clearC) clearMyCache('setLoggingLevel')
	return [logging:mlogging]
}

Map setCategory(String category){
	state.category=category
	clearMyCache('setCategory')
	return [category:category]
}

Map test(){
	handleEvents([date:new Date(), device:location, name:'test', value:now()])
	return [:]
}

Map execute(data, source){
	handleEvents([date:new Date(), device:location, name:'execute', value:source!=null ? source : now(), jsonData:data], false)
	return [:]
}

Map clickTile(index){
	handleEvents([date:new Date(), device:location, name:'tile', value:index])
	return (Map)state.state ?: [:]
}

Map clearCache(){
	handleEvents([date:new Date(), device:location, name:'clearc', value:now()])
	return [:]
}

Map clearLogsQ(){
	handleEvents([date:new Date(), device:location, name:'clearl', value:now()])
	return [:]
}

private Map getCachedAtomicState(){
	Long atomStart=now()
	def atomState
	atomicState.loadState()
	atomState=atomicState.@backingMap
	if(settings.logging>2)log.debug "AtomicState generated in ${now() - atomStart}ms"
	return atomState
}

@Field volatile static Map<String,Long> lockTimesFLD=[:]
@Field volatile static Map<String,String> lockHolderFLD=[:]

Boolean getTheLock(String qname, String meth=sNULL, Boolean longWait=false){
	Long waitT=longWait? 1000L:60L
	Boolean wait=false
	Integer semaNum=getSemaNum(qname)
	String semaSNum=semaNum.toString()
	def sema=getSema(semaNum)
	while(!((Boolean)sema.tryAcquire())){
		// did not get the lock
		Long timeL=lockTimesFLD[semaSNum]
		if(timeL==null){
			timeL=now()
			lockTimesFLD[semaSNum]=timeL
			lockTimesFLD=lockTimesFLD
		}
		if(eric())log.warn "waiting for ${qname} ${semaSNum} lock access, $meth, long: $longWait, holder: ${(String)lockHolderFLD[semaSNum]}"
		pauseExecution(waitT)
		wait=true
		if((now() - timeL) > 30000L) {
			releaseTheLock(qname)
			if(eric())log.warn "overriding lock $meth"
		}
	}
	lockTimesFLD[semaSNum]=now()
	lockTimesFLD=lockTimesFLD
	lockHolderFLD[semaSNum]=app.id.toString()+sSPC+meth
	lockHolderFLD=lockHolderFLD
	return wait
}

void releaseTheLock(String qname){
	Integer semaNum=getSemaNum(qname)
	String semaSNum=semaNum.toString()
	def sema=getSema(semaNum)
	lockTimesFLD[semaSNum]=null
	lockTimesFLD=lockTimesFLD
//	lockHolderFLD[semaSNum]=sNULL
//	lockHolderFLD=lockHolderFLD
	sema.release()
}

@Field static java.util.concurrent.Semaphore theSerialLockFLD=new java.util.concurrent.Semaphore(0)

// Memory Barrier
static void mb(){
	if((Boolean)theSerialLockFLD.tryAcquire()){
		theSerialLockFLD.release()
	}
}

@Field static java.util.concurrent.Semaphore theLock0FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock1FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock2FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock3FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock4FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock5FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock6FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock7FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock8FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock9FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock10FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock11FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock12FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock13FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock14FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock15FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock16FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock17FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock18FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock19FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock20FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock21FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock22FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock23FLD=new java.util.concurrent.Semaphore(1)
@Field static java.util.concurrent.Semaphore theLock24FLD=new java.util.concurrent.Semaphore(1)

static Integer getSemaNum(String name){
	if(name==sTCCC)return 22
	if(name==sTSLF)return 23
	if(name==sTGBL)return 24
	Integer stripes=22
	if(name.isNumber()) return name.toInteger()%stripes
	Integer hash=smear(name.hashCode())
	return Math.abs(hash)%stripes
//	if(eric())log.info "sema $name # $sema"
}

java.util.concurrent.Semaphore getSema(Integer snum){
	switch(snum){
		case 0: return theLock0FLD
		case 1: return theLock1FLD
		case 2: return theLock2FLD
		case 3: return theLock3FLD
		case 4: return theLock4FLD
		case 5: return theLock5FLD
		case 6: return theLock6FLD
		case 7: return theLock7FLD
		case 8: return theLock8FLD
		case 9: return theLock9FLD
		case 10: return theLock10FLD
		case 11: return theLock11FLD
		case 12: return theLock12FLD
		case 13: return theLock13FLD
		case 14: return theLock14FLD
		case 15: return theLock15FLD
		case 16: return theLock16FLD
		case 17: return theLock17FLD
		case 18: return theLock18FLD
		case 19: return theLock19FLD
		case 20: return theLock20FLD
		case 21: return theLock21FLD
		case 22: return theLock22FLD
		case 23: return theLock23FLD
		case 24: return theLock24FLD
		default: log.error "bad hash result $snum"
			return null
	}
}

private static Integer smear(Integer hashCode) {
	hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12)
	return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4)
}

void getCacheLock(String meth=sNULL){
	Boolean w=getTheLock(sTCCC,meth+sSPC+sTCL)
}

void releaseCacheLock(){
	releaseTheLock(sTCCC)
}

@Field volatile static Map<String,List> theQueuesFLD=[:]
@Field volatile static Map<String,Long> theSemaphoresFLD=[:]

// This can a)lock semaphore, b)wait for semaphore, c)queue event, d)just fall through (no locking, waiting)
private Map lockOrQueueSemaphore(Boolean synchr, event, Boolean queue, Map rtD){
	Long tt1=now()
	Long startTime=tt1
	Long r_semaphore=0L
	Long semaphoreDelay=0L
	String semaphoreName=sNULL
	Boolean didQ=false
	Boolean waited=false

	if(synchr){
		String semaName=app.id.toString()
		waited=getTheLock(semaName, sLCK1)
		tt1=now()

		Long lastSemaphore
		Boolean clearC=false
		Integer qsize
		while(true){
			Long t0=(Long)theSemaphoresFLD[semaName]
			Long tt0=t0!=null ? t0 : 0L
			lastSemaphore=tt0
			if(lastSemaphore==0L || tt1-lastSemaphore>100000L){
				theSemaphoresFLD[semaName]=tt1
				theSemaphoresFLD=theSemaphoresFLD
				semaphoreName=semaName
				semaphoreDelay=waited ? tt1-startTime:0L
				r_semaphore=tt1
				break
			}
			if(queue){
				if(event!=null){
					Map myEvent=[
						t:(Long)((Date)event.date).getTime(),
						name:(String)event.name,
						value:event.value,
						descriptionText:(String)event.descriptionText,
						unit:event?.unit,
						physical:!!event.physical,
						jsonData:event?.jsonData,
					]+(event instanceof com.hubitat.hub.domain.Event ? [:]:[
						index:event.index,
						recovery:event.recovery,
						schedule:event.schedule,
						contentType:(String)event.contentType,
						responseData:event.responseData,
						responseCode:event.responseCode,
						setRtData:event.setRtData
					])
					if(event.device!=null){
						myEvent.device=[id:event.device?.id, name:event.device?.name, label:event.device?.label]
						if(event.device?.hubs!=null){
							myEvent.device.hubs=[t:'tt']
						}
					}
					List evtQ=(List)theQueuesFLD[semaName]
					evtQ=evtQ!=null ? evtQ:[]
					qsize=(Integer)evtQ.size()
					if(qsize>12){
						clearC=true
					}else{
						Boolean a=evtQ.push(myEvent)
						theQueuesFLD[semaName]=evtQ
						theQueuesFLD=theQueuesFLD
						didQ=true
					}
				}
				break
			}else{
				releaseTheLock(semaName)
				waited=true
				pauseExecution(100L)
				Boolean a=getTheLock(semaName, sLCK2)
				tt1=now()
			}
		}
		releaseTheLock(semaName)
		if(clearC){
			error "large queue size ${qsize} clearing", rtD
			clear1(true,true,true,true)
		}
	}
	return [
		semaphore: r_semaphore,
		semaphoreName: semaphoreName,
		semaphoreDelay: semaphoreDelay,
		waited: waited,
		exitOut: didQ
	]
}

private LinkedHashMap<String,Object> getTemporaryRunTimeData(Long startTime){
	if(thePhysCommandsFLD==null){ //do one time load once
		String semName=sTSLF
		Boolean a=getTheLock(semName,sGETTRTD,true)
		if(thePhysCommandsFLD==null){
			Map comparison=Comparisons()
			Map vcmd=VirtualCommands()
			Map attr=Attributes()
			List col=getColors()
			Map cmd=PhysicalCommands()
		}
		releaseTheLock(semName)
	}
	LinkedHashMap<String,Object> rtD=getDSCache(sGETTRTD)
	rtD.temporary=true
	rtD.timestamp=startTime
	rtD.logs=[[t:startTime]]
	rtD.debugLevel=0
	rtD.eric=eric1() && (Integer)rtD.logging>2
	return rtD
}

@Field volatile static LinkedHashMap<String,LinkedHashMap> theCacheFLD=[:] // each piston has a map in here

private void clearMyCache(String meth=sNULL){
	Boolean clrd=false
	String appStr=app.id.toString()
	String myId=hashId(appStr)
	if(!myId)return
	String semaName=appStr
	String str='clearMyCache'
	Boolean a=getTheLock(semaName,str)
	getCacheLock(str)
	Map t0=(Map)theCacheFLD[myId]
	if(t0){
		theCacheFLD[myId]=null
		clrd=true
		t0=null
	}
	releaseCacheLock()
	releaseTheLock(semaName)
	if(clrd && eric())log.debug 'clearing piston data cache '+meth
}

private LinkedHashMap<String,Object> getCachedMaps(String meth=sNULL, Boolean retry=true, Boolean Upd=true){
	String myId=hashId(app.id)
	LinkedHashMap<String,Object> result=(LinkedHashMap<String,Object>)theCacheFLD[myId]
	if(result!=null){
		if(result.cache instanceof Map && result.build instanceof Integer){
			return result
		}
		String semaName=app.id.toString()
		Boolean aa=getTheLock(semaName, sI)
		theCacheFLD[myId]=null
		releaseTheLock(semaName)
	}
	if(retry){
		LinkedHashMap<String,Object> a=getDSCache(meth,Upd)
		if(!Upd)return a
		return getCachedMaps(meth,false,Upd)
	}
	if(eric())log.warn 'cached map nf'
	return null
}

private LinkedHashMap<String,Object> getDSCache(String meth, Boolean Upd=true){
	String appStr=app.id.toString()
	String appId=hashId(appStr)
	String myId=appId
	LinkedHashMap<String,Object> pC=getParentCache()
	LinkedHashMap<String,Object> result=(LinkedHashMap)theCacheFLD[myId]

	if(result!=null) result.stateAccess=null
	Boolean sendM=false
	if(result==null){
		String lockTyp='getDSCache'
		String semaName=appStr
		Boolean a=getTheLock(semaName, lockTyp)
		result=(LinkedHashMap)theCacheFLD[myId]
		if(result==null){
			Long stateStart=now()
			if(state.pep==null){ // upgrades of older pistons
				LinkedHashMap piston=recreatePiston()
				state.pep=piston.o?.pep ? true:false
			}
			Integer bld=(Integer)state.build
			String ttt=(String)state.svLabel
			if(ttt==sNULL){
				ttt=(String)app.label
				if(bld>0){
					state.svLabel=ttt
					atomicState.svLabel=ttt
				}
			}
			LinkedHashMap<String,Object> t1=[
				id: appId,
				logging: (Integer)state.logging!=null ? (Integer)state.logging:0,
				svLabel: ttt,
				name: ttt,
				active: (Boolean)state.active,
				category: state.category ?: 0,
				pep: (Boolean)state.pep,
				created: (Long)state.created,
				modified: (Long)state.modified,
				build: bld,
				author: (String)state.author,
				bin: (String)state.bin,
				logsToHE: (Boolean)settings.logsToHE,
			]
			Long stateEnd=now()
			t1.stateAccess=stateEnd-stateStart
			t1.runTimeHis=[]
			def atomState=((Boolean)t1.pep)? getCachedAtomicState():state

			def t0=(Map)atomState.cache
			t1.cache=t0 ? (Map)t0:[:]
			t0=(Map)atomState.store
			t1.store=t0 ? (Map)t0:[:]

			t0=(Map)atomState.state
			t1.state=t0 ? (Map)t0:[:]

			t0=(String)atomState.pistonZ
			t1.pistonZ=t0

			t0=(Map)atomState.trace
			t1.trace=t0 ? (Map)t0:[:]
			t0=(List)atomState.schedules
			t1.schedules=t0 ? (List)t0:[]
			t1.nextSchedule=(Long)atomState.nextSchedule
			t1.lastExecuted=(Long)atomState.lastExecuted
			t1.mem=mem()
			t0=(List)atomState.logs
			t1.logs=t0 ? (List)t0:[]
			t0=(Map)atomState.vars
			t1.vars=t0 ? [:]+(Map)t0:[:]
			t1.cachePersist=[:]
			resetRandomValues(t1)
			t1.devices= settings.dev && settings.dev instanceof List ? settings.dev.collectEntries{[(hashId(it.id)): it]} : [:]

			sendM=true
			if(Upd){
				t1.Cached=true
				theCacheFLD[myId]=t1
			}
			result=t1
			t1=null
			t0=null
			atomState=null
		}
		releaseTheLock(semaName)
		if(sendM && eric()){
			String st=sBLK
			if(Upd)st='/cached'
			log.debug 'creating'+st+' my piston cache '+meth
		}
	}
	LinkedHashMap<String,Object> rtD=pC+result
	pC=null
	result=null
	if(sendM && rtD.build!=0)checkLabel(rtD)
	return rtD
}

@Field static LinkedHashMap theParentCacheFLD

void clearParentCache(String meth=sNULL){
	String lockTyp='clearParentCache'
	String semName=sTSLF
	Boolean a=getTheLock(semName, lockTyp)

	theParentCacheFLD=null

	getCacheLock(lockTyp)
	theCacheFLD=[:] // all pistons reset their cache
	theHashMapFLD=[:]
	theVirtDevicesFLD=null
	releaseCacheLock()

	releaseTheLock(semName)

	if(eric())log.debug "clearing parent cache and all piston caches $meth"
}

private LinkedHashMap<String,Object> getParentCache(){
	String lockTyp='getParentCache'
	LinkedHashMap<String,Object> result=theParentCacheFLD
	if(result==null){
		String semName=sTSLF
		Boolean a=getTheLock(semName, lockTyp)
		result=theParentCacheFLD
		Boolean sendM=false
		if(result==null){
			Map t0=(Map)parent.getChildPstate()
			Map t1=[
				coreVersion: (String)t0.sCv,
				hcoreVersion: (String)t0.sHv,
				powerSource: (String)t0.powerSource,
				region: (String)t0.region,
				instanceId: (String)t0.instanceId,
				settings: (Map)t0.stsettings,
				enabled: (Boolean)t0.enabled,
				//disabled: !(Boolean)t0.enabled,
				logPExec: (Boolean)t0.logPExec,
				locationId: (String)t0.locationId,
				oldLocationId: hashId(location.id.toString()+'L'), //backwards compatibility
				incidents: (List)t0.incidents,
				useLocalFuelStreams: (Boolean)t0.useLocalFuelStreams
			]
			result=t1
			theParentCacheFLD=t1
			t1=null
			sendM=true
		}
		releaseTheLock(semName)
		if(sendM && eric()){
			String mStr='gathering parent cache'
			log.debug mStr
		}
	}
	return result
}

private LinkedHashMap<String,Object> getRunTimeData(LinkedHashMap<String,Object> rtD=null, Map retSt=null, Boolean fetchWrappers=false, Boolean shorten=false){
	Long timestamp=now()
	Long started=timestamp
	List logs=[]
	Long lstarted=0L
	Long lended=0L
	LinkedHashMap piston
	Integer dbgLevel=0
	if(rtD!=null){
		timestamp=(Long)rtD.timestamp
		logs=rtD.logs!=null ? (List)rtD.logs:[]
		lstarted=rtD.lstarted!=null ? (Long)rtD.lstarted:0L
		lended=rtD.lended!=null ? (Long)rtD.lended:0L
		piston=rtD.piston!=null ? (LinkedHashMap)rtD.piston:null
		dbgLevel=rtD.debugLevel!=null ? (Integer)rtD.debugLevel:0
	}else rtD=getTemporaryRunTimeData(timestamp)

	if(rtD.temporary!=null) rtD.remove('temporary')

	LinkedHashMap m1=[semaphore:0L, semaphoreName:sNULL, semaphoreDelay:0L]
	if(retSt!=null){
		m1.semaphore=(Long)retSt.semaphore
		m1.semaphoreName=(String)retSt.semaphoreName
		m1.semaphoreDelay=(Long)retSt.semaphoreDelay
	}
	rtD=rtD+m1

	rtD.timestamp=timestamp
	rtD.lstarted=lstarted
	rtD.lended=lended
	//rtD.logs=[]
	if(logs!=[] && (Integer)logs.size()>0) rtD.logs=logs
	else rtD.logs=[[t: timestamp]]
	rtD.debugLevel=dbgLevel

	rtD.trace=[t:timestamp, points:[:]]
	rtD.stats=[nextSchedule:0L]
	rtD.newCache=[:]
	rtD.schedules=[]
	rtD.cancelations=[statements:[], conditions:[], all:false]
	rtD.updateDevices=false
	rtD.systemVars=getSystemVariables()

	Map atomState=getCachedMaps('getRTD')
	atomState=atomState!=null?atomState:[:]
	Map st=(Map)atomState.state
	rtD.state=st!=null && st instanceof Map ? [:]+st : [old:sBLK, new:sBLK]
	rtD.state.old=(String)rtD.state.new

	rtD.pStart=now()

	if(piston==null) piston=recreatePiston(shorten)
	Boolean doSubScribe=!(Boolean)piston.cached
	
	rtD.piston=piston

	getLocalVariables(rtD, (List)piston.v, atomState)
	piston=null

	if(doSubScribe || fetchWrappers){
		subscribeAll(rtD, fetchWrappers)
		String pisName=app.id.toString()
		Map pData=(Map)thePistonCacheFLD[pisName]
		if(shorten && pisName!=sBLK && pData!=null && pData.pis==null){
			pData.pis=[:]+(LinkedHashMap)rtD.piston
			thePistonCacheFLD[pisName]=[:]+pData
			pData=null
			mb()
			if(eric()){
				Map pL
				Integer t0=0
				Integer t1=0
				try {
					pL=[:]+thePistonCacheFLD
					t0=(Integer)pL.size()
					t1=(Integer)"${pL}".size()
				} catch(a) {
				}
				pL=null
				String mStr=" piston plist is ${t0} elements, and ${t1} bytes".toString()
				log.debug 'creating my piston-code-cache'
				log.debug "saving"+mStr
				if(t1>40000000){
					thePistonCacheFLD=[:]
					mb()
					log.warn "clearing entire"+mStr
				}
			}
		}
	}
	Long t0=now()
	rtD.pEnd=t0
	rtD.ended=t0
	rtD.generatedIn=t0-started
	return rtD
}

private void checkVersion(Map rtD){
	String ver=HEversion()
	String t0=(String)rtD.hcoreVersion
	if(ver!=t0){
		String tt0="child app's version($ver)".toString()
		String tt1="parent app's version($t0)".toString()
		String tt2=' is newer than the '
		String msg
		if(ver>t0) msg=tt0+tt2+tt1
		else msg=tt1+tt2+tt0
		warn "WARNING: Results may be unreliable because the "+msg+". Please update both apps to the same version.", rtD
	}
	if(location.timeZone==null){
		error 'Your location is not setup correctly - timezone information is missing. Please select your location by placing the pin and radius on the map, then tap Save, and then tap Done. You may encounter error or incorrect timing until this is fixed.', rtD
	}
}

/** EVENT HANDLING								**/

void deviceHandler(event){
	handleEvents(event)
}

void timeHandler(event){
	timeHelper(event, false)
}

void timeHelper(event, Boolean recovery){
	handleEvents([date:new Date((Long)event.t), device:location, name:sTIME, value:(Long)event.t, schedule:event, recovery:recovery], !recovery)
}

void executeHandler(event){
	handleEvents([date:event.date, device:location, name:'execute', value:event.value, jsonData:event.jsonData])
}

@Field static final Map getPistonLimits=[
	schedule: 3000L, // need this or longer remaining execution time to process schedules
	scheduleVariance: 970L,
	executionTime: 40000L, // time we stop this execution
	slTime: 1300L, // time before we start pausing
	useBigDelay: 10000L, // transition from short delay to Long delay
	taskShortDelay: 150L,
	taskLongDelay: 500L,
	taskMaxDelay: 1000L,
	maxStats: 50,
	maxLogs: 50,
]

void handleEvents(event, Boolean queue=true, Boolean callMySelf=false){
	Long startTime=now()
	LinkedHashMap<String,Object> tmpRtD=getTemporaryRunTimeData(startTime)
	Map msg=timer 'Event processed successfully', tmpRtD, -1
	String evntName=(String)event.name
	String evntVal="${event.value}".toString()
	Long eventDelay=Math.round(1.0D*startTime-(Long)((Date)event.date).getTime())
	if((Integer)tmpRtD.logging!=0){
		String devStr="${event.device?.label ?: event.device?.name ?: location}".toString()
		String recStr=evntName==sTIME && (Boolean)event.recovery ? '/recovery':sBLK
		String valStr=evntVal+(evntName=='hsmAlert' && evntVal=='rule' ? ', '+(String)event.descriptionText:sBLK)
		String mymsg='Received event ['+devStr+'].'+evntName+recStr+' = '+valStr+" with a delay of ${eventDelay}ms, canQueue: ${queue}, calledMyself: ${callMySelf}".toString()
		info mymsg, tmpRtD, 0
	}

	Boolean clearC=evntName=='clearc'
	Boolean clearL=evntName=='clearl'

	Boolean act=(Boolean)tmpRtD.active
	Boolean dis=!(Boolean)tmpRtD.enabled
	if(!act || dis){
		if((Integer)tmpRtD.logging!=0){
			String tstr=' active, aborting piston execution.'
			if(!act) msg.m='Piston is not'+tstr+' (Paused)' // this is pause/resume piston
			if(dis) msg.m='Kill switch is'+tstr
			info msg, tmpRtD
		}
		updateLogs(tmpRtD)
		if(clearL) clear1(true,true,true,false,true)
		else if(clearC) clear1(true,false,false,false)
		return
	}

	Boolean myPep=(Boolean)tmpRtD.pep
	String appId=(String)tmpRtD.id
	Boolean serializationOn=true // on / off switch
	Boolean strictSync=true // this could be a setting
	Boolean doSerialization=!myPep && (serializationOn || strictSync) && !callMySelf

	tmpRtD.lstarted=now()
	Map retSt=[ semaphore:0L, semaphoreName:sNULL, semaphoreDelay:0L]
	if(doSerialization){
		retSt=lockOrQueueSemaphore(doSerialization, event, queue, tmpRtD)
		if((Boolean)retSt.exitOut){
			if((Integer)tmpRtD.logging!=0){
				msg.m='Event queued'
				info msg, tmpRtD
			}
			updateLogs(tmpRtD)
			event=null
			tmpRtD=null
			return
		}
		if((Long)retSt.semaphoreDelay>0L)warn 'Piston waited for semaphore '+(Long)retSt.semaphoreDelay+'ms', tmpRtD
	}
	tmpRtD.lended=now()

//measure how Long first state access takes
	Long stAccess=0L
	if((Integer)tmpRtD.logging>0 && !myPep){
		if(tmpRtD.stateAccess==null){
			Long stStart=now()
			Long b=(Long)state.nextSchedule
			def a=(List)state.schedules
			Map pEvt=(Map)state.lastEvent
			Long stEnd=now()
			stAccess=stEnd-stStart
		}else stAccess=(Long)tmpRtD.stateAccess
	}

	tmpRtD.cachePersist=[:]
	LinkedHashMap<String,Object> rtD=getRunTimeData(tmpRtD, retSt, false, true)
	tmpRtD=null
	checkVersion(rtD)

	Long theend=now()
	Long t0=theend-startTime
	Long t1=(Long)rtD.lended-(Long)rtD.lstarted
	Long t2=(Long)rtD.generatedIn
	Long t3=(Long)rtD.pEnd-(Long)rtD.pStart
	Long missing=t0-t1-t2
	Long t4=(Long)rtD.lended-startTime
	Long t5=theend-(Long)rtD.lended
	rtD.curStat=[i:t0, l:t1, r:t2, p:t3, s:stAccess]
	if((Integer)rtD.logging>1){
		if((Integer)rtD.logging>2)debug "RunTime initialize > ${t0} LockT > ${t1}ms > rtDT > ${t2}ms > pistonT > ${t3}ms (first state access ${missing} $t4 $t5)".toString(), rtD
		String adMsg=sBLK
		if(eric())adMsg=" (Init: $t0, Lock: $t1, pistonT $t3 first state access $missing ($t4 $t5) $stAccess".toString()
		trace "Runtime (${(Integer)"$rtD".size()} bytes) successfully initialized in ${t2}ms (${HEversion()})".toString()+adMsg, rtD
	}

	resetRandomValues(rtD)
	rtD.tPause=0L
	rtD.stats.timing=[t:startTime, d:eventDelay>0L ? eventDelay:0L, l:Math.round(1.0D*now()-startTime)]

	if(clearC||clearL){
		if(clearL) clear1(true,true,true,false,true)
		else if(rtD.lastExecuted==null || now()-(Long)rtD.lastExecuted > 3660000L) clear1(true,false,false,false)
	}else{
		startTime=now()
		Map msg2
		if((Integer)rtD.logging>0)msg2=timer "Execution stage complete.", rtD, -1
		Boolean success=true
		Boolean firstTime=true
		if(evntName!=sTIME && evntName!=sASYNCREP){
			if((Integer)rtD.logging>0)info "Execution stage started", rtD, 1
			success=executeEvent(rtD, event)
			firstTime=false
		}
		if(evntName==sTIME && !(Boolean)event.recovery){
			rtD.stats.nextSchedule=0L
			rtD.nextSchedule=0L
			state.nextSchedule=0L
		}
	
		Boolean syncTime=true
		String myId=(String)rtD.id
		while(success && (Long)getPistonLimits.executionTime+(Long)rtD.timestamp-now()>(Long)getPistonLimits.schedule){
			List<Map> schedules
			Map tt0=getCachedMaps()
			if(tt0!=null)schedules=(List<Map>)[]+(List<Map>)tt0.schedules
			else schedules=myPep ? (List<Map>)atomicState.schedules:(List<Map>)state.schedules
			if(schedules==null || schedules==(List<Map>)[] || (Integer)schedules.size()==0)break
			Long t=now()
			if(evntName==sASYNCREP){
				event.schedule=schedules.sort{ (Long)it.t }.find{ (String)it.d==evntVal }
				syncTime=false
			}else{
				//anything less than .9 seconds in the future is considered due, we'll do some pause to sync with it
				//we're doing this because many times, the scheduler will run a job early, usually 0-1.5 seconds early...
				evntName=sTIME
				evntVal=t.toString()
				event=[date:(Date)event.date, device:location, name:evntName, value:t, schedule:schedules.sort{ (Long)it.t }.find{ (Long)it.t<t+(Long)getPistonLimits.scheduleVariance }]
			}
			if(event.schedule==null) break
			schedules.remove(event.schedule)
	
			tt0=getCachedMaps()
			if(tt0!=null){
				String semaName=app.id.toString()
				Boolean aa=getTheLock(semaName, sX)
				theCacheFLD[myId].schedules=schedules
				releaseTheLock(semaName)
			}
			tt0=null
			if(myPep)atomicState.schedules=schedules
			else state.schedules=schedules
	
			if(evntName==sASYNCREP){
				if((Boolean)rtD.eric) myDetail rtD, "async event $event"
				Integer responseCode=(Integer)event.responseCode
				Boolean statOk=responseCode>=200 && responseCode<=299
				String eMsg
				switch(evntVal){
				case sHTTPR:
					if(event.schedule.stack!=null){
						event.schedule.stack.response=event.responseData
						event.schedule.stack.json=event.jsonData
					}
					setSystemVariableValue(rtD, sHTTPCONTENT, (String)event.contentType)
				case sSTOREM:
					if(event.setRtData){
						for(item in event.setRtData){
							rtD[(String)item.key]=item.value
						}
					}
					setSystemVariableValue(rtD, sHTTPSTSCODE, responseCode)
					setSystemVariableValue(rtD, sHTTPSTSOK, statOk)
					break
				case sIFTTM:
					setSystemVariableValue(rtD, sIFTTTSTSCODE, responseCode)
					setSystemVariableValue(rtD, sIFTTTSTSOK, statOk)
					break
				case sSENDE:
					break
				default:
					eMsg="unknown "
					error eMsg+"async event "+evntVal, rtD
				}
				evntName=sTIME
				event.name=evntName
				event.value=t
				evntVal=t.toString()
			}else{
				Integer responseCode=408
				Boolean statOk=false
				String ttyp=(String)event.schedule.d
				Boolean found=true
				switch(ttyp){
				case sHTTPR:
					setSystemVariableValue(rtD, sHTTPCONTENT, sBLK)
					if(event.schedule.stack!=null) event.schedule.stack.response=null
				case sSTOREM:
					setSystemVariableValue(rtD, sHTTPSTSCODE, responseCode)
					setSystemVariableValue(rtD, sHTTPSTSOK, statOk)
					break
				case sSENDE:
					break
				case sIFTTM:
					setSystemVariableValue(rtD, sIFTTTSTSCODE, responseCode)
					setSystemVariableValue(rtD, sIFTTTSTSOK, statOk)
					break
				default:
					found=false
					break
				}
				if(found){
					error "Timeout Error "+ttyp, rtD
					syncTime=true
				}
			}
			//if we have any other pending -3 events (device schedules), we cancel them all
			//if(event.schedule.i>0)schedules.removeAll{ (it.s==event.schedule.s) && (it.i==-3)}
			if(syncTime && strictSync){
				Long delay=Math.round((Long)event.schedule.t-1.0D*now())
				if(delay>0L && delay<(Long)getPistonLimits.scheduleVariance){
					if((Integer)rtD.logging>1)trace "Synchronizing scheduled event, waiting for ${delay}ms".toString(), rtD
					pauseExecution(delay)
				}
			}
			if(firstTime&&(Integer)rtD.logging>0){
				msg2=timer "Execution stage complete.", rtD, -1
				info "Execution stage started", rtD, 1
			}
			success=executeEvent(rtD, event)
			syncTime=true
			firstTime=false
		}

		rtD.stats.timing.e=Math.round(1.0D*now()-startTime)
		if((Integer)rtD.logging>0)info msg2, rtD
		if(!success)msg.m='Event processing failed'
		if(eric())msg.m=(String)msg.m+' Total Pauses ms: '+((Long)rtD.tPause).toString()
		finalizeEvent(rtD, msg, success)

		if((Boolean)rtD.logPExec && (Map)rtD.currentEvent!=null){
			String desc='webCore piston \''+(String)app.label+'\' was executed'
			sendLocationEvent(name:'webCoRE', value:'pistonExecuted', isStateChange:true, displayed:false, linkText:desc, descriptionText:desc, data:[
				id:appId,
				name:(String)app.label,
				event:[date:new Date((Long)rtD.currentEvent.date), delay:(Long)rtD.currentEvent.delay, duration:now()-(Long)rtD.currentEvent.date, device:"${rtD.event.device}".toString(), name:(String)rtD.currentEvent.name, value:rtD.currentEvent.value, physical:(Boolean)rtD.currentEvent.physical, index:(Integer)rtD.currentEvent.index],
				state:[old:(String)rtD.state.old, new:(String)rtD.state.new]
			])
		}
	}
	for(String foo in heData) rtD.remove(foo)

// any queued events?
	String msgt
	if((Integer)rtD.logging>2)msgt='Exiting'
	String semName=(String)rtD.semaphoreName
	while(doSerialization && semName!=sNULL){
		Boolean a=getTheLock(semName, sHNDLEVT)
		List<Map> evtQ=(List<Map>)theQueuesFLD[semName]
		if(evtQ==null || evtQ==[]){
			if((Long)theSemaphoresFLD[semName]<=(Long)rtD.semaphore){
				if((Integer)rtD.logging>2) msgt='Released Lock and exiting'
				theSemaphoresFLD[semName]=0L
				theSemaphoresFLD=theSemaphoresFLD
			}
			releaseTheLock(semName)
			break
		}
		List<Map> evtList=evtQ.sort{ (Long)it.t }
		Map theEvent=evtList.remove(0)
		theQueuesFLD[semName]=evtList
		theQueuesFLD=theQueuesFLD
		releaseTheLock(semName)

		Integer qsize=(Integer)evtQ.size()
		if(qsize>8) log.error "large queue size ${qsize}".toString()
		theEvent.date=new Date((Long)theEvent.t)
		handleEvents(theEvent, false, true)
	}
	if((Integer)rtD.logging>2) log.debug msgt 
	if((Boolean)rtD.updateDevices) clearMyCache('updateDeviceList')
	data=rtD.collect{ it.key }
	for(item in data)rtD.remove((String)item)
	event=null
	rtD=null
}

@Field static final List<String> heData=[ 'event', 'currentEvent', 'state', 'created', 'modified', 'sunTimes']

private Boolean executeEvent(Map rtD, event){
	String myS
	if((Boolean)rtD.eric){
		myS='executeEvent'
		myDetail rtD, myS, 1
	}
	try{
/*		if(event instanceof com.hubitat.hub.domain.Event){
			Map myEvent=[
				date:(Date)event.date,
				name:(String)event.name,
				value:event.value,
				descriptionText:(String)event.descriptionText,
				unit:event.unit,
				physical:event.physical,
				jsonData:event.jsonData,
			]
			if(event.device!=null){
				myEvent.device=[id:event.device?.id, name:event.device?.name, label:event.device?.label]
				if(event.device?.hubs!=null){
					myEvent.device.hubs=[t:'tt']
				}
			}
			rtD.event=myEvent
		}else*/ rtD.event=event
		Map pEvt=(Map)state.lastEvent
		if(pEvt==null)pEvt=[:]
		rtD.previousEvent=pEvt
		String evntName=(String)event.name
		Integer index=0 //event?.index ?: 0
		if(event.jsonData!=null){
			Map attribute=Attributes()[evntName]
			String attrI=attribute!=null ? (String)attribute.i:sNULL
			if(attrI!=sNULL && event.jsonData[attrI]){ // .i is the attribute to lookup
				index=event.jsonData[attrI]
			}
			if(!index)index=1
		}
		Map srcEvent=null
		rtD.args=[:]
		Map sysV=(Map)rtD.systemVars
		if(event!=null){
			rtD.args= evntName==sTIME && event.schedule!=null && event.schedule.args!=null && event.schedule.args instanceof Map ? (Map)event.schedule.args:(event.jsonData!=null ? event.jsonData:[:])
			if(evntName==sTIME && event.schedule!=null){
				srcEvent=(Map)event.schedule.evt
				Map tMap=(Map)event.schedule.stack
				if(tMap!=null){
					sysV[sDLLRINDX].v=(Double)tMap.index
					sysV[sDLLRDEVICE].v=(List)tMap.device
					sysV[sDLLRDEVS].v=(List)tMap.devices
					rtD.json=tMap.json ?: [:]
					rtD.response=tMap.response ?: [:]
					index=srcEvent?.index ?: 0
// more to restore here?
					rtD.systemVars=sysV
				}
			}
		}
		setSystemVariableValue(rtD, sDOLARGS, rtD.args)
		sysV=(Map)rtD.systemVars

		String theDevice=srcEvent!=null ? (String)srcEvent.device:sNULL
		def theDevice1=theDevice==sNULL && event.device ? event.device.id:null
		String theFinalDevice=theDevice!=sNULL ? theDevice : (theDevice1!=null ? (!isDeviceLocation(event.device) ? hashId(theDevice1.toString()) : (String)rtD.locationId) : (String)rtD.locationId)
		Map myEvt=[
			date:(Long)((Date)event.date).getTime(),
			delay:rtD.stats?.timing?.d ? (Long)rtD.stats.timing.d : 0L,
			device:theFinalDevice,
			index:index
		]
		if(srcEvent!=null){
			myEvt=myEvt + [
				name:(String)srcEvent.name,
				value:srcEvent.value,
				descriptionText:(String)srcEvent.descriptionText,
				unit:srcEvent.unit,
				physical:(Boolean)srcEvent.physical,
			]
		}else{
			myEvt=myEvt + [
				name:evntName,
				value:event.value,
				descriptionText:(String)event.descriptionText,
				unit:event.unit,
				physical:!!event.physical,
			]
		}
		rtD.currentEvent=myEvt
		state.lastEvent=myEvt

		rtD.conditionStateChanged=false
		rtD.pistonStateChanged=false
		rtD.ffTo=0
		rtD.statementLevel=0
		rtD.break=false
		rtD.resumed=false
		rtD.terminated=false
		if(evntName==sTIME){
			rtD.ffTo=(Integer)event.schedule.i
		}
		sysV[sPEVDATE].v=pEvt.date ?: now()
		sysV[sPEVDELAY].v=pEvt.delay ?: 0L
		sysV[sPEVDEV].v=[pEvt.device]
		sysV[sPEVDEVINDX].v=pEvt.index ?: 0
		sysV[sPEVATTR].v=pEvt.name ?: sBLK
		sysV[sPEVDESC].v=pEvt.descriptionText ?: sBLK
		sysV[sPEVVALUE].v=pEvt.value ?: sBLK
		sysV[sPEVUNIT].v=pEvt.unit ?: sBLK
		sysV[sPEVPHYS].v=!!pEvt.physical

		sysV[sCURDATE].v=(Long)myEvt.date
		sysV[sCURDELAY].v=(Long)myEvt.delay
		sysV[sCURDEV].v=[myEvt.device]
		sysV[sCURDEVINDX].v=myEvt.index!=sBLK && myEvt.index!=null? (Integer)myEvt.index:0
		sysV[sCURATTR].v=(String)myEvt.name
		sysV[sCURDESC].v=(String)myEvt.descriptionText
		sysV[sCURVALUE].v=myEvt.value
		sysV[sCURUNIT].v=myEvt.unit
		sysV[sCURPHYS].v=(Boolean)myEvt.physical
		rtD.systemVars=sysV

		rtD.stack=[c: 0, s: 0, cs:[], ss:[]]
		Boolean ended=false
		try{
			Boolean allowed=!rtD.piston.r || rtD.piston.r.length==0 || evaluateConditions(rtD, (Map)rtD.piston, sR, true)
			rtD.restricted=!rtD.piston.o?.aps && !allowed //allowPreScheduled tasks to execute during restrictions
			if(allowed || (Integer)rtD.ffTo!=0){
				if((Integer)rtD.ffTo==-3){
					//device related time schedules
					if(!(Boolean)rtD.restricted){
						def data=event.schedule.d
						if(data!=null && (String)data.d && (String)data.c){
							//we have a device schedule, execute it
							def device=getDevice(rtD, (String)data.d)
							if(device!=null){
								//executing scheduled physical command
								//used by fades, flashes, etc.
								executePhysicalCommand(rtD, device, (String)data.c, data.p, 0L, sNULL, true)
							}
						}
					}
				}else{
					if(executeStatements(rtD, (List)rtD.piston.s)){
						ended=true
						tracePoint(rtD, sEND, 0L, 0)
					}
					processSchedules rtD
				}
			}else{
				if((Integer)rtD.logging>2)debug 'Piston execution aborted due to restrictions in effect', rtD
				//we need to run through all to update stuff
				rtD.ffTo=-9
				Boolean a=executeStatements(rtD, (List)rtD.piston.s)
				ended=true
				tracePoint(rtD, sEND, 0L, 0)
				processSchedules rtD
			}
			if(!ended)tracePoint(rtD, sBREAK, 0L, 0)
		}catch (all){
			error 'An error occurred while executing the event: ', rtD, -2, all
		}
		if((Boolean)rtD.eric) myDetail rtD, myS+' Result: TRUE', -1
		return true
	}catch(all){
		error 'An error occurred within executeEvent: ', rtD, -2, all
	}
	processSchedules rtD
	return false
}

@Field static final List<String> cleanData=[ 'allDevices', 'cachePersist', 'mem', 'break', 'powerSource', 'oldLocationId', 'incidents', 'lstarted', 'lended', 'pStart', 'pEnd', 'generatedIn', 'ended', 'semaphoreDelay', 'vars', 'stateAccess', 'author', 'bin', 'build', 'newCache', 'mediaData', 'weather', 'logs', 'trace', 'systemVars', 'localVars', 'currentAction', 'previousEvent', 'json', 'response', 'cache', 'store', 'settings', 'locationModeId', 'locationId', 'coreVersion', 'hcoreVersion', 'cancelations', 'conditionStateChanged', 'pistonStateChanged', 'ffTo', 'resumed', 'terminated', 'instanceId', 'wakingUp', 'statementLevel', 'args', 'nfl', 'temp' ]

private void finalizeEvent(Map rtD, Map initialMsg, Boolean success=true){
	Long startTime=now()
	Boolean myPep=(Boolean)rtD.pep

	processSchedules(rtD, true)

	if(success){
		if((Integer)rtD.logging>0)info initialMsg, rtD
	}else error initialMsg, rtD

	updateLogs(rtD, (Long)rtD.timestamp)

	String myId=(String)rtD.id

	rtD.trace.d=Math.round(1.0D*now()-(Long)rtD.trace.t)

	//flush the new cache value
	for(item in (Map)rtD.newCache)rtD.cache[(String)item.key]=item.value

	//overwrite state, might have changed meanwhile
	Map t0=getCachedMaps()
	String str='finalize '
	String semaName=app.id.toString()
	if(t0!=null){
		Boolean aa=getTheLock(semaName, str)
		theCacheFLD[myId].cache=[:]+(Map)rtD.cache
		theCacheFLD[myId].store=[:]+(Map)rtD.store
		theCacheFLD[myId].state=[:]+(Map)rtD.state
		theCacheFLD[myId].trace=[:]+(Map)rtD.trace
		releaseTheLock(semaName)
	}
	if(myPep){
		atomicState.cache=(Map)rtD.cache
		atomicState.store=(Map)rtD.store
		atomicState.state=[:]+(Map)rtD.state
		atomicState.trace=(Map)rtD.trace
	}else{
		state.cache=(Map)rtD.cache
		state.store=(Map)rtD.store
		state.state=[:]+(Map)rtD.state
		state.trace=(Map)rtD.trace
	}

//remove large stuff
	for(String foo in cleanData) rtD.remove(foo)
	if(!(rtD.event instanceof com.hubitat.hub.domain.Event)){
		if(rtD.event?.responseData)rtD.event.responseData=[:]
		if(rtD.event?.jsonData)rtD.event.jsonData=[:]
		if(rtD.event?.setRtData)rtD.event.setRtData=[:]
		if(rtD.event?.schedule?.stack)rtD.event.schedule.stack=[:]
	}

	if((Boolean)rtD.updateDevices) updateDeviceList(rtD, rtD.devices*.value.id)
	rtD.remove('devices')

	Boolean a
	if(rtD.gvCache!=null || rtD.gvStoreCache!=null){
		LinkedHashMap tpiston=(LinkedHashMap)rtD.piston
		rtD.piston=[:]
		rtD.piston.z=(String)tpiston.z
		tpiston=null
		if(rtD.gvCache!=null){
			String lockTyp='finalize'
			String semName=sTGBL
			a=getTheLock(semName, lockTyp)
			for(var in rtD.gvCache){
				Map vars=globalVarsFLD
				String varName=(String)var.key
				if(varName && (Boolean)varName.startsWith(sAT) && vars[varName] && var.value.v!=vars[varName].v){
					globalVarsFLD[varName].v=var.value.v
					globalVarsFLD=globalVarsFLD
				}
			}
			releaseTheLock(semName)
		}
		parent.pCallupdateRunTimeData(rtD)
		rtD.remove('gvCache')
		rtD.remove('gvStoreCache')
		rtD.initGStore=false
	}else{
		Map myRt=shortRtd(rtD)
		myRt.t=now()
		parent.pCallupdateRunTimeData(myRt)
	}
	rtD.piston=null

	rtD.stats.timing.u=Math.round(1.0D*now()-startTime)
//update graph data
	Map stats
	if(myPep)stats=(Map)atomicState.stats
	else stats=(Map)state.stats
	stats=stats ?: [:]

	List tlist=(List)stats.timing ?: []
	Map lastST= (Integer)tlist.size() ? [:]+(Map)tlist.last() : null
	Map newMap=[:]+(Map)rtD.stats.timing
	if(lastST && newMap){
		lastST.t=(Long)newMap.t-10L
		a=tlist.push(lastST)
	}
	a=tlist.push(newMap)
	Integer t1=settings.maxStats!=null ? (Integer)settings.maxStats: (Integer)getPistonLimits.maxStats
	if(t1<=0)t1=(Integer)getPistonLimits.maxStats
	if(t1<2)t1=2
	Integer t2=(Integer)tlist.size()
	if(t2>t1)tlist=tlist[t2-t1..t2-1]

	stats.timing=tlist
	if(myPep)atomicState.stats=stats
	else state.stats=stats
	rtD.stats.timing=null

	t0=getCachedMaps()
	if(t0!=null){
		Long totTime=Math.round(now()*1.0D-(Long)rtD.timestamp)
		t1=20
		String t4=mem()
		Boolean aa=getTheLock(semaName, str+sONE)
		theCacheFLD[myId].mem=t4
		theCacheFLD[myId].runStats=[:]+(Map)rtD.curStat
		List hisList=(List)theCacheFLD[myId].runTimeHis
		Boolean b=hisList.push(totTime)
		t2=(Integer)hisList.size()
		if(t2>t1) hisList=hisList[t2-t1..t2-1]
		theCacheFLD[myId].runTimeHis=hisList
		releaseTheLock(semaName)
	}
}

private void processSchedules(Map rtD, Boolean scheduleJob=false){
	Boolean myPep=(Boolean)rtD.pep

	List<Map> schedules
	Map t0=getCachedMaps()
	if(t0!=null)schedules=(List<Map>)[]+(List<Map>)t0.schedules
	else schedules=myPep ? (List<Map>)atomicState.schedules:(List<Map>)state.schedules

	//if automatic piston states, we set it based on the autoNew - if any
	if(rtD.piston.o?.mps==null || !rtD.piston.o.mps) rtD.state.new=(String)rtD.state.autoNew ?: sTRUE
	rtD.state.old=(String)rtD.state.new

	if((Boolean)rtD.cancelations.all) Boolean a=schedules.removeAll{ (Integer)it.i>0 }

	//cancel statements
	Boolean b=schedules.removeAll{ Map schedule -> !!((List<Map>)rtD.cancelations.statements).find{ Map cancelation -> (Integer)cancelation.id==(Integer)schedule.s && (!cancelation.data || ((String)cancelation.data==(String)schedule.d))}}

	//cancel on conditions
	for(Integer cid in (List<Integer>)rtD.cancelations.conditions){
		Boolean a=schedules.removeAll{ cid in (List)it.cs }
	}

	//cancel on piston state change
	if((Boolean)rtD.pistonStateChanged){
		Boolean a=schedules.removeAll{ (Integer)it.ps!=0 }
	}

	rtD.cancelations=[statements:[], conditions:[], all:false]
	schedules=(schedules+(List<Map>)rtD.schedules)//.sort{ (Long)it.t }

	if(myPep)atomicState.schedules=schedules
	else state.schedules=(List<Map>)[]+schedules
	String myId=(String)rtD.id
	String semaName=app.id.toString()
	t0=getCachedMaps()
	if(t0!=null){
		Boolean aa=getTheLock(semaName, sT)
		theCacheFLD[myId].schedules=(List<Map>)[]+schedules
		releaseTheLock(semaName)
	}

	if(scheduleJob){
		Long nextT=0L
		Integer ssz=(Integer)schedules.size()
		if(ssz>0){
			Map tnext=((List<Map>)schedules).sort{ (Long)it.t }[0]
			nextT=(Long)tnext.t
			Long t=Math.round((nextT-now())/1000.0D)
			t=(t<1L ? 1L:t)
			runIn(t, timeHandler, [data: tnext])

			if((Integer)rtD.logging>0) info 'Setting up scheduled job for '+formatLocalTime(nextT)+' (in '+t.toString()+'s)' + ((ssz)>1 ? ', with ' + (ssz-1).toString() + ' more job' + (ssz>2 ? sS : sBLK) + ' pending' : sBLK), rtD
		}
		if(nextT==0L && (Long)rtD.nextSchedule!=0L){
			unschedule(timeHandler)
		}

		rtD.nextSchedule=nextT
		rtD.stats.nextSchedule=nextT
		state.nextSchedule=nextT
		t0=getCachedMaps()
		if(t0!=null){
			Boolean aa=getTheLock(semaName, sT+sONE)
			theCacheFLD[myId].nextSchedule=nextT
			releaseTheLock(semaName)
		}
	}
	rtD.schedules=[]
}

private void updateLogs(Map rtD, Long lastExecute=null){
	if(!rtD || !rtD.logs)return

	String myId=(String)rtD.id
	Map cacheMap
	String semaName=app.id.toString()
	if(lastExecute!=null){
		state.lastExecuted=lastExecute
		cacheMap=getCachedMaps()
		if(cacheMap!=null){
			Boolean aa=getTheLock(semaName, sE)
			theCacheFLD[myId].lastExecuted=lastExecute
			theCacheFLD[myId].temp=[:]+(Map)rtD.temp
			theCacheFLD[myId].cachePersist=[:]+(Map)rtD.cachePersist
			releaseTheLock(semaName)
		}
	}

	if((Integer)((List)rtD.logs).size()>1){
		Boolean myPep=(Boolean)rtD.pep
		Integer t1=settings.maxLogs!=null ? (Integer)settings.maxLogs:(Integer)getPistonLimits.maxLogs
		if(t1<0)t1=(Integer)getPistonLimits.maxLogs

		List t0
		cacheMap=getCachedMaps()
		if(cacheMap!=null)t0=[]+(List)cacheMap.logs
		else t0=myPep ? (List)atomicState.logs:(List)state.logs
		List logs=[]+(List)rtD.logs+t0
		if(t1>=0){
			Integer t2=(Integer)logs.size()
			if(t1==0 || t2==0) logs=[]
			else{
				if(t1< t2-1) logs=logs[0..t1]
				if(t1>5 && (Integer)state.toString().size()>75000){
					t1 -= Math.min(50, Math.round(t1/2.0D))
					logs=logs[0..t1]
					if(!myPep) state.logs=logs //this mixes state and AS
				}
			}
		}
		cacheMap=getCachedMaps()
		if(cacheMap!=null){
			Boolean aa=getTheLock(semaName, sE+sONE)
			theCacheFLD[myId].logs=logs
			releaseTheLock(semaName)
		}
		if(myPep)atomicState.logs=logs
		else state.logs=logs
	}
	rtD.logs=[]
}

private Boolean executeStatements(Map rtD, List<Map> statements, Boolean async=false){
	rtD.statementLevel=(Integer)rtD.statementLevel+1
	for(Map statement in statements){
		//only execute statements that are enabled
		Boolean disab=statement.di!=null && (Boolean)statement.di
		if(!disab && !executeStatement(rtD, statement, async)){
			//stop processing
			rtD.statementLevel=(Integer)rtD.statementLevel-1
			return false
		}
	}
	//continue processing
	rtD.statementLevel=(Integer)rtD.statementLevel-1
	return true
}

private Boolean executeStatement(Map rtD, Map statement, Boolean async=false){
	//if rtD.ffTo is a positive, non-zero number, we need to fast forward through all
	//branches until we find the task with an id equal to that number, then we play nicely after that
	if(statement==null)return false
	Integer statementNum=statement.$!=null ? (Integer)statement.$:0
	if((Integer)rtD.ffTo==0){
		String sMsg="Skipping execution for statement #${statementNum} because "
		switch ((String)statement.tep){ // Task Execution Policy
		case sC:
			if(!(Boolean)rtD.conditionStateChanged){
				if((Integer)rtD.logging>2)debug sMsg+'condition state did not change', rtD
				return true
			}
			break
		case sP:
			if(!(Boolean)rtD.pistonStateChanged){
				if((Integer)rtD.logging>2)debug sMsg+'piston state did not change', rtD
				return true
			}
			break
		case sB:
			if( !(Boolean)rtD.conditionStateChanged && !(Boolean)rtD.pistonStateChanged){
				if((Integer)rtD.logging>2)debug sMsg+'neither condition state nor piston state changed', rtD
				return true
			}
			break
		}
	}
	String mySt
	if((Boolean)rtD.eric){
		mySt='executeStatement '+(String)statement.t
		myDetail rtD, mySt, 1
	}
	Boolean a=((List<Integer>)rtD.stack.ss).push((Integer)rtD.stack.s)
	rtD.stack.s=statementNum
	Long t=now()
	Boolean value=true
	Integer c=(Integer)rtD.stack.c
	Boolean stacked=true /* cancelable on condition change */
	if(stacked)a=((List<Integer>)rtD.stack.cs).push(c)
	Boolean svCSC=(Boolean)rtD.conditionStateChanged
	//def parentAsync=async
	Double svIndex=(Double)rtD.systemVars[sDLLRINDX].v
	List svDevice=(List)rtD.systemVars[sDLLRDEVICE].v
	Boolean selfAsync= (String)statement.a==sONE || (String)statement.t==sEVERY || (String)statement.t==sON // execution method
	async=async || selfAsync
	Boolean myPep=(Boolean)rtD.pep
	Boolean perform=false
	Boolean repeat=true
	Double index=null
	Boolean allowed=!(List)statement.r || ((List)statement.r).length==0 || evaluateConditions(rtD, statement, sR, async)
	if(allowed || (Integer)rtD.ffTo!=0){
		while(repeat){
			switch ((String)statement.t){
			case sEVERY:
				//we override current condition that child statements can cancel on it
				Boolean ownEvent= rtD.event!=null && (String)rtD.event.name==sTIME && rtD.event.schedule!=null && (Integer)rtD.event.schedule.s==statementNum && (Integer)rtD.event.schedule.i<0

				List<Map> schedules
				Map t0=getCachedMaps()
				if(t0!=null)schedules=[]+(List<Map>)t0.schedules
				else schedules=myPep ? (List<Map>)atomicState.schedules:(List<Map>)state.schedules
				if(ownEvent || !schedules.find{ (Integer)it.s==statementNum }){
					//if the time has come for our timer, schedule the next timer
					//if no next time is found quick enough, a new schedule with i=-2 will be setup so that a new attempt can be made at a later time
					if(ownEvent)rtD.ffTo=0
					scheduleTimer(rtD, statement, ownEvent ? (Long)rtD.event.schedule.t:0L)
				}
				rtD.stack.c=statementNum
				if(ownEvent)rtD.ffTo=0
				if((Integer)rtD.ffTo!=0 || (ownEvent && allowed && !(Boolean)rtD.restricted)){
					//we don't want to run this if there are piston restrictions in effect
					//we only execute the every if i=-1 (for rapid timers with large restrictions i.e. every second, but only on Mondays)we need to make sure we don't block execution while trying
					//to find the next execution scheduled time, so we give up after too many attempts and schedule a rerun with i=-2 to give us the chance to try again at that later time
					if((Integer)rtD.ffTo!=0 || (Integer)rtD.event.schedule.i==-1)a=executeStatements(rtD, (List)statement.s, true)
					//we always exit a timer, this only runs on its own schedule, nothing else is executed
					if(ownEvent)rtD.terminated=true
					value=false
					break
				}
				value=true
				break
			case sREPEAT:
				//we override current condition that child statements can cancel on it
				rtD.stack.c=statementNum
				if(!executeStatements(rtD, (List)statement.s, async)){
					//stop processing
					value=false
					if((Integer)rtD.ffTo==0)break
				}
				value=true
				perform= !evaluateConditions(rtD, statement, sC, async)
				break
			case sON:
				perform=false
				if((Integer)rtD.ffTo==0){
					//look to see if any of the event matches
					String deviceId= rtD.event.device!=null ? hashId(rtD.event.device.id):sNULL
					for(event in statement.c){
						def operand=event.lo
						if(operand!=null && (String)operand.t){
							switch ((String)operand.t){
							case sP:
								if(deviceId!=sNULL && (String)rtD.event.name==(String)operand.a && (List)operand.d!=[] && deviceId in expandDeviceList(rtD, (List)operand.d, true)) perform=true
								break
							case sV:
								if((String)rtD.event.name==(String)operand.v) perform=true
								break
							case sX:
								String operX=(String)operand.x
								if(rtD.event.value==operX && (String)rtD.event.name==(String)rtD.instanceId+sDOT+operX) perform=true
								break
							}
						}
						if(perform)break
					}
				}
				value= (Integer)rtD.ffTo!=0 || perform ? executeStatements(rtD, (List)statement.s, async):true
				break
			case sIF:
			case sWHILE:
				//check conditions for if and while
				perform=evaluateConditions(rtD, statement, sC, async)
				//we override current condition that child statements can cancel on it
				rtD.stack.c=statementNum
				if((Integer)rtD.ffTo==0 && !rtD.piston.o?.mps && (String)statement.t==sIF && (Integer)rtD.statementLevel==1 && perform){
					//automatic piston state
					rtD.state.autoNew=sTRUE
				}
				if(perform || (Integer)rtD.ffTo!=0){
					if((String)statement.t in [sIF, sWHILE]){
						if(!executeStatements(rtD, (List)statement.s, async)){
							//stop processing
							value=false
							if((Integer)rtD.ffTo==0)break
						}
						value=true
						if((Integer)rtD.ffTo==0)break
					}
				}
				if(!perform || (Integer)rtD.ffTo!=0){
					if((String)statement.t==sIF){
						//look for else-ifs
						for(Map elseIf in (List<Map>)statement.ei){
							perform=evaluateConditions(rtD, elseIf, sC, async)
							if(perform || (Integer)rtD.ffTo!=0){
								if(!executeStatements(rtD, (List)elseIf.s, async)){
									//stop processing
									value=false
									if((Integer)rtD.ffTo==0)break
								}
								value=true
								if((Integer)rtD.ffTo==0)break
							}
						}
						if((Integer)rtD.ffTo==0 && !rtD.piston.o?.mps && (Integer)rtD.statementLevel==1){
							//automatic piston state
								rtD.state.autoNew=sFALSE
						}
						if((!perform || (Integer)rtD.ffTo!=0) && !executeStatements(rtD, (List)statement.e, async)){
							//stop processing
							value=false
							if((Integer)rtD.ffTo==0)break
						}
					}
				}
				break
			case sFOR:
			case sEACH:
				List devices=[]
				Double startValue=0.0D
				Double endValue
				Double stepValue=1.0D
				Integer dsiz=(Integer)devices.size()
				if((String)statement.t==sEACH){
					List t0=(List)((Map)evaluateOperand(rtD, null, (Map)statement.lo)).v
					devices=t0 ?: []
					dsiz=(Integer)devices.size()
					endValue=dsiz-1.0D
				}else{
					startValue=(Double)evaluateScalarOperand(rtD, statement, (Map)statement.lo, null, sDCML).v
					endValue=(Double)evaluateScalarOperand(rtD, statement, (Map)statement.lo2, null, sDCML).v
					Double t0=(Double)evaluateScalarOperand(rtD, statement, (Map)statement.lo3, null, sDCML).v
					stepValue=t0 ?: 1.0D
				}
				String counterVariable=(String)getVariable(rtD, (String)statement.x).t!=sERROR ? (String)statement.x:sNULL
				String sidx='f:'+statementNum.toString()
				if( (startValue<=endValue && stepValue>0.0D) || (startValue>=endValue && stepValue<0.0D) || (Integer)rtD.ffTo!=0){
					//initialize the for loop
					if((Integer)rtD.ffTo!=0)index=(Double)cast(rtD, rtD.cache[sidx], sDCML)
					if(index==null){
						index=(Double)cast(rtD, startValue, sDCML)
						//index=startValue
						rtD.cache[sidx]=index
					}
					rtD.systemVars[sDLLRINDX].v=index
					if((String)statement.t==sEACH && ((Integer)rtD.ffTo==0||(Integer)rtD.ffTo==-9))setSystemVariableValue(rtD, sDLLRDEVICE, index<dsiz ? [devices[index.toInteger()]]:[])
					if(counterVariable!=sNULL && (Integer)rtD.ffTo==0)def m=setVariable(rtD, counterVariable, (String)statement.t==sEACH ? (index<dsiz ? [devices[index.toInteger()]]:[]):index)
					//do the loop
					perform=executeStatements(rtD, (List)statement.s, async)
					if(!perform){
						//stop processing
						value=false
						if((Boolean)rtD.break){
							//we reached a break, so we really want to continue execution outside of the for
							value=true
							rtD.break=false
							//perform=false
						}
						break
					}
					//don't do the rest if we're fast forwarding
					if((Integer)rtD.ffTo!=0)break
					index=index+stepValue
					rtD.systemVars[sDLLRINDX].v=index
					if((String)statement.t==sEACH && (Integer)rtD.ffTo==0)setSystemVariableValue(rtD, sDLLRDEVICE, index<dsiz ? [devices[index.toInteger()]]:[])
					if(counterVariable!=sNULL && (Integer)rtD.ffTo==0)def n=setVariable(rtD, counterVariable, (String)statement.t==sEACH ? (index<dsiz ? [devices[index.toInteger()]]:[]):index)
					rtD.cache[sidx]=index
					if((stepValue>0.0D && index>endValue) || (stepValue<0.0D && index<endValue)){
						perform=false
						break
					}
				}
				break
			case sSWITCH:
				Map lo=[operand: (Map)statement.lo, values: (List)evaluateOperand(rtD, statement, (Map)statement.lo)]
				//go through all cases
				Boolean found=false
				Boolean implicitBreaks= (String)statement.ctp==sI // case traversal policy
				Boolean fallThrough=!implicitBreaks
				perform=false
				if((Integer)rtD.logging>2)debug "Evaluating switch with values $lo.values", rtD
				for(Map _case in (List<Map>)statement.cs){
					Map ro=[operand: (Map)_case.ro, values: (List)evaluateOperand(rtD, _case, (Map)_case.ro)]
					Map ro2= (String)_case.t==sR ? [operand: (Map)_case.ro2, values: (List)evaluateOperand(rtD, _case, (Map)_case.ro2, null, false, true)]:null
					perform=perform || evaluateComparison(rtD, ((String)_case.t==sR ? 'is_inside_of_range' : 'is'), lo, ro, ro2)
					found=found || perform
					if(perform || (found && fallThrough)|| (Integer)rtD.ffTo!=0){
						Integer ffTo=(Integer)rtD.ffTo
						if(!executeStatements(rtD, (List)_case.s, async)){
							//stop processing
							value=false
							if((Boolean)rtD.break){
								//we reached a break, so we really want to continue execution outside of the switch
								value=true
								found=true
								fallThrough=false
								rtD.break=false
							}
							if((Integer)rtD.ffTo==0){
								break
							}
						}
						//if we determine that the fast forwarding ended during this execution, we assume found is true
						found=found || (ffTo!=(Integer)rtD.ffTo)
						value=true
						//if implicit breaks
						if(implicitBreaks && (Integer)rtD.ffTo==0){
							fallThrough=false
							break
						}
					}
				}
				if(statement.e && ((List)statement.e).length && (value || (Integer)rtD.ffTo!=0) && (!found || fallThrough || (Integer)rtD.ffTo!=0)){
					//no case found, let's do the default
					if(!executeStatements(rtD, (List)statement.e, async)){
						//stop processing
						value=false
						if((Boolean)rtD.break){
							//we reached a break, so we really want to continue execution outside of the switch
							value=true
							rtD.break=false
						}
						if((Integer)rtD.ffTo==0)break
					}
				}
				break
			case sACTION:
				value=executeAction(rtD, statement, async)
				break
			case sDO:
				value=executeStatements(rtD, (List)statement.s, async)
				break
			case sBREAK:
				if((Integer)rtD.ffTo==0){
					rtD.break=true
				}
				value=false
				break
			case sEXIT:
				if((Integer)rtD.ffTo==0){
					vcmd_setState(rtD, null, [(String)cast(rtD, ((Map)evaluateOperand(rtD, null, (Map)statement.lo)).v, sSTR)])
					rtD.terminated=true
				}
				value=false
				break
			}
			//break the loop
			if((Integer)rtD.ffTo!=0 || (String)statement.t==sIF)perform=false

			//is this statement a loop
			Boolean loop=((String)statement.t in [sWHILE, sREPEAT, sFOR, sEACH])
			if(loop && !value && (Boolean)rtD.break){
				//someone requested a break from the loop, we're doing it
				rtD.break=false
				//but we're allowing the rest to continue
				value=true
				perform=false
			}
			//do we repeat the loop?
			repeat=perform && value && loop && (Integer)rtD.ffTo==0

			Long overBy=checkForSlowdown(rtD)
			if(overBy>0L){
				Long delay=(Long)getPistonLimits.taskShortDelay
				if(overBy>(Long)getPistonLimits.useBigDelay){
					delay=(Long)getPistonLimits.taskLongDelay
				}
				String mstr="executeStatement: Execution time exceeded by ${overBy}ms, ".toString()
				if(repeat && overBy>(Long)getPistonLimits.executionTime){
					error mstr+'Terminating', rtD
					rtD.terminated=true
					repeat=false
				}else{
					Long b=doPause(mstr+'Waiting for '+delay+'ms', delay, rtD)
				}
			}
		}
	}
	if((Integer)rtD.ffTo==0){
		Map schedule
		if((String)statement.t==sEVERY){
			Map t0=((List<Map>)rtD.schedules).find{ (Integer)it.s==statementNum}
			if(t0==null){
				List<Map> schedules
				Map t1=getCachedMaps()
				if(t1!=null)schedules=[]+(List<Map>)t1.schedules
				else schedules=myPep ? (List<Map>)atomicState.schedules:(List<Map>)state.schedules
				schedule=schedules.find{ (Integer)it.s==statementNum }
			}else schedule=t0
		}
		String myS="s:${statementNum}".toString()
		Long myL=Math.round(1.0D*now()-t)
		if(schedule!=null){
			//timers need to show the remaining time
			tracePoint(rtD, myS, myL, Math.round(1.0D*now()-(Long)schedule.t))
		}else{
			tracePoint(rtD, myS, myL, value)
		}
	}
	//if(statement.a==sONE){
		//when an async action requests the thread termination, we continue to execute the parent
		//when an async action terminates as a result of a time event, we exit completely
//		value=(rtD.event.name!=sTIME)
	//}
	if(selfAsync){
		//if running in async mode, we return true (to continue execution)
		value=!(Boolean)rtD.resumed
		rtD.resumed=false
	}
	if((Boolean)rtD.terminated){
		value=false
	}
	//restore current condition
	rtD.stack.c=c
	if(stacked){
		Integer tc=((List<Integer>)rtD.stack.cs).pop()
	}
	rtD.stack.s=(Integer)((List<Integer>)rtD.stack.ss).pop()
	rtD.systemVars[sDLLRINDX].v=svIndex
	rtD.systemVars[sDLLRDEVICE].v=svDevice
	rtD.conditionStateChanged=svCSC
	Boolean ret=value || (Integer)rtD.ffTo!=0
	if((Boolean)rtD.eric) myDetail rtD, mySt+" result: $ret".toString(), -1
	return ret
}

private Long checkForSlowdown(Map rtD){
	//return how long over the time limit we are
	Long overBy=0L
	Long curRunTime=Math.round(1.0D*now()-(Long)rtD.timestamp-(Long)getPistonLimits.slTime)
	if(curRunTime>overBy){
		overBy=curRunTime
	}
	return overBy
}

private Long doPause(String mstr, Long delay, Map rtD){
	Long actDelay=0L
	Long t0=now()
	if((Long)rtD.lastPause==null || (t0-(Long)rtD.lastPause)>1000L){
		if((Integer)rtD.logging>1)trace mstr+'; lastPause: '+rtD.lastPause, rtD
		rtD.lastPause=t0
		pauseExecution(delay)
		Long t1=now()
		actDelay=t1-t0
		Long t2=(Long)rtD.tPause!=null ? (Long)rtD.tPause : 0L
		rtD.tPause=t2+actDelay
		rtD.lastPause=t1
		t2=(Long)state.pauses!=null ? (Long)state.pauses : 0L
		state.pauses=t2+1L
	}
	return actDelay
}

private Boolean executeAction(Map rtD, Map statement, Boolean async){
	String mySt
	if((Boolean)rtD.eric){
		mySt='executeAction'
		myDetail rtD, mySt, 1
	}
	List svDevices=(List)rtD.systemVars[sDLLRDEVS].v
	//if override
	if((Integer)rtD.ffTo==0 && (String)statement.tsp!='a'){ // Task scheduling policy
		cancelStatementSchedules(rtD, (Integer)statement.$)
	}
	Boolean result=true
	List deviceIds=expandDeviceList(rtD, (List)statement.d)
	List devices=deviceIds.collect{ getDevice(rtD, (String)it)}
	rtD.currentAction=statement
	for(Map task in (List<Map>)statement.k){
		if(task.$!=null && (Integer)task.$==(Integer)rtD.ffTo){
			//resuming a waiting task, we need to bring back the devices
			if(rtD.event && rtD.event.schedule && rtD.event.schedule.stack){
				rtD.systemVars[sDLLRINDX].v=(Double)rtD.event.schedule.stack.index
				rtD.systemVars[sDLLRDEVICE].v=(List)rtD.event.schedule.stack.device
				if(rtD.event.schedule.stack.devices instanceof List){
					deviceIds=(List)rtD.event.schedule.stack.devices
					rtD.systemVars[sDLLRDEVS].v=deviceIds
					devices=deviceIds.collect{ getDevice(rtD, (String)it)}
				}
			}
		}
		rtD.systemVars[sDLLRDEVS].v=deviceIds
		result=executeTask(rtD, devices, statement, task, async)
		if(!result && (Integer)rtD.ffTo==0){
			break
		}
	}
	rtD.systemVars[sDLLRDEVS].v=svDevices
	if((Boolean)rtD.eric) myDetail rtD, mySt+" result: $result".toString(), -1
	return result
}

private Boolean executeTask(Map rtD, List devices, Map statement, Map task, Boolean async){
	Long t=now()
	String myS='t:'+(Integer)task.$
	if((Integer)rtD.ffTo!=0){
		if((Integer)task.$==(Integer)rtD.ffTo){
			//finally found the resuming point, play nicely from hereon
			tracePoint(rtD, myS, Math.round(1.0D*now()-t), null)
			rtD.ffTo=0
			//restore $device and $devices
			rtD.resumed=true
		}
		//we're not doing anything, we're fast forwarding...
		return true
	}
	if(task.m!=null && task.m instanceof List && (Integer)((List)task.m).size()>0){
		if(rtD.locationModeId==null){
			def mode=location.getCurrentMode()
			rtD.locationModeId=mode!=null ? hashId(mode.getId()):null
		}
		if(!((String)rtD.locationModeId in (List)task.m)){
			if((Integer)rtD.logging>2)debug "Skipping task ${(Integer)task.$} because of mode restrictions", rtD
			return true
		}
	}
	String mySt
	if((Boolean)rtD.eric){
		mySt='executeTask '+(String)task.c
		myDetail rtD, mySt, 1
	}
	//parse parameters
	List params=[]
	for(Map param in (List<Map>)task.p){
		def p
		switch ((String)param.vt){
		case sVARIABLE:
			if((String)param.t==sX) p=param.x instanceof List ? (List)param.x : (String)param.x + ((String)param.xi!=sNULL ? sLB+(String)param.xi+sRB:sBLK)
			break
		default:
			Map v=(Map)evaluateOperand(rtD, null, param)
			//if not selected, we want to return null
			String tt1=(String)param.vt //?: (String)v.vt
			def t0=v.v
			Boolean match=(tt1!=null && ((tt1==(String)v.t)|| (t0 instanceof String && tt1 in [sSTR, sENUM, sTEXT])||
					(t0 instanceof Integer && tt1==sINT)||
					(t0 instanceof Long && tt1==sLONG)||
					(t0 instanceof Double && tt1==sDCML)||
					(t0 instanceof BigDecimal && tt1==sDCML)))
			p=(t0!=null)? (!match ? evaluateExpression(rtD, v, tt1).v:t0):null
		}
		//ensure value type is successfuly passed through
		Boolean a=params.push(p)
	}

	//handle duplicate command "push" which was replaced with fake command "pushMomentary"
	def override=CommandsOverrides.find{ (String)it.value.r==(String)task.c }
	String command=override ? (String)override.value.c:(String)task.c

	def virtualDevice=(Integer)devices.size()!=0 ? null:location
	Map vcmd=VirtualCommands()[command]
	Long delay=0L
	for(device in (virtualDevice!=null ? [virtualDevice]:devices)){
		if(virtualDevice==null && device.hasCommand(command) && !(vcmd && vcmd.o /*virtual command overrides physical command*/)){
			Map msg=timer "Executed [$device].${command}", rtD
			try{
				delay="cmd_${command}"(rtD, device, params)
			}catch(all){
				executePhysicalCommand(rtD, device, command, params)
			}
			if((Integer)rtD.logging>1)trace msg, rtD
		}else{
			if(vcmd!=null){
				delay=executeVirtualCommand(rtD, vcmd.a ? devices:device, command, params)
				//aggregate commands only run once, for all devices at the same time
				if(vcmd.a)break
			}
		}
	}
	//if we don't have to wait, we're home free

	//negative delays force us to reschedule, no sleeping on this one
	Boolean reschedule= delay<0L
	delay=reschedule ? -delay:delay

	if(delay!=0L){
		//get remaining piston time
		if(reschedule || async || delay>(Long)getPistonLimits.taskMaxDelay){
			//schedule a wake up
			Long sec=Math.round(delay/1000.0D)
			if((Integer)rtD.logging>1)trace "Requesting a wake up for ${formatLocalTime(Math.round(now()*1.0D+delay))} (in ${sec}s)", rtD
			tracePoint(rtD, myS, Math.round(1.0D*now()-t), -delay)
			requestWakeUp(rtD, statement, task, delay, (String)task.c)
			if((Boolean)rtD.eric) myDetail rtD, mySt+" result: FALSE".toString(), -1
			return false
		}else{
			if((Integer)rtD.logging>1)trace "executeTask: Waiting for ${delay}ms", rtD
			pauseExecution(delay)
		}
	}
	tracePoint(rtD, myS, Math.round(1.0D*now()-t), delay)

	//get remaining piston time
	Long overBy=checkForSlowdown(rtD)
	if(overBy>0L){
		Long mdelay=(Long)getPistonLimits.taskShortDelay
		if(overBy>(Long)getPistonLimits.useBigDelay){
			mdelay=(Long)getPistonLimits.taskLongDelay
		}
		Long actDelay=doPause("executeTask: Execution time exceeded by ${overBy}ms, Waiting for ${mdelay}ms", mdelay, rtD)
	}
	if((Boolean)rtD.eric) myDetail rtD, mySt+" result: TRUE".toString(), -1
	return true
}

private Long executeVirtualCommand(Map rtD, devices, String command, List params){
	Map msg=timer "Executed virtual command ${devices ? (devices instanceof List ? "$devices.":"[$devices]."):sBLK}${command}", rtD
	Long delay=0L
	try{
		delay="vcmd_${command}"(rtD, devices, params)
		if((Integer)rtD.logging>1)trace msg, rtD
	}catch(all){
		msg.m="Error executing virtual command ${devices instanceof List ? "$devices":"[$devices]"}.${command}:"
		msg.e=all
		error msg, rtD
	}
	return delay
}

private void executePhysicalCommand(Map rtD, device, String command, params=[], Long delay=0L, String scheduleDevice=sNULL, Boolean disableCommandOptimization=false){
	if(delay!=0L && scheduleDevice!=sNULL){
		//delay without schedules is not supported in hubitat
		//scheduleDevice=hashId(device.id)
		//we're using schedules instead
		Map statement=(Map)rtD.currentAction
		List<Integer> cs=[]+ ((String)statement.tcp==sB || (String)statement.tcp==sC ? (rtD.stack?.cs!=null ? (List<Integer>)rtD.stack.cs:[]):[]) // task cancelation policy
		Integer ps= (String)statement.tcp==sB || (String)statement.tcp==sP ? 1:0
		Boolean a=cs.removeAll{ it==0 }
		Map schedule=[
			t:(Long)Math.round(now()*1.0D+delay),
			s:(Integer)statement.$,
			i:-3,
			cs:cs,
			ps:ps,
			d:[
				d:scheduleDevice,
				c:command,
				p:params
			]
		]
		if((Boolean)rtD.eric)trace "Requesting a physical command wake up for ${formatLocalTime(Math.round(now()*1.0D+delay))}", rtD
		a=((List<Map>)rtD.schedules).push(schedule)
	}else{
		List nparams=(params instanceof List)? (List)params:(params!=null ? [params]:[])
		try{
			//cleanup the params so that SONOS works
			while ((Integer)nparams.size()>0 && nparams[(Integer)nparams.size()-1]==null)def a=nparams.pop()
			Map msg
			Boolean doL=(Integer)rtD.logging>2
			if(doL) msg=timer sBLK, rtD
			Boolean skip=false
			if(!rtD.piston.o?.dco && !disableCommandOptimization && !(command in [sSCLRTEMP, sSCLR, sSHUE, sSSATUR])){
				def cmd=PhysicalCommands()[command]
				if(cmd!=null && (String)cmd.a!=sNULL){
					if(cmd.v!=null && (Integer)nparams.size()==0){
						//commands with no parameter that set an attribute to a preset value
						if((String)getDeviceAttributeValue(rtD, device, (String)cmd.a)==(String)cmd.v){
							skip=true
						}
					}else if((Integer)nparams.size()==1){
						if(getDeviceAttributeValue(rtD, device, (String)cmd.a)==nparams[0]){
							skip=(command in [sSTLVL, sSTIFLVL] ? (String)getDeviceAttributeValue(rtD, device, sSWITCH)==sON:true)
						}
					}
				}
			}
			//if we're skipping, we already have a message
			String tstr
			if(doL) tstr=' physical command ['+"${(String)device.label ?: (String)device.name}".toString()+'].'+command+'('
			if(skip){
				if(doL) msg.m='Skipped execution of'+tstr+"$nparams".toString()+') because it would make no change to the device.'
			}else{
				String tailStr
				if(doL) tailStr=')'
				if(delay>(Long)getPistonLimits.taskMaxDelay)delay=1000L
				if(delay>0L){
					pauseExecution(delay) //simulated in hubitat
					if(doL) tailStr="[delay: $delay])".toString()
				}
				if(doL) tstr='Executed'+tstr
				if((Integer)nparams.size()>0){
					if(doL) msg.m=tstr+"$nparams".toString()+', '+tailStr
					device."$command"(nparams as Object[])
				}else{
					if(doL) msg.m=tstr+tailStr
					device."$command"()
				}
			}
			if(doL)debug msg, rtD
		}catch(all){
			error "Error while executing physical command $device.$command($nparams):", rtD, -2, all
		}
		Long t0=rtD.piston.o?.ced ? (Integer)rtD.piston.o.ced:0L
		if(t0!=0L){
			if(t0>(Long)getPistonLimits.taskMaxDelay)t0=1000L
			pauseExecution(t0)
			if((Integer)rtD.logging>1)trace "Injected command execution delay ${t0}ms after [$device].$command(${nparams ? "$nparams":sBLK})", rtD
		}
	}
}

private void scheduleTimer(Map rtD, Map timer, Long lastRun=0L){
	//if already scheduled once during this run, don't do it again
	if(((List<Map>)rtD.schedules).find{ (Integer)it.s==(Integer)timer.$ })return
	String mySt
	if((Boolean)rtD.eric){
		mySt="scheduleTimer $timer     $lastRun"
		myDetail rtD, mySt, 1
	}
	//complicated stuff follows...
	Long t=now()
	String tinterval="${((Map)evaluateOperand(rtD, null, (Map)timer.lo)).v}".toString()
	Boolean exitOut=false
	Integer interval
	if(tinterval.isInteger()){
		interval=tinterval.toInteger()
		if(interval<=0)exitOut=true
	}else{ exitOut=true }
	if(exitOut) {
		if ((Boolean)rtD.eric) myDetail rtD, mySt, -1
		return
	}
	String intervalUnit=(String)timer.lo.vt
	Integer level=0
	Long delta=0L
	switch(intervalUnit){
		case 'ms': level=1; delta=1L; break
		case sS: level=2; delta=1000L; break
		case 'm': level=3; delta=60000L; break
		case sH: level=4;  delta=3600000L; break
		case sD: level=5; break
		case 'w': level=6; break
		case 'n': level=7; break
		case 'y': level=8; break
	}

	Long time=0L
	if(delta==0L){
		//let's get the offset
		time=(Long)evaluateExpression(rtD, (Map)evaluateOperand(rtD, null, (Map)timer.lo2), sDTIME).v
		if((String)timer.lo2.t!=sC){
			Map offset=(Map)evaluateOperand(rtD, null, (Map)timer.lo3)
			time += (Long)evaluateExpression(rtD, [t:sDURATION, v:offset.v, vt:(String)offset.vt], sLONG).v
		}
		//resulting time is in UTC
		if(lastRun==0L){
			//first run, just adjust the time so we're in the future
			time=pushTimeAhead(time, now())
		}
	}
	delta=Math.round(delta*interval*1.0D)
	Boolean priorActivity=lastRun!=0L

	Long rightNow=now()
	lastRun=lastRun!=0L ? lastRun:rightNow
	Long nextSchedule=lastRun

	if(lastRun>rightNow){
		//sometimes timers run early, so make sure at least in the near future
		rightNow=Math.round(lastRun+1.0D)
	}

	if(intervalUnit==sH){
		Long min=(Long)cast(rtD, timer.lo.om, sLONG)
		nextSchedule=Math.round(3600000.0D*Math.floor(nextSchedule/3600000.0D)+(min*60000.0D))
	}

	//next date
	Integer cycles=100
	while(cycles!=0){
		if(delta!=0L){
			if(nextSchedule<(rightNow-delta)){
				//we're behind, let's fast forward to where the next occurrence happens in the future
				Long count=Math.floor((rightNow-nextSchedule)/delta*1.0D)
				//if((Integer)rtD.logging>2)debug "Timer fell behind by $count interval${count>1 ? sS:sBLK}, catching up...", rtD
				nextSchedule=Math.round(nextSchedule+delta*count*1.0D)
			}
			nextSchedule=nextSchedule+delta
		}else{
			//advance one day if we're in the past
			time=pushTimeAhead(time, rightNow)
			Long lastDay=Math.floor(nextSchedule/86400000.0D)
			Long thisDay=Math.floor(time/86400000.0D)

			//the repeating interval is not necessarily constant
			switch (intervalUnit){
				case sD:
					if(priorActivity){
						//add the required number of days
						nextSchedule=time+Math.round(86400000.0D*(interval-(thisDay-lastDay)))
					}else{
						nextSchedule=time
					}
					break
				case 'w':
					//figure out the first day of the week matching the requirement
					Long currentDay=(Integer)(new Date(time)).day
					Long requiredDay=(Long)cast(rtD, timer.lo.odw, sLONG)
					if(currentDay>requiredDay)requiredDay += 7
					//move to first matching day
					nextSchedule=time+Math.round(86400000.0D*(requiredDay-currentDay))
					if(nextSchedule<rightNow){
						nextSchedule=Math.round(nextSchedule+604800000.0D*interval)
					}
					break
				case 'n':
				case 'y':
					//figure out the first day of the week matching the requirement
					Integer odm=timer.lo.odm.toInteger()
					def odw=timer.lo.odw
					Integer omy=intervalUnit=='y' ? timer.lo.omy.toInteger():0
					Integer day=0
					Date date=new Date(time)
					Integer year=(Integer)date.year
					Integer month=Math.round((intervalUnit=='n' ? (Integer)date.month:omy)+(priorActivity ? interval:((nextSchedule<rightNow)? 1.0D:0.0D))*(intervalUnit=='n' ? 1.0D:12.0D))
					if(month>=12){
						year += Math.floor(month/12.0D)
						month=month.mod(12)
					}
					date.setDate(1)
					date.setMonth(month)
					date.setYear(year)
					Integer lastDayOfMonth=(Integer)(new Date((Integer)date.year, (Integer)date.month+1, 0)).date
					if(odw==sD){
						if(odm>0){
							day=(odm<=lastDayOfMonth)? odm:0
						}else{
							day=lastDayOfMonth+1+odm
							day=(day>=1)? day:0
						}
					}else{
						odw=odw.toInteger()
						//find the nth week day of the month
						if(odm>0){
							//going forward
							Integer firstDayOfMonthDOW=(Integer)(new Date((Integer)date.year, (Integer)date.month, 1)).day
							//find the first matching day
							Integer firstMatch=Math.round(1+odw-firstDayOfMonthDOW+(odw<firstDayOfMonthDOW ? 7.0D:0.0D))
							day=Math.round(firstMatch+7.0D*(odm-1.0D))
							day=(day<=lastDayOfMonth)? day:0
						}else{
							//going backwards
							Integer lastDayOfMonthDOW=(Integer)(new Date((Integer)date.year, (Integer)date.month+1, 0)).day
							//find the first matching day
							Integer firstMatch=lastDayOfMonth+odw-lastDayOfMonthDOW-(odw>lastDayOfMonthDOW ? 7:0)
							day=Math.round(firstMatch+7.0D*(odm+1))
							day=(day>=1)? day:0
						}
					}
					if(day){
						date.setDate(day)
						nextSchedule=(Long)date.getTime()
					}
					break
			}
		}
		//check to see if it fits the restrictions
		if(nextSchedule>=rightNow){
			Long offset=checkTimeRestrictions(rtD, (Map)timer.lo, nextSchedule, level, interval)
			if(offset==0L)break
			if(offset>0L)nextSchedule += offset
		}
		time=nextSchedule
		priorActivity=true
		cycles -= 1
	}

	if(nextSchedule>lastRun){
		Boolean a=((List<Map>)rtD.schedules).removeAll{ (Integer)it.s==(Integer)timer.$ }
		requestWakeUp(rtD, timer, [$: -1], nextSchedule)
	}
	if((Boolean)rtD.eric) myDetail rtD, mySt, -1
}

private Long pushTimeAhead(Long pastTime, Long curTime){
	Long retTime=pastTime
	while(retTime<curTime){
		Long t0=Math.round(retTime+86400000.0D)
		Long t1=Math.round(t0+((Integer)location.timeZone.getOffset(retTime)-(Integer)location.timeZone.getOffset(t0))*1.0D)
		retTime=t1
	}
	return retTime
}

private void scheduleTimeCondition(Map rtD, Map condition){
	if((Boolean)rtD.eric) myDetail rtD, "scheduleTimeCondition", 1
	Integer conditionNum=(Integer)condition.$
	//if already scheduled once during this run, don't do it again
	if(((List<Map>)rtD.schedules).find{ (Integer)it.s==conditionNum && (Integer)it.i==0 })return
	Map comparison=Comparisons().conditions[(String)condition.co]
	Boolean trigger=false
	if(comparison==null){
		comparison=Comparisons().triggers[(String)condition.co]
		if(comparison==null)return
		trigger=true
	}
	cancelStatementSchedules(rtD, conditionNum)
	if(!comparison.p)return
	Map tv1=condition.ro!=null && (String)condition.ro.t!=sC ? (Map)evaluateOperand(rtD, null, (Map)condition.to):null
	Long v1 = (Long)evaluateExpression(rtD, (Map)evaluateOperand(rtD, null, (Map)condition.ro), sDTIME).v + (tv1!=null ? (Long)evaluateExpression(rtD, [t: sDURATION, v: tv1.v, vt: (String)tv1.vt], sLONG).v : 0L)
	Map tv2=condition.ro2!=null && (String)condition.ro2.t!=sC && (Integer)comparison.p>1 ? (Map)evaluateOperand(rtD, null, (Map)condition.to2):null
	Long v2=trigger ? v1 : ((Integer)comparison.p>1 ? ((Long)evaluateExpression(rtD, (Map)evaluateOperand(rtD, null, (Map)condition.ro2, null, false, true), sDTIME).v + (tv2!=null ? (Long)evaluateExpression(rtD, [t:sDURATION, v:tv2.v, vt:(String)tv2.vt]).v : 0L)) : (String)condition.lo.v==sTIME ? getMidnightTime():v1 )
	Long n=Math.round(1.0D*now()+2000L)
	if((String)condition.lo.v==sTIME){
		v1=pushTimeAhead(v1, n)
		v2=pushTimeAhead(v2, n)
	}
	//figure out the next time
	v1=(v1<n)? v2:v1
	v2=(v2<n)? v1:v2
	n=v1<v2 ? v1:v2
	if(n>now()){
		if((Integer)rtD.logging>2)debug "Requesting time schedule wake up at ${formatLocalTime(n)}", rtD
		requestWakeUp(rtD, condition, [$:0], n)
	}
	if((Boolean)rtD.eric) myDetail rtD, "scheduleTimeCondition", -1
}

private Long checkTimeRestrictions(Map rtD, Map operand, Long time, Integer level, Integer interval){
	//returns 0 if restrictions are passed
	//returns a positive number as millisecond offset to apply to nextSchedule for fast forwarding
	//returns a negative number as a failed restriction with no fast forwarding offset suggestion

	List om=level<=2 && operand.om instanceof List && (Integer)((List)operand.om).size()>0 ? (List)operand.om:null
	List oh=level<=3 && operand.oh instanceof List && (Integer)((List)operand.oh).size()>0 ? (List)operand.oh:null
	List odw=level<=5 && operand.odw instanceof List && (Integer)((List)operand.odw).size()>0 ? (List)operand.odw:null
	List odm=level<=6 && operand.odm instanceof List && (Integer)((List)operand.odm).size()>0 ? (List)operand.odm:null
	List owm=level<=6 && odm==null && operand.owm instanceof List && (Integer)((List)operand.owm).size()>0 ? (List)operand.owm:null
	List omy=level<=7 && operand.omy instanceof List && (Integer)((List)operand.omy).size()>0 ? (List)operand.omy:null


	if(om==null && oh==null && odw==null && odm==null && owm==null && omy==null)return 0L
	Date date=new Date(time)

	Long result=-1L
	//month restrictions
	if(omy!=null && (omy.indexOf((Integer)date.month+1)<0)){
		Integer month=(omy.sort{ it }.find{ it>(Integer)date.month+1 } ?: 12+omy.sort{ it }[0])- 1
		Integer year=date.year+(month>=12 ? 1:0)
		month=(month>=12 ? month-12:month)
		Long ms=(Long)(new Date(year, month, 1)).time-time
		switch (level){
		case 2: //by second
			result=Math.round(interval*(Math.floor(ms/1000.0D/interval)-2.0D)*1000.0D)
			break
		case 3: //by minute
			result=Math.round(interval*(Math.floor(ms/60000.0D/interval)-2.0D)*60000.0D)
			break
		}
		return (result>0L)? result:-1L
	}

	//week of month restrictions
	if(owm!=null){
		if(!((owm.indexOf(getWeekOfMonth(date))>=0)|| (owm.indexOf(getWeekOfMonth(date, true))>=0))){
			switch (level){
			case 2: //by second
				result=Math.round(interval*(Math.floor(((7.0D-(Integer)date.day)*86400.0D-(Integer)date.hours*3600.0D-(Integer)date.minutes*60.0D)/interval)-2.0D)*1000.0D)
				break
			case 3: //by minute
				result=Math.round(interval*(Math.floor(((7.0D-(Integer)date.day)*1440.0D-(Integer)date.hours*60.0D-(Integer)date.minutes)/interval)-2.0D)*60000.0D)
				break
			}
			return (result>0L)? result:-1L
		}
	}

	//day of month restrictions
	if(odm!=null){
		if(odm.indexOf((Integer)date.date)<0){
			Integer lastDayOfMonth=new Date((Integer)date.year, (Integer)date.month+1, 0).date
			if(odm.find{ it<1 }){
				//we need to add the last days
				odm=[]+odm //copy the array
				if(odm.indexOf(-1)>=0)Boolean a=odm.push(lastDayOfMonth)
				if(odm.indexOf(-2)>=0)Boolean a=odm.push(lastDayOfMonth-1)
				if(odm.indexOf(-3)>=0)Boolean a=odm.push(lastDayOfMonth-2)
				Boolean a=odm.removeAll{ it<1 }
			}
			switch (level){
			case 2: //by second
				result=Math.round(interval*(Math.floor((((odm.sort{ it }.find{ it>(Integer)date.date } ?: lastDayOfMonth+odm.sort{ it }[0])-(Integer)date.date)*86400.0D-(Integer)date.hours*3600.0D-(Integer)date.minutes*60.0D)/interval)- 2.0D)*1000.0D)
				break
			case 3: //by minute
				result=Math.round(interval*(Math.floor((((odm.sort{ it }.find{ it>(Integer)date.date } ?: lastDayOfMonth+odm.sort{ it }[0])-(Integer)date.date)*1440.0D-(Integer)date.hours*60.0D-(Integer)date.minutes)/interval)-2.0D)*60000.0D)
				break
			}
			return (result>0L)? result:-1L
		}
	}

	//day of week restrictions
	if(odw!=null && (odw.indexOf(date.day)<0)){
		switch (level){
		case 2: //by second
			result=Math.round(interval*(Math.floor((((odw.sort{ it }.find{ it>(Integer)date.day } ?: 7.0D+odw.sort{ it }[0])-(Integer)date.day)*86400.0D-(Integer)date.hours*3600.0D-(Integer)date.minutes*60.0D)/interval)-2.0D)*1000.0D)
			break
		case 3: //by minute
			result=Math.round(interval*(Math.floor((((odw.sort{ it }.find{ it>(Integer)date.day } ?: 7.0D+odw.sort{ it }[0])-(Integer)date.day)*1440.0D-(Integer)date.hours*60.0D-(Integer)date.minutes)/interval)-2.0D)*60000.0D)
			break
		}
		return (result>0L)? result:-1L
	}

	//hour restrictions
	if(oh!=null && (oh.indexOf((Integer)date.hours)<0)){
		switch (level){
		case 2: //by second
			result=Math.round(interval*(Math.floor((((oh.sort{ it }.find{ it>(Integer)date.hours } ?: 24.0D+oh.sort{ it }[0])-(Integer)date.hours)*3600.0D-(Integer)date.minutes*60.0D)/interval)-2.0D)*1000.0D)
			break
		case 3: //by minute
			result=Math.round(interval*(Math.floor((((oh.sort{ it }.find{ it>(Integer)date.hours } ?: 24.0D+oh.sort{ it }[0])-(Integer)date.hours)*60.0D-(Integer)date.minutes)/interval)-2.0D)*60000.0D)
			break
		}
		return (result>0L)? result:-1L
	}

	//minute restrictions
	if(om!=null && (om.indexOf((Integer)date.minutes)<0)){
		//get the next highest minute
	//suggest an offset to reach the next minute
		result=Math.round(interval*(Math.floor(((om.sort{ it }.find{ it>(Integer)date.minutes } ?: 60.0D+om.sort{ it }[0])-(Integer)date.minutes-1.0D)*60.0D/interval)-2.0D)*1000.0D)
		return (result>0L)? result:-1L
	}
	return 0L
}

//return the number of occurrences of same day of week up until the date or from the end of the month if backwards, i.e. last Sunday is -1, second-last Sunday is -2
private static Integer getWeekOfMonth(date=null, Boolean backwards=false){
	Integer day=(Integer)date.date
	if(backwards){
		Integer month=(Integer)date.month
		Integer year=(Integer)date.year
		Integer lastDayOfMonth=(Integer)(new Date(year, month+1, 0)).date
		return -(1+Math.floor((lastDayOfMonth-day)/7))
	}else{
		return 1+Math.floor((day-1)/7) //1 based
	}
}

private void requestWakeUp(Map rtD, Map statement, Map task, Long timeOrDelay, String data=sNULL){
	Long time=timeOrDelay>9999999999L ? timeOrDelay:now()+timeOrDelay
	List<Integer> cs=[]+ ((String)statement.tcp==sB || (String)statement.tcp==sC ? (rtD.stack?.cs!=null ? (List<Integer>)rtD.stack.cs:[]):[]) // task cancelation policy
	Integer ps= (String)statement.tcp==sB || (String)statement.tcp==sP ? 1:0
	Boolean a=cs.removeAll{ it==0 }
// state to save across a sleep
	Boolean fnd=false
	def myResp=rtD.response
	if(myResp.toString().size() > 10000) { myResp=[:]; fnd=true } // state can only be total 100KB
	def myJson=rtD.json
	if(myJson.toString().size() > 10000) { myJson=[:]; fnd=true }
	if(fnd) debug 'trimming saved $response and/or $json for scheduled wakeup due to large size' , rtD
	Map mmschedule=[
		t:time,
		s:(Integer)statement.$,
		i:task?.$!=null ? (Integer)task.$:0,
		cs:cs,
		ps:ps,
		d:data,
		evt:(Map)rtD.currentEvent,
		args:rtD.args,
		stack:[
			index:(Double)rtD.systemVars[sDLLRINDX].v,
			device:(List)rtD.systemVars[sDLLRDEVICE].v,
			devices:(List)rtD.systemVars[sDLLRDEVS].v,
			json:myJson ?: [:],
			response:myResp ?: [:]
// what about previousEvent httpContentType httpStatusCode httpStatusOk iftttStatusCode iftttStatusOk "\$mediaId" "\$mediaUrl" "\$mediaType" mediaData (big)
// currentEvent in case of httpRequest
		]
	]
	a=((List<Map>)rtD.schedules).push(mmschedule)
}

private Long do_setLevel(Map rtD, device, List params, String attr, val=null){
	Integer arg=val!=null ? (Integer)val:(Integer)params[0]
	Integer psz=(Integer)params.size()
	String mstate=psz>1 ? (String)params[1]:sNULL
	if(mstate!=sNULL && (String)getDeviceAttributeValue(rtD, device, sSWITCH)!=mstate){
		return 0L
	}
	Long delay=psz>2 ? (Long)params[2]:0L
	executePhysicalCommand(rtD, device, attr, arg, delay)
	return 0L
}

private Long cmd_setLevel(Map rtD, device, List params){
	return do_setLevel(rtD, device, params, sSTLVL)
}

private Long cmd_setInfraredLevel(Map rtD, device, List params){
	return do_setLevel(rtD, device, params, sSTIFLVL)
}

private Long cmd_setHue(Map rtD, device, List params){
	Integer hue=(Integer)cast(rtD, Math.round(params[0]/3.6D), sINT)
	return do_setLevel(rtD, device, params, sSHUE, hue)
}

private Long cmd_setSaturation(Map rtD, device, List params){
	return do_setLevel(rtD, device, params, sSSATUR)
}

private Long cmd_setColorTemperature(Map rtD, device, List params){
	return do_setLevel(rtD, device, params, sSCLRTEMP)
}

private Map getColor(Map rtD, String colorValue){
	Map color=(colorValue=='Random')? getRandomColor():getColorByName(colorValue)
	if(color!=null){
		color=[
			hex:(String)color.rgb,
			hue:Math.round((Integer)color.h/3.6D),
			saturation:(Integer)color.s,
			level:(Integer)color.l
		]
	}else{
		color=hexToColor(colorValue)
		if(color!=null){
			color=[
				hex:(String)color.hex,
				hue:Math.round((Integer)color.hue/3.6D),
				saturation:(Integer)color.saturation,
				level:(Integer)color.level
			]
		}
	}
	return color
}

private Long cmd_setColor(Map rtD, device, List params){
	Map color=getColor(rtD, (String)params[0])
	if(!color){
		error "ERROR: Invalid color $params", rtD
		return 0L
	}
	Integer psz=(Integer)params.size()
	String mstate=psz>1 ? (String)params[1]:sNULL
	if(mstate!=sNULL && (String)getDeviceAttributeValue(rtD, device, sSWITCH)!=mstate){
		return 0L
	}
	Long delay=psz>2 ? (Long)params[2]:0L
	executePhysicalCommand(rtD, device, sSCLR, color, delay)
	return 0L
}

private Long cmd_setAdjustedColor(Map rtD, device, List params){
	Map color=getColor(rtD, (String)params[0])
	if(!color){
		error "ERROR: Invalid color $params", rtD
		return 0L
	}
	Long duration=(Long)cast(rtD, params[1], sLONG)
	Integer psz=(Integer)params.size()
	String mstate=psz>2 ? (String)params[2]:sNULL
	if(mstate!=sNULL && (String)getDeviceAttributeValue(rtD, device, sSWITCH)!=mstate){
		return 0L
	}
	Long delay=psz>3 ? (Long)params[3]:0L
	executePhysicalCommand(rtD, device, 'setAdjustedColor', [color, duration], delay)
	return 0L
}

private Long cmd_setAdjustedHSLColor(Map rtD, device, List params){
	Integer hue=(Integer)cast(rtD, Math.round(params[0]/3.6D), sINT)
	Integer saturation=(Integer)params[1]
	Integer level=(Integer)params[2]
	def color=[
		hue: hue,
		saturation: saturation,
		level: level
	]
	Long duration=(Long)cast(rtD, params[3], sLONG)
	Integer psz=(Integer)params.size()
	String mstate=psz>4 ? (String)params[4]:sNULL
	Long delay=psz>5 ? (Long)params[5]:0L
	if(mstate!=sNULL && (String)getDeviceAttributeValue(rtD, device, sSWITCH)!=mstate){
		return 0L
	}
	executePhysicalCommand(rtD, device, 'setAdjustedColor', [color, duration], delay)
	return 0L
}

private Long cmd_setLoopDuration(Map rtD, device, List params){
	Integer duration=(Integer)Math.round((Long)cast(rtD, params[0], sLONG)/1000)
	executePhysicalCommand(rtD, device, 'setLoopDuration', duration)
	return 0L
}

private Long cmd_setVideoLength(Map rtD, device, List params){
	Integer duration=(Integer)Math.round((Long)cast(rtD, params[0], sLONG)/1000)
	executePhysicalCommand(rtD, device, 'setVideoLength', duration)
	return 0L
}

private Long cmd_setVariable(Map rtD, device, List params){
	def var=params[1]
	executePhysicalCommand(rtD, device, 'setVariable', var)
	return 0L
}

private Long vcmd_log(Map rtD, device, List params){
	String command=params[0] ? (String)params[0]:sBLK
	String message=(String)params[1]
	Map a=log(message, rtD, -2, null, command.toLowerCase().trim(), true)
	return 0L
}

private Long vcmd_setState(Map rtD, device, List params){
	String value=params[0]
	if(rtD.piston.o?.mps){
		rtD.state.new=value
		rtD.pistonStateChanged=(Boolean)rtD.pistonStateChanged || ((String)rtD.state.old!=(String)rtD.state.new)
	}else{
		error "Cannot set the piston state while in automatic mode. Please edit the piston settings to disable the automatic piston state if you want to manually control the state.", rtD
	}
	return 0L
}

private Long vcmd_setTileColor(Map rtD, device, List params){
	Integer index=(Integer)cast(rtD, params[0], sINT)
	if(index<1 || index>16)return 0L
	String sIdx=index.toString()
	rtD.state[sC+sIdx]=(String)getColor(rtD, (String)params[1])?.hex
	rtD.state[sB+sIdx]=(String)getColor(rtD, (String)params[2])?.hex
	rtD.state['f'+sIdx]=!!params[3]
	return 0L
}

private Long vcmd_setTileTitle(Map rtD, device, List params){
	return helper_setTile(rtD, sI, params)
}

private Long vcmd_setTileText(Map rtD, device, List params){
	return helper_setTile(rtD, sT, params)
}

private Long vcmd_setTileFooter(Map rtD, device, List params){
	return helper_setTile(rtD, 'o', params)
}

private Long vcmd_setTileOTitle(Map rtD, device, List params){
	return helper_setTile(rtD, sP, params)
}

private Long helper_setTile(Map rtD, String typ, List params){
	Integer index=(Integer)cast(rtD, params[0], sINT)
	if(index<1 || index>16)return 0L
	rtD.state["${typ}$index".toString()]=(String)params[1]
	return 0L
}

private Long vcmd_setTile(Map rtD, device, List params){
	Integer index=(Integer)cast(rtD, params[0], sINT)
	if(index<1 || index>16)return 0L
	String sIdx=index.toString()
	rtD.state[sI+sIdx]=(String)params[1]
	rtD.state[sT+sIdx]=(String)params[2]
	rtD.state['o'+sIdx]=(String)params[3]
	rtD.state[sC+sIdx]=(String)getColor(rtD, (String)params[4])?.hex
	rtD.state[sB+sIdx]=(String)getColor(rtD, (String)params[5])?.hex
	rtD.state['f'+sIdx]=!!params[6]
	return 0L
}

private Long vcmd_clearTile(Map rtD, device, List params){
	Integer index=(Integer)cast(rtD, params[0], sINT)
	if(index<1 || index>16)return 0L
	String sIdx=index.toString()
	Map t0=(Map)rtD.state
	t0.remove(sI+sIdx)
	t0.remove(sT+sIdx)
	t0.remove(sC+sIdx)
	t0.remove('o'+sIdx)
	t0.remove(sB+sIdx)
	t0.remove('f'+sIdx)
	t0.remove(sP+sIdx)
	rtD.state=t0
	return 0L
}

private Long vcmd_setLocationMode(Map rtD, device, List params){
	String modeIdOrName=(String)params[0]
	def mode=location.getModes()?.find{ (hashId(it.id)==modeIdOrName)|| ((String)it.name==modeIdOrName)}
	if(mode) location.setMode((String)mode.name)
	else error "Error setting location mode. Mode '$modeIdOrName' does not exist.", rtD
	return 0L
}

private Long vcmd_setAlarmSystemStatus(Map rtD, device, List params){
	String statusIdOrName=(String)params[0]
	def dev=VirtualDevices()['alarmSystemStatus']
	def options=dev?.ac
	List status=options?.find{ (String)it.key==statusIdOrName || (String)it.value==statusIdOrName }?.collect{ [id: (String)it.key, name: it.value] }

	if(status && (Integer)status.size()!=0){
		sendLocationEvent(name:'hsmSetArm', value: status[0].id)
	}else{
		error "Error setting HSM status. Status '$statusIdOrName' does not exist.", rtD
	}
	return 0L
}

private Long vcmd_sendEmail(Map rtD, device, List params){
	def data=[
		i: (String)rtD.id,
		n: (String)app.label,
		t: (String)params[0],
		s: (String)params[1],
		m: (String)params[2]
	]

	Map requestParams=[
		uri: 'https://api.webcore.co/email/send/'+(String)rtD.locationId,
		query: null,
		headers: [:], //(auth ? [Authorization: auth]:[:]),
		requestContentType: sAPPJSON,
		body: data
	]
	String msg='Unknown error'

	try{
		asynchttpPost('ahttpRequestHandler', requestParams, [command:sSENDE, em: data])
		return 24000L
	}catch (all){
		error "Error sending email to ${data.t}: $msg", rtD
	}
	return 0L
}

private static Long vcmd_noop(Map rtD, device, List params){
	return 0L
}

private Long vcmd_wait(Map rtD, device, List params){
	return (Long)cast(rtD, params[0], sLONG)
}

private Long vcmd_waitRandom(Map rtD, device, List params){
	Long min=(Long)cast(rtD, params[0], sLONG)
	Long max=(Long)cast(rtD, params[1], sLONG)
	if(max<min){
		Long v=max
		max=min
		min=v
	}
	return min+(Integer)Math.round(1.0D*(max-min)*Math.random())
}

private Long vcmd_waitForTime(Map rtD, device, List params){
	Long time
	time=(Long)cast(rtD, (Long)cast(rtD, params[0], sTIME), sDTIME, sTIME)
	Long rightNow=now()
	time=pushTimeAhead(time, rightNow)
	return time-rightNow
}

private Long vcmd_waitForDateTime(Map rtD, device, List params){
	Long time=(Long)cast(rtD, params[0], sDTIME)
	Long rightNow=now()
	return (time>rightNow)? time-rightNow:0L
}

private Long vcmd_setSwitch(Map rtD, device, List params){
	executePhysicalCommand(rtD, device, (Boolean)cast(rtD, params[0], sBOOLN) ? sON : sOFF)
	return 0L
}

private Long vcmd_toggle(Map rtD, device, List params){
	executePhysicalCommand(rtD, device, (String)getDeviceAttributeValue(rtD, device, sSWITCH)==sOFF ? sON : sOFF)
	return 0L
}

private Long vcmd_toggleRandom(Map rtD, device, List params){
	Integer probability=(Integer)cast(rtD, (Integer)params.size()==1 ? params[0]:50, sINT)
	if(probability<=0)probability=50
	executePhysicalCommand(rtD, device, Math.round(100.0D*Math.random())<=probability ? sON : sOFF)
	return 0L
}

private Long vcmd_toggleLevel(Map rtD, device, List params){
	Integer level=(Integer)params[0]
	executePhysicalCommand(rtD, device, sSTLVL, (Integer)getDeviceAttributeValue(rtD, device, sLVL)==level ? 0 : level)
	return 0L
}

private Long do_adjustLevel(Map rtD, device, List params, String attr, String attr1, Integer val=null, Boolean big=false){
	Integer arg=val!=null ? val : (Integer)cast(rtD, params[0], sINT)
	Integer psz=(Integer)params.size()
	String mstate=psz>1 ? (String)params[1]:sNULL
	Long delay=psz>2 ? (Long)params[2]:0L
	if(mstate!=sNULL && (String)getDeviceAttributeValue(rtD, device, sSWITCH)!=mstate){
		return 0L
	}
	arg=arg+(Integer)cast(rtD, getDeviceAttributeValue(rtD, device, attr), sINT)
	Integer low=big ? 1000:0
	Integer hi=big ? 30000:100
	arg=(arg<low)? low:((arg>hi)? hi:arg)
	executePhysicalCommand(rtD, device, attr1, arg, delay)
	return 0L
}

private Long vcmd_adjustLevel(Map rtD, device, List params){
	return do_adjustLevel(rtD, device, params, sLVL, sSTLVL)
}

private Long vcmd_adjustInfraredLevel(Map rtD, device, List params){
	return do_adjustLevel(rtD, device, params, sIFLVL, sSTIFLVL)
}

private Long vcmd_adjustSaturation(Map rtD, device, List params){
	return do_adjustLevel(rtD, device, params, sSATUR, sSSATUR)
}

private Long vcmd_adjustHue(Map rtD, device, List params){
	Integer hue=(Integer)cast(rtD, Math.round(params[0]/3.6D), sINT)
	return do_adjustLevel(rtD, device, params, sHUE, sSHUE, hue)
}

private Long vcmd_adjustColorTemperature(Map rtD, device, List params){
	return do_adjustLevel(rtD, device, params, sCLRTEMP, sSCLRTEMP, null, true)
}

private Long do_fadeLevel(Map rtD, device, List params, String attr, String attr1, Integer val=null, Integer val1=null, Boolean big=false){
	Integer startLevel
	Integer endLevel
	if(val==null){
		startLevel=(params[0]!=null)? (Integer)cast(rtD, params[0], sINT):(Integer)cast(rtD, getDeviceAttributeValue(rtD, device, attr), sINT)
		endLevel=(Integer)cast(rtD, params[1], sINT)
	}else{
		startLevel=val
		endLevel=val1
	}
	Long duration=(Long)cast(rtD, params[2], sLONG)
	String mstate=(Integer)params.size()>3 ? (String)params[3]:sNULL
	if(mstate!=sNULL && (String)getDeviceAttributeValue(rtD, device, sSWITCH)!=mstate){
		return 0L
	}
	Integer low=big ? 1000:0
	Integer hi=big ? 30000:100
	startLevel=(startLevel<low)? low:((startLevel>hi)? hi:startLevel)
	endLevel=(endLevel<low)? low:((endLevel>hi)? hi:endLevel)
	return vcmd_internal_fade(rtD, device, attr1, startLevel, endLevel, duration)
}

private Long vcmd_fadeLevel(Map rtD, device, List params){
	return do_fadeLevel(rtD, device, params, sLVL, sSTLVL)
}

private Long vcmd_fadeInfraredLevel(Map rtD, device, List params){
	return do_fadeLevel(rtD, device, params, sIFLVL, sSTIFLVL)
}

private Long vcmd_fadeSaturation(Map rtD, device, List params){
	return do_fadeLevel(rtD, device, params, sSATUR, sSSATUR)
}

private Long vcmd_fadeHue(Map rtD, device, List params){
	Integer startLevel=(params[0]!=null)? (Integer)cast(rtD, Math.round((Integer)params[0]/3.6D), sINT):(Integer)cast(rtD, getDeviceAttributeValue(rtD, device, sHUE), sINT)
	Integer endLevel=(Integer)cast(rtD, Math.round((Integer)params[1]/3.6D), sINT)
	return do_fadeLevel(rtD, device, params, sHUE, sSHUE, startLevel, endLevel)
}

private Long vcmd_fadeColorTemperature(Map rtD, device, List params){
	return do_fadeLevel(rtD, device, params, sCLRTEMP, sSCLRTEMP, null, null, true)
}

private Long vcmd_internal_fade(Map rtD, device, String command, Integer startLevel, Integer endLevel, Long duration){
	Long minInterval
	if(duration<=5000L){
		minInterval=500L
	}else if(duration<=10000L){
		minInterval=1000L
	}else if(duration<=30000L){
		minInterval=3000L
	}else{
		minInterval=5000L
	}
	if((startLevel==endLevel)|| (duration<=500L)){
		//if the fade is too fast, or not changing anything, go to the end level directly
		executePhysicalCommand(rtD, device, command, endLevel)
		return 0L
	}
	Integer delta=endLevel-startLevel
	//the max number of steps we can do
	Integer steps=delta>0 ? delta:-delta
	//figure out the interval
	Long interval=Math.round(duration/steps)
	if(interval<minInterval){
		//intervals too small, adjust to do one change per 500ms
		steps=Math.floor(1.0D*duration/minInterval)
		interval=Math.round(1.0D*duration/steps)
	}
	String scheduleDevice=hashId(device.id)
	Integer oldLevel=startLevel
	executePhysicalCommand(rtD, device, command, startLevel)
	for(Integer i=1; i<=steps; i++){
		Integer newLevel=Math.round(startLevel+delta*i/steps*1.0D)
		if(oldLevel!=newLevel){
			executePhysicalCommand(rtD, device, command, newLevel, i*interval, scheduleDevice, true)
		}
		oldLevel=newLevel
	}
	//for good measure, send a last command 100ms after the end of the interval
	executePhysicalCommand(rtD, device, command, endLevel, duration+99L, scheduleDevice, true)
	return duration+105L
}

private Long vcmd_emulatedFlash(Map rtD, device, List params){
	vcmd_flash(rtD, device, params)
}

private Long vcmd_flash(Map rtD, device, List params){
	Long onDuration=(Long)cast(rtD, params[0], sLONG)
	Long offDuration=(Long)cast(rtD, params[1], sLONG)
	Integer cycles=(Integer)cast(rtD, params[2], sINT)
	String mstate=(Integer)params.size()>3 ? (String)params[3]:sNULL
	String currentState=(String)getDeviceAttributeValue(rtD, device, sSWITCH)
	if(mstate!=sNULL && (currentState!=mstate)){
		return 0L
	}
	Long duration=Math.round((onDuration+offDuration)*cycles*1.0D)
	if(duration<=500L){
		//if the flash is too fast, ignore it
		return 0L
	}
	//initialize parameters
	String firstCommand=currentState==sON ? sOFF:sON
	Long firstDuration=firstCommand==sON ? onDuration:offDuration
	String secondCommand=firstCommand==sON ? sOFF:sON
	Long secondDuration=firstCommand==sON ? offDuration:onDuration
	String scheduleDevice=hashId(device.id)
	Long dur=0L
	for(Integer i=1; i<=cycles; i++){
		executePhysicalCommand(rtD, device, firstCommand, [], dur, scheduleDevice, true)
		dur += firstDuration
		executePhysicalCommand(rtD, device, secondCommand, [], dur, scheduleDevice, true)
		dur += secondDuration
	}
	//for good measure, send a last command 100ms after the end of the interval
	executePhysicalCommand(rtD, device, currentState, [], dur+100L, scheduleDevice, true)
	return dur+105L
}

private Long vcmd_flashLevel(Map rtD, device, List params){
	Integer level1=(Integer)cast(rtD, params[0], sINT)
	Long duration1=(Long)cast(rtD, params[1], sLONG)
	Integer level2=(Integer)cast(rtD, params[2], sINT)
	Long duration2=(Long)cast(rtD, params[3], sLONG)
	Integer cycles=(Integer)cast(rtD, params[4], sINT)
	String mstate=(Integer)params.size()>5 ? (String)params[5]:sNULL
	String currentState=(String)getDeviceAttributeValue(rtD, device, sSWITCH)
	if(mstate!=sNULL && (currentState!=mstate)){
		return 0L
	}
	Integer currentLevel=(Integer)getDeviceAttributeValue(rtD, device, sLVL)
	Long duration=Math.round((duration1+duration2)*cycles*1.0D)
	if(duration<=500L){
		//if the flash is too fast, ignore it
		return 0L
	}
	String scheduleDevice=hashId(device.id)
	Long dur=0L
	for(Integer i=1; i<=cycles; i++){
		executePhysicalCommand(rtD, device, sSTLVL, [level1], dur, scheduleDevice, true)
		dur += duration1
		executePhysicalCommand(rtD, device, sSTLVL, [level2], dur, scheduleDevice, true)
		dur += duration2
	}
	//for good measure, send a last command 100ms after the end of the interval
	executePhysicalCommand(rtD, device, sSTLVL, [currentLevel], dur+100L, scheduleDevice, true)
	executePhysicalCommand(rtD, device, currentState, [], dur+101L, scheduleDevice, true)
	return dur+105L
}

private Long vcmd_flashColor(Map rtD, device, List params){
	def color1=getColor(rtD, (String)params[0])
	Long duration1=(Long)cast(rtD, params[1], sLONG)
	def color2=getColor(rtD, (String)params[2])
	Long duration2=(Long)cast(rtD, params[3], sLONG)
	Integer cycles=(Integer)cast(rtD, params[4], sINT)
	String mstate=(Integer)params.size()>5 ? (String)params[5]:sNULL
	String currentState=(String)getDeviceAttributeValue(rtD, device, sSWITCH)
	if(mstate!=sNULL && (currentState!=mstate)){
		return 0L
	}
	Long duration=Math.round((duration1+duration2)*cycles*1.0D)
	if(duration<=500L){
		//if the flash is too fast, ignore it
		return 0L
	}
	String scheduleDevice=hashId(device.id)
	Long dur=0
	for(Integer i=1; i<=cycles; i++){
		executePhysicalCommand(rtD, device, sSCLR, [color1], dur, scheduleDevice, true)
		dur += duration1
		executePhysicalCommand(rtD, device, sSCLR, [color2], dur, scheduleDevice, true)
		dur += duration2
	}
	//for good measure, send a last command 100ms after the end of the interval
	executePhysicalCommand(rtD, device, currentState, [], dur+99L, scheduleDevice, true)
	return dur+105L
}

private Long vcmd_sendNotification(Map rtD, device, List params){
	def message="Hubitat does not support sendNotification "+params[0]
	Map a=log(message, rtD, -2, "Err", 'warn', true)
	//sendNotificationEvent(message)
	return 0L
}

private Long vcmd_sendPushNotification(Map rtD, device, List params){
	String message=(String)params[0]
	if(rtD.initPush==null){
		rtD.pushDev=(List)parent.getPushDev()
		rtD.initPush=true
	}
	List t0=(List)rtD.pushDev
	try{
		t0*.deviceNotification(message)
	}catch (all){
		message="Default push device not set properly in webCoRE "+(String)params[0]
		error message, rtD
	}
	return 0L
}

private Long vcmd_sendSMSNotification(Map rtD, device, List params){
	String message=(String)params[0]
	String msg="HE SMS notifications are being removed, please convert to a notification device "+message
	warn msg, rtD
	return 0L
}

private Long vcmd_sendNotificationToContacts(Map rtD, device, List params){
	// Contact Book has been disabled and we're falling back onto PUSH notifications, if the option is on
	String message=(String)params[0]
	Boolean save=!!params[2]
	return vcmd_sendPushNotification(rtD, devices, [message, save])
}

private static Map parseVariableName(String name){
	Map result=[
		name: name,
		index: sNULL
	]
	if(name!=sNULL && !(Boolean)name.startsWith(sDLR) && (Boolean)name.endsWith(sRB)){
		List parts=name.replace(sRB, sBLK).tokenize(sLB)
		if((Integer)parts.size()==2){
			result=[
				name: (String)parts[0],
				index: (String)parts[1]
			]
		}
	}
	return result
}

private Long vcmd_setVariable(Map rtD, device, List params){
	String name=(String)params[0]
	def value=params[1]
	if((Boolean)rtD.eric) myDetail rtD, "setVariable $name  $value"
	Map t0=setVariable(rtD, name, value)
	if((String)t0.t==sERROR) {
		String message = (String)t0.v+sSPC+name
		error message, rtD
	}
	return 0L
}

private Long vcmd_executePiston(Map rtD, device, List params){
	String selfId=(String)rtD.id
	String pistonId=(String)params[0]
	List arguments=(params[1] instanceof List ? (List)params[1]:params[1].toString().tokenize(sCOMMA)).unique()
	Boolean wait=((Integer)params.size()>2)? (Boolean)cast(rtD, params[2], sBOOLN):false
	String description="webCoRE: Piston ${(String)app.label} requested execution of piston $pistonId".toString()
	Map data=[:]
	for(String argument in arguments){
		if(argument)data[argument]=getVariable(rtD, argument).v
	}
	if(wait){
		wait=(Boolean)parent.executePiston(pistonId, data, selfId)
	}
	if(!wait){
		sendLocationEvent(name:pistonId, value:selfId, isStateChange:true, displayed:false, linkText:description, descriptionText:description, data:data)
	}
	return 0L
}

private Long vcmd_pausePiston(Map rtD, device, List params){
//	String selfId=(String)rtD.id
	String pistonId=(String)params[0]
	if(!(Boolean)parent.pausePiston(pistonId)){
		String message="Piston not found "+pistonId
		error message, rtD
	}
	return 0L
}

private Long vcmd_resumePiston(Map rtD, device, List params){
//	String selfId=(String)rtD.id
	String pistonId=(String)params[0]
	if(!(Boolean)parent.resumePiston(pistonId)){
		String message="Piston not found "+pistonId
		error message, rtD
	}
	return 0L
}

private Long vcmd_executeRule(Map rtD, device, List params){
	String ruleId=(String)params[0]
	String action=(String)params[1]
	Boolean wait=((Integer)params.size()>2)? (Boolean)cast(rtD, params[2], sBOOLN):false
	def rules=RMUtils.getRuleList()
	List myRule=[]
	rules.each{rule->
		List t0=rule.find{ hashId((String)it.key)==ruleId }.collect{(String)it.key}
		myRule += t0
	}

	if(myRule){
		String ruleAction
		if(action=="Run")ruleAction="runRuleAct"
		if(action=="Stop")ruleAction="stopRuleAct"
		if(action=="Pause")ruleAction="pauseRule"
		if(action=="Resume")ruleAction="resumeRule"
		if(action=="Evaluate")ruleAction="runRule"
		if(action=="Set Boolean True")ruleAction="setRuleBooleanTrue"
		if(action=="Set Boolean False")ruleAction="setRuleBooleanFalse"
		RMUtils.sendAction(myRule, ruleAction, (String)app.label)
	}else{
		String message="Rule not found "+ruleId
		error message, rtD
	}
	return 0L
}

private Long vcmd_setHSLColor(Map rtD, device, List params){
	Integer hue=(Integer)cast(rtD, Math.round(params[0]/3.6D), sINT)
	Integer saturation=(Integer)params[1]
	Integer level=(Integer)params[2]
	def color=[
		hue: hue,
		saturation: saturation,
		level: level
	]
	String mstate=(Integer)params.size()>3 ? (String)params[3]:sNULL
	Long delay=(Integer)params.size()>4 ? (Long)params[4]:0L
	if(mstate!=sNULL && (String)getDeviceAttributeValue(rtD, device, sSWITCH)!=mstate){
		return 0L
	}
	executePhysicalCommand(rtD, device, sSCLR, color, delay)
	return 0L
}

private Long vcmd_wolRequest(Map rtD, device, List params){
	String mac=(String)params[0]
	String secureCode=(String)params[1]
	mac=mac.replace(sCOLON, sBLK).replace(sMINUS, sBLK).replace(sDOT, sBLK).replace(sSPC, sBLK).toLowerCase()

	sendHubCommand(HubActionClass().newInstance(
		"wake on lan $mac".toString(),
		HubProtocolClass().LAN,
		null,
		secureCode ? [secureCode: secureCode]:[:]
	))
	return 0L
}

private Long vcmd_iftttMaker(Map rtD, device, List params){
	String key
	if(rtD.settings==null){
		error "no settings", rtD
	}else{
		key=((String)rtD.settings.ifttt_url ?: sBLK).trim().replace('https://', sBLK).replace('http://', sBLK).replace('maker.ifttt.com/use/', sBLK)
	}
	if(!key){
		error "Failed to send IFTTT event, because the IFTTT integration is not properly set up. Please visit Settings in your webCoRE dashboard and configure the IFTTT integration.", rtD
		return 0L
	}
	String event=params[0]
	def value1=(Integer)params.size()>1 ? params[1]:sBLK
	def value2=(Integer)params.size()>2 ? params[2]:sBLK
	def value3=(Integer)params.size()>3 ? params[3]:sBLK
	def body=[:]
	if(value1)body.value1=value1
	if(value2)body.value2=value2
	if(value3)body.value3=value3
	def data=[
		t: event,
		p1:value1,
		p2:value2,
		p3:value3
	]
	def requestParams=[
		uri: "https://maker.ifttt.com/trigger/${java.net.URLEncoder.encode(event, "UTF-8")}/with/key/".toString()+key,
		requestContentType: sAPPJSON,
		body: body
	]
	try{
		asynchttpPost('ahttpRequestHandler', requestParams, [command:sIFTTM, em: data])
		return 24000L
	}catch (all){
		error "Error iftttMaker to ${requestParams.uri}  ${data.t}: ${data..p1}, ${data.p2}, ${data.p3}", rtD
	}
	return 0L
}

private Long vcmd_httpRequest(Map rtD, device, List params){
	String uri=((String)params[0]).replace(sSPC, "%20")
	if(!uri){
		error "Error executing external web request: no URI", rtD
		return 0L
	}
	String method=(String)params[1]
	Boolean useQueryString=method=='GET' || method=='DELETE' || method=='HEAD'
	String requestBodyType=(String)params[2]
	def variables=params[3]
	String auth=sNULL
	def requestBody=null
	String contentType=sNULL
	if((Integer)params.size()==5){
		auth=(String)params[4]
	}else if((Integer)params.size()==7){
		requestBody=(String)params[4]
		contentType=(String)params[5] ?: 'text/plain'
		auth=(String)params[6]
	}
	String protocol="https"
	String requestContentType=(method=="GET" || requestBodyType=="FORM")? "application/x-www-form-urlencoded":(requestBodyType=="JSON")? sAPPJSON:contentType
	String userPart=sBLK
	List uriParts=uri.split("://").toList()
	if((Integer)uriParts.size()>2){
		warn "Invalid URI for web request: $uri", rtD
		return 0L
	}
	if((Integer)uriParts.size()==2){
		//remove the httpX:// from the uri
		protocol=(String)uriParts[0].toLowerCase()
		uri=(String)uriParts[1]
	}
	//support for user:pass@IP
	if((Boolean)uri.contains(sAT)){
		List uriSubParts=uri.split(sAT).toList()
		userPart=(String)uriSubParts[0]+sAT
		uri=(String)uriSubParts[1]
	}
	def data=null
	if(requestBodyType=='CUSTOM' && !useQueryString){
		data=requestBody
	}else if(variables instanceof List){
		for(String variable in ((List)variables).findAll{ !!it }){
			data=data ?: [:]
			data[variable]=getVariable(rtD, variable).v
		}
	}
	try{
		Map requestParams=[
			uri: protocol+'://'+userPart+uri,
			query: useQueryString ? data:null,
			headers: (auth ? (((Boolean)auth.startsWith('{') && (Boolean)auth.endsWith('}'))? (new groovy.json.JsonSlurper().parseText(auth)):[Authorization: auth]):[:]),
			requestContentType: requestContentType,
			body: !useQueryString ? data:null,
			timeout: 20
		]
		String func=sBLK
		switch(method){
			case 'GET':
				func='asynchttpGet'
				break
			case 'POST':
				func='asynchttpPost'
				break
			case 'PUT':
				func='asynchttpPut'
				break
			case 'DELETE':
				func='asynchttpDelete'
				break
			case 'HEAD':
				func='asynchttpHead'
				break
		}
		if((Integer)rtD.logging>2)debug "Sending ${func} web request to: $uri", rtD
		if(func!=sBLK){
			"$func"('ahttpRequestHandler', requestParams, [command:sHTTPR])
			return 24000L
		}
	}catch (all){
		error "Error executing external web request: ", rtD, -2, all
	}
	return 0L
}

void ahttpRequestHandler(resp, Map callbackData){
	Boolean binary=false
	def t0=resp.getHeaders()
	String t1=t0!=null && (String)t0."Content-Type" ? (String)t0."Content-Type" : sNULL
	String mediaType=t1 ? (String)(t1.toLowerCase()?.tokenize(';')[0]):sNULL
	switch (mediaType){
		case 'image/jpeg':
		case 'image/png':
		case 'image/gif':
			binary=true
	}
	def data
	def json
	Map setRtData=[:]
	String callBackC=(String)callbackData?.command
	Integer responseCode=resp.status
	Boolean success=false
	String erMsg
	if(resp.hasError()){
		erMsg=" Response Status: ${resp.status}  error Message: ${resp.getErrorMessage()}".toString()
		if(!responseCode) responseCode=500
	}
	switch(callBackC){
	case sSENDE:
		String msg='Unknown error'
		def em=callbackData?.em
		if(responseCode==200){
			data=resp.getJson()
			if(data!=null){
				if((String)data.result=='OK'){
					success=true
				}else{
					msg=((String)data.result).replace('ERROR ', sBLK)
				}
			}
		}
		if(!success){
			erMsg="Error sending email to ${em?.t}: ${msg}".toString()
		}
		break
	case sHTTPR:
		if(responseCode==204){
			mediaType=sBLK
		}else{
			if(responseCode>=200 && responseCode<300 && resp.data){
				if(!binary){
					data=resp.data
					//log.error "RESP ${data}"
					if(data!=null && !(data instanceof Map) && !(data instanceof List)){
						try{
							data= new groovy.json.JsonSlurper().parseText(resp.data)
							json=resp.data
						}catch (all){
							try{ // HE can return data Base64
								String decode=new String(resp.data.decodeBase64())
								data= new groovy.json.JsonSlurper().parseText(decode)
								json=decode
							}catch (al1){
								data=resp.data
							}
						}
					}
				}else{
					if(resp.data!=null && resp.data instanceof java.io.ByteArrayInputStream){
						setRtData.mediaType=mediaType
						//setRtData.mediaData=resp.data.getBytes()
						setRtData.mediaData=resp.data.decodeBase64()
					}
				}
			}else{
				erMsg='http'+erMsg
			}
		}
		break
	case sIFTTM:
		def em=callbackData?.em
		if(!(responseCode>=200 && responseCode<300))
			erMsg="ifttt Error iftttMaker to ${em?.t}: ${em?.p1}, ${em?.p2}, ${em?.p3}  ".toString()+erMsg
		break
	case sSTOREM:
		def mediaId
		def mediaUrl
		if(responseCode==200){
			data=resp.getJson()
			if((String)data.result=='OK' && data.url){
				mediaId=data.id
				mediaUrl=data.url
			}else{
				if(data.message){
					erMsg="storeMedia Error storing media item: $data.message"+erMsg
				}
			}
			data=null
		}else erMsg='ifttt'+erMsg
		setRtData=[mediaId:mediaId, mediaUrl:mediaUrl]
	}
	if(erMsg!=sNULL) error erMsg, [:]

	handleEvents([date: new Date(), device: location, name:sASYNCREP, value: callBackC, contentType: mediaType, responseData: data, jsonData: json, responseCode: responseCode, setRtData: setRtData])
}

private Long vcmd_writeToFuelStream(Map rtD, device, List params){
	String canister=(String)params[0]
	String name=(String)params[1]
	def data=params[2]
	def source=params[3]

	Map req=[
		c: canister,
		n: name,
		s: source,
		d: data,
		i: (String)rtD.instanceId
	]
	if((Boolean)rtD.useLocalFuelStreams && name!=sNULL){
		parent.writeToFuelStream(req)
	}else{
		def requestParams = [
			uri: "https://api-"+(String)rtD.region+'-'+((String)rtD.instanceId)[32]+".webcore.co:9247",
			path: "/fuelStream/write",
			headers: [ 'ST': (String)rtD.instanceId ],
			body: req,
			requestContentType: sAPPJSON
		]
		asynchttpPut('asyncFuel', requestParams, [bbb:0])
	}
	return 0L
}

void asyncFuel(response,data){
	if(response.status==200){
		return
	}
	error "Error storing fuel stream: $response.data.message", [:]
}

private Long vcmd_storeMedia(Map rtD, device, List params){
	if(!rtD.mediaData || !rtD.mediaType || !(rtD.mediaData)|| ((Integer)rtD.mediaData.size()<=0)){
		error 'No media is available to store; operation aborted.', rtD
		return 0L
	}
	String data=new String(rtD.mediaData, 'ISO_8859_1')
	Map requestParams=[
		uri: "https://api-"+(String)rtD.region+'-'+((String)rtD.instanceId)[32]+".webcore.co:9247",
		path: "/media/store",
		headers: [
			'ST':(String)rtD.instanceId,
			'media-type':rtD.mediaType
		],
		body: data,
		requestContentType: rtD.mediaType
	]
	asynchttpPut('asyncRequestHandler', requestParams, [command:sSTOREM])
	return 24000L
}

private Long vcmd_saveStateLocally(Map rtD, device, List params, Boolean global=false){
	List attributes=((String)cast(rtD, params[0], sSTR)).tokenize(sCOMMA)
	String canister=((Integer)params.size()>1 ? (String)cast(rtD, params[1], sSTR)+sCOLON : sBLK)+hashId(device.id)+sCOLON
	Boolean overwrite=!((Integer)params.size()>2 ? (Boolean)cast(rtD, params[2], sBOOLN):false)
	for(String attr in attributes){
		String n=canister+attr
		if(global && !(Boolean)rtD.initGStore){
			rtD.globalStore=(Map)parent.getGStore()
			rtD.initGStore=true
		}
		if(overwrite || (global ? (rtD.globalStore[n]==null):(rtD.store[n]==null))){
			def value=getDeviceAttributeValue(rtD, device, attr)
			if(attr==sHUE)value=value*3.6D
			if(global){
				rtD.globalStore[n]=value
				LinkedHashMap<String,Object> cache=(LinkedHashMap)rtD.gvStoreCache ?: [:]
				cache[n]=value
				rtD.gvStoreCache=cache
			}else{
				rtD.store[n]=value
			}
		}
	}
	return 0L
}

private Long vcmd_saveStateGlobally(Map rtD, device, List params){
	return vcmd_saveStateLocally(rtD, device, params, true)
}

private Long vcmd_loadStateLocally(Map rtD, device, List params, Boolean global=false){
	List attributes=((String)cast(rtD, params[0], sSTR)).tokenize(sCOMMA)
	String canister=((Integer)params.size()>1 ? (String)cast(rtD, params[1], sSTR)+sCOLON : sBLK)+hashId(device.id)+sCOLON
	Boolean empty=(Integer)params.size()>2 ? (Boolean)cast(rtD, params[2], sBOOLN):false
	for(String attr in attributes){
		String n=canister+attr
		if(global && !(Boolean)rtD.initGStore){
			rtD.globalStore=(Map)parent.getGStore()
			rtD.initGStore=true
		}
		def value=global ? rtD.globalStore[n]:rtD.store[n]
		if(attr==sHUE)value=(Double)cast(rtD, value, sDCML)/3.6D
		if(empty){
			if(global){
				rtD.globalStore.remove(n)
				Map cache=(Map)rtD.gvStoreCache ?: [:]
				cache[n]=null
				rtD.gvStoreCache=cache
			}else rtD.store.remove(n)
		}
		if(value==null)continue
		String exactCommand
		String fuzzyCommand
		for(command in PhysicalCommands()){
			if((String)command.value.a==attr){
				if(command.value.v==null){
					fuzzyCommand=(String)command.key
				}else{
					if((String)command.value.v==value){
						exactCommand=(String)command.key
						break
					}
				}
			}
		}
		String t0="Restoring attribute '$attr' to value '$value' using command".toString()
		if(exactCommand!=sNULL){
			if((Integer)rtD.logging>2)debug "${t0} $exactCommand()", rtD
			executePhysicalCommand(rtD, device, exactCommand)
			continue
		}
		if(fuzzyCommand!=sNULL){
			if((Integer)rtD.logging>2)debug "${t0} $fuzzyCommand($value)", rtD
			executePhysicalCommand(rtD, device, fuzzyCommand, value)
			continue
		}
		warn "Could not find a command to set attribute '$attr' to value '$value'", rtD
	}
	return 0L
}

private Long vcmd_loadStateGlobally(Map rtD, device, List params){
	return vcmd_loadStateLocally(rtD, device, params, true)
}

private Long vcmd_parseJson(Map rtD, device, List params){
	String data=params[0]
	try{
		if((Boolean)data.startsWith('{') && (Boolean)data.endsWith('}')){
			rtD.json=(LinkedHashMap)new groovy.json.JsonSlurper().parseText(data)
		}else if((Boolean)data.startsWith(sLB) && (Boolean)data.endsWith(sRB)){
			rtD.json=(List)new groovy.json.JsonSlurper().parseText(data)
		}else{
			rtD.json=[:]
		}
	}catch (all){
		error "Error parsing JSON data $data", rtD, -2, all
	}
	return 0L
}

private static Long vcmd_cancelTasks(Map rtD, device, List params){
	rtD.cancelations.all=true
	return 0L
}

private Boolean evaluateConditions(Map rtD, Map conditions, String collection, Boolean async){
	if((Boolean)rtD.eric) myDetail rtD, "evaluateConditions", 1
	Long t=now()
	Map msg
	if((Integer)rtD.logging>2)msg=timer sBLK, rtD
	//override condition id
	Integer c=(Integer)rtD.stack.c
	Integer myC=conditions.$!=null ? (Integer)conditions.$:0
	rtD.stack.c=myC
	Boolean not= collection==sC ? !!conditions.n:!!conditions.rn
	String grouping= collection==sC ? (String)conditions.o:(String)conditions.rop
	Boolean value= grouping!=sOR


	if(grouping=='followed by' && collection==sC){
		if((Integer)rtD.ffTo==0 || (Integer)rtD.ffTo==myC){
			//we're dealing with a followed by condition
			String sidx='c:fbi:'+myC.toString()
			Integer ladderIndex=(Integer)cast(rtD, rtD.cache[sidx], sINT)
			String sldt='c:fbt:'+myC.toString()
			Long ladderUpdated=(Long)cast(rtD, rtD.cache[sldt], sDTIME)
			Integer steps=conditions[collection] ? (Integer)conditions[collection].size():0
			if(ladderIndex>=steps){
				value=false
			}else{
				Map condition=((List<Map>)conditions[collection])[ladderIndex]
				Long duration=0L
				if(ladderIndex){
					Map tv=(Map)evaluateOperand(rtD, null, (Map)condition.wd)
					duration=(Long)evaluateExpression(rtD, [t:sDURATION, v:tv.v, vt:(String)tv.vt], sLONG).v
				}
				if(ladderUpdated && duration!=0L && (ladderUpdated+duration<now())){
					//time has expired
					value=((String)condition.wt=='n')
					if(!value){
						if((Integer)rtD.logging>2)debug "Conditional ladder step failed due to a timeout", rtD
					}
				}else{
					value=evaluateCondition(rtD, condition, collection, async)
					if((String)condition.wt=='n'){
						if(value){
							value=false
						}else{
							value=null
						}
					}
					//we allow loose matches to work even if other events happen
					if((String)condition.wt=='l' && !value)value=null
				}
				if(value){
					//successful step, move on
					ladderIndex += 1
					ladderUpdated=now()
					cancelStatementSchedules(rtD, myC)
					if((Integer)rtD.logging>2)debug "Condition group #${myC} made progress up the ladder; currently at step $ladderIndex of $steps", rtD
					if(ladderIndex<steps){
						//delay decision, there are more steps to go through
						value=null
						condition=((List<Map>)conditions[collection])[ladderIndex]
						Map tv=(Map)evaluateOperand(rtD, null, (Map)condition.wd)
						duration=(Long)evaluateExpression(rtD, [t:sDURATION, v:tv.v, vt:(String)tv.vt], sLONG).v
						requestWakeUp(rtD, conditions, conditions, duration)
					}
				}
			}

			switch (value){
			case null:
				//we need to exit time events set to work out the timeouts...
				if((Integer)rtD.ffTo==myC)rtD.terminated=true
				break
			case true:
			case false:
				//ladder either collapsed or finished, reset data
				ladderIndex=0
				ladderUpdated=0L
				cancelStatementSchedules(rtD, myC)
				break
			}
			if((Integer)rtD.ffTo==myC)rtD.ffTo=0
			rtD.cache[sidx]=ladderIndex
			rtD.cache[sldt]=ladderUpdated
		}
	}else{
		for(Map condition in (List<Map>)conditions[collection]){
			Boolean res=evaluateCondition(rtD, condition, collection, async)
			value= grouping==sOR ? value||res : value&&res
			//cto == disable condition traversal optimizations
			if((Integer)rtD.ffTo==0 && !rtD.piston.o?.cto && ((value && grouping==sOR) || (!value && grouping==sAND)))break
		}
	}
	Boolean result=false
	if(value!=null){
		result=not ? !value:value
	}
	if(value!=null && myC!=0){
		String mC="c:${myC}".toString()
		if((Integer)rtD.ffTo==0)tracePoint(rtD, mC, Math.round(1.0D*now()-t), result)
		Boolean oldResult=!!(Boolean)rtD.cache[mC]
		rtD.conditionStateChanged=(oldResult!=result)
		if((Boolean)rtD.conditionStateChanged){
			//condition change, perform Task Cancellation Policy TCP
			cancelConditionSchedules(rtD, myC)
		}
		rtD.cache[mC]=result
		//true/false actions
		if(collection==sC){
			if((result || (Integer)rtD.ffTo!=0) && conditions.ts!=null && (List)(conditions.ts).length)Boolean a=executeStatements(rtD, (List)conditions.ts, async)
			if((!result || (Integer)rtD.ffTo!=0) && conditions.fs!=null && (List)(conditions.fs).length)Boolean a=executeStatements(rtD, (List)conditions.fs, async)
		}
		if((Integer)rtD.ffTo==0 && (Integer)rtD.logging>2){
			msg.m="Condition group #${myC} evaluated $result (state ${(Boolean)rtD.conditionStateChanged ? 'changed' : 'did not change'})".toString()
			debug msg, rtD
		}
	}
	//restore condition id
	rtD.stack.c=c
	if((Boolean)rtD.eric) myDetail rtD, "evaluateConditions result: $result", -1
	return result
}

private evaluateOperand(Map rtD, Map node, Map operand, index=null, Boolean trigger=false, Boolean nextMidnight=false){
	if((Boolean)rtD.eric) myDetail rtD, "evaluateOperand $operand", 1
	List values=[]
	//older pistons don't have the 'to' operand (time offset), we're simulating an empty one
	if(!operand)operand=[t:sC]
	String ovt=(String)operand.vt
	String nodeI="${node?.$}:$index:0".toString()
	switch ((String)operand.t){
	case sBLK: //optional, nothing selected
		values=[[i:nodeI, v:[t:ovt, v:null]]]
		break
	case sP: //physical device
		String operA=(String)operand.a
		Map attribute=operA ? Attributes()[operA] : [:]
		for(String deviceId in expandDeviceList(rtD, (List)operand.d)){
			Map value=[i: deviceId+sCOLON+operA, v:getDeviceAttribute(rtD, deviceId, operA, operand.i, trigger)+(ovt ? [vt:ovt]:[:])+(attribute && attribute.p ? [p:operand.p]:[:])]
			updateCache(rtD, value)
			Boolean a=values.push(value)
		}
		if((Integer)values.size()>1 && !((String)operand.g in [sANY, sALL])){
			//if we have multiple values and a grouping other than any or all we need to apply that function
			try{
				values=[[i:nodeI, v:(Map)"func_${(String)operand.g}"(rtD, values*.v)+(ovt ? [vt:ovt]:[:])]]
			}catch(all){
				error "Error applying grouping method ${(String)operand.g}", rtD
			}
		}
		break
	case sD: //devices
		List deviceIds=[]
		for(String d in expandDeviceList(rtD, (List)operand.d)){
			if(getDevice(rtD, d))Boolean a=deviceIds.push(d)
		}
		values=[[i:"${node?.$}:d".toString(), v:[t:sDEV, v:deviceIds.unique()]]]
		break
	case sV: //virtual devices
		String rEN=(String)rtD.event.name
		String evntVal="${rtD.event.value}".toString()
		String nodeV="${node?.$}:v".toString()
		switch ((String)operand.v){
		case 'mode':
		case 'alarmSystemStatus':
			values=[[i:nodeV, v:getDeviceAttribute(rtD, (String)rtD.locationId, (String)operand.v)]]
			break
		case 'alarmSystemAlert':
			String valStr=evntVal+(rEN=='hsmAlert' && evntVal=='rule' ? ", ${(String)rtD.event.descriptionText}".toString():sBLK)
			values=[[i:nodeV, v:[t:sSTR, v:(rEN=='hsmAlert' ? valStr:sNULL)]]]
			break
		case 'alarmSystemEvent':
			values=[[i:nodeV, v:[t:sSTR, v:(rEN=='hsmSetArm' ? evntVal:sNULL)]]]
			break
		case 'alarmSystemRule':
			values=[[i:nodeV, v:[t:sSTR, v:(rEN=='hsmRules' ? evntVal:sNULL)]]]
			break
		case 'powerSource':
			values=[[i:nodeV, v:[t:sENUM, v:rtD.powerSource]]]
			break
		case sTIME:
		case sDATE:
		case sDTIME:
			values=[[i:nodeV, v:[t:(String)operand.v, v:(Long)cast(rtD, now(), (String)operand.v, sLONG)]]]
			break
		case 'routine':
			values=[[i:nodeV, v:[t:sSTR, v:(rEN=='routineExecuted' ? hashId(evntVal):sNULL)]]]
			break
		case 'systemStart':
			values=[[i:nodeV, v:[t:sSTR, v:(rEN=='systemStart' ? evntVal:sNULL)]]]
			break
		case 'tile':
			values=[[i:nodeV, v:[t:sSTR, v:(rEN==(String)operand.v ? evntVal:sNULL)]]]
			break
		case 'ifttt':
			values=[[i:nodeV, v:[t:sSTR, v:(rEN==('ifttt.'+evntVal)? evntVal:sNULL)]]]
			break
		case 'email':
			values=[[i:nodeV, v:[t:'email', v:(rEN==('email.'+evntVal)? evntVal:sNULL)]]]
			break
		}
		break
	case sS: //preset
		Boolean time=false
		switch (ovt){
		case sTIME:
			time=true
		case sDTIME:
			Long v=0L
			switch ((String)operand.s){
			case 'midnight': v=nextMidnight ? getNextMidnightTime():getMidnightTime(); break
			case 'sunrise': v=getSunriseTime(rtD); break
			case 'noon': v=getNoonTime(); break
			case 'sunset': v=getSunsetTime(rtD); break
			}
			if(time)v=(Long)cast(rtD, v, ovt, sDTIME)
			values=[[i:nodeI, v:[t:ovt, v:v]]]
			break
		default:
			values=[[i:nodeI, v:[t:ovt, v:operand.s]]]
			break
		}
		break
	case sX: //variable
		if(ovt==sDEV && operand.x instanceof List){
			//we could have multiple devices selected
			List sum=[]
			for(String x in (List)operand.x){
				Map var=getVariable(rtD, x)
				if(var.v instanceof List){
					sum += (List)var.v
				}else{
					Boolean a=sum.push(var.v)
				}
			}
			values=[[i:nodeI, v:[t:sDEV, v:sum]+(ovt ? [vt:ovt]:[:])]]
		}else{
			values=[[i:nodeI, v:getVariable(rtD, (String)operand.x+((String)operand.xi!=sNULL ? sLB+(String)operand.xi+sRB:sBLK))+(ovt ? [vt:ovt]:[:])]]
		}
		break
	case sC: //constant
		switch (ovt){
		case sTIME:
			Long offset=(operand.c instanceof Integer)? operand.c.toLong():(Long)cast(rtD, operand.c, sLONG)
			values=[[i:nodeI, v:[t:sTIME, v:(offset%1440L)*60000L]]]
			break
		case sDATE:
		case sDTIME:
			values=[[i:nodeI, v:[t:ovt, v:operand.c]]]
			break
		}
		if((Integer)values.size()!=0)break
	case sE: //expression
		values=[[i:nodeI, v: [:]+evaluateExpression(rtD, (Map)operand.exp) + (ovt ? [vt:ovt]:[:]) ]]
		break
	case 'u': //expression
		values=[[i:nodeI, v:getArgument(rtD, (String)operand.u)]]
		break
	}
	def ret=values
	if(node==null){ // return a Map instead of a List
		if(values.length)ret=values[0].v
		else ret=[t:sDYN, v:null]
	}
	if((Boolean)rtD.eric) myDetail rtD, "evaluateOperand $operand result: $ret", -1
	return ret
}

private Map evaluateScalarOperand(Map rtD, Map node, Map operand, index=null, String dataType=sSTR){
	Map value=(Map)evaluateOperand(rtD, null, operand, index)
	return [t:dataType, v:cast(rtD, (value ? value.v:sBLK), dataType)]
}

private Boolean evaluateCondition(Map rtD, Map condition, String collection, Boolean async){
	String myS
	if((Boolean)rtD.eric){
		myS="evaluateCondition $condition".toString()
		myDetail rtD, myS, 1
	}
	Long t=now()
	Map msg
	if((Integer)rtD.logging>2)msg=timer sBLK, rtD
	//override condition id
	Integer c=(Integer)rtD.stack.c
	Integer conditionNum=condition.$!=null ? (Integer)condition.$:0
	rtD.stack.c=conditionNum
	String sIndx="c:${conditionNum}".toString()
	Boolean not=false
	Boolean oldResult=!!(Boolean)rtD.cache[sIndx]
	Boolean result=false
	if((String)condition.t==sGROUP){
		Boolean tt1=evaluateConditions(rtD, condition, collection, async)
		if((Boolean)rtD.eric) myDetail rtD, myS+" result: $tt1", -1
		return tt1
	}else{
		not=!!condition.n
		Map comparison=Comparisons().triggers[(String)condition.co]
		Boolean trigger=comparison!=null
		if(!trigger)comparison=Comparisons().conditions[(String)condition.co]
		rtD.wakingUp=(String)rtD.event.name==sTIME && rtD.event.schedule!=null && (Integer)rtD.event.schedule.s==conditionNum
		if((Integer)rtD.ffTo!=0 || comparison!=null){
			if((Integer)rtD.ffTo==0 || ((Integer)rtD.ffTo==-9 /*initial run*/)){
				Integer paramCount=comparison.p!=null ? (Integer)comparison.p:0
				Map lo=null
				Map ro=null
				Map ro2=null
				for(Integer i=0; i<=paramCount; i++){
					Map operand=(i==0 ? (Map)condition.lo:(i==1 ? (Map)condition.ro : (Map)condition.ro2))
					//parse the operand
					List values=(List)evaluateOperand(rtD, condition, operand, i, trigger)
					switch (i){
					case 0:
						lo=[operand:operand, values:values]
						break
					case 1:
						ro=[operand:operand, values:values]
						break
					case 2:
						ro2=[operand:operand, values:values]
						break
					}
				}

				//we now have all the operands, their values, and the comparison, let's get to work
				Boolean t_and_compt=(trigger && comparison.t!=null)
				Map options=[
					//we ask for matching/non-matching devices if the user requested it or if the trigger is timed
					//setting matches to true will force the condition group to evaluate all members (disables evaluation optimizations)
					matches: lo.operand.dm!=null || lo.operand.dn!=null || t_and_compt,
					forceAll: t_and_compt
				]
				Map to=(comparison.t!=null || (ro!=null && (String)lo.operand.t==sV && (String)lo.operand.v==sTIME && (String)ro.operand.t!=sC)) && condition.to!=null ? [operand: (Map)condition.to, values: (Map)evaluateOperand(rtD, null, (Map)condition.to)]:null
				Map to2=ro2!=null && (String)lo.operand.t==sV && (String)lo.operand.v==sTIME && (String)ro2.operand.t!=sC && condition.to2!=null ? [operand: (Map)condition.to2, values: (Map)evaluateOperand(rtD, null, (Map)condition.to2)]:null
				result=evaluateComparison(rtD, (String)condition.co, lo, ro, ro2, to, to2, options)
				//save new values to cache
				if(lo)for(Map value in (List<Map>)lo.values)updateCache(rtD, value)
				if(ro)for(Map value in (List<Map>)ro.values)updateCache(rtD, value)
				if(ro2)for(Map value in (List<Map>)ro2.values)updateCache(rtD, value)
				if((Integer)rtD.ffTo==0)tracePoint(rtD, sIndx, Math.round(1.0D*now()-t), result)
				if(lo.operand.dm!=null && options.devices!=null)def m=setVariable(rtD, (String)lo.operand.dm, options.devices.matched!=null ? (List)options.devices.matched:[])
				if(lo.operand.dn!=null && options.devices!=null)def n=setVariable(rtD, (String)lo.operand.dn, options.devices.unmatched!=null ? (List)options.devices.unmatched:[])
				//do the stay logic here
				if(t_and_compt && (Integer)rtD.ffTo==0){
					//timed trigger
					if(to!=null){
						def tvalue=to.operand && to.values ? (Map)to.values+[f: to.operand.f]:null
						if(tvalue!=null){
							Long delay=(Long)evaluateExpression(rtD, [t:sDURATION, v:tvalue.v, vt:(String)tvalue.vt], sLONG).v
							if((String)lo.operand.t==sP && (String)lo.operand.g==sANY && (Integer)lo.values.size()>1){

								List<Map> schedules
								Map t0=getCachedMaps()
								if(t0!=null)schedules=[]+(List<Map>)t0.schedules
								else schedules=(Boolean)rtD.pep ? (List<Map>)atomicState.schedules:(List<Map>)state.schedules
								for(value in (List)lo.values){
									String dev=(String)value.v?.d
									if(dev in (List)options.devices.matched){
										//schedule one device schedule
										if(!schedules.find{ (Integer)it.s==conditionNum && (String)it.d==dev }){
											//schedule a wake up if there's none, otherwise just move on
											if((Integer)rtD.logging>2)debug "Adding a timed trigger schedule for device $dev for condition ${conditionNum}", rtD
											requestWakeUp(rtD, condition, condition, delay, dev)
										}
									}else{
										//cancel that one device schedule
										if((Integer)rtD.logging>2)debug "Cancelling any timed trigger schedules for device $dev for condition ${conditionNum}", rtD
										cancelStatementSchedules(rtD, conditionNum, dev)
									}
								}
							}else{
								if(result){
								//if we find the comparison true, set a timer if we haven't already

									List<Map> schedules
									Map t0=getCachedMaps()
									if(t0!=null)schedules=[]+(List<Map>)t0.schedules
									else schedules=(Boolean)rtD.pep ? (List<Map>)atomicState.schedules:(List<Map>)state.schedules
									if(!schedules.find{ ((Integer)it.s==conditionNum)}){
										if((Integer)rtD.logging>2)debug "Adding a timed trigger schedule for condition ${conditionNum}", rtD
										requestWakeUp(rtD, condition, condition, delay)
									}
								}else{
									if((Integer)rtD.logging>2)debug "Cancelling any timed trigger schedules for condition ${conditionNum}", rtD
									cancelStatementSchedules(rtD, conditionNum)
								}
							}
						}
					}
					result=false
				}
				result=not ? !result:result
			}else if((String)rtD.event.name==sTIME && (Integer)rtD.ffTo==conditionNum){
				rtD.ffTo=0
				rtD.resumed=true
				result=!not
			}else{
				result=oldResult
			}
		}
	}
	rtD.wakingUp=false
	rtD.conditionStateChanged=oldResult!=result
	if((Boolean)rtD.conditionStateChanged){
		//condition change, perform Task Cancellation Policy TCP
		cancelConditionSchedules(rtD, conditionNum)
	}
	rtD.cache[sIndx]=result
	//true/false actions
	if((result || (Integer)rtD.ffTo!=0) && condition.ts!=null && ((List)condition.ts).length!=0)Boolean a=executeStatements(rtD, (List)condition.ts, async)
	if((!result || (Integer)rtD.ffTo!=0) && condition.fs!=null && ((List)condition.fs).length!=0)Boolean a=executeStatements(rtD, (List)condition.fs, async)
	//restore condition id
	rtD.stack.c=c
	if((Integer)rtD.ffTo==0 && (Integer)rtD.logging>2){
		msg.m="Condition #${conditionNum} evaluated $result"
		debug msg, rtD
	}
	if((Integer)rtD.ffTo<=0 && (Boolean)condition.s && (String)condition.t==sCONDITION && condition.lo!=null && (String)condition.lo.t==sV){
		switch ((String)condition.lo.v){
		case sTIME:
		case sDATE:
		case sDTIME:
			scheduleTimeCondition(rtD, condition)
			break
		}
	}
	if((Boolean)rtD.eric) myDetail rtD, myS+" result: $result", -1
	return result
}

private void updateCache(Map rtD, Map value){
	Map oldValue=(Map)((Map)rtD.cache)[(String)value.i]
	if(oldValue==null || ((String)oldValue.t!=(String)value.v.t) || (oldValue.v!=value.v.v)){
		rtD.newCache[(String)value.i]=(Map)value.v+[s: now()]
	}
}

private Boolean evaluateComparison(Map rtD, String comparison, Map lo, Map ro=null, Map ro2=null, Map to=null, Map to2=null, options=[:]){
	String mySt
	if((Boolean)rtD.eric){
		mySt="evaluateComparison $comparison"
		myDetail rtD, mySt, 1
	}
	String fn="comp_"+comparison
	Boolean result= (String)lo.operand.g!=sANY
	if((Boolean)options?.matches){
		options.devices=[matched: [], unmatched: []]
	}
	//if multiple left values, go through each
	Map tvalue=to && to.operand && to.values ? (Map)to.values+[f: to.operand.f]:null
	Map tvalue2=to2 && to2.operand && to2.values ? (Map)to2.values:null
	for(Map value in (List<Map>)lo.values){
		Boolean res=false
		if(value && value.v && (!value.v.x || (Boolean)options.forceAll)){
			try{
				//physical support
				//value.p=lo.operand.p
				if(value && ((String)value.v.t==sDEV))value.v=evaluateExpression(rtD, (Map)value.v, sDYN)
				if(!ro){
					Map msg
					if((Integer)rtD.logging>2)msg=timer sBLK, rtD
					if(comparison=='event_occurs' && (String)lo.operand.t==sV && (String)rtD.event.name==(String)lo.operand.v)res=true
					else res=(Boolean)"$fn"(rtD, value, null, null, tvalue, tvalue2)
					if((Integer)rtD.logging>2){
						msg.m="Comparison (${value?.v?.t}) ${value?.v?.v} $comparison = $res"
						debug msg, rtD
					}
				}else{
					Boolean rres
					res= (String)ro.operand.g!=sANY
					//if multiple right values, go through each
					for(Map rvalue in (List<Map>)ro.values){
						if(rvalue && ((String)rvalue.v.t==sDEV))rvalue.v=evaluateExpression(rtD, (Map)rvalue.v, sDYN)
						if(!ro2){
							Map msg
							if((Integer)rtD.logging>2)msg=timer sBLK, rtD
							rres=(Boolean)"$fn"(rtD, value, rvalue, null, tvalue, tvalue2)
							if((Integer)rtD.logging>2){
								msg.m="Comparison (${value?.v?.t}) ${value?.v?.v} $comparison  (${rvalue?.v?.t}) ${rvalue?.v?.v} = $rres"
								debug msg, rtD
							}
						}else{
							rres=(String)ro2.operand.g!=sANY
							//if multiple right2 values, go through each
							for(Map r2value in (List<Map>)ro2.values){
								if(r2value && ((String)r2value.v.t==sDEV))r2value.v=evaluateExpression(rtD, (Map)r2value.v, sDYN)
								Map msg
								if((Integer)rtD.logging>2)msg=timer sBLK, rtD
//if((Boolean)rtD.eric) myDetail rtD, "$fn $value   $rvalue    $r2value    $tvalue   $tvalue2", 1
								Boolean r2res=(Boolean)"$fn"(rtD, value, rvalue, r2value, tvalue, tvalue2)
//if((Boolean)rtD.eric) myDetail rtD, "$r2res  ${myObj(value?.v?.v)}    ${myObj(rvalue?.v?.v)}  $fn $value   $rvalue    $r2value    $tvalue   $tvalue2", -1
								if((Integer)rtD.logging>2){
									msg.m="Comparison (${value?.v?.t}) ${value?.v?.v} $comparison  (${rvalue?.v?.t}) ${rvalue?.v?.v} .. (${r2value?.v?.t}) ${r2value?.v?.v} = $r2res"
									debug msg, rtD
								}
								rres= (String)ro2.operand.g==sANY ? rres||r2res : rres&&r2res
								if(((String)ro2.operand.g==sANY && rres) || ((String)ro2.operand.g!=sANY && !rres))break
							}
						}
						res=((String)ro.operand.g==sANY ? res||rres : res&&rres)
						if(((String)ro.operand.g==sANY && res) || ((String)ro.operand.g!=sANY && !res))break
					}
				}
			}catch(all){
				error "Error calling comparison $fn:", rtD, -2, all
				res=false
			}

			if(res && ((String)lo.operand.t==sV)){
				switch ((String)lo.operand.v){
				case sTIME:
				case sDATE:
				case sDTIME:
					Boolean pass=(checkTimeRestrictions(rtD, (Map)lo.operand, now(), 5, 1)==0L)
					if((Integer)rtD.logging>2)debug "Time restriction check ${pass ? 'passed' : 'failed'}", rtD
					if(!pass)res=false
				}
			}
		}
		result= (String)lo.operand.g==sANY ? result||res : result&&res
		if((Boolean)options?.matches && (String)value.v.d){
			if(res){
				Boolean a=((List)options.devices.matched).push((String)value.v.d)
			}else{
				Boolean a=((List)options.devices.unmatched).push((String)value.v.d)
			}
		}
		if((String)lo.operand.g==sANY && res && !((Boolean)options?.matches)){
			//logical OR if we're using the ANY keyword
			break
		}
		if((String)lo.operand.g==sALL && !result && !((Boolean)options?.matches)){
			//logical AND if we're using the ALL keyword
			break
		}
	}
	if((Boolean)rtD.eric) myDetail rtD, mySt+" result: $result", -1
	return result
}

private void cancelStatementSchedules(Map rtD, Integer statementId, String data=sNULL){
	//cancel all schedules that are pending for statement statementId
	Boolean found=false
	for(Map item in (List<Map>)rtD.cancelations.statements){
		found=(statementId==(Integer)item.id && (!data || data==(String)item.data))
		if(found)break
	}
	if((Integer)rtD.logging>2)debug "Cancelling statement #${statementId}'s schedules...", rtD
	if(!found)Boolean a=((List<Map>)rtD.cancelations.statements).push([id: statementId, data: data])
}

private void cancelConditionSchedules(Map rtD, Integer conditionId){
	//cancel all schedules that are pending for condition conditionId
	if((Integer)rtD.logging>2)debug "Cancelling condition #${conditionId}'s schedules...", rtD
	if(!(conditionId in (List<Integer>)rtD.cancelations.conditions)){
		Boolean a=((List<Integer>)rtD.cancelations.conditions).push(conditionId)
	}
}

private static Boolean matchDeviceSubIndex(list, deviceSubIndex){
	//if (!list || !(list instanceof List) || (list.size() == 0)) return true
	//return list.collect{ "$it".toString() }.indexOf("$deviceSubIndex".toString()) >= 0
	return true
}

private static Boolean matchDeviceInteraction(String option, Map rtD){
	Boolean isPhysical=(Boolean)rtD.currentEvent.physical
	return !((option==sP && !isPhysical) || (option==sS && isPhysical))
}

private List listPreviousStates(device, String attribute, Long threshold, Boolean excludeLast){
	List result=[]
	List events=device.events([all: true, max: 100]).findAll{(String)it.name==attribute}
	//if we got any events, let's go through them
	//if we need to exclude last event, we start at the second event, as the first one is the event that triggered this function. The attribute's value has to be different from the current one to qualify for quiet
	if((Integer)events.size()!=0){
		Long thresholdTime=now()-threshold
		Long endTime=now()
		for(Integer i=0; i<(Integer)events.size(); i++){
			Long startTime=(Long)((Date)events[i].date).getTime()
			Long duration=endTime-startTime
			if(duration>=1000L && (i>0 || !excludeLast)){
				Boolean a=result.push([value: events[i].value, startTime: startTime, duration: duration])
			}
			if(startTime<thresholdTime)
				break
			endTime=startTime
		}
	}else{
		def currentState=device.currentState(attribute, true)
		if(currentState){
			Long startTime=(Long)((Date)currentState.getDate()).getTime()
			Boolean a=result.push([value: currentState.value, startTime: startTime, duration: now()- startTime])
		}
	}
	return result
}

private static Map valueCacheChanged(Map rtD, Map comparisonValue){
	Map oldValue=(Map)rtD.cache[(String)comparisonValue.i]
	def newValue=comparisonValue.v
	if(!(oldValue instanceof Map))oldValue=null
	return (oldValue!=null && ((String)oldValue.t!=(String)newValue.t || "${oldValue.v}"!="${newValue.v}")) ? [i: (String)comparisonValue.i, v: oldValue] : null
}

private Boolean valueWas(Map rtD, Map comparisonValue, Map rightValue, Map rightValue2, Map timeValue, String func){
	if(comparisonValue==null || comparisonValue.v==null || !(String)comparisonValue.v.d || !(String)comparisonValue.v.a || timeValue==null || !timeValue.v || !(String)timeValue.vt){
		return false
	}
	def device=getDevice(rtD, (String)comparisonValue.v.d)
	if(device==null)return false
	String attribute=(String)comparisonValue.v.a
	Long threshold=(Long)evaluateExpression(rtD, [t:sDURATION, v:timeValue.v, vt:(String)timeValue.vt], sLONG).v

	List states=listPreviousStates(device, attribute, threshold, rtD.event.device?.id==device.id && (String)rtD.event.name==attribute)
	Boolean result=true
	Long duration=0
	for(stte in states){
		if(!("comp_$func"(rtD, [i: (String)comparisonValue.i, v: [t: (String)comparisonValue.v.t, v: cast(rtD, stte.value, (String)comparisonValue.v.t)]], rightValue, rightValue2, timeValue)))break
		duration += stte.duration
	}
	if(duration==0L)return false
	result=((String)timeValue.f=='l')? duration<threshold:duration>=threshold
	if((Integer)rtD.logging>2)debug "Duration ${duration}ms for ${func.replace('is_', 'was_')} ${(String)timeValue.f=='l' ? sLTH : sGTHE} ${threshold}ms threshold = ${result}", rtD
	return result
}

private Boolean valueChanged(Map rtD, Map comparisonValue, Map timeValue){
	if(comparisonValue==null || comparisonValue.v==null || !(String)comparisonValue.v.d || !(String)comparisonValue.v.a || timeValue==null || !timeValue.v || !(String)timeValue.vt){
		return false
	}
	def device=getDevice(rtD, (String)comparisonValue.v.d)
	if(device==null)return false
	String attribute=(String)comparisonValue.v.a
	Long threshold=(Long)evaluateExpression(rtD, [t:sDURATION, v:timeValue.v, vt:(String)timeValue.vt], sLONG).v

	List states=listPreviousStates(device, attribute, threshold, false)
	if((Integer)states.size()==0)return false
	def value=states[0].value
	for(tstate in states){
		if(tstate.value!=value)return true
	}
	return false
}

private Boolean match(String string, String pattern){
	Integer sz=(Integer)pattern.size
	if(sz>2 && (Boolean)pattern.startsWith(sDIV) && (Boolean)pattern.endsWith(sDIV)){
		pattern=~pattern.substring(1, sz-1)
		return !!(string =~ pattern)
	}
	return (Boolean)string.contains(pattern)
}

//comparison low level functions
private Boolean comp_is					(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return ((String)evaluateExpression(rtD, (Map)lv.v, sSTR).v==(String)evaluateExpression(rtD, (Map)rv.v, sSTR).v)|| (lv.v.n && ((String)cast(rtD, lv.v.n, sSTR)==(String)cast(rtD, rv.v.v, sSTR)))}
private Boolean comp_is_not				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return !comp_is(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_is_equal_to			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ String dt=(((String)lv?.v?.t==sDCML)|| ((String)rv?.v?.t==sDCML)? sDCML:(((String)lv?.v?.t==sINT)|| ((String)rv?.v?.t==sINT)? sINT:sDYN)); return evaluateExpression(rtD, (Map)lv.v, dt).v==evaluateExpression(rtD, (Map)rv.v, dt).v }
private Boolean comp_is_not_equal_to			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return !comp_is_equal_to(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_is_different_than			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_not_equal_to(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_is_less_than			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return (Double)evaluateExpression(rtD, (Map)lv.v, sDCML).v<(Double)evaluateExpression(rtD, (Map)rv.v, sDCML).v }
private Boolean comp_is_less_than_or_equal_to		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return (Double)evaluateExpression(rtD, (Map)lv.v, sDCML).v<=(Double)evaluateExpression(rtD, (Map)rv.v, sDCML).v }
private Boolean comp_is_greater_than			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return (Double)evaluateExpression(rtD, (Map)lv.v, sDCML).v>(Double)evaluateExpression(rtD, (Map)rv.v, sDCML).v }
private Boolean comp_is_greater_than_or_equal_to	(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return (Double)evaluateExpression(rtD, (Map)lv.v, sDCML).v>=(Double)evaluateExpression(rtD, (Map)rv.v, sDCML).v }
private Boolean comp_is_even				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return ((Integer)evaluateExpression(rtD, (Map)lv.v, sINT).v).mod(2)==0 }
private Boolean comp_is_odd				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return ((Integer)evaluateExpression(rtD, (Map)lv.v, sINT).v).mod(2)!=0 }
private Boolean comp_is_true				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return (Boolean)evaluateExpression(rtD, (Map)lv.v, sBOOLN).v }
private Boolean comp_is_false				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return !(Boolean)evaluateExpression(rtD, (Map)lv.v, sBOOLN).v }
private Boolean comp_is_inside_of_range			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Double v=(Double)evaluateExpression(rtD, (Map)lv.v, sDCML).v; Double v1=(Double)evaluateExpression(rtD, (Map)rv.v, sDCML).v; Double v2=(Double)evaluateExpression(rtD, (Map)rv2.v, sDCML).v; return (v1<v2) ? (v>=v1 && v<=v2):(v>=v2 && v<=v1)}
private Boolean comp_is_outside_of_range		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return !comp_is_inside_of_range(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_is_any_of				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ String v=(String)evaluateExpression(rtD, (Map)lv.v, sSTR).v; for(String vi in ((String)rv.v.v).tokenize(sCOMMA)){ if(v==(String)evaluateExpression(rtD, [t: (String)rv.v.t, v: "$vi".toString().trim(), i: rv.v.i, a: rv.v.a, vt: (String)rv.v.vt], sSTR).v)return true }; return false}
private Boolean comp_is_not_any_of			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return !comp_is_any_of(rtD, lv, rv, rv2, tv, tv2)}

private Boolean comp_was				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is')}
private Boolean comp_was_not				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_not')}
private Boolean comp_was_equal_to			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_equal_to')}
private Boolean comp_was_not_equal_to			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_not_equal_to')}
private Boolean comp_was_different_than			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_different_than')}
private Boolean comp_was_less_than			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_less_than')}
private Boolean comp_was_less_than_or_equal_to		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_less_than_or_equal_to')}
private Boolean comp_was_greater_than			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_greater_than')}
private Boolean comp_was_greater_than_or_equal_to	(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_greater_than_or_equal_to')}
private Boolean comp_was_even				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_even')}
private Boolean comp_was_odd				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_odd')}
private Boolean comp_was_true				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_true')}
private Boolean comp_was_false				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_false')}
private Boolean comp_was_inside_of_range		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_inside_of_range')}
private Boolean comp_was_outside_of_range		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_outside_of_range')}
private Boolean comp_was_any_of				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_any_of')}
private Boolean comp_was_not_any_of			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueWas(rtD, lv, rv, rv2, tv, 'is_not_any_of')}

private Boolean comp_changed				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, tv2=null){ return valueChanged(rtD, lv, tv)}
private Boolean comp_did_not_change			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return !valueChanged(rtD, lv, tv)}

private Boolean comp_is_any			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return true }
private Boolean comp_is_before				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Long offset1=tv ? (Long)evaluateExpression(rtD, [t:sDURATION, v:tv.v, vt:(String)tv.vt], sLONG).v:0L; return cast(rtD, (Long)evaluateExpression(rtD, (Map)lv.v, sDTIME).v+2000L, (String)lv.v.t)<cast(rtD, (Long)evaluateExpression(rtD, (Map)rv.v, sDTIME).v+offset1, (String)lv.v.t)}
private Boolean comp_is_after				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Long offset1=tv ? (Long)evaluateExpression(rtD, [t:sDURATION, v:tv.v, vt:(String)tv.vt], sLONG).v:0L; return cast(rtD, (Long)evaluateExpression(rtD, (Map)lv.v, sDTIME).v+2000L, (String)lv.v.t)>=cast(rtD, (Long)evaluateExpression(rtD, (Map)rv.v, sDTIME).v+offset1, (String)lv.v.t)}
private Boolean comp_is_between				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Long offset1=tv ? (Long)evaluateExpression(rtD, [t:sDURATION, v:tv.v, vt:(String)tv.vt], sLONG).v:0L; Long offset2=tv2 ? (Long)evaluateExpression(rtD, [t:sDURATION, v:tv2.v, vt:(String)tv2.vt], sLONG).v:0L; Long v=(Long)cast(rtD, (Long)evaluateExpression(rtD, (Map)lv.v, sDTIME).v+2000L, (String)lv.v.t); Long v1=(Long)cast(rtD, (Long)evaluateExpression(rtD, (Map)rv.v, sDTIME).v+offset1, (String)lv.v.t); Long v2=(Long)cast(rtD, (Long)evaluateExpression(rtD, (Map)rv2.v, sDTIME).v+offset2, (String)lv.v.t); return v1<v2 ? v>=v1 && v<v2 : v<v2 || v>=v1}
private Boolean comp_is_not_between			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return !comp_is_between(rtD, lv, rv, rv2, tv, tv2)}

/*triggers*/
private Boolean comp_gets				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return (String)cast(rtD, lv.v.v, sSTR)==(String)cast(rtD, rv.v.v, sSTR) && matchDeviceSubIndex(lv.v.i, (Integer)rtD.currentEvent.index)}
private Boolean comp_executes				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_arrives				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return (String)rtD.event.name=='email' && match(rtD.event?.jsonData?.from ?: sBLK, (String)evaluateExpression(rtD, (Map)rv.v, sSTR).v) && match(rtD.event?.jsonData?.message ?: sBLK, (String)evaluateExpression(rtD, (Map)rv2.v, sSTR).v)}
private Boolean comp_event_occurs		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return false }
private Boolean comp_happens_daily_at		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return (Boolean)rtD.wakingUp }
private Boolean comp_changes			(Map rtD, Map lv, rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueCacheChanged(rtD, lv)!=null && matchDeviceInteraction((String)lv.v.p, rtD)}
private Boolean comp_changes_to			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueCacheChanged(rtD, lv)!=null && ("${lv.v.v}"=="${rv.v.v}") && matchDeviceInteraction((String)lv.v.p, rtD)}
private Boolean comp_receives			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return ("${lv.v.v}"=="${rv.v.v}") && matchDeviceInteraction((String)lv.v.p, rtD)}
private Boolean comp_changes_away_from		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ("${oldValue.v.v}"=="${rv.v.v}") && matchDeviceInteraction((String)lv.v.p, rtD)}
private Boolean comp_drops			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)>(Double)cast(rtD, lv.v.v, sDCML))}
private Boolean comp_does_not_drop			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return !comp_drops(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_drops_below			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)>=(Double)cast(rtD, rv.v.v, sDCML)) && ((Double)cast(rtD, lv.v.v, sDCML)<(Double)cast(rtD, rv.v.v, sDCML))}
private Boolean comp_drops_to_or_below			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)>(Double)cast(rtD, rv.v.v, sDCML)) && ((Double)cast(rtD, lv.v.v, sDCML)<=(Double)cast(rtD, rv.v.v, sDCML))}
private Boolean comp_rises				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)<(Double)cast(rtD, lv.v.v, sDCML))}
private Boolean comp_does_not_rise			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return !comp_rises(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_rises_above			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)<=(Double)cast(rtD, rv.v.v, sDCML)) && ((Double)cast(rtD, lv.v.v, sDCML)>(Double)cast(rtD, rv.v.v, sDCML))}
private Boolean comp_rises_to_or_above			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)<(Double)cast(rtD, rv.v.v, sDCML)) && ((Double)cast(rtD, lv.v.v, sDCML)>=(Double)cast(rtD, rv.v.v, sDCML))}
private Boolean comp_remains_below			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)<(Double)cast(rtD, rv.v.v, sDCML)) && ((Double)cast(rtD, lv.v.v, sDCML)<(Double)cast(rtD, rv.v.v, sDCML))}
private Boolean comp_remains_below_or_equal_to		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)<=(Double)cast(rtD, rv.v.v, sDCML)) && ((Double)cast(rtD, lv.v.v, sDCML)<=(Double)cast(rtD, rv.v.v, sDCML))}
private Boolean comp_remains_above			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)>(Double)cast(rtD, rv.v.v, sDCML)) && ((Double)cast(rtD, lv.v.v, sDCML)>(Double)cast(rtD, rv.v.v, sDCML))}
private Boolean comp_remains_above_or_equal_to		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && ((Double)cast(rtD, oldValue.v.v, sDCML)>=(Double)cast(rtD, rv.v.v, sDCML)) && ((Double)cast(rtD, lv.v.v, sDCML)>=(Double)cast(rtD, rv.v.v, sDCML))}
private Boolean comp_enters_range			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); if(oldValue==null)return false; Double ov=(Double)cast(rtD, oldValue.v.v, sDCML); Double v=(Double)cast(rtD, lv.v.v, sDCML); Double v1=(Double)cast(rtD, rv.v.v, sDCML); Double v2=(Double)cast(rtD, rv2.v.v, sDCML); if(v1>v2){ Double vv=v1; v1=v2; v2=vv }; return ((ov<v1)|| (ov>v2)) && ((v>=v1) && (v<=v2))}
private Boolean comp_exits_range			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); if(oldValue==null)return false; Double ov=(Double)cast(rtD, oldValue.v.v, sDCML); Double v=(Double)cast(rtD, lv.v.v, sDCML); Double v1=(Double)cast(rtD, rv.v.v, sDCML); Double v2=(Double)cast(rtD, rv2.v.v, sDCML); if(v1>v2){ Double vv=v1; v1=v2; v2=vv }; return ((ov>=v1) && (ov<=v2)) && ((v<v1)|| (v>v2))}
private Boolean comp_remains_inside_of_range		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); if(oldValue==null)return false; Double ov=(Double)cast(rtD, oldValue.v.v, sDCML); Double v=(Double)cast(rtD, lv.v.v, sDCML); Double v1=(Double)cast(rtD, rv.v.v, sDCML); Double v2=(Double)cast(rtD, rv2.v.v, sDCML); if(v1>v2){ Double vv=v1; v1=v2; v2=vv }; return (ov>=v1) && (ov<=v2) && (v>=v1) && (v<=v2)}
private Boolean comp_remains_outside_of_range		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); if(oldValue==null)return false; Double ov=(Double)cast(rtD, oldValue.v.v, sDCML); Double v=(Double)cast(rtD, lv.v.v, sDCML); Double v1=(Double)cast(rtD, rv.v.v, sDCML); Double v2=(Double)cast(rtD, rv2.v.v, sDCML); if(v1>v2){ Double vv=v1; v1=v2; v2=vv }; return ((ov<v1)|| (ov>v2)) && ((v<v1) || (v>v2))}
private Boolean comp_becomes_even			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && (((Integer)cast(rtD, oldValue.v.v, sINT)).mod(2)!=0) && (((Integer)cast(rtD, lv.v.v, sINT)).mod(2)==0)}
private Boolean comp_becomes_odd			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && (((Integer)cast(rtD, oldValue.v.v, sINT)).mod(2)==0) && (((Integer)cast(rtD, lv.v.v, sINT)).mod(2)!=0)}
private Boolean comp_remains_even			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && (((Integer)cast(rtD, oldValue.v.v, sINT)).mod(2)==0) && (((Integer)cast(rtD, lv.v.v, sINT)).mod(2)==0)}
private Boolean comp_remains_odd			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && (((Integer)cast(rtD, oldValue.v.v, sINT)).mod(2)!=0) && (((Integer)cast(rtD, lv.v.v, sINT)).mod(2)!=0)}

private Boolean comp_changes_to_any_of			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return valueCacheChanged(rtD, lv)!=null && comp_is_any_of(rtD, lv, rv, rv2, tv, tv2) && matchDeviceInteraction((String)lv.v.p, rtD)}
private Boolean comp_changes_away_from_any_of		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ Map oldValue=valueCacheChanged(rtD, lv); return oldValue!=null && comp_is_any_of(rtD, oldValue, rv, rv2) && matchDeviceInteraction((String)lv.v.p, rtD)}

private Boolean comp_stays				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_unchanged			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return true }
private Boolean comp_stays_not				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_not(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_equal_to			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_equal_to(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_different_than		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_different_than(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_less_than			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_less_than(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_less_than_or_equal_to	(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_less_than_or_equal_to(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_greater_than			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_greater_than(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_greater_than_or_equal_to	(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_greater_than_or_equal_to(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_even				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_even(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_odd				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_odd(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_true				(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_true(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_false			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_false(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_inside_of_range		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_inside_of_range(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_outside_of_range		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_outside_of_range(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_any_of			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_any_of(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_away_from			(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_not_equal_to(rtD, lv, rv, rv2, tv, tv2)}
private Boolean comp_stays_away_from_any_of		(Map rtD, Map lv, Map rv=null, Map rv2=null, Map tv=null, Map tv2=null){ return comp_is_not_any_of(rtD, lv, rv, rv2, tv, tv2)}

private void traverseStatements(node, closure, parentNode=null, Map data=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(def item in (List)node){
			if(!item.di){
				Boolean lastTimer=(data!=null && (Boolean)data.timer)
				if(data!=null && ((String)item.t==sEVERY)){
					data.timer=true
				}
				traverseStatements(item, closure, parentNode, data)
				if(data!=null){
					data.timer=lastTimer
				}
			}
		}
		return
	}

	//got a statement
	if(closure instanceof Closure){
		closure(node, parentNode, data)
	}

	//if the statements has substatements, go through them
	if(node.s instanceof List){
		traverseStatements((List)node.s, closure, node, data)
	}
	if(node.e instanceof List){
		traverseStatements((List)node.e, closure, node, data)
	}
}

private void traverseEvents(node, closure, parentNode=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(item in (List)node){
			traverseEvents(item, closure, parentNode)
		}
		return
	}
	//got a condition
	if(closure instanceof Closure){
		closure(node, parentNode)
	}
}

private void traverseConditions(node, closure, parentNode=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(item in (List)node){
			traverseConditions(item, closure, parentNode)
		}
		return
	}
	//got a condition
	if(node.t==sCONDITION && (closure instanceof Closure)){
		closure(node, parentNode)
	}
	//if the statements has substatements, go through them
	if(node.c instanceof List){
		if(closure instanceof Closure)closure(node, parentNode)
		traverseConditions((List)node.c, closure, node)
	}
}

private void traverseRestrictions(node, closure, parentNode=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(item in (List)node){
			traverseRestrictions(item, closure, parentNode)
		}
		return
	}
	//got a restriction
	if(node.t==sRESTRIC && (closure instanceof Closure)){
		closure(node, parentNode)
	}
	//if the statements has substatements, go through them
	if(node.r instanceof List){
		if(closure instanceof Closure)closure(node, parentNode)
		traverseRestrictions((List)node.r, closure, node)
	}
}

private void traverseExpressions(node, closure, param, parentNode=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(item in (List)node){
			traverseExpressions(item, closure, param, parentNode)
		}
		return
	}
	//got a statement
	if(closure instanceof Closure){
		closure(node, parentNode, param)
	}
	//if the statements has substatements, go through them
	if(node.i instanceof List){
		traverseExpressions((List)node.i, closure, param, node)
	}
}

private void updateDeviceList(Map rtD, List deviceIdList){
	app.updateSetting('dev', [type: /*isHubitat()?*/ 'capability'/*:'capability.device'*/, value: deviceIdList.unique()])// settings update do not happen till next execution
}

private void subscribeAll(Map rtD, Boolean doit=true){
	if(eric())log.debug "subscribeAll $doit"
	try{
	if(!rtD){ log.error "no rtD subscribeAll"; return }
	Map ss=[
		events: 0,
		controls: 0,
		devices: 0,
	]
	Map statementData=[timer:false]
	Map msg=timer "Finished subscribing", rtD, -1
	if(doit){
		unsubscribe()
		rtD.devices=[:]
		if((Integer)rtD.logging>1)trace "Subscribing to devices...", rtD, 1
	}
	Map devices=[:]
	Map rawDevices=[:]
	Map subscriptions=[:]
	Boolean hasTriggers=false
	Boolean downgradeTriggers=false
	String never='never'
	//traverse all statements
	def expressionTraverser
	def operandTraverser
	def eventTraverser
	def conditionTraverser
	def restrictionTraverser
	def statementTraverser
	expressionTraverser={ Map expression, parentExpression, String comparisonType ->
		String subsId=sNULL
		String deviceId=sNULL
		String attribute=sNULL
		String exprID=(String)expression.id
		if((String)expression.t==sDEV && exprID){
			if(exprId==(String)rtD.oldLocationId)exprId=(String)rtD.locationId
			devices[exprID]=[c: (comparisonType ? 1:0)+(devices[exprID]?.c ? (Integer)devices[exprID].c:0)]
			deviceId=exprID
			attribute=(String)expression.a
			subsId=deviceId+attribute
		}
		String exprX=(String)expression.x
		if((String)expression.t==sVARIABLE && exprX && (Boolean)exprX.startsWith(sAT)){
			subsId=exprX
			deviceId=(String)rtD.locationId
			attribute=(String)rtD.instanceId+sDOT+exprX
		}
		if(subsId!=sNULL && deviceId!=sNULL){
			String ct=(String)subscriptions[subsId]?.t ?: sNULL
			if(ct==sTRIG || comparisonType==sTRIG){
				ct=sTRIG
			}else{
				ct=ct ?: comparisonType
			}
			subscriptions[subsId]=[d: deviceId, a: attribute, t: ct, c: (subscriptions[subsId] ? (List)subscriptions[subsId].c:[])+[condition]]
			if(deviceId!=(String)rtD.locationId && (Boolean)deviceId.startsWith(sCOLON)){
				if(doit)rawDevices[deviceId]=getDevice(rtD, deviceId)
				devices[deviceId]=[c: (comparisonType ? 1:0)+(devices[deviceId]?.c ? (Integer)devices[deviceId].c:0)]
			}
		}
	}
	operandTraverser={ Map node, Map operand, value, String comparisonType ->
		if(!operand)return
		switch ((String)operand.t){
		case sP: //physical device
			for(String mdeviceId in expandDeviceList(rtD, (List)operand.d, true)){
				String deviceId=mdeviceId
				if(deviceId==(String)rtD.oldLocationId)deviceId=(String)rtD.locationId
				devices[deviceId]=[c: (comparisonType ? 1:0)+(devices[deviceId]?.c ? (Integer)devices[deviceId].c:0)]
				String attribute=(String)operand.a
				String subsId=deviceId+attribute
				//if we have any trigger, it takes precedence over anything else
				String ct=(String)subscriptions[subsId]?.t ?: sNULL
				String oct=ct
				String msgVal
				Boolean allowAval
				List avals=[]
				if(ct==sTRIG || comparisonType==sTRIG){
					ct=sTRIG
					hasTriggers=true

					allowAval= subscriptions[subsId]?.allowA==null ? true : (Boolean)subscriptions[subsId].allowA
					String attrVal=sNULL
					if(allowAval && ((String)node.co=='receives' || (String)node.co=='gets') && value && (String)value.t==sC && value.c){
						attrVal=(String)value.c
						msgVal='Attempting Attribute value'
						avals=subscriptions[subsId]?.avals ?: []
					}else allowAval=false
					if(allowAval && attrVal!=sNULL){
						if(! (attrVal in avals)) avals << attrVal
						msgVal='Attempting Attribute value '+avals
					}else{
						allowAval=false
						msgVal='Using Attribute'
						avals=[]
					}
					if(doit && msgVal!=sNULL && (Integer)rtD.logging>2)debug msgVal+' subscription', rtD

				}else{
					ct=ct ?: comparisonType
				}
				subscriptions[subsId]=[d: deviceId, a: attribute, t: ct, c: (subscriptions[subsId] ? (List)subscriptions[subsId].c:[])+(comparisonType?[node]:[]), allowA: allowAval, avals: avals]
				if(doit && deviceId!=(String)rtD.locationId && (Boolean)deviceId.startsWith(sCOLON)){
					rawDevices[deviceId]=getDevice(rtD, deviceId)
				}
			}
			break
		case sV: //virtual device
			String deviceId=(String)rtD.locationId
			//if we have any trigger, it takes precedence over anything else
			devices[deviceId]=[c: (comparisonType ? 1:0)+(devices[deviceId]?.c ? (Integer)devices[deviceId].c:0)]
			String subsId=sNULL
			String attribute
			String operV=(String)operand.v
			String tsubId=deviceId+operV
			switch (operV){
			case 'alarmSystemStatus':
				subsId=tsubId
				attribute="hsmStatus"
				break
			case 'alarmSystemAlert':
				subsId=tsubId
				attribute="hsmAlert"
				break
			case 'alarmSystemEvent':
				subsId=tsubId
				attribute="hsmSetArm"
				break
			case 'alarmSystemRule':
				subsId=tsubId
				attribute="hsmRules"
				break
			case sTIME:
			case sDATE:
			case sDTIME:
			case 'mode':
			case 'powerSource':
			case 'systemStart':
				subsId=tsubId
				attribute=operV
				break
			case 'email':
				subsId="$deviceId${operV}${(String)rtD.id}".toString()
				attribute="email.${(String)rtD.id}".toString()// receive email does not work
				break
			case 'ifttt':
				if(value && (String)value.t==sC && value.c){
					def options=VirtualDevices()[operV]?.o
					def item=options ? options[value.c]:value.c
					if(item){
						subsId="$deviceId${operV}${item}".toString()
						String attrVal=".${item}".toString()
						attribute="${operV}${attrVal}".toString()
					}
				}
				break
			}
			if(subsId!=sNULL){
				String ct=(String)subscriptions[subsId]?.t ?: sNULL
				if(ct==sTRIG || comparisonType==sTRIG){
					ct=sTRIG
					hasTriggers=true
				}else{
					ct=ct ?: comparisonType
				}
				subscriptions[subsId]=[d: deviceId, a: attribute, t: ct, c: (subscriptions[subsId] ? (List)subscriptions[subsId].c:[])+(comparisonType?[node]:[])]
				break
			}
			break
		case sX:
			String operX=(String)operand.x
			if(operX && (Boolean)operX.startsWith(sAT)){
				String subsId=operX
				String attribute="${(String)rtD.instanceId}.${operX}".toString()
				String ct=(String)subscriptions[subsId]?.t ?: sNULL
				if(ct==sTRIG || comparisonType==sTRIG){
					ct=sTRIG
					hasTriggers=true
				}else{
					ct=ct ?: comparisonType
				}
				subscriptions[subsId]=[d: (String)rtD.locationId, a: attribute, t: ct, c: (subscriptions[subsId] ? (List)subscriptions[subsId].c:[])+(comparisonType?[node]:[])]
			}
			break
		case sC: //constant
		case sE: //expression
			traverseExpressions(operand.exp?.i, expressionTraverser, comparisonType)
			break
		}
	}
	eventTraverser={ Map event, parentEvent ->
		if(event.lo){
			String comparisonType=sTRIG
			operandTraverser(event, (Map)event.lo, null, comparisonType)
		}
	}
	conditionTraverser={ Map condition, parentCondition ->
		if((String)condition.co){
			Map comparison=Comparisons().conditions[(String)condition.co]
			String comparisonType=sCONDITION
			if(comparison==null){
				hasTriggers=true
				comparisonType=downgradeTriggers || ((String)condition.sm==never)? sCONDITION:sTRIG //subscription method
				comparison=Comparisons().triggers[(String)condition.co]
			}
			if(comparison!=null){
				condition.ct=(String)comparisonType.take(1) // modifies the code
				Integer paramCount=comparison.p!=null ? (Integer)comparison.p: 0
				for(Integer i=0; i<=paramCount; i++){
					//get the operand to parse
					Map operand=(i==0 ? (Map)condition.lo:(i==1 ? (Map)condition.ro:(Map)condition.ro2))
					operandTraverser(condition, operand, condition.ro, comparisonType)
				}
			}
		}
		if(condition.ts instanceof List)traverseStatements((List)condition.ts, statementTraverser, condition, statementData)
		if(condition.fs instanceof List)traverseStatements((List)condition.fs, statementTraverser, condition, statementData)
	}
	restrictionTraverser={ Map restriction, parentRestriction ->
		if((String)restriction.co){
			Map comparison=Comparisons().conditions[(String)restriction.co]
			String comparisonType=sCONDITION
			if(comparison==null){
				comparison=Comparisons().triggers[(String)restriction.co]
			}
			if(comparison!=null){
				Integer paramCount=comparison.p!=null ? (Integer)comparison.p: 0
				for(Integer i=0; i<=paramCount; i++){
					//get the operand to parse
					Map operand=(i==0 ? (Map)restriction.lo:(i==1 ? (Map)restriction.ro:(Map)restriction.ro2))
					operandTraverser(restriction, operand, null, sNULL)
				}
			}
		}
	}
	statementTraverser={ Map node, parentNode, Map data ->
		downgradeTriggers=data!=null && (Boolean)data.timer
		if(node.r)traverseRestrictions(node.r, restrictionTraverser)
		for(String mdeviceId in node.d){
			String deviceId=mdeviceId
			if(deviceId==(String)rtD.oldLocationId)deviceId=(String)rtD.locationId
			devices[deviceId]=devices[deviceId] ?: [c: 0]
			if(doit && deviceId!=(String)rtD.locationId && (Boolean)deviceId.startsWith(sCOLON)){
				rawDevices[deviceId]=getDevice(rtD, deviceId)
			}
		}
		switch((String)node.t){
		case sACTION:
			if(node.k){
				for(Map k in (List<Map>)node.k){
					traverseStatements(k.p?:[], statementTraverser, k, data)
				}
			}
			break
		case sIF:
			if(node.ei){
				for(Map ei in (List<Map>)node.ei){
					traverseConditions(ei.c?:[], conditionTraverser)
					traverseStatements(ei.s?:[], statementTraverser, ei, data)
				}
			}
		case sWHILE:
		case sREPEAT:
			traverseConditions(node.c, conditionTraverser)
			break
		case sON:
			traverseEvents(node.c?:[], eventTraverser)
			break
		case sSWITCH:
			operandTraverser(node, (Map)node.lo, null, sCONDITION)
			for(Map c in (List<Map>)node.cs){
				operandTraverser(c, (Map)c.ro, null, sNULL)
				//if case is a range, traverse the second operand too
				if((String)c.t==sR)operandTraverser(c, (Map)c.ro2, null, sNULL)
				if(c.s instanceof List) traverseStatements((List)c.s, statementTraverser, node, data)
			}
			break
		case sEVERY:
			hasTriggers=true
			break
		}
	}
	if(rtD.piston.r)traverseRestrictions((List)rtD.piston.r, restrictionTraverser)
	if(rtD.piston.s)traverseStatements((List)rtD.piston.s, statementTraverser, null, statementData)
	//device variables
	for(variable in rtD.piston.v.findAll{ (String)it.t==sDEV && it.v!=null && it.v.d!=null && it.v.d instanceof List}){
		for(String mdeviceId in (List)variable.v.d){
			String deviceId=mdeviceId
			if(deviceId==(String)rtD.oldLocationId)deviceId=(String)rtD.locationId
			devices[deviceId]=[c: 0+(devices[deviceId]?.c ? (Integer)devices[deviceId].c:0)]
			if(doit && deviceId!=(String)rtD.locationId){
				rawDevices[deviceId]=getDevice(rtD, deviceId)
			}
		}
	}
	Map<String,Integer> dds=[:]
	for(subscription in subscriptions){
		String devStr=(String)subscription.value.d
		String altSub=never
		String always='always'
		for(condition in (List)subscription.value.c)if(condition){
			condition.s=false // this modifies the code
			String tt0=(String)condition.sm
			altSub= tt0==always ? tt0 : (altSub!=always && tt0!=never ? tt0 : altSub)
		}
		// check for disabled event subscriptions
		if(!rtD.piston.o?.des && (String)subscription.value.t && !!subscription.value.c && altSub!=never && ((String)subscription.value.t==sTRIG || altSub==always || !hasTriggers)){
			def device=(Boolean)devStr.startsWith(sCOLON)? getDevice(rtD, devStr):null
			Boolean allowA=subscription.value.allowA!=null?(Boolean)subscription.value.allowA:false
			String a=(String)subscription.value.a
			if(a==sORIENT || a==sAXISX || a==sAXISY || a==sAXISZ){
				a=sTHREAX
				allowA=false
			}
			if(device!=null){
				for(condition in (List)subscription.value.c)if(condition){
					String t1=(String)condition.sm
					condition.s= t1!=never && ((String)condition.ct==sT || t1==always || !hasTriggers) // modifies the code
				}
				switch (a){
				case sTIME:
				case sDATE:
				case sDTIME:
					break
				default:
					Integer cnt=(Integer)ss.events
					List avals=(List)subscription.value.avals
					if(allowA && (Integer)avals.size()<9){
						for(String aval in avals){
							String myattr=a+sDOT+aval
							if(doit){
								if((Integer)rtD.logging>0)info "Subscribing to $device.${myattr}...", rtD
								subscribe(device, myattr, deviceHandler)
							}
							cnt+=1
						}
					}else{
						if(doit){
							if((Integer)rtD.logging>0)info "Subscribing to $device.${a}...", rtD
							subscribe(device, a, deviceHandler)
						}
						cnt+=1
					}
					ss.events=cnt
					String didS=device.id.toString()
					if(!dds[didS]){
						ss.devices=(Integer)ss.devices+1
						dds[didS]=1
					}
				}
			}else{
				error "Failed subscribing to $devStr.${a}, device not found", rtD
			}
		}else{
			for(condition in (List)subscription.value.c)if(condition){ condition.s=false } // modifies the code
			if(devices[devStr]){
				devices[devStr].c=(Integer)devices[devStr].c-1
			}
		}
	}
	//not using fake subscriptions for controlled devices - piston has device in settings
	for(d in devices.findAll{ ((Integer)it.value.c<=0 || rtD.piston.o?.des) && (String)it.key!=(String)rtD.locationId }){
		def device=(Boolean)((String)d.key).startsWith(sCOLON)? getDevice(rtD, (String)d.key):null
		if(device!=null && !isDeviceLocation(device)){
			String didS=device.id.toString()
			if((Integer)rtD.logging>1 && doit)trace "Piston controls $device...", rtD
			ss.controls=(Integer)ss.controls+1
			if(!dds[didS]){
				ss.devices=(Integer)ss.devices+1
				dds[didS]=1
			}
		}
	}
	if(doit){
		//save devices
		List deviceIdList=rawDevices.collect{ it && it.value ? it.value.id:null }
		rawDevices=null
		Boolean a=deviceIdList.removeAll{ it==null }
		updateDeviceList(rtD, deviceIdList)

		state.subscriptions=ss
		if((Integer)rtD.logging>1)trace msg, rtD

		//subscribe(app, appHandler)
		subscribe(location, (String)rtD.id, executeHandler)
		Map event=[date:new Date(), device:location, name:sTIME, value:now(), schedule:[t:0L, s:0, i:-9]]
		a=executeEvent(rtD, event)
		processSchedules rtD, true
	//save cache collected through dummy run
		for(item in rtD.newCache)rtD.cache[(String)item.key]=item.value

		String str='subAll'
		Map t0=getCachedMaps(str)
		String myId=(String)rtD.id
		if(t0!=null){
			getCacheLock(str)
			theCacheFLD[myId].cache=[:]+(Map)rtD.cache
			releaseCacheLock()
		}
		state.cache=(Map)rtD.cache
	}

	}catch (all){
		error "An error has occurred while subscribing: ", rtD, -2, all
	}
}

private List expandDeviceList(Map rtD, List devices, Boolean localVarsOnly=false){
	localVarsOnly=false	//temporary allowing global vars
	List result=[]
	for(String deviceId in devices){
		if(deviceId && (Integer)deviceId.size()==34 && (Boolean)deviceId.startsWith(sCOLON) && (Boolean)deviceId.endsWith(sCOLON)){
			Boolean a=result.push(deviceId)
		}else{
			if(localVarsOnly){
				//during subscriptions we use local vars only to make sure we don't subscribe to "variable" lists of devices
				Map var=(Map)rtD.localVars[deviceId]
				if(var && (String)var.t==sDEV && var.v instanceof Map && (String)var.v.t==sD && var.v.d instanceof List && (Integer)((List)var.v.d).size()!=0)result += (List)var.v.d
			}else{
				Map var=getVariable(rtD, deviceId)
				if((String)var.t==sDEV && var.v instanceof List && ((Integer)((List)var.v).size())!=0)result += (List)var.v
				if((String)var.t!=sDEV){
					def device=getDevice(rtD, (String)cast(rtD, var.v, sSTR))
					if(device!=null)result += [hashId(device.id)]
				}
			}
		}
	}
	return result.unique()
}

//def appHandler(evt){
//}

private static String sanitizeVariableName(String name){
	name=name!=sNULL ? name.trim().replace(sSPC, '_'):sNULL
}

private getDevice(Map rtD, String idOrName){
	if((String)rtD.locationId==idOrName || (String)rtD.oldLocationId==idOrName)return location
//	if(rtD.devices==null)rtD.devices= settings.dev && settings.dev instanceof List ? settings.dev.collectEntries{[(hashId(it.id)): it]} : [:]
	def t0=rtD.devices[idOrName]
	def device=t0!=null ? t0:rtD.devices.find{ (String)it.value.getDisplayName()==idOrName }?.value
	if(device==null){
		if(rtD.allDevices==null){
			Map msg=timer "Device missing from piston. Loading all from parent", rtD
			rtD.allDevices=(Map)parent.listAvailableDevices(true)
			if(eric()||(Integer)rtD.logging>2)debug msg, rtD
		}
		if(rtD.allDevices!=null){
			def deviceMap=rtD.allDevices.find{ (idOrName==(String)it.key)|| (idOrName==(String)it.value.getDisplayName())}
			if(deviceMap!=null){
				device=deviceMap.value
				rtD.updateDevices=true
				rtD.devices[(String)deviceMap.key]=device
			}
		}else{
			error "Device ${idOrName} was not found. Please review your piston.", rtD
		}
	}
	return device
}

private getDeviceAttributeValue(Map rtD, device, String attributeName){
	String rtDEvN=rtD.event!=null ? (String)rtD.event.name:sBLK
	Boolean rtDEdID=rtD.event!=null ? rtD.event.device?.id==device.id:false
	if(rtDEvN==attributeName && rtDEdID){
		return rtD.event.value
	}else{
		def result
		String msg="Error reading current value for ${device}.".toString()
		String a='$status'
		if(attributeName in [ a, sORIENT, sAXISX, sAXISY, sAXISZ ]){
			switch (attributeName){
			case a:
				return device.getStatus()
			case sORIENT:
			case sAXISX:
			case sAXISY:
			case sAXISZ:
				Map xyz
				try{ xyz= rtDEvN==sTHREAX && rtDEdID && rtD.event.value ? rtD.event.value : null }catch (aa){ }
				if(xyz==null){
					try{
						xyz=device.currentValue(sTHREAX, true)
					}catch (al){
						error msg+sTHREAX+sCOLON, rtD, -2, al
						break
					}
				}
				switch (attributeName){
				case sORIENT:
					return getThreeAxisOrientation(xyz)
				case sAXISX:
					return xyz.x
				case sAXISY:
					return xyz.y
				case sAXISZ:
					return xyz.z
				}
			}
		}else{
			try{
				result=device.currentValue(attributeName, true)
			}catch (all){
				error msg+attributeName+sCOLON, rtD, -2, all
			}
		}
		return result!=null ? result:sBLK
	}
}

private Map getDeviceAttribute(Map rtD, String deviceId, String attributeName, subDeviceIndex=null, Boolean trigger=false){
	if(deviceId==(String)rtD.locationId || deviceId==(String)rtD.oldLocationId){ //backwards compatibility
		//we have the location here
		switch (attributeName){
		case 'mode':
			def mode=location.getCurrentMode()
			return [t:sSTR, v:hashId(mode.getId()), n:(String)mode.getName()]
		case 'alarmSystemStatus':
			String v=location.hsmStatus
			String n=VirtualDevices()['alarmSystemStatus']?.o[v]
			return [t:sSTR, v:v, n:n]
		}
		return [t:sSTR, v:(String)location.getName()]
	}
	def device=getDevice(rtD, deviceId)
	if(device!=null){
		Map attribute=attributeName!=null ? Attributes()[attributeName]:null
		if(attribute==null){
			attribute=[t:sSTR, /* m:false */ ]
		}
		//x=eXclude - if a momentary attribute is looked for and the device does not match the current device, then we must ignore this during comparisons
		def t0=(attributeName!=null ? getDeviceAttributeValue(rtD, device, attributeName):null)
		String tt1=(String)attribute.t
		Boolean match=t0!=null && ( (t0 instanceof String && tt1 in [sSTR, sENUM]) ||
				(t0 instanceof Integer && tt1==sINT) )
//	String tt2=myObj(t0)
//if(attributeName)log.warn "attributeName $attributeName t0   $t0 of $tt2   tt1 $tt1    match $match }"
		def value=(attributeName!=null ? (match ? t0:cast(rtD, t0, tt1)):"$device")
		if(attributeName==sHUE){
			value=cast(rtD, (Double)cast(rtD, value, sDCML)*3.6D, (String)attribute.t)
		}
		//have to compare ids and type for hubitat since the locationid can be the same as the deviceid
		def tt0=rtD.event?.device!=null ? rtD.event.device:location
		Boolean deviceMatch=device?.id==tt0.id && isDeviceLocation(device)==isDeviceLocation(tt0)
		return [t: (String)attribute.t, v: value, d: deviceId, a: attributeName, i: subDeviceIndex, x: (attribute.m!=null || trigger) && (!deviceMatch || (( attributeName==sORIENT || attributeName==sAXISX || attributeName==sAXISY || attributeName==sAXISZ ? sTHREAX:attributeName)!=(String)rtD.event.name))]
	}
	return [t:sERROR, v:"Device '${deviceId}' not found"]
}

private Map getJsonData(Map rtD, data, String name, String feature=sNULL){
	if(data!=null){
	try{
		List parts=name.replace('][', '].[').tokenize(sDOT)
		def args=(data instanceof Map ? [:]+(Map)data : (data instanceof List ? []+(List)data : new groovy.json.JsonSlurper().parseText(data)))
		Integer partIndex=-1
		for(String part in parts){
			partIndex=partIndex+1
			if(args instanceof String || args instanceof GString){
				String sarg=args.toString()
				if((Boolean)sarg.startsWith('{') && (Boolean)sarg.endsWith('}')){
					args=(LinkedHashMap)new groovy.json.JsonSlurper().parseText(sarg)
				}else if((Boolean)sarg.startsWith(sLB) && (Boolean)sarg.endsWith(sRB)){
					args=(List)new groovy.json.JsonSlurper().parseText(sarg)
				}
			}
			if(args instanceof List){
				Integer sz=(Integer)args.size()
				switch (part){
				case 'length':
					return [t:sINT, v:sz]
				case 'first':
					args=sz>0 ? args[0]:sBLK
					continue
					break
				case 'second':
					args=sz>1 ? args[1]:sBLK
					continue
					break
				case 'third':
					args=sz>2 ? args[2]:sBLK
					continue
					break
				case 'fourth':
					args=sz>3 ? args[3]:sBLK
					continue
					break
				case 'fifth':
					args=sz>4 ? args[4]:sBLK
					continue
					break
				case 'sixth':
					args=sz ? args[5]:sBLK
					continue
					break
				case 'seventh':
					args=sz>6 ? args[6]:sBLK
					continue
					break
				case 'eighth':
					args=sz>7 ? args[7]:sBLK
					continue
					break
				case 'ninth':
					args=sz>8 ? args[8]:sBLK
					continue
					break
				case 'tenth':
					args=sz>9 ? args[9]:sBLK
					continue
					break
				case 'last':
					args=sz>0 ? args[sz- 1]:sBLK
					continue
					break
				}
			}
			if(!(args instanceof Map) && !(args instanceof List))return [t:sDYN, v:sBLK]
			//nfl overrides
			Boolean overrideArgs=false
			if(feature=='NFL' && partIndex==1 && !!args && !!args.games){
				def offset=null
				def start=null
				def end=null
				Date date=localDate()
				Integer dow=date.day
				switch (((String)part.tokenize(sLB)[0]).toLowerCase()){
				case 'yesterday':
					offset=-1
					break
				case 'today':
					offset=0
					break
				case 'tomorrow':
					offset=1
					break
				case 'mon':
				case 'monday':
					offset=dow<=2 ? 1 - dow:8 - dow
					break
				case 'tue':
				case 'tuesday':
					offset=dow<=2 ? 2-dow:9-dow
					break
				case 'wed':
				case 'wednesday':
					offset=dow<=2 ? -4 - dow:3-dow
					break
				case 'thu':
				case 'thursday':
					offset=dow<=2 ? -3 - dow:4-dow
					break
				case 'fri':
				case 'friday':
					offset=dow<=2 ? -2 - dow:5-dow
					break
				case 'sat':
				case 'saturday':
					offset=dow<=2 ? -1 - dow:6-dow
					break
				case 'sun':
				case 'sunday':
					offset=dow<=2 ? 0 - dow:7-dow
					break
				case 'lastweek':
					start=(dow<=2 ? -4 - dow:3-dow)-7
					end=(dow<=2 ? 2 - dow:9-dow)-7
					break
				case 'thisweek':
					start=dow<=2 ? -4 - dow:3-dow
					end=dow<=2 ? 2 - dow:9-dow
					break
				case 'nextweek':
					start=(dow<=2 ? -4 - dow:3-dow)+7
					end=(dow<=2 ? 2 - dow:9-dow)+7
					break
				}
				if(offset!=null){
					date.setTime(Math.round((Long)date.getTime()+offset*86400000.0D))
					def game=args.games.find{ it.year==date.year+1900 && it.month==date.month+1 && it.day==date.date}
					args=game
					continue
				}
				if(start!=null){
					Date startDate=localDate()
					startDate.setTime(Math.round((Long)date.getTime()+start*86400000.0D))
					Date endDate=localDate()
					endDate.setTime(Math.round((Long)date.getTime()+end*86400000.0D))
					start=((Integer)startDate.year+1900)*372+((Integer)startDate.month*31)+((Integer)startDate.date-1)
					end=((Integer)endDate.year+1900)*372+((Integer)endDate.month*31)+((Integer)endDate.date-1)
					if((Integer)parts[0].size()>3){
						def games=args.games.findAll{ (it.year*372+(it.month-1)*31+(it.day-1)>=start) && (it.year*372+(it.month-1)*31+(it.day-1)<=end)}
						args=games
						overrideArgs=true
					}else{
						def game=args.games.find{ (it.year*372+(it.month-1)*31+(it.day-1)>=start) && (it.year*372+(it.month-1)*31+(it.day-1)<=end)}
						args=game
						continue
					}
				}
			}
			def idx=0
			String newPart=part
			if((Boolean)part.endsWith(sRB)){
				//array index
				Integer start=part.indexOf(sLB)
				if(start>=0){
					idx=part.substring(start+1, (Integer)part.size()-1)
					newPart=part.substring(0, start)
					if(idx.isInteger()){
						idx=idx.toInteger()
					}else{
						Map var=getVariable(rtD, "$idx".toString())
						idx=(String)var.t!=sERROR ? var.v:idx
					}
				}
				if(!overrideArgs && !!newPart)args=args[newPart]
				if(args instanceof List)idx=cast(rtD, idx, sINT)
				args=args[idx]
				continue
			}
			if(!overrideArgs)args=args[newPart]
		}
		return [t:sDYN, v:"$args".toString()]
	}catch (all){
		error "Error retrieving JSON data part $part", rtD, -2, all
		return [t:sDYN, v:sBLK]
	}
	}
	return [t:sDYN, v:sBLK]
}

private Map getArgument(Map rtD, String name){
	return getJsonData(rtD, rtD.args, name)
}

private Map getJson(Map rtD, String name){
	return getJsonData(rtD, rtD.json, name)
}

private Map getPlaces(Map rtD, String name){
	return getJsonData(rtD, rtD.settings?.places, name)
}

private Map getResponse(Map rtD, String name){
	return getJsonData(rtD, rtD.response, name)
}

private Map getWeather(Map rtD, String name){
	if(rtD.weather==null){
		Map t0=parent.getWData()
		rtD.weather=t0!=null ? t0:[:]
	}
	return getJsonData(rtD, rtD.weather, name)
}

private Map getNFLDataFeature(String dataFeature){
	Map requestParams=[
		uri: "https://api.webcore.co/nfl/$dataFeature".toString(),
		query: method=="GET" ? data:null,
		timeout: 20
	]
	httpGet(requestParams){ response ->
		if(response.status==200 && response.data){
			try{
				return response.data instanceof Map ? response.data : (LinkedHashMap)new groovy.json.JsonSlurper().parseText(response.data)
			}catch (all){
				return null
			}
		}
		return null
	}
}

private Map getNFL(Map rtD, String name){
	List parts=name.tokenize(sDOT)
	rtD.nfl=rtD.nfl!=null?rtD.nfl: [:]
	if((Integer)parts.size()>0){
		String dataFeature=(String)(((String)parts[0]).tokenize(sLB)[0])
		if(rtD.nfl[dataFeature]==null){
			rtD.nfl[dataFeature]=getNFLDataFeature(dataFeature)
		}
	}
	return getJsonData(rtD, rtD.nfl, name, 'NFL')
}

private Map getIncidents(rtD, String name){
	return getJsonData(rtD, rtD.incidents, name)
}

@Field volatile static Boolean initGlobalFLD
@Field volatile static Map globalVarsFLD

void clearGlobalCache(String meth=sNULL){
	String lockTyp='clearGlobalCache '+meth
	String semaName=sTGBL
	Boolean a=getTheLock(semaName, lockTyp)
	globalVarsFLD=null
	initGlobalFLD=false
	releaseTheLock(semaName)
	if(eric())log.debug lockTyp
}

private void loadGlobalCache(){
	if(!initGlobalFLD){
		String lockTyp='loadGlobalCache'
		String semaName=sTGBL
		Boolean a=getTheLock(semaName, lockTyp)
		globalVarsFLD=(Map)parent.listAvailableVariables()
		initGlobalFLD=true
		releaseTheLock(semaName)
		if(eric())log.debug lockTyp
	}
}

private Map getVariable(Map rtD, String name){
	Map var=parseVariableName(name)
	name=sanitizeVariableName((String)var.name)
	if(name==sNULL)return [t:sERROR, v:'Invalid empty variable name']
	Map result
	String tname=name
	Map err=[t:sERROR, v:"Variable '$tname' not found".toString()]
	if((Boolean)tname.startsWith(sAT)){
		loadGlobalCache()
		def tresult=globalVarsFLD[tname]
		if(!(tresult instanceof Map))result=err
		else{
			result=(Map)tresult
			result.v=cast(rtD, result.v, (String)result.t)
		}
	}else{
		if((Boolean)tname.startsWith(sDLR)){
			Integer t0=(Integer)tname.size()
			if((Boolean)tname.startsWith('$args.') && (t0>6)){
				result=getArgument(rtD, tname.substring(6))
			}else if((Boolean)tname.startsWith('$args[') && (t0>6)){
				result=getArgument(rtD, tname.substring(5))
			}else if((Boolean)tname.startsWith('$json.') && (t0>6)){
				result=getJson(rtD, tname.substring(6))
			}else if((Boolean)tname.startsWith('$json[') && (t0>6)){
				result=getJson(rtD, tname.substring(5))
			}else if((Boolean)tname.startsWith('$places.') && (t0>8)){
				result=getPlaces(rtD, tname.substring(8))
			}else if((Boolean)tname.startsWith('$places[') && (t0>8)){
				result=getPlaces(rtD, tname.substring(7))
			}else if((Boolean)tname.startsWith('$response.') && (t0>10)){
				result=getResponse(rtD, tname.substring(10))
			}else if((Boolean)tname.startsWith('$response[') && (t0>10)){
				result=getResponse(rtD, tname.substring(9))
			}else if((Boolean)tname.startsWith('$nfl.') && (t0>5)){
				result=getNFL(rtD, tname.substring(5))
			}else if((Boolean)tname.startsWith('$weather.') && (t0>9)){
				result=getWeather(rtD, tname.substring(9))
			}else if((Boolean)tname.startsWith('$incidents.') && (t0>11)){
				result=getIncidents(rtD, tname.substring(11))
			}else if((Boolean)tname.startsWith('$incidents[') && (t0>11)){
				result=getIncidents(rtD, tname.substring(10))
			}else{
				def tresult=rtD.systemVars[tname]
				if(!(tresult instanceof Map))result=err
				else result=(Map)tresult
				if(result!=null && result.d){
					result=[t: (String)result.t, v: getSystemVariableValue(rtD, tname)]
				}
			}
		}else{
			def tlocalVar=rtD.localVars[tname]
			if(!(tlocalVar instanceof Map)){
				result=err
			}else{
				result=[t: (String)tlocalVar.t, v: tlocalVar.v]
				//make a local copy of the list
				if(result.v instanceof List)result.v=[]+(List)result.v
				//make a local copy of the map
				if(result.v instanceof Map)result.v=[:]+(Map)result.v
			}
		}
	}
	if(result!=null && (Boolean)((String)result.t).endsWith(sRB)){
		result.t=((String)result.t).replace('[]', sBLK)
		if(result.v instanceof Map && (String)var.index!=sNULL && (String)var.index!=sBLK){
			Map indirectVar=getVariable(rtD, (String)var.index)
			//indirect variable addressing
			if((String)indirectVar.t!=sERROR){
				def value=(String)indirectVar.t==sDCML ? (Integer)cast(rtD, indirectVar.v, sINT, (String)indirectVar.t):indirectVar.v
				String dataType=(String)indirectVar.t==sDCML ? sINT:(String)indirectVar.t
				var.index=(String)cast(rtD, value, sSTR, dataType)
			}
			result.v=result.v[(String)var.index]
		}
	}else{
		if(result.v instanceof Map){
			String tt0=(String)result.t
			result=(Map)evaluateOperand(rtD, null, (Map)result.v)
			result=(tt0!=null && tt0==(String)result.t) ? result : evaluateExpression(rtD, result, tt0)
		}
	}
	return [t:(String)result.t, v:result.v]
}

private Map setVariable(Map rtD, String name, value){
	Map var=parseVariableName(name)
	name=sanitizeVariableName((String)var.name)
	if(name==sNULL)return [t:sERROR, v:'Invalid empty variable name']
	String tname=name
	if((Boolean)tname.startsWith(sAT)){
		loadGlobalCache()
		String lockTyp='setGlobalvar'
		String semaName=sTGBL
		Boolean a=getTheLock(semaName, lockTyp)
		def tvariable=globalVarsFLD[tname]
		if(tvariable instanceof Map){
			Map variable=(Map)globalVarsFLD[tname]
			variable.v=cast(rtD, value, (String)variable.t)
			globalVarsFLD=globalVarsFLD
			Map cache=rtD.gvCache!=null ? (Map)rtD.gvCache:[:]
			cache[tname]=variable
			rtD.gvCache=cache
			releaseTheLock(semaName)
			return variable
		}
		releaseTheLock(semaName)
	}else{
// global vars are removed by setting them to null via webcore dashboard
// local vars are removed by 'clear all data' via HE console
		def tvariable=rtD.localVars[tname]
		if(tvariable instanceof Map){
			Map variable=(Map)rtD.localVars[tname]
			if((Boolean)((String)variable.t).endsWith(sRB)){
				//we're dealing with a list
				variable.v=(variable.v instanceof Map)? variable.v:[:]
				if((String)var.index=='*CLEAR'){
					variable.v.clear()
				}else{
					Map indirectVar=getVariable(rtD, (String)var.index)
					//indirect variable addressing
					if((String)indirectVar.t!=sERROR){
						var.index=(String)cast(rtD, indirectVar.v, sSTR, (String)indirectVar.t)
					}
					variable.v[(String)var.index]=cast(rtD, value, ((String)variable.t).replace('[]', sBLK))
				}
			}else{
				def v=(value instanceof GString)? "$value".toString():value
				Boolean match=v!=null && ((v instanceof String && t==sSTR)||
							(v instanceof Long && t==sLONG)||
							(v instanceof Integer && t==sINT)||
							(v instanceof Double && t==sDCML))
				variable.v=match ? v:cast(rtD, v, (String)variable.t)
			}
			if(!variable.f){
				Map<String,Object> vars
				Map t0=getCachedMaps()
				if(t0!=null)vars=(Map<String,Object>)t0.vars
				else{ vars=(Boolean)rtD.pep ? (Map<String,Object>)atomicState.vars:(Map<String,Object>)state.vars }

				rtD.localVars[tname]=variable
				vars[tname]=variable.v

				String myId=(String)rtD.id
				if(t0!=null){
					String semaName=app.id.toString()
					Boolean aa=getTheLock(semaName, sV)
					theCacheFLD[myId].vars=vars
					releaseTheLock(semaName)
				}
				if((Boolean)rtD.pep)atomicState.vars=vars
				else state.vars=vars
			}
			return variable
		}
	}
	return [t:sERROR, v:'Invalid variable']
}

Map setLocalVariable(String name, value){ // called by parent (IDE)to set value to a variable
	name=sanitizeVariableName(name)
	if(name==sNULL || (Boolean)name.startsWith(sAT))return [:]
	Map<String,Object> vars=(Map<String,Object>)atomicState.vars
	vars=vars!=null ? vars:[:]
	vars[name]=value
	atomicState.vars=vars
	clearMyCache('setLocalVariable')
	return vars
}

/** EXPRESSION FUNCTIONS							**/

Map proxyEvaluateExpression(LinkedHashMap mrtD, Map expression, String dataType=sNULL){
	LinkedHashMap rtD=getRunTimeData(mrtD)
	resetRandomValues(rtD)
	try{
		Map result=evaluateExpression(rtD, expression, dataType)
		if((String)result.t==sDEV && result.a!=null){
			Map attr=Attributes()[(String)result.a]
			result=evaluateExpression(rtD, result, attr!=null && attr.t!=null ? (String)attr.t:sSTR)
		}
		rtD=null
		return result
	}catch (all){
		error 'An error occurred while executing the expression', rtD, -2, all
	}
	return [t:sERROR, v:'expression error']
}

private static Map simplifyExpression(Map expression){
	while ((String)expression.t==sEXPR && expression.i && (Integer)((List)expression.i).size()==1) expression=((List)expression.i)[0]
	return expression
}

private Map evaluateExpression(Map rtD, Map expression, String dataType=sNULL){
	//if dealing with an expression that has multiple items, let's evaluate each item one by one
	//let's evaluate this expression
	if(!expression)return [t:sERROR, v:'Null expression']
	//not sure what it was needed for - need to comment more
	//if(expression && expression.v instanceof Map)return evaluateExpression(rtD, expression.v, expression.t)
	Long time=now()
	expression=simplifyExpression(expression)
	String mySt
	if((Boolean)rtD.eric){
		mySt="evaluateExpression $expression   dataType: $dataType".toString()
		myDetail rtD, mySt, 1
	}
	Map result=expression
	String exprType=(String)expression.t
	switch (exprType){
	case sINT:
	case sLONG:
	case sDCML:
		result=[t:exprType, v:expression.v]
		break
	case sTIME:
		def t0=expression.v
		Boolean found=false
		if("$t0".isNumber() && (t0.toLong()<86400000L))found=true
		result=[t:exprType, v: found ? t0.toLong():(Long)cast(rtD, t0, exprType, dataType)]
		break
	case sDTIME:
		def t0=expression.v
		if("$t0".isNumber() && (t0.toLong()>=86400000L)){
			result=[t:exprType, v: t0.toLong() ]
			break
		}
	case sINT32:
	case sINT64:
	case sDATE:
		result=[t:exprType, v:cast(rtD, expression.v, exprType, dataType)]
		break
	case sBOOL:
	case sBOOLN:
		def t0=expression.v
		if(t0 instanceof Boolean){
			result=[t:sBOOLN, v:(Boolean)t0]
			break
		}
		result=[t:sBOOLN, v:(Boolean)cast(rtD, t0, sBOOLN, dataType)]
		break
	case sSTR:
	case sENUM:
	case sERROR:
	case sPHONE:
	case sURI:
	case sTEXT:
		def t0=expression.v
		if(t0 instanceof String){
			result=[t:sSTR, v:(String)t0]
			break
		}
		result=[t:sSTR, v:(String)cast(rtD, t0, sSTR, dataType)]
		break
	case sNUMBER:
	case sFLOAT:
	case sDBL:
		def t0=expression.v
		if(t0 instanceof Double){
			result=[t:sDCML, v:(Double)t0]
			break
		}
		result=[t:sDCML, v:(Double)cast(rtD, expression.v, sDCML, dataType)]
		break
	case sDURATION:
		String t0=(String)expression.vt
		if(t0==null && expression.v instanceof Long){ result=[t:sLONG, v:(Long)expression.v ] }
		else result=[t:sLONG, v:(Long)cast(rtD, expression.v, t0!=sNULL ? t0:sLONG)]
		break
	case sVARIABLE:
		//get variable as{n: name, t: type, v: value}
		//result=[t:sERROR, v:'Invalid variable']
		result=getVariable(rtD, (String)expression.x+((String)expression.xi!=sNULL ? sLB+(String)expression.xi+sRB:sBLK))
		break
	case sDEV:
		//get variable as{n: name, t: type, v: value}
		if(expression.v instanceof List){
			//already parsed
			result=expression
		}else{
			List deviceIds=(expression.id instanceof List)? (List)expression.id:(expression.id ? [expression.id]:[])
			if((Integer)deviceIds.size()==0){
				Map var=getVariable(rtD, (String)expression.x)
				if((String)var.t==sDEV){
					deviceIds=(List)var.v
				}else{
					def device=getDevice(rtD, (String)var.v)
					if(device!=null)deviceIds=[hashId(device.id)]
				}
			}
			result=[t:sDEV, v:deviceIds, a:(String)expression.a]
		}
		break
	case sOPERAND:
		result=[t:sSTR, v:(String)cast(rtD, expression.v, sSTR)]
		break
	case sFUNC:
		String fn='func_'+(String)expression.n
		//in a function, we look for device parameters, they may be lists - we need to reformat all parameters to send them to the function properly
		String myStr
		try{
			List params=[]
			List<Map> t0=(List<Map>)expression.i
			if(t0 && (Integer)t0.size()!=0){
				for(Map i in t0){
					Map param=simplifyExpression(i)
					if((String)param.t==sDEV || (String)param.t==sVARIABLE){
						//if multiple devices involved, we need to spread the param into multiple params
						param=evaluateExpression(rtD, param)
						Integer sz=param.v instanceof List ? (Integer)((List)param.v).size():1
						switch (sz){
							case 0: break
							case 1: Boolean a=params.push(param); break
							default:
								for(v in (List)param.v){
									Boolean b=params.push([t: (String)param.t, a: (String)param.a, v: [v]])
								}
						}
					}else{
						Boolean a=params.push(param)
					}
				}
			}
			if((Boolean)rtD.eric){
				myStr='calling function '+fn
				myDetail rtD, myStr, 1
			}
			result=(Map)"$fn"(rtD, params)
		}catch (all){
			error "Error executing $fn: ", rtD, -2, all
			result=[t:sERROR, v:all]
		}
		if((Boolean)rtD.eric) myDetail rtD, myStr+sSPC+"${result}".toString(), -1
		break
	case sEXPR:
		//if we have a single item, we simply traverse the expression
		List items=[]
		Integer operand=-1
		Integer lastOperand=-1
		for(Map item in (List<Map>)expression.i){
			if((String)item.t==sOPER){
				String ito=(String)item.o
				if(operand<0){
					switch (ito){
					case sPLUS:
					case sMINUS:
					case sPWR:
					case sAMP:
					case sBOR:
					case sBXOR:
					case sBNOT:
					case sBNAND:
					case sBNOR:
					case sBNXOR:
					case sLTH:
					case sGTH:
					case sLTHE:
					case sGTHE:
					case sEQ:
					case sNEQ:
					case sNEQA:
					case sSBL:
					case sSBR:
					case sNEG:
					case sDNEG:
					case sQM:
						Boolean a=items.push([t:sINT, v:0, o:ito])
						break
					case sCOLON:
						if(lastOperand>=0){
							//groovy-style support for(object ?: value)
							Boolean a=items.push(items[lastOperand]+[o:ito])
						}else{
							Boolean a=items.push([t:sINT, v:0, o:ito])
						}
						break
					case sMULP:
					case sDIV:
						Boolean a=items.push([t:sINT, v:1, o:ito])
						break
					case sLAND:
					case sLNAND:
						Boolean a=items.push([t:sBOOLN, v:true, o:ito])
						break
					case sLOR:
					case sLNOR:
					case sLXOR:
					case sLNXOR:
						Boolean a=items.push([t:sBOOLN, v:false, o:ito])
						break
					}
				}else{
					items[operand].o=ito
					operand=-1
				}
			}else{
				Boolean a=items.push(evaluateExpression(rtD, item)+[:])
				operand=(Integer)items.size()-1
				lastOperand=operand
			}
		}
		//clean up operators, ensure there's one for each
		Integer idx=0
		for(Map item in items){
			if(!item.o){
				switch ((String)item.t){
					case sINT:
					case sFLOAT:
					case sDBL:
					case sDCML:
					case sNUMBER:
						String nextType=sSTR
						if(idx<(Integer)items.size()-1)nextType=(String)items[idx+1].t
						item.o=(nextType==sSTR || nextType==sTEXT)? sPLUS:sMULP
						break
					default:
						item.o=sPLUS
						break
				}
			}
			idx++
		}
		//do the job
		idx=0
		while ((Integer)items.size()>1){
			Integer itmSz=(Integer)items.size()
			//ternary
			if(itmSz==3 && (String)items[0].o==sQM && (String)items[1].o==sCOLON){
				//we have a ternary operator
				if((Boolean)evaluateExpression(rtD, (Map)items[0], sBOOLN).v){
					items=[items[1]]
				}else{
					items=[items[2]]
				}
				items[0].o=sNULL
				break
			}
			//order of operations :D
			idx=0
			//#2	!   !!   ~   -	Logical negation, logical double-negation, bitwise NOT, and numeric negation unary operators
			for(Map item in items){
				String t0=(String)item.o
				if(t0==sNEG || t0==sDNEG || t0==sBNOT || (item.t==null && t0==sMINUS))break
				idx++
			}
			//#3	**	Exponent operator
			if(idx>=itmSz){
				//we then look for power **
				idx=0
				for(Map item in items){
					if((String)item.o==sPWR)break
					idx++
				}
			}
			//#4	*   /   \   % MOD	Multiplication, division, modulo
			if(idx>=itmSz){
				//we then look for * or /
				idx=0
				for(Map item in items){
					String t0=(String)item.o
					if(t0==sMULP || t0==sDIV || t0==sMOD1 || t0==sMOD)break
					idx++
				}
			}
			//#5	+   -	Addition and subtraction
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					if((String)item.o==sPLUS || (String)item.o==sMINUS)break
					idx++
				}
			}
			//#6	<<   >>	Shift left and shift right operators
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					if((String)item.o==sSBL || (String)item.o==sSBR)break
					idx++
				}
			}
			//#7	<  <= >  >=	Comparisons: less than, less than or equal to, greater than, greater than or equal to
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					String t0=(String)item.o
					if(t0==sGTH || t0==sLTH || t0==sGTHE || t0==sLTHE)break
					idx++
				}
			}
			//#8	==   !=	Comparisons: equal and not equal
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					String t0=(String)item.o
					if(t0==sEQ || t0==sNEQ || t0==sNEQA)break
					idx++
				}
			}
			//#9	&	Bitwise AND
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					if((String)item.o==sAMP || (String)item.o==sBNAND)break
					idx++
				}
			}
			//#10	^	Bitwise exclusive OR (XOR)
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					if((String)item.o==sBXOR || (String)item.o==sBNXOR)break
					idx++
				}
			}
			//#11	|	Bitwise inclusive (normal)OR
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					if((String)item.o==sBOR || (String)item.o==sBNOR)break
					idx++
				}
			}
			//#12	&&	Logical AND
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					if((String)item.o==sLAND || (String)item.o==sLNAND)break
					idx++
				}
			}
			//#13	^^	Logical XOR
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					if((String)item.o==sLXOR || (String)item.o==sLNXOR)break
					idx++
				}
			}
			//#14	||	Logical OR
			if(idx>=itmSz){
				idx=0
				for(Map item in items){
					if((String)item.o==sLOR || (String)item.o==sLNOR)break
					idx++
				}
			}
			if(idx>=itmSz){
				//just get the first one
				idx=0
			}
			if(idx>=itmSz-1)idx=0

			def v=null
			String o=(String)items[idx].o
			String a1=(String)items[idx].a
			String t1=(String)items[idx].t
			def v1=items[idx].v

			Integer idxPlus=idx+1
			String a2=(String)items[idxPlus].a
			String t2=(String)items[idxPlus].t
			def v2=items[idxPlus].v
			String t=t1
			//fix-ups
			//integer with decimal gives decimal, also *, / require decimals
			if(t1==sDEV && a1!=sNULL && (Integer)a1.length()>0){
				Map attr=Attributes()[a1]
				t1=attr!=null ? (String)attr.t:sSTR
			}
			if(t2==sDEV && a2!=sNULL && (Integer)a2.length()>0){
				Map attr=Attributes()[a2]
				t2=attr!=null ? (String)attr.t:sSTR
			}
			if(t1==sDEV && t2==sDEV && (o==sPLUS || o==sMINUS)){
				v1=(v1 instanceof List)? v1:[v1]
				v2=(v2 instanceof List)? v2:[v2]
				v= o==sPLUS ? v1+v2 : v1-v2
				//set the results
				items[idxPlus].t=sDEV
				items[idxPlus].v=v
			}else{
				Boolean t1d= t1==sDTIME || t1==sDATE || t1==sTIME
				Boolean t2d= t2==sDTIME || t2==sDATE || t2==sTIME
				Boolean t1i= t1==sNUMBER || t1==sINT || t1==sLONG
				Boolean t2i= t2==sNUMBER || t2==sINT || t2==sLONG
				Boolean t1f= t1==sDCML || t1==sFLOAT
				Boolean t2f= t2==sDCML || t2==sFLOAT
				Boolean t1n=t1i || t1f
				Boolean t2n=t2i || t2f
				//warn "Precalc ($t1) $v1 $o ($t2) $v2 >>> t1d=$t1d, t2d=$t2d, t1n=$t1n, t2n=$t2n", rtD
				if((o==sPLUS || o==sMINUS) && (t1d || t2d) && (t1d || t1n) && (t2n || t2d)){
					//if dealing with date +/- date/numeric then
					if(t1n){
						t=t2
					}else if(t2n){
						t=t1
					}else{
						t=t1==sDATE && t2==sDATE ? sDATE:((t1==sTIME) && (t2==sTIME)? sTIME:sDTIME)
					}
				}else{
					if(o==sPLUS || o==sMINUS){
						//devices and others play nice
						if(t1==sDEV){
							t=t2
							t1=t2
						}else if(t2==sDEV){
							t=t1
							t2=t1
						}
					}
					if(o in [sMULP,sDIV,sMINUS,sPWR]){
						t= t1i && t2i ? (t1==sLONG || t2==sLONG ? sLONG:sINT) : sDCML
						t1=t
						t2=t
					}
					if(o in [sMOD1,sMOD,sAMP,sBOR,sBXOR,sBNAND,sBNOR,sBNXOR,sSBL,sSBR]){
						t= t1==sLONG || t2==sLONG ? sLONG:sINT
						t1=t
						t2=t
					}
					if(o in [sLAND,sLOR,sLXOR,sLNAND,sLNOR,sLNXOR,sNEG,sDNEG]){
						t1=sBOOLN
						t2=sBOOLN
						t=sBOOLN
					}
					if(o==sPLUS && (t1==sSTR || t1==sTEXT || t2==sSTR || t2==sTEXT)){
						t1=sSTR
						t2=sSTR
						t=sSTR
					}
					if(t1n && t2n){
						t=(t1i && t2i)? ((t1==sLONG)|| (t2==sLONG)? sLONG:sINT):sDCML
						t1=t
						t2=t
					}
					if(o in [sEQ,sNEQ,sLTH,sGTH,sLTHE,sGTHE,sNEQA]){
						if(t1==sDEV)t1=sSTR
						if(t2==sDEV)t2=sSTR
						t1=t1==sSTR ? t2:t1
						t2=t2==sSTR ? t1:t2
						t=sBOOLN
					}
				}
				//v1=evaluateExpression(rtD, (Map)items[idx], t1).v
				if((String)items[idx].t==t1) v1=items[idx].v
				else v1=evaluateExpression(rtD, (Map)items[idx], t1).v

				//v2=evaluateExpression(rtD, (Map)items[idxPlus], t2).v
				if((String)items[idxPlus].t==t2) v2=items[idxPlus].v
				else v2=evaluateExpression(rtD, (Map)items[idxPlus], t2).v

				v1=v1==sSNULL ? null:v1
				v2=v2==sSNULL ? null:v2
				switch (o){
					case sQM:
					case sCOLON:
						error "Invalid ternary operator. Ternary operator's syntax is (condition ? trueValue:falseValue ). Please check your syntax.", rtD
						v=sBLK
						break
					case sMINUS:
						v=v1 - v2
						break
					case sMULP:
						v=v1 * v2
						break
					case sDIV:
						v=(v2!=0 ? v1/v2 : 0)
						break
					case sMOD1:
						v=(Integer)Math.floor(v2!=0 ? v1/v2 : 0)
						break
					case sMOD:
						v=(Integer)(v2!=0 ? v1%v2 : 0)
						break
					case sPWR:
						v=v1 ** v2
						break
					case sAMP:
						v=v1 & v2
						break
					case sBOR:
						v=v1 | v2
						break
					case sBXOR:
						v=v1 ^ v2
						break
					case sBNAND:
						v=~(v1 & v2)
						break
					case sBNOR:
						v=~(v1 | v2)
						break
					case sBNXOR:
						v=~(v1 ^ v2)
						break
					case sBNOT:
						v=~v2
						break
					case sSBL:
						v=v1 << v2
						break
					case sSBR:
						v=v1 >> v2
						break
					case sLAND:
						v=!!v1 && !!v2
						break
					case sLOR:
						v=!!v1 || !!v2
						break
					case sLXOR:
						v=!v1!=!v2
						break
					case sLNAND:
						v=!(!!v1 && !!v2)
						break
					case sLNOR:
						v=!(!!v1 || !!v2)
						break
					case sLNXOR:
						v=!(!v1!=!v2)
						break
					case sEQ:
						v=v1==v2
						break
					case sNEQ:
					case sNEQA:
						v=v1!=v2
						break
					case sLTH:
						v=v1<v2
						break
					case sGTH:
						v=v1>v2
						break
					case sLTHE:
						v=v1<=v2
						break
					case sGTHE:
						v=v1>=v2
						break
					case sNEG:
						v=!v2
						break
					case sDNEG:
						v=!!v2
						break
					case sPLUS:
					default:
						v=t==sSTR ? "$v1$v2":v1+v2
						break
				} //end switch

				if((Integer)rtD.logging>2)debug "Calculating ($t1)$v1 $o ($t2)$v2 >> ($t)$v", rtD

				//set the results
				//items[idx+1].t=t
				items[idxPlus].t=t
				v=(v instanceof GString)? "$v".toString():v
				Boolean match=v!=null && ((v instanceof String && t==sSTR)||
							(v instanceof Long && t==sLONG)||
							(v instanceof Boolean && t==sBOOLN)||
							(v instanceof Integer && t==sINT)||
							(v instanceof Double && t==sDCML))
				if(match)items[idxPlus].v=v
				else items[idxPlus].v=cast(rtD, v, t)
			} // end else
			items.remove(idx)
		} //end while
		result=items[0] ? ((String)items[0].t==sDEV ? (Map)items[0] : evaluateExpression(rtD, (Map)items[0])) : [t:sDYN, v:null]
		break
	} //end switch

	//return the value, either directly or via cast, if certain data type is requested
	//when dealing with devices, they need to be "converted" unless the request is to return devices
	if(dataType && dataType!=sDEV && (String)result.t==sDEV){
		//if not a list, make it a list
		if(!(result.v instanceof List))result.v=[result.v]
		switch ((Integer)((List)result.v).size()){
			case 0: result=[t:sERROR, v:'Empty device list']; break
			case 1: result=getDeviceAttribute(rtD, (String)((List)result.v)[0], (String)result.a, result.i); break
			default: result=[t:sSTR, v:buildDeviceAttributeList(rtD, (List)result.v, (String)result.a)]; break
		}
	}
	if(dataType){
		String t0=(String)result.t
		def t1=result.v
		if(dataType!=t0){
			Boolean match= (dataType in [sSTR, sENUM]) && (t0 in [sSTR, sENUM])
			if(!match)t1=cast(rtD, result.v, dataType, t0)
		}
		result=[t:dataType, v: t1] + (result.a ? [a:(String)result.a]:[:])+(result.i ? [a:result.i]:[:])
	}
	result.d=now()-time
	if((Boolean)rtD.eric) myDetail rtD, mySt+" result: $result".toString(), -1
	return result
}

private static String buildList(List list, String suffix=sAND){
	if(!list)return sBLK
	List nlist=(list instanceof List)? list:[list]
	Integer cnt=1
	String result=sBLK
	Integer t0=(Integer)nlist.size()
	for(item in nlist){
		result += item.toString()+(cnt<t0 ? (cnt==t0-1 ? sSPC+suffix+sSPC:sCOMMA+sSPC):sBLK)
		cnt++
	}
	return result
}

private String buildDeviceList(Map rtD, devices, String suffix=sAND){
	if(!devices)return sBLK
	List nlist=(devices instanceof List)? devices:[devices]
	List list=[]
	for(String device in nlist){
		def dev=getDevice(rtD, device)
		if(dev!=null)Boolean a=list.push(dev)
	}
	return buildList(list, suffix)
}

private String buildDeviceAttributeList(Map rtD, List devices, String attribute, String suffix=sAND){
	if(!devices)return sBLK
	//List nlist=(devices instanceof List)? devices:[devices]
	List list=[]
	for(String device in devices){
		def value=getDeviceAttribute(rtD, device, attribute).v
		Boolean a=list.push(value)
	}
	return buildList(list, suffix)
}

private static Boolean checkParams(Map rtD, List params, Integer minParams){
	if(params==null || !(params instanceof List) || ((Integer)params.size()<minParams)) return false
	return true
}

private static Map rtnErr(String msg){
	return [t:sERROR, v:sEXPECTING+msg]
}

/** dewPoint returns the calculated dew point temperature			**/
/** Usage: dewPoint(temperature, relativeHumidity[, scale])			**/
private Map func_dewpoint(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('dewPoint(temperature, relativeHumidity[, scale])')
	Double t=(Double)evaluateExpression(rtD, params[0], sDCML).v
	Double rh=(Double)evaluateExpression(rtD, params[1], sDCML).v
	//if no temperature scale is provided, we assume the location's temperature scale
	Boolean fahrenheit=((String)cast(rtD, (Integer)params.size()>2 ? (String)evaluateExpression(rtD, params[2]).v:(String)location.temperatureScale, sSTR)).toUpperCase()=='F'
	if(fahrenheit){
		t=(t-32.0D)*5.0D/9.0D
	}
	//convert rh to percentage
	if((rh>0) && (rh<1)){
		rh=rh*100.0D
	}
	Double b=(Math.log(rh/100.0D)+((17.27D*t)/(237.3D+t)))/17.27D
	Double result=(237.3D*b)/(1.0D-b)
	if(fahrenheit){
		result=result*9.0D/5.0D+32.0D
	}
	return [t:sDCML, v:result]
}

/** celsius converts temperature from Fahrenheit to Celsius			**/
/** Usage: celsius(temperature)							**/
private Map func_celsius(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('celsius(temperature)')
	Double t=(Double)evaluateExpression(rtD, params[0], sDCML).v
	//convert temperature to Celsius
	return [t:sDCML, v:(Double)((t-32.0D)*5.0D/9.0D)]
}

/** fahrenheit converts temperature from Celsius to Fahrenheit			**/
/** Usage: fahrenheit(temperature)						**/
private Map func_fahrenheit(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('fahrenheit(temperature)')
	Double t=(Double)evaluateExpression(rtD, params[0], sDCML).v
	//convert temperature to Fahrenheit
	return [t:sDCML, v:(Double)(t*9.0D/5.0D+32.0D)]
}

/** fahrenheit converts temperature between Celsius and Fahrenheit if the	**/
/** units differ from location.temperatureScale					**/
/** Usage: convertTemperatureIfNeeded(celsiusTemperature, 'C')			**/
private Map func_converttemperatureifneeded(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('convertTemperatureIfNeeded(temperature, unit)')
	String u=((String)evaluateExpression(rtD, params[1], sSTR).v).toUpperCase()
	switch ((String)location.temperatureScale){
		case u: // matches, return value
			Double t=(Double)evaluateExpression(rtD, params[0], sDCML).v
			return [t:sDCML, v:t]
		case 'F': return func_celsius(rtD, [params[0]])
		case 'C': return func_fahrenheit(rtD, [params[0]])
	}
	return [:]
}

/** integer converts a decimal to integer value			**/
/** Usage: integer(decimal or string)				**/
private Map func_integer(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('integer(decimal or string)')
	return [t:sINT, v:(Integer)evaluateExpression(rtD, params[0], sINT).v]
}
private Map func_int(Map rtD, List<Map> params){ return func_integer(rtD, params)}

/** decimal/float converts an integer value to it's decimal value		**/
/** Usage: decimal(integer or string)						**/
private Map func_decimal(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('decimal(integer or string)')
	return [t:sDCML, v:(Double)evaluateExpression(rtD, params[0], sDCML).v]
}
private Map func_float(Map rtD, List<Map> params){ return func_decimal(rtD, params)}
private Map func_number(Map rtD, List<Map> params){ return func_decimal(rtD, params)}

/** string converts an value to it's string value				**/
/** Usage: string(anything)							**/
private Map func_string(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('string(anything)')
	String result=sBLK
	for(Map param in params){
		result += (String)evaluateExpression(rtD, param, sSTR).v
	}
	return [t:sSTR, v:result]
}
private Map func_concat(Map rtD, List<Map> params){ return func_string(rtD, params)}
private Map func_text(Map rtD, List<Map> params){ return func_string(rtD, params)}

/** Boolean converts a value to it's Boolean value				**/
/** Usage: boolean(anything)							**/
private Map func_boolean(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('boolean(anything)')
	return [t:sBOOLN, v:(Boolean)evaluateExpression(rtD, params[0], sBOOLN).v]
}
private Map func_bool(Map rtD, List<Map> params){ return func_boolean(rtD, params)}

/** sqr converts a decimal to square decimal value			**/
/** Usage: sqr(integer or decimal or string)				**/
private Map func_sqr(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('sqr(integer or decimal or string)')
	return [t:sDCML, v:(Double)evaluateExpression(rtD, params[0], sDCML).v**2]
}

/** sqrt converts a decimal to square root decimal value		**/
/** Usage: sqrt(integer or decimal or string)				**/
private Map func_sqrt(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('sqrt(integer or decimal or string)')
	return [t:sDCML, v:Math.sqrt((Double)evaluateExpression(rtD, params[0], sDCML).v)]
}

/** power converts a decimal to power decimal value			**/
/** Usage: power(integer or decimal or string, power)			**/
private Map func_power(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('sqrt(integer or decimal or string, power)')
	return [t:sDCML, v:(Double)evaluateExpression(rtD, params[0], sDCML).v ** (Double)evaluateExpression(rtD, params[1], sDCML).v]
}

/** round converts a decimal to rounded value			**/
/** Usage: round(decimal or string[, precision])		**/
private Map func_round(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('round(decimal or string[, precision])')
	Integer precision=((Integer)params.size()>1)? (Integer)evaluateExpression(rtD, params[1], sINT).v:0
	return [t:sDCML, v:Math.round((Double)evaluateExpression(rtD, params[0], sDCML).v * (10 ** precision))/(10 ** precision)]
}

/** floor converts a decimal to closest lower integer value		**/
/** Usage: floor(decimal or string)					**/
private Map func_floor(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('floor(decimal or string)')
	return [t:sINT, v:(Integer)cast(rtD, Math.floor((Double)evaluateExpression(rtD, params[0], sDCML).v), sINT)]
}

/** ceiling converts a decimal to closest higher integer value	**/
/** Usage: ceiling(decimal or string)						**/
private Map func_ceiling(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('ceiling(decimal or string)')
	return [t:sINT, v:(Integer)cast(rtD, Math.ceil((Double)evaluateExpression(rtD, params[0], sDCML).v), sINT)]
}
private Map func_ceil(Map rtD, List<Map> params){ return func_ceiling(rtD, params)}


/** sprintf converts formats a series of values into a string			**/
/** Usage: sprintf(format, arguments)						**/
private Map func_sprintf(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('sprintf(format, arguments)')
	String format
	List args=[]
	try{
		format=(String)evaluateExpression(rtD, params[0], sSTR).v
		for(Integer x=1; x<(Integer)params.size(); x++){
			Boolean a=args.push(evaluateExpression(rtD, params[x]).v)
		}
		return [t:sSTR, v:sprintf(format, args)]
	}catch(all){
		return rtnErr("$all $format $args".toString())
	}
}
private Map func_format(Map rtD, List<Map> params){ return func_sprintf(rtD, params)}

/** left returns a substring of a value					**/
/** Usage: left(string, count)						**/
private Map func_left(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('left(string, count)')
	String value=(String)evaluateExpression(rtD, params[0], sSTR).v
	Integer count=(Integer)evaluateExpression(rtD, params[1], sINT).v
	Integer sz=(Integer)value.size()
	if(count>sz)count=sz
	return [t:sSTR, v:value.substring(0, count)]
}

/** right returns a substring of a value				**/
/** Usage: right(string, count)						**/
private Map func_right(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('right(string, count)')
	String value=(String)evaluateExpression(rtD, params[0], sSTR).v
	Integer count=(Integer)evaluateExpression(rtD, params[1], sINT).v
	Integer sz=(Integer)value.size()
	if(count>sz)count=sz
	return [t:sSTR, v:value.substring(sz-count, sz)]
}

/** strlen returns the length of a string value				**/
/** Usage: strlen(string)						**/
private Map func_strlen(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('strlen(string)')
	String value=(String)evaluateExpression(rtD, params[0], sSTR).v
	return [t:sINT, v:(Integer)value.size()]
}
private Map func_length(Map rtD, List<Map> params){ return func_strlen(rtD, params)}

/** coalesce returns the first non-empty parameter				**/
/** Usage: coalesce(value1[, value2[, ..., valueN]])				**/
private Map func_coalesce(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('coalesce(value1[, value2[, ..., valueN]])')
	Integer sz=(Integer)params.size()
	for(i=0; i<sz; i++){
		Map value=evaluateExpression(rtD, params[i])
		if(!(value.v==null || (value.v instanceof List ? value.v==[null] || value.v==[] || value.v==[sSNULL] : false) || (String)value.t==sERROR || value.v==sSNULL || (String)cast(rtD, value.v, sSTR)==sBLK)){
			return value
		}
	}
	return [t:sDYN, v:null]
}

/** trim removes leading and trailing spaces from a string			**/
/** Usage: trim(value)								**/
private Map func_trim(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('trim(value)')
	String t0=(String)evaluateExpression(rtD, params[0], sSTR).v
	String value=(String)t0.trim()
	return [t:sSTR, v:value]
}

/** trimleft removes leading spaces from a string				**/
/** Usage: trimLeft(value)							**/
private Map func_trimleft(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('trimLeft(value)')
	String t0=(String)evaluateExpression(rtD, params[0], sSTR).v
	String value=(String)t0.replaceAll('^\\s+', sBLK)
	return [t:sSTR, v:value]
}
private Map func_ltrim(Map rtD, List<Map> params){ return func_trimleft(rtD, params)}

/** trimright removes trailing spaces from a string				**/
/** Usage: trimRight(value)							**/
private Map func_trimright(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('trimRight(value)')
	String t0=(String)evaluateExpression(rtD, params[0], sSTR).v
	String value=(String)t0.replaceAll('\\s+$', sBLK)
	return [t:sSTR, v:value]
}
private Map func_rtrim(Map rtD, List<Map> params){ return func_trimright(rtD, params)}

/** substring returns a substring of a value					**/
/** Usage: substring(string, start, count)					**/
private Map func_substring(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('substring(string, start, count)')
	String value=(String)evaluateExpression(rtD, params[0], sSTR).v
	Integer start=(Integer)evaluateExpression(rtD, params[1], sINT).v
	def count=(Integer)params.size()>2 ? (Integer)evaluateExpression(rtD, params[2], sINT).v:null
	//def end=null
	String result=sBLK
	Integer t0=(Integer)value.size()
	if(start<t0 && start>-t0){
		if(count!=null){
			if(count<0){
				//reverse
				start=start<0 ? -start:t0-start
				count=-count
				value=value.reverse()
			}
			if(start>=0){
				if(count>t0-start)count= t0-start
			}else{
				if(count>-start)count=-start
			}
		}
		start=start>=0 ? start : t0+start
		if(count>t0-start)count=t0-start
		result=(count==null) ? value.substring(start) : value.substring(start, start+count)
	}
	return [t:sSTR, v:result]
}
private Map func_substr(Map rtD, List<Map> params){ return func_substring(rtD, params)}
private Map func_mid(Map rtD, List<Map> params){ return func_substring(rtD, params)}

/** replace replaces a search text inside of a value				**/
/** Usage: replace(string, search, replace[, [..], search, replace])		**/
private Map func_replace(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,3) || (Integer)params.size()%2 != 1) return rtnErr('replace(string, search, replace[, [..], search, replace])')
	String value=(String)evaluateExpression(rtD, params[0], sSTR).v
	Integer cnt=Math.floor(((Integer)params.size()-1)/2)
	for(Integer i=0; i<cnt; i++){
		String search=(String)evaluateExpression(rtD, params[i*2+1], sSTR).v
		String replace=(String)evaluateExpression(rtD, params[i*2+2], sSTR).v
		if(((Integer)search.size()>2)&& (Boolean)search.startsWith(sDIV)&& (Boolean)search.endsWith(sDIV)){
			search=~search.substring(1, (Integer)search.size()-1)
			value=value.replaceAll(search, replace)
		}else{
			value=value.replace(search, replace)
		}
	}
	return [t:sSTR, v:value]
}

/** rangeValue returns the matching value in a range					**/
/** Usage: rangeValue(input, defaultValue, point1, value1[, [..], pointN, valueN])	**/
private Map func_rangevalue(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2) || (Integer)params.size()%2!=0) return rtnErr('rangeValue(input, defaultValue, point1, value1[, [..], pointN, valueN])')
	Double input=(Double)evaluateExpression(rtD, params[0], sDCML).v
	Map value=params[1]
	Integer cnt=Math.floor(((Integer)params.size()-2)/2)
	for(Integer i=0; i<cnt; i++){
		Double point=(Double)evaluateExpression(rtD, params[i*2 +2], sDCML).v
		if(input>=point)value=params[i*2 +3]
	}
	return value
}

/** rainbowValue returns the matching value in a range				**/
/** Usage: rainbowValue(input, minInput, minColor, maxInput, maxColor)		**/
private Map func_rainbowvalue(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,5)) return rtnErr('rainbowValue(input, minColor, minValue, maxInput, maxColor)')
	Integer input=(Integer)evaluateExpression(rtD, params[0], sINT).v
	Integer minInput=(Integer)evaluateExpression(rtD, params[1], sINT).v
	Map minColor=getColor(rtD, (String)evaluateExpression(rtD, params[2], sSTR).v)
	Integer maxInput=(Integer)evaluateExpression(rtD, params[3], sINT).v
	Map maxColor=getColor(rtD, (String)evaluateExpression(rtD, params[4], sSTR).v)
	if(minInput>maxInput){
		Integer x=minInput
		minInput=maxInput
		maxInput=x
		Map x1=minColor
		minColor=maxColor
		maxColor=x1
	}
	input=(input<minInput ? minInput:(input>maxInput ? maxInput:input))
	if((input==minInput)|| (minInput==maxInput))return [t:sSTR, v:(String)minColor.hex]
	if(input==maxInput)return [t:sSTR, v:(String)maxColor.hex]
	List start=hexToHsl((String)minColor.hex)
	List end=hexToHsl((String)maxColor.hex)
	Double alpha=1.0D*(input-minInput)/(maxInput-minInput+1)
	Integer h=Math.round(start[0]-((input-minInput)*(start[0]-end[0])/(maxInput-minInput)))
	Integer s=Math.round(start[1]+(end[1]-start[1])*alpha)
	Integer l=Math.round(start[2]+(end[2]-start[2])*alpha)
	return [t:sSTR, v:hslToHex(h,s,l)]
}

/** indexOf finds the first occurrence of a substring in a string		**/
/** Usage: indexOf(stringOrDeviceOrList, substringOrItem)			**/
private Map func_indexof(Map rtD, List<Map> params){
	Integer sz=(Integer)params.size()
	if(!checkParams(rtD, params,2) || ((String)params[0].t!=sDEV && sz!=2)) return rtnErr('indexOf(stringOrDeviceOrList, substringOrItem)')
	if(((String)params[0].t==sDEV)&& (sz>2)){
		Integer t0=sz-1
		String item=(String)evaluateExpression(rtD, params[t0], sSTR).v
		for(Integer idx=0; idx<t0; idx++){
			Map it=evaluateExpression(rtD, params[idx], sSTR)
			if(it.v==item){
				return [t:sINT, v:idx]
			}
		}
		return [t:sINT, v:-1]
	}else if(params[0].v instanceof Map){
		def item=evaluateExpression(rtD, params[1], (String)params[0].t).v
		def key=params[0].v.find{ it.value==item }?.key
		return [t:sSTR, v:key]
	}else{
		String value=(String)evaluateExpression(rtD, params[0], sSTR).v
		String substring=(String)evaluateExpression(rtD, params[1], sSTR).v
		return [t:sINT, v:(Integer)value.indexOf(substring)]
	}
}

/** lastIndexOf finds the first occurrence of a substring in a string		**/
/** Usage: lastIndexOf(string, substring)					**/
private Map func_lastindexof(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2) || ((String)params[0].t!=sDEV && (Integer)params.size()!=2)) return rtnErr('lastIndexOf(string, substring)')
	if(((String)params[0].t==sDEV)&& ((Integer)params.size()>2)){
		String item=(String)evaluateExpression(rtD, params[(Integer)params.size()-1], sSTR).v
		for(Integer idx=(Integer)params.size()-2; idx>=0; idx--){
			Map it=evaluateExpression(rtD, params[idx], sSTR)
			if(it.v==item){
				return [t:sINT, v:idx]
			}
		}
		return [t:sINT, v:-1]
	}else if(params[0].v instanceof Map){
		String item=evaluateExpression(rtD, params[1], (String)params[0].t).v
		def key=params[0].v.find{ it.value==item }?.key
		return [t:sSTR, v:key]
	}else{
		String value=(String)evaluateExpression(rtD, params[0], sSTR).v
		String substring=(String)evaluateExpression(rtD, params[1], sSTR).v
		return [t:sINT, v:(Integer)value.lastIndexOf(substring)]
	}
}


/** lower returns a lower case value of a string				**/
/** Usage: lower(string)							**/
private Map func_lower(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('lower(string)')
	String result=sBLK
	for(Map param in params){
		result += (String)evaluateExpression(rtD, param, sSTR).v
	}
	return [t:sSTR, v:result.toLowerCase()]
}

/** upper returns a upper case value of a string				**/
/** Usage: upper(string)							**/
private Map func_upper(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('upper(string)')
	String result=sBLK
	for(Map param in params){
		result += (String)evaluateExpression(rtD, param, sSTR).v
	}
	return [t:sSTR, v:result.toUpperCase()]
}

/** title returns a title case value of a string				**/
/** Usage: title(string)							**/
private Map func_title(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('title(string)')
	String result=sBLK
	for(Map param in params){
		result += (String)evaluateExpression(rtD, param, sSTR).v
	}
	return [t:sSTR, v:result.tokenize(sSPC)*.toLowerCase()*.capitalize().join(sSPC)]
}

/** avg calculates the average of a series of numeric values			**/
/** Usage: avg(values)								**/
private Map func_avg(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('avg'+sVALUEN)
	Double sum=0
	for(Map param in params){
		sum += (Double)evaluateExpression(rtD, param, sDCML).v
	}
	return [t:sDCML, v:sum/(Integer)params.size()]
}

/** median returns the value in the middle of a sorted array			**/
/** Usage: median(values)							**/
private Map func_median(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('median'+sVALUEN)
	List data=params.collect{ evaluateExpression(rtD, (Map)it, sDYN)}.sort{ it.v }
	if(data){
		return data[(Integer)Math.floor((Integer)data.size()/2)]
	}
	return [t:sDYN, v:sBLK]
}

/** least returns the value that is least found a series of numeric values	**/
/** Usage: least(values)							**/
private Map func_least(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('least'+sVALUEN)
	Map data=[:]
	for(Map param in params){
		Map value=evaluateExpression(rtD, param, sDYN)
		data[value.v]=[t:(String)value.t, v:value.v, c:(data[value.v]?.c ?: 0)+1]
	}
	def value=data.sort{ it.value.c }.collect{ it.value }[0]
	return [t:(String)value.t, v:value.v]
}

/** most returns the value that is most found a series of numeric values	**/
/** Usage: most(values)								**/
private Map func_most(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('most'+sVALUEN)
	Map data=[:]
	for(Map param in params){
		Map value=evaluateExpression(rtD, param, sDYN)
		data[value.v]=[t:(String)value.t, v:value.v, c:(data[value.v]?.c ?: 0)+1]
	}
	def value=data.sort{ -it.value.c }.collect{ it.value }[0]
	return [t:(String)value.t, v:value.v]
}

/** sum calculates the sum of a series of numeric values			**/
/** Usage: sum(values)								**/
private Map func_sum(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('sum'+sVALUEN)
	Double sum=0
	for(Map param in params){
		sum += (Double)evaluateExpression(rtD, param, sDCML).v
	}
	return [t:sDCML, v:sum]
}

/** variance calculates the standard deviation of a series of numeric values	**/
/** Usage: stdev(values)							**/
private Map func_variance(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('variance'+sVALUEN)
	Double sum=0
	List values=[]
	for(Map param in params){
		Double value=(Double)evaluateExpression(rtD, param, sDCML).v
		Boolean a=values.push(value)
		sum += value
	}
	Double avg=sum/(Integer)values.size()
	sum=0
	for(Integer i=0; i<(Integer)values.size(); i++){
		sum += ((Double)values[i]-avg)**2
	}
	return [t:sDCML, v:sum/(Integer)values.size()]
}

/** stdev calculates the standard deviation of a series of numeric values	**/
/** Usage: stdev(values)							**/
private Map func_stdev(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)){
		return rtnErr('stdev'+sVALUEN)
	}
	Map result=func_variance(rtD, params)
	return [t:sDCML, v:Math.sqrt(result.v)]
}

/** min calculates the minimum of a series of numeric values			**/
/** Usage: min(values)								**/
private Map func_min(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('min'+sVALUEN)
	List<Map> data=params.collect{ evaluateExpression(rtD, (Map)it, sDYN)}.sort{ it.v }
	if(data){
		return data[0]
	}
	return [t:sDYN, v:sBLK]
}

/** max calculates the maximum of a series of numeric values			**/
/** Usage: max(values)								**/
private Map func_max(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('max'+sVALUEN)
	List<Map> data=params.collect{ evaluateExpression(rtD, (Map)it, sDYN)}.sort{ it.v }
	if(data){
		return data[(Integer)data.size()-1]
	}
	return [t:sDYN, v:sBLK]
}

/** abs calculates the absolute value of a number				**/
/** Usage: abs(number)								**/
private Map func_abs(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('abs(value)')
	Double value=(Double)evaluateExpression(rtD, params[0], sDCML).v
	String dataType=(value==Math.round(value).toDouble() ? sINT:sDCML)
	return [t:dataType, v:(Double)cast(rtD, Math.abs(value), dataType, sDCML)]
}

/** hslToHex converts a hue/saturation/level trio to it hex #rrggbb representation	**/
/** Usage: hslToHex(hue, saturation, level)						**/
private Map func_hsltohex(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,3)) return rtnErr('hsl(hue, saturation, level)')
	Double hue=(Double)evaluateExpression(rtD, params[0], sDCML).v
	Double saturation=(Double)evaluateExpression(rtD, params[1], sDCML).v
	Double level=(Double)evaluateExpression(rtD, params[2], sDCML).v
	return [t:sSTR, v:hslToHex(hue, saturation, level)]
}

/** count calculates the number of true/non-zero/non-empty items in a series of numeric values		**/
/** Usage: count(values)										**/
private Map func_count(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)){
		return [t:sINT, v:0]
	}
	Integer count=0
	if((Integer)params.size()==1 && ((String)params[0].t==sSTR || (String)params[0].t==sDYN)){
		List list=((String)evaluateExpression(rtD, params[0], sSTR).v).split(sCOMMA).toList()
		for(Integer i=0; i<(Integer)list.size(); i++){
			count += (Boolean)cast(rtD, list[i], sBOOLN)? 1:0
		}
	}else{
		for(Map param in params){
			count += (Boolean)evaluateExpression(rtD, param, sBOOLN).v ? 1:0
		}
	}
	return [t:sINT, v:count]
}

/** size returns the number of values provided				**/
/** Usage: size(values)							**/
private Map func_size(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)){
		return [t:sINT, v:0]
	}
	Integer count=0
	Integer sz=(Integer)params.size()
	if(sz==1 && ((String)params[0].t==sSTR || (String)params[0].t==sDYN)){
		List list=((String)evaluateExpression(rtD, params[0], sSTR).v).split(sCOMMA).toList()
		count=(Integer)list.size()
	}else{
		count=sz
	}
	return [t:sINT, v:count]
}

/** age returns the number of milliseconds an attribute had the current value	**/
/** Usage: age([device:attribute])						**/
private Map func_age(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('age([device:attribute])')
	Map param=evaluateExpression(rtD, params[0], sDEV)
	if((String)param.t==sDEV && (String)param.a && (Integer)((List)param.v).size()){
		def device=getDevice(rtD, (String)((List)param.v)[0])
		if(device!=null){
			def dstate=device.currentState((String)param.a, true)
			if(dstate){
				Long result=now()-(Long)((Date)dstate.getDate()).getTime()
				return [t:sLONG, v:result]
			}
		}
	}
	return [t:sERROR, v:'Invalid device']
}

/** previousAge returns the number of milliseconds an attribute had the previous value		**/
/** Usage: previousAge([device:attribute])							**/
private Map func_previousage(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('previousAge([device:attribute])')
	Map param=evaluateExpression(rtD, params[0], sDEV)
	if((String)param.t==sDEV && (String)param.a && (Integer)((List)param.v).size()){
		def device=getDevice(rtD, (String)((List)param.v)[0])
		if(device!=null && !isDeviceLocation(device)){
			List states=device.statesSince((String)param.a, new Date(now()-604500000L), [max:5])
			if((Integer)states.size()>1){
				def newValue=states[0].getValue()
				//some events get duplicated, so we really want to look for the last "different valued" state
				for(Integer i=1; i<(Integer)states.size(); i++){
					if(states[i].getValue()!=newValue){
						Long result=now()-(Long)((Date)states[i].getDate()).getTime()
						return [t:sLONG, v:result]
					}
				}
			}
			//we're saying 7 days, though it may be wrong - but we have no data
			return [t:sLONG, v:604800000L]
		}
	}
	return [t:sERROR, v:'Invalid device']
}

/** previousValue returns the previous value of the attribute				**/
/** Usage: previousValue([device:attribute])						**/
private Map func_previousvalue(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('previousValue([device:attribute])')
	Map param=evaluateExpression(rtD, params[0], sDEV)
	if((String)param.t==sDEV && (String)param.a && (Integer)((List)param.v).size()){
		Map attribute=Attributes()[(String)param.a]
		if(attribute!=null){
			def device=getDevice(rtD, (String)((List)param.v)[0])
			if(device!=null && !isDeviceLocation(device)){
				List states=device.statesSince((String)param.a, new Date(now()-604500000), [max:5])
				if((Integer)states.size()>1){
					def newValue=states[0].getValue()
					//some events get duplicated, so we really want to look for the last "different valued" state
					for(Integer i=1; i<(Integer)states.size(); i++){
						def result=states[i].getValue()
						if(result!=newValue){
							return [t:(String)attribute.t, v:cast(rtD, result, (String)attribute.t)]
						}
					}
				}
				//we're saying no value - we have no data
				return [t:sSTR, v:sBLK]
			}
		}
	}
	return [t:sERROR, v:'Invalid device']
}

/** newer returns the number of devices whose attribute had the current		**/
/** value for less than the specified number of milliseconds			**/
/** Usage: newer([device:attribute] [,.., [device:attribute]], threshold)	**/
private Map func_newer(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('newer([device:attribute] [,.., [device:attribute]], threshold)')
	Integer t0=(Integer)params.size()-1
	Long threshold=(Long)evaluateExpression(rtD, params[t0], sLONG).v
	Integer result=0
	for(Integer i=0; i<t0; i++){
		Map age=func_age(rtD, [params[i]])
		if((String)age.t!=sERROR && (Long)age.v<threshold)result++
	}
	return [t:sINT, v:result]
}

/** older returns the number of devices whose attribute had the current		**/
/** value for more than the specified number of milliseconds			**/
/** Usage: older([device:attribute] [,.., [device:attribute]], threshold)	**/
private Map func_older(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('older([device:attribute] [,.., [device:attribute]], threshold)')
	Integer t0=(Integer)params.size()-1
	Long threshold=(Long)evaluateExpression(rtD, params[t0], sLONG).v
	Integer result=0
	for(Integer i=0; i<t0; i++){
		Map age=func_age(rtD, [params[i]])
		if((String)age.t!=sERROR && (Long)age.v>=threshold)result++
	}
	return [t:sINT, v:result]
}

/** startsWith returns true if a string starts with a substring			**/
/** Usage: startsWith(string, substring)					**/
private Map func_startswith(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('startsWith(string, substring)')
	String string=(String)evaluateExpression(rtD, params[0], sSTR).v
	String substring=(String)evaluateExpression(rtD, params[1], sSTR).v
	return [t:sBOOLN, v:(Boolean)string.startsWith(substring)]
}

/** endsWith returns true if a string ends with a substring				**/
/** Usage: endsWith(string, substring)							**/
private Map func_endswith(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('endsWith(string, substring)')
	String string=(String)evaluateExpression(rtD, params[0], sSTR).v
	String substring=(String)evaluateExpression(rtD, params[1], sSTR).v
	return [t:sBOOLN, v:(Boolean)string.endsWith(substring)]
}

/** contains returns true if a string contains a substring				**/
/** Usage: contains(string, substring)							**/
private Map func_contains(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2) || ((String)params[0].t!=sDEV && (Integer)params.size()!=2)) return rtnErr('contains(string, substring)')
	if((String)params[0].t==sDEV && (Integer)params.size()>2){
		Integer t0=(Integer)params.size()-1
		String item=evaluateExpression(rtD, params[t0], sSTR).v
		for(Integer idx=0; idx<t0; idx++){
			Map it=evaluateExpression(rtD, params[idx], sSTR)
			if(it.v==item){
				return [t:sBOOLN, v:true]
			}
		}
		return [t:sBOOLN, v:false]
	}else{
		String string=(String)evaluateExpression(rtD, params[0], sSTR).v
		String substring=(String)evaluateExpression(rtD, params[1], sSTR).v
		return [t:sBOOLN, v:(Boolean)string.contains(substring)]
	}
}

/** matches returns true if a string matches a pattern					**/
/** Usage: matches(string, pattern)							**/
private Map func_matches(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('matches(string, pattern)')
	String string=(String)evaluateExpression(rtD, params[0], sSTR).v
	String pattern=(String)evaluateExpression(rtD, params[1], sSTR).v
	if(((Integer)pattern.size()>2)&& (Boolean)pattern.startsWith(sDIV)&& (Boolean)pattern.endsWith(sDIV)){
		pattern=~pattern.substring(1, (Integer)pattern.size()-1)
		return [t:sBOOLN, v: !!(string =~ pattern)]
	}
	return [t:sBOOLN, v:(Boolean)string.contains(pattern)]
}

/** eq returns true if two values are equal					**/
/** Usage: eq(value1, value2)							**/
private Map func_eq(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('eq(value1, value2)')
	String t=(String)params[0].t==sDEV ? (String)params[1].t:(String)params[0].t
	Map value1=evaluateExpression(rtD, params[0], t)
	Map value2=evaluateExpression(rtD, params[1], t)
	return [t:sBOOLN, v: value1.v==value2.v]
}

/** lt returns true if value1<value2						**/
/** Usage: lt(value1, value2)							**/
private Map func_lt(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('lt(value1, value2)')
	Map value1=evaluateExpression(rtD, params[0])
	Map value2=evaluateExpression(rtD, params[1], (String)value1.t)
	return [t:sBOOLN, v: value1.v<value2.v]
}

/** le returns true if value1<=value2						**/
/** Usage: le(value1, value2)							**/
private Map func_le(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('le(value1, value2)')
	Map value1=evaluateExpression(rtD, params[0])
	Map value2=evaluateExpression(rtD, params[1], (String)value1.t)
	return [t:sBOOLN, v: value1.v<=value2.v]
}

/** gt returns true if value1>value2						**/
/** Usage: gt(value1, value2)							**/
private Map func_gt(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('gt(value1, value2)')
	Map value1=evaluateExpression(rtD, params[0])
	Map value2=evaluateExpression(rtD, params[1], (String)value1.t)
	return [t:sBOOLN, v: value1.v>value2.v]
}

/** ge returns true if value1>=value2						**/
/** Usage: ge(value1, value2)							**/
private Map func_ge(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('ge(value1, value2)')
	Map value1=evaluateExpression(rtD, params[0])
	Map value2=evaluateExpression(rtD, params[1], (String)value1.t)
	return [t:sBOOLN, v: value1.v>=value2.v]
}

/** not returns the negative Boolean value					**/
/** Usage: not(value)								**/
private Map func_not(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('not(value)')
	Boolean value=(Boolean)evaluateExpression(rtD, params[0], sBOOLN).v
	return [t:sBOOLN, v: !value]
}

/** if evaluates a Boolean and returns value1 if true, otherwise value2		**/
/** Usage: if(condition, valueIfTrue, valueIfFalse)				**/
private Map func_if(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,3)) return rtnErr('if(condition, valueIfTrue, valueIfFalse)')
	Boolean value=(Boolean)evaluateExpression(rtD, params[0], sBOOLN).v
	return value ? evaluateExpression(rtD, params[1]) : evaluateExpression(rtD, params[2])
}

/** isEmpty returns true if the value is empty					**/
/** Usage: isEmpty(value)							**/
private Map func_isempty(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('isEmpty(value)')
	Map value=evaluateExpression(rtD, params[0])
	Boolean result=value.v==null || (value.v instanceof List ? value.v==[null] || value.v==[] || value.v==[sSNULL] : false) || (String)value.t==sERROR || value.v==sSNULL || (String)cast(rtD, value.v, sSTR)==sBLK || "$value.v".toString()==sBLK
	return [t:sBOOLN, v:result]
}

/** datetime returns the value as a datetime type				**/
/** Usage: datetime([value])							**/
private Map func_datetime(Map rtD, List<Map> params){
	Integer sz=(Integer)params.size()
	if(!checkParams(rtD, params,0) || sz>1) return rtnErr('datetime([value])')
	Long value=sz>0 ? (Long)evaluateExpression(rtD, params[0], sDTIME).v:now()
	return [t:sDTIME, v:value]
}

/** date returns the value as a date type					**/
/** Usage: date([value])							**/
private Map func_date(Map rtD, List<Map> params){
	Integer sz=(Integer)params.size()
	if(!checkParams(rtD, params,0) || sz>1) return rtnErr('date([value])')
	Long value=sz>0 ? (Long)evaluateExpression(rtD, params[0], sDATE).v:(Long)cast(rtD, now(), sDATE, sDTIME)
	return [t:sDATE, v:value]
}

/** time returns the value as a time type					**/
/** Usage: time([value])							**/
private Map func_time(Map rtD, List<Map> params){
	Integer sz=(Integer)params.size()
	if(!checkParams(rtD, params,0) || sz>1) return rtnErr('time([value])')
	Long value=sz>0 ? (Long)evaluateExpression(rtD, params[0], sTIME).v:(Long)cast(rtD, now(), sTIME, sDTIME)
	return [t:sTIME, v:value]
}

private Map addtimeHelper(Map rtD, List<Map> params, Long mulp, String msg){
	Integer sz=(Integer)params.size()
	if(!checkParams(rtD, params,1) || sz>2) return rtnErr(msg)
	Long value=sz==2 ? (Long)evaluateExpression(rtD, params[0], sDTIME).v:now()
	Long delta=(Long)evaluateExpression(rtD, (sz==2 ? params[1]:params[0]), sLONG).v*mulp
	return [t:sDTIME, v: value+delta]
}

/** addSeconds returns the value as a time type						**/
/** Usage: addSeconds([dateTime, ]seconds)						**/
private Map func_addseconds(Map rtD, List<Map> params){
	return addtimeHelper(rtD, params, 1000L, 'addSeconds([dateTime, ]seconds)')
}

/** addMinutes returns the value as a time type						**/
/** Usage: addMinutes([dateTime, ]minutes)						**/
private Map func_addminutes(Map rtD, List<Map> params){
	return addtimeHelper(rtD, params, 60000L, 'addMinutes([dateTime, ]minutes)')
}

/** addHours returns the value as a time type						**/
/** Usage: addHours([dateTime, ]hours)							**/
private Map func_addhours(Map rtD, List<Map> params){
	return addtimeHelper(rtD, params, 3600000L, 'addHours([dateTime, ]hours)')
}

/** addDays returns the value as a time type						**/
/** Usage: addDays([dateTime, ]days)							**/
private Map func_adddays(Map rtD, List<Map> params){
	return addtimeHelper(rtD, params, 86400000L, 'addDays([dateTime, ]days)')
}

/** addWeeks returns the value as a time type						**/
/** Usage: addWeeks([dateTime, ]weeks)							**/
private Map func_addweeks(Map rtD, List<Map> params){
	return addtimeHelper(rtD, params, 604800000L, 'addWeeks([dateTime, ]weeks)')
}

/** weekDayName returns the name of the week day					**/
/** Usage: weekDayName(dateTimeOrWeekDayIndex)						**/
private Map func_weekdayname(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('weekDayName(dateTimeOrWeekDayIndex)')
	Long value=(Long)evaluateExpression(rtD, params[0], sLONG).v
	Integer index=((value>=86400000L)? (Integer)utcToLocalDate(value).day:value) % 7
	return [t:sSTR, v:(String)weekDaysFLD[index]]
}

/** monthName returns the name of the month						**/
/** Usage: monthName(dateTimeOrMonthNumber)						**/
private Map func_monthname(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('monthName(dateTimeOrMonthNumber)')
	Long value=(Long)evaluateExpression(rtD, params[0], sLONG).v
	Integer index=((value>=86400000L)? (Integer)utcToLocalDate(value).month:value-1)%12+1
	return [t:sSTR, v:(String)yearMonthsFLD[index]]
}

/** arrayItem returns the nth item in the parameter list				**/
/** Usage: arrayItem(index, item0[, item1[, .., itemN]])				**/
private Map func_arrayitem(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2)) return rtnErr('arrayItem(index, item0[, item1[, .., itemN]])')
	Integer index=(Integer)evaluateExpression(rtD, params[0], sINT).v
	Integer sz=(Integer)params.size()
	if(sz==2 && ((String)params[1].t==sSTR || (String)params[1].t==sDYN)){
		List list=((String)evaluateExpression(rtD, params[1], sSTR).v).split(sCOMMA).toList()
		if(index<0 || index>=(Integer)list.size()) return [t:sERROR, v:'Array item index is outside of bounds.']
		return [t:sSTR, v:list[index]]
	}
	if(index<0 || index>=sz-1) return [t:sERROR, v:'Array item index is outside of bounds.']
	return params[index+1]
}

/** isBetween returns true if value>=startValue and value<=endValue		**/
/** Usage: isBetween(value, startValue, endValue)				**/
private Map func_isbetween(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,3)) return rtnErr('isBetween(value, startValue, endValue)')
	Map value=evaluateExpression(rtD, params[0])
	Map startValue=evaluateExpression(rtD, params[1], (String)value.t)
	Map endValue=evaluateExpression(rtD, params[2], (String)value.t)
	return [t:sBOOLN, v: value.v>=startValue.v && value.v<=endValue.v]
}

/** formatDuration returns a duration in a readable format					**/
/** Usage: formatDuration(value[, friendly=false[, granularity='s'[, showAdverbs=false]]])	**/
private Map func_formatduration(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1) || (Integer)params.size()>4) return rtnErr("formatDuration(value[, friendly=false[, granularity='s'[, showAdverbs=false]]])")
	Long value=(Long)evaluateExpression(rtD, params[0], sLONG).v
	Boolean friendly=(Integer)params.size()>1 ? (Boolean)evaluateExpression(rtD, params[1], sBOOLN).v:false
	String granularity=(Integer)params.size()>2 ? (String)evaluateExpression(rtD, params[2], sSTR).v:sS
	Boolean showAdverbs=(Integer)params.size()>3 ? (Boolean)evaluateExpression(rtD, params[3], sBOOLN).v:false

	Integer sign=(value>=0)? 1:-1
	if(sign<0)value=-value
	Integer ms=value%1000
	value=Math.floor((value-ms)/1000.0D)
	Integer s=value%60
	value=Math.floor((value-s)/60.0D)
	Integer m=value%60
	value=Math.floor((value-m)/60.0D)
	Integer h=value%24
	value=Math.floor((value-h)/24.0D)
	Integer d=value

	Integer parts=0
	String partName=sBLK
	switch (granularity){
		case sD: parts=1; partName='day'; break
		case sH: parts=2; partName='hour'; break
		case 'm': parts=3; partName='minute'; break
		case 'ms': parts=5; partName='millisecond'; break
		default: parts=4; partName='second'; break
	}
	parts=friendly ? parts:(parts<3 ? 3:parts)
	String result=sBLK
	if(friendly){
		List p=[]
		if(d)Boolean a=p.push("$d day"+(d>1 ? sS:sBLK))
		if(parts>1 && h)Boolean a=p.push("$h hour"+(h>1 ? sS:sBLK))
		if(parts>2 && m)Boolean a=p.push("$m minute"+(m>1 ? sS:sBLK))
		if(parts>3 && s)Boolean a=p.push("$s second"+(s>1 ? sS:sBLK))
		if(parts>4 && ms)Boolean a=p.push("$ms millisecond"+(ms>1 ? sS:sBLK))
		switch ((Integer)p.size()){
			case 0:
				result=showAdverbs ? 'now' : '0 '+partName+sS
				break
			case 1:
				result=p[0]
				break
			default:
				result=sBLK
				Integer sz=(Integer)p.size()
				for(Integer i=0; i<sz; i++){
					result += (i ? (sz>2 ? ', ':sSPC):sBLK)+(i==sz-1 ? 'and ':sBLK)+p[i]
				}
				result=(showAdverbs && (sign>0)? 'in ':sBLK)+result+(showAdverbs && (sign<0)? ' ago':sBLK)
				break
		}
	}else{
		result=(sign<0 ? sMINUS:sBLK)+(d>0 ? sprintf("%dd ", d):sBLK)+sprintf("%02d:%02d", h, m)+(parts>3 ? sprintf(":%02d", s):sBLK)+(parts>4 ? sprintf(".%03d", ms):sBLK)
	}
	return [t:sSTR, v:result]
}

/** formatDateTime returns a datetime in a readable format				**/
/** Usage: formatDateTime(value[, format])						**/
private Map func_formatdatetime(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1) || (Integer)params.size()>2) return rtnErr('formatDateTime(value[, format])')
	Long value=(Long)evaluateExpression(rtD, params[0], sDTIME).v
	String format=(Integer)params.size()>1 ? (String)evaluateExpression(rtD, params[1], sSTR).v:sNULL
	return [t:sSTR, v:(format ? formatLocalTime(value, format) : formatLocalTime(value))]
}

/** random returns a random value						**/
/** Usage: random([range | value1, value2[, ..,valueN]])			**/
private Map func_random(Map rtD, List<Map> params){
	Integer sz=params!=null && (params instanceof List) ? (Integer)params.size():0
	switch (sz){
		case 0:
			return [t:sDCML, v:Math.random()]
		case 1:
			Double range=(Double)evaluateExpression(rtD, params[0], sDCML).v
			return [t:sINT, v:(Integer)Math.round(range*Math.random())]
		case 2:
			if(((String)params[0].t==sINT || (String)params[0].t==sDCML) && ((String)params[1].t==sINT || (String)params[1].t==sDCML)){
				Double min=(Double)evaluateExpression(rtD, params[0], sDCML).v
				Double max=(Double)evaluateExpression(rtD, params[1], sDCML).v
				if(min>max){
					Double swap=min
					min=max
					max=swap
				}
				return [t:sINT, v:(Integer)Math.round(min+(max-min)*Math.random())]
			}
	}
	Integer choice=(Integer)Math.round((sz-1)*Math.random())
	if(choice>=sz)choice=sz-1
	return params[choice]
}

/** distance returns a distance measurement							**/
/** Usage: distance((device | latitude, longitude), (device | latitude, longitude)[, unit])	**/
private Map func_distance(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,2) || (Integer)params.size()>4) return rtnErr('distance((device | latitude, longitude), (device | latitude, longitude)[, unit])')
	Double lat1, lng1, lat2, lng2
	String unit
	Integer idx=0
	Integer pidx=0
	String errMsg=sBLK
	while (pidx<(Integer)params.size()){
		if((String)params[pidx].t!=sDEV || ((String)params[pidx].t==sDEV && !!params[pidx].a)){
			//a decimal or device attribute is provided
			switch (idx){
			case 0:
				lat1=(Double)evaluateExpression(rtD,params[pidx],sDCML).v
				break
			case 1:
				lng1=(Double)evaluateExpression(rtD,params[pidx],sDCML).v
				break
			case 2:
				lat2=(Double)evaluateExpression(rtD,params[pidx],sDCML).v
				break
			case 3:
				lng2=(Double)evaluateExpression(rtD,params[pidx],sDCML).v
				break
			case 4:
				unit=(String)evaluateExpression(rtD,params[pidx],sSTR).v
			}
			idx += 1
			pidx += 1
			continue
		}else{
			switch (idx){
			case 0:
			case 2:
				params[pidx].a='latitude'
				Double lat=(Double)evaluateExpression(rtD, params[pidx], sDCML).v
				params[pidx].a='longitude'
				Double lng=(Double)evaluateExpression(rtD, params[pidx], sDCML).v
				if(idx==0){
					lat1=lat
					lng1=lng
				}else{
					lat2=lat
					lng2=lng
				}
				idx += 2
				pidx += 1
				continue
			default:
				errMsg="Invalid parameter order. Expecting parameter #${idx+1} to be a decimal, not a device."
				pidx=-1
				break
			}
		}
		if(pidx==-1)break
	}
	if(errMsg!=sBLK)return [t:sERROR, v:errMsg]
	if(idx<4 || idx>5)return [t:sERROR, v:'Invalid parameter combination. Expecting either two devices, a device and two decimals, or four decimals, followed by an optional unit.']
	Double earthRadius=6371000.0D //meters
	Double dLat=Math.toRadians(lat2-lat1)
	Double dLng=Math.toRadians(lng2-lng1)
	Double a=Math.sin(dLat/2.0D)*Math.sin(dLat/2.0D)+
		Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))*
		Math.sin(dLng/2.0D)*Math.sin(dLng/2.0D)
	Double c=2.0D*Math.atan2(Math.sqrt(a), Math.sqrt(1.0D-a))
	Double dist=earthRadius*c
	switch (unit!=null ? unit:'m'){
		case 'km':
		case 'kilometer':
		case 'kilometers':
			return [t:sDCML, v:dist/1000.0D]
		case 'mi':
		case 'mile':
		case 'miles':
			return [t:sDCML, v:dist/1609.3440D]
		case 'ft':
		case 'foot':
		case 'feet':
			return [t:sDCML, v:dist/0.3048D]
		case 'yd':
		case 'yard':
		case 'yards':
			return [t:sDCML, v:dist/0.9144D]
	}
	return [t:sDCML, v:dist]
}

/** json encodes data as a JSON string							**/
/** Usage: json(value[, pretty])							**/
private static Map func_json(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1) || (Integer)params.size()>2) return rtnErr('json(value[, format])')
	def builder=new groovy.json.JsonBuilder([params[0].v])
	String op=params[1] ? 'toPrettyString' : 'toString'
	String json=builder."${op}"()
	return [t:sSTR, v:json[1..-2].trim()]
}

/** urlencode encodes data for use in a URL						**/
/** Usage: urlencode(value)								**/
private Map func_urlencode(Map rtD, List<Map> params){
	if(!checkParams(rtD, params,1)) return rtnErr('urlencode(value])')
	// URLEncoder converts spaces to + which is then indistinguishable from any
	// actual + characters in the value. Match encodeURIComponent in ECMAScript
	// which encodes "a+b c" as "a+b%20c" rather than URLEncoder's "a+b+c"
	String t0=(String)evaluateExpression(rtD, params[0], sSTR).v
	String value=(t0!=null ? t0:sBLK).replaceAll('\\+', '__wc_plus__')
	return [t:sSTR, v:URLEncoder.encode(value, 'UTF-8').replaceAll('\\+', '%20').replaceAll('__wc_plus__', sPLUS)]
}
private Map func_encodeuricomponent(Map rtD, List params){ return func_urlencode(rtD, params)}

/** COMMON PUBLISHED METHODS							**/

private String mem(Boolean showBytes=true){
	String mbytes=new groovy.json.JsonOutput().toJson(state)
	Integer bytes=(Integer)mbytes.length()
	return Math.round(100.0D*(bytes/100000.0D))+"%${showBytes ? " ($bytes bytes)".toString() : sBLK}"
}

private static String runTimeHis(Map rtD){
	String myId=(String)rtD.id
	return 'Total run history: '+((List)theCacheFLD[myId].runTimeHis).toString()+'<br>' +
		'Last run details: '+((Map)theCacheFLD[myId].runStats).toString()
}

/** UTILITIES									**/

private String md5(String md5){
	java.security.MessageDigest md=java.security.MessageDigest.getInstance('MD5')
	byte[] array=md.digest(md5.getBytes())
	String result=sBLK
	for(Integer i=0; i<array.length; ++i){
		result += Integer.toHexString((array[i] & 0xFF)| 0x100).substring(1,3)
	}
	return result
}

@Field static Map theHashMapFLD=[:]

private String hashId(id, Boolean updateCache=true){
	String result
	String myId=id.toString()
	result=(String)theHashMapFLD[myId]
	if(result==sNULL){
		result=sCOLON+md5('core.'+myId)+sCOLON
		if(updateCache){
			getCacheLock(sD)
			theHashMapFLD[myId]=result
			releaseCacheLock()
		}
	}
	return result
}

private getThreeAxisOrientation(value, Boolean getIndex=false){
	if(value instanceof Map){
		if((value.x!=null)&& (value.y!=null)&& (value.z!=null)){
			Integer x=Math.abs(value.x)
			Integer y=Math.abs(value.y)
			Integer z=Math.abs(value.z)
			Integer side=(x>y ? (x>z ? 0:2):(y>z ? 1:2))
			side+= ( (side==0 && value.x<0) || (side==1 && value.y<0) || (side==2 && value.z<0) ? 3:0 )
			List orientations=['rear', 'down', 'left', 'front', 'up', 'right']
			def result=getIndex ? side : (String)orientations[side]+' side up'
			return result
		}
	}
	return value
}

private Long getTimeToday(Long time){
	Long t0=getMidnightTime()
	Long result=time+t0
	//we need to adjust for time overlapping during DST changes
	return Math.round(result+((Integer)location.timeZone.getOffset(t0)-(Integer)location.timeZone.getOffset(result))*1.0D)
}

@Field static final List<String> trueStrings= [ '1', 'true',  "on",  "open",   "locked",   "active",   "wet",             "detected",     "present",     "occupied",     "muted",   "sleeping"]
@Field static final List<String> falseStrings=[ '0', 'false', "off", "closed", "unlocked", "inactive", "dry", "clear",    "not detected", "not present", "not occupied", "unmuted", "not sleeping", "null"]

private cast(Map rtD, value, String dataType, String srcDataType=sNULL){
	if(dataType==sDYN)return value
	if(value==null){
		value=sBLK
		srcDataType=sSTR
	}
	value=(value instanceof GString)? "$value".toString():value //get rid of GStrings
	if(srcDataType==sNULL || (Integer)srcDataType.length()==0 || srcDataType==sBOOLN || srcDataType==sDYN){
		if(value instanceof List){srcDataType=sDEV}else
		if(value instanceof Boolean){srcDataType=sBOOLN}else
		if(value instanceof String){srcDataType=sSTR}else
		if(value instanceof Integer){srcDataType=sINT}else
		if(value instanceof BigInteger){srcDataType=sLONG}else
		if(value instanceof Long){srcDataType=sLONG}else
		if(value instanceof Double){srcDataType=sDCML}else
		if(value instanceof Float){srcDataType=sDCML}else
		if(value instanceof BigDecimal){srcDataType=sDCML}else
		if(value instanceof Map && value.x!=null && value.y!=null && value.z!=null){srcDataType='vector3'}else{
			value="$value".toString()
			srcDataType=sSTR
		}
	}
	//overrides
	switch (srcDataType){
		case sBOOL: srcDataType=sBOOLN; break
		case sNUMBER: srcDataType=sDCML; break
		case sENUM: srcDataType=sSTR; break
	}
	switch (dataType){
		case sBOOL: dataType=sBOOLN; break
		case sNUMBER: dataType=sDCML; break
		case sENUM: dataType=sSTR; break
	}
	if((Boolean)rtD.eric)myDetail rtD, "cast $srcDataType $value as $dataType"
	switch (dataType){
		case sSTR:
		case sTEXT:
			switch (srcDataType){
				case sBOOLN: return value ? sTRUE:sFALSE
				case sDCML:
					//if(value instanceof Double)return sprintf('%f', value)
					// strip trailing zeroes (e.g. 5.00 to 5 and 5.030 to 5.03)
					return value.toString().replaceFirst(/(?:\.|(\.\d*?))0+$/, '$1')
				case sINT:
				case sLONG: break
				case sTIME: return formatLocalTime(value, 'h:mm:ss a z')
				case sDATE: return formatLocalTime(value, 'EEE, MMM d yyyy')
				case sDTIME: return formatLocalTime(value)
				case sDEV: return buildDeviceList(rtD, value)
			}
			return "$value".toString()
		case sINT:
			switch (srcDataType){
				case sSTR:
					value=value.replaceAll(/[^-\d.-E]/, sBLK)
					if(value.isInteger())
						return value.toInteger()
					if(value.isFloat())
						return (Integer)Math.floor(value.toDouble())
					if(value in trueStrings)
						return (Integer)1
					break
				case sBOOLN: return (Integer)(value ? 1:0)
			}
			Integer result
			try{
				result=(Integer)value.toInteger()
			}catch(all){
				result=0
			}
			return result
		case sLONG:
			switch (srcDataType){
				case sSTR:
					value=value.replaceAll(/[^-\d.-E]/, sBLK)
					if(value.isLong())
						return value.toLong()
					if(value.isInteger())
						return (Long)value.toInteger()
					if(value.isFloat())
						return (Long)Math.floor(value.toDouble())
					if(value in trueStrings)
						return 1L
					break
				case sBOOLN: return (value ? 1L:0L)
			}
			Long result
			try{
				result=(Long)value.toLong()
			}catch(all){
				result=0L
			}
			return result
		case sDCML:
			switch (srcDataType){
				case sSTR:
					value=value.replaceAll(/[^-\d.-E]/, sBLK)
					if(value.isDouble())
						return (Double)value.toDouble()
					if(value.isFloat())
						return (Double)value.toDouble()
					if(value.isLong())
						return (Double)value.toLong()
					if(value.isInteger())
						return (Double)value.toInteger()
					if(value in trueStrings)
						return 1.0D
					break
				case sBOOLN: return (Double)(value ? 1.0D:0.0D)
			}
			Double result=0.0D
			try{
				result=(Double)value.toDouble()
			}catch(all){
			}
			return result
		case sBOOLN:
			switch (srcDataType){
				case sINT:
				case sDCML:
				case sBOOLN:
					return !!value
				case sDEV:
					return value instanceof List && (Integer)value.size()>0
			}
			if(value){
				if("$value".toLowerCase().trim() in trueStrings)return true
				if("$value".toLowerCase().trim() in falseStrings)return false
			}
			return !!value
		case sTIME:
			if("$value".isNumber() && value.toLong()<86400000L) return value.toLong()
			Long d= srcDataType==sSTR ? stringToTime(value):value.toLong() // (Long)cast(rtD, value, sLONG)
			Date t1=new Date(d)
			Long t2=Math.round(((Integer)t1.hours*3600.0D+(Integer)t1.minutes*60.0D+(Integer)t1.seconds)*1000.0D)
			return t2
		case sDATE:
			if(srcDataType==sTIME){
				Long tt1=value.toLong()
				if(tt1<86400000L) value=getTimeToday(tt1)
			}
			Long d=(srcDataType==sSTR)? stringToTime(value):(Long)value // (Long)cast(rtD, value, sLONG)
			Date t1=new Date(d)
			Long t2=Math.round((Math.floor(d/1000.0D)*1000.0D)-(((Integer)t1.hours*3600.0D+(Integer)t1.minutes*60.0D+(Integer)t1.seconds)*1000.0D)) // take ms off and first guess at midnight (could be earlier/later depending if DST change day
			Long t3=Math.round(t2-(1.0D*3600000.0D)) // guess at 11 PM
			Long t4=Math.round(t2+(4.0D*3600000.0D)) // guess at 04 AM
			Long t5=Math.round(t2+(3.0D*3600000.0D)+((Integer)location.timeZone.getOffset(t3)-(Integer)location.timeZone.getOffset(t4))) // normalize to 3:00 AM for DST
			return t5
		case sDTIME:
			if(srcDataType==sTIME){
				Long tt1=value.toLong()
				if(tt1<86400000L) value=getTimeToday(tt1)
			}
			return (srcDataType==sSTR)? stringToTime(value):value.toLong() // (Long)cast(rtD, value, sLONG)
		case 'vector3':
			return value instanceof Map && value.x!=null && value.y!=null && value.z!=null ? value : [x:0, y:0, z:0]
		case sORIENT:
			return getThreeAxisOrientation(value)
		case 'ms':
		case sS:
		case 'm':
		case sH:
		case sD:
		case 'w':
		case 'n':
		case 'y':
			Long t1=0L
			switch (srcDataType){
				case sINT:
				case sLONG:
					t1=value; break
				default:
					t1=(Long)cast(rtD, value, sLONG)
			}
			switch (dataType){
				case 'ms': return t1
				case sS: return Math.round(t1*1000.0D)
				case 'm': return Math.round(t1*60000.0D)
				case sH: return Math.round(t1*3600000.0D)
				case sD: return Math.round(t1*86400000.0D)
				case 'w': return Math.round(t1*604800000.0D)
				case 'n': return Math.round(t1*2592000000.0D)
				case 'y': return Math.round(t1*31536000000.0D)
			}
		case sDEV:
		//device type is an array of device Ids
			if(value instanceof List){
				Boolean a=value.removeAll{ !it }
				return value
			}
			String v=(String)cast(rtD, value, sSTR)
			if(v!=sNULL)return [v]
			return []
	}
	//anything else...
	return value
}

private Date utcToLocalDate(dateOrTimeOrString=null){ // this is really cast to Date
	if(dateOrTimeOrString instanceof String){
		dateOrTimeOrString=stringToTime((String)dateOrTimeOrString)
	}
	if(dateOrTimeOrString instanceof Date){
		//get unix time
		dateOrTimeOrString=(Long)((Date)dateOrTimeOrString).getTime()
	}
	if(dateOrTimeOrString==null || dateOrTimeOrString==0L){
		dateOrTimeOrString=now()
	}
	if(dateOrTimeOrString instanceof Long){
		//HE adjusts Date fields (except for getTime()to local timezone of hub)
		return new Date((Long)dateOrTimeOrString)
	}
	return null
}

private Date localDate(){ return utcToLocalDate()}

//private Long localTime(){ return now()} //utcToLocalTime()}

private Long stringToTime(dateOrTimeOrString){ // this is convert to time
	Long result
	if("$dateOrTimeOrString".isNumber()){
		Long tt=dateOrTimeOrString.toLong()
		if(tt<86400000L){
			result=getTimeToday(dateOrTimeOrString)
			return result
		}else{
// deal with a time in sec (vs. ms)
			Long span=365*24*60*60*2
			Long nowInsecs=now()/1000L
			Long secsMin=nowInsecs - span
			Long secsMax=nowInsecs + span
			if(tt>secsMin && tt<secsMax){
				result=tt*1000L
				return result
			}
		}
		return tt
	}

	if(dateOrTimeOrString instanceof String){

		try{
			result=(new Date()).parse(dateOrTimeOrString)
			return result
		}catch (all0){
		}

		try{
			Date tt1=toDateTime(dateOrTimeOrString)
			result=(Long)tt1.getTime()
			return result
		}catch(all3){
		}

		// additional ISO 8601 that Hubitat does not parse
		try {
			String tt=dateOrTimeOrString
			def regex1 = /Z/
			String tt0 = tt.replaceAll(regex1, " -0000")
			result = (new Date()).parse("yyyy-MM-dd'T'HH:mm z", tt0).getTime()
			return result
		} catch(all1) {
		}

		try{
			//get unix time
			if(!(dateOrTimeOrString =~ /(\s[A-Z]{3}((\+|\-)[0-9]{2}\:[0-9]{2}|\s[0-9]{4})?$)/)){
				def newDate=(new Date()).parse(dateOrTimeOrString+sSPC+formatLocalTime(now(), 'Z'))
				result=newDate
				return result
			}
			result=(new Date()).parse(dateOrTimeOrString)
			return result
		}catch (all){
		}

		try{
			def tz=location.timeZone
			if(dateOrTimeOrString =~ /\s[A-Z]{3}$/){ // this is not the timezone... strings like CET are not unique.
				try{
					tz=TimeZone.getTimeZone(dateOrTimeOrString[-3..-1])
					dateOrTimeOrString=dateOrTimeOrString.take((Integer)dateOrTimeOrString.size()-3).trim()
				}catch (all4){
				}
			}

			String t0=dateOrTimeOrString?.trim()?: sBLK
			t0=t0.toLowerCase()
			Boolean hasMeridian=false
			Boolean hasAM=false
			Boolean hasPM=false
			if((Boolean)t0.endsWith('a.m.')){
				t0 = t0.replaceAll('a\\.m\\.', 'am')
			}
			if((Boolean)t0.endsWith('p.m.')){
				t0 = t0.replaceAll('p\\.m\\.', 'pm')
			}
			if((Boolean)t0.endsWith('am')){
				hasMeridian=true
				hasAM=true
			}
			if((Boolean)t0.endsWith('pm')){
				hasMeridian=true
				hasPM=true
			}
			Long time
			if(hasMeridian) t0=t0[0..-3].trim()

			if(t0.length() == 8){
				try {
					String tt=t0
					time = (new Date()).parse('HH:mm:ss', tt).getTime()
					time=getTimeToday(time)
				} catch(all11) {
				}
			} else {
				try {
					time=timeToday(t0, tz).getTime()
				} catch(all12) {
				}
			}

			if(hasMeridian && time){
				Date t1=new Date(time)
				Integer hr=(Integer)t1.hours
				Integer min=(Integer)t1.minutes
				Integer sec=(Integer)t1.seconds
				Boolean twelve= hr>=12
				if(twelve && hasAM)hr -= 12
				if(!twelve && hasPM)hr += 12
				String str1="${hr}".toString()
				String str2="${min}".toString()
				String str3="${sec}".toString()
				if(hr<10)str1=String.format('%02d', hr)
				if(min<10)str2=String.format('%02d', min)
				if(sec<10)str3=String.format('%02d', sec)
				String str=str1+sCOLON+str2
				time=timeToday(str, tz).getTime()
				if(sec != 0) time += sec*1000
			}
			result=time ?: 0L
			return result
		}catch (all5){
		}

//		result=(new Date()).getTime()
//		return result
	}

	if(dateOrTimeOrString instanceof Date){
		result=(Long)((Date)dateOrTimeOrString).getTime()
		return result
	}
	return 0L
}

private String formatLocalTime(time, String format='EEE, MMM d yyyy @ h:mm:ss a z'){
	def nTime=time
	if("$time".isNumber()){
		Long ltime=(Long)time.toLong()
		if(ltime<86400000L)ltime=getTimeToday(ltime)
// deal with a time in sec (vs. ms)
		if(ltime<Math.round(now()/1000.0D+86400.0D*365.0D))ltime=Math.round(ltime*1000.0D)
		nTime=new Date(ltime)
	}else if(time instanceof String){
		//get time
		nTime=new Date(stringToTime((String)time))
	}
	if(!(nTime instanceof Date)){
		return sNULL
	}
	java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat(format)
	formatter.setTimeZone(location.timeZone)
	return (String)formatter.format(nTime)
}

private static Map hexToColor(String hex){
	hex=hex!=sNULL ? hex:sZEROS
	if((Boolean)hex.startsWith('#'))hex=hex.substring(1)
	if((Integer)hex.size()!=6)hex=sZEROS
	List<Integer> myHsl=hexToHsl(hex)
	return [
		hue: myHsl[0],
		saturation: myHsl[1],
		level: myHsl[2],
		hex: '#'+hex
	]
}

private static Double _hue2rgb(Double p, Double q, Double t){
	if(t<0.0D)t += 1.0D
	if(t>=1.0D)t -= 1.0D
	if(t<1.0D/6.0D)return p+(q-p)*6.0D*t
	if(t<1.0D/2.0D)return q
	if(t<2.0D/3.0D)return p+(q-p)*(2.0D/3.0D-t)*6.0D
	return p
}

private static String hslToHex(hue, saturation, level){
	Double h=hue/360.0D
	Double s=saturation/100.0D
	Double l=level/100.0D
// argument checking for user calls
	if(h<0.0D)h=0.0D
	if(h>1.0D)h=1.0D
	if(s<0.0D)s=0.0D
	if(s>1.0D)s=1.0D
	if(l<0.0D)l=0.0D
	if(l>1.0D)l=1.0D

	Double r, g, b
	if(s==0.0D){
		r=g=b=l // achromatic
	}else{
		Double q=l<0.5D ? l*(1.0D+s) : l+s-(l*s)
		Double p=2.0D*l-q
		r=_hue2rgb(p, q, h+1.0D/3.0D)
		g=_hue2rgb(p, q, h)
		b=_hue2rgb(p, q, h-1.0D/3.0D)
	}

	return sprintf('#%02X%02X%02X', Math.round(r*255.0D), Math.round(g*255.0D), Math.round(b*255.0D))
}
/*
private static Map<String,Integer> hexToRgb(String hex){
	hex=hex!=sNULL ? hex:sZEROS
	if((Boolean)hex.startsWith('#'))hex=hex.substring(1)
	if((Integer)hex.size()!=6)hex=sZEROS
	Integer r1=Integer.parseInt(hex.substring(0, 2), 16)
	Integer g1=Integer.parseInt(hex.substring(2, 4), 16)
	Integer b1=Integer.parseInt(hex.substring(4, 6), 16)
	return [r:r1, g:g1, b:b1]
}*/

private static List<Integer> hexToHsl(String hex){
	hex=hex!=sNULL ? hex:sZEROS
	if((Boolean)hex.startsWith('#'))hex=hex.substring(1)
	if((Integer)hex.size()!=6)hex=sZEROS
	Double r=Integer.parseInt(hex.substring(0, 2), 16)/255.0D
	Double g=Integer.parseInt(hex.substring(2, 4), 16)/255.0D
	Double b=Integer.parseInt(hex.substring(4, 6), 16)/255.0D

	Double max=Math.max(Math.max(r, g), b)
	Double min=Math.min(Math.min(r, g), b)
	Double h, s, l=(max+min)/2.0D

	if(max==min){
		h=s=0.0D // achromatic
	}else{
		Double d=max-min
		s=l>0.5D ? d/(2.0D-max-min) : d/(max+min)
		switch(max){
			case r: h=(g-b)/d+(g<b ? 6.0D:0.0D); break
			case g: h=(b-r)/d+2.0D; break
			case b: h=(r-g)/d+4.0D; break
		}
		h /= 6.0D
	}
	return [Math.round(h*360.0D), Math.round(s*100.0D), Math.round(l*100.0D)]
}

//hubitat device ids can be the same as the location id
private Boolean isDeviceLocation(device){
	if((String)device.id.toString()==(String)location.id.toString()){
		Integer tt0=device.hubs?.size()
		if((tt0!=null?tt0:0)>0)return true
	}
	return false
}

/**							**/
/** DEBUG FUNCTIONS					**/
/**							**/

private void myDetail(Map rtD, String msg, Integer shift=-2){
	Map a=log(msg, rtD, shift, null, 'warn', true, false)
}

private Map log(message, Map rtD, Integer shift=-2, err=null, String cmd=sNULL, Boolean force=false, Boolean svLog=true){
	if(cmd=='timer'){
		return [m:message.toString(), t:now(), s:shift, e:err]
	}
	if(message instanceof Map){
		shift=(Integer)message.s
		err=message.e
		message=(String)message.m+" (${now()-(Long)message.t}ms)".toString()
	}
	String myMsg=message.toString()
	cmd=cmd!=sNULL ? cmd:'debug'
	//shift is
	// 0 - initialize level, level set to 1
	// 1 - start of routine, level up
	// -1 - end of routine, level down
	// anything else - nothing happens
//	Integer maxLevel=4
	Integer level=rtD?.debugLevel ? (Integer)rtD.debugLevel:0
	String prefix="║"
	String prefix2="║"
//	String pad=sBLK //"░"
	switch (shift){
		case 0:
			level=0
		case 1:
			level += 1
			prefix="╚"
			prefix2="╔"
//			pad="═"
			break
		case -1:
			level -= 1
//			pad="═"
			prefix="╔"
			prefix2="╚"
			break
	}

	if(level>0){
		prefix=prefix.padLeft(level+(shift==-1 ? 1:0), "║")
		prefix2=prefix2.padLeft(level+(shift==-1 ? 1:0), "║")
	}

	rtD.debugLevel=level
	Boolean hasErr=(err!=null && !!err)

	if(svLog && rtD!=null && rtD instanceof Map && rtD.logs instanceof List){
		myMsg=myMsg.replaceAll(/(\r\n|\r|\n|\\r\\n|\\r|\\n)+/, "\r")
		if((Integer)myMsg.size()>1024){
			myMsg=myMsg[0..1023]+'...[TRUNCATED]'
		}
		List msgs=!hasErr ? myMsg.tokenize("\r"):[myMsg]
		for(msg in msgs){
			Boolean a=((List)rtD.logs).push([o: now()-(Long)rtD.timestamp, p: prefix2, m: msg+(hasErr ? " $err".toString() : sBLK), c: cmd])
		}
	}
	String myPad=sSPC
	switch(cmd){
		case 'debug':
			break
		case 'info':
			myPad=" ░"
			break
		case 'trace':
		case sERROR:
		case 'warn':
			myPad="░"
			break
		default:
			break
	}
	if(hasErr) myMsg += "$err".toString()
	if((cmd in [sERROR,'warn']) || hasErr || force || !svLog || (Boolean)rtD.logsToHE || (Boolean)rtD.eric)log."$cmd" myPad+prefix+sSPC+myMsg
	return [:]
}

private void info(message, Map rtD, Integer shift=-2, err=null){ Map a=log(message, rtD, shift, err, 'info')}
private void trace(message, Map rtD, Integer shift=-2, err=null){ Map a=log(message, rtD, shift, err, 'trace')}
private void debug(message, Map rtD, Integer shift=-2, err=null){ Map a=log(message, rtD, shift, err, 'debug')}
private void warn(message, Map rtD, Integer shift=-2, err=null){ Map a=log(message, rtD, shift, err, 'warn')}
private void error(message, Map rtD, Integer shift=-2, err=null){ Map a=log(message, rtD, shift, err, sERROR)}
private Map timer(String message, Map rtD, Integer shift=-2, err=null){ log(message, rtD, shift, err, 'timer')}

private void tracePoint(Map rtD, String objectId, Long duration, value){
	if(objectId!=sNULL && rtD!=null && (Map)rtD.trace!=null){
		rtD.trace.points[objectId]=[o: Math.round(1.0D*now()-(Long)rtD.trace.t-duration), d: duration, v: value]
	}else{
		error "Invalid object ID $objectID for trace point...", rtD
	}
}

@Field static final List<String> weekDaysFLD=[
	'Sunday',
	'Monday',
	'Tuesday',
	'Wednesday',
	'Thursday',
	'Friday',
	'Saturday'
]

@Field static final List<String> yearMonthsFLD=[
	'',
	'January',
	'February',
	'March',
	'April',
	'May',
	'June',
	'July',
	'August',
	'September',
	'October',
	'November',
	'December'
]

@Field static Map svSunTFLD

private void initSunriseAndSunset(Map rtD){
	Map t0=svSunTFLD
	Long t=now()
	if(t0!=null){
		if(t<(Long)t0.nextM){
			rtD.sunTimes=[:]+t0
		}else{ t0=null; svSunTFLD=null; rtD.nextsunrise==null; rtD.nextsunset=null }
	}
	if(t0==null){
		Map sunTimes=app.getSunriseAndSunset()
		if(sunTimes.sunrise==null){
			warn 'Actual sunrise and sunset times are unavailable; please reset the location for your hub', rtD
			Long t1=getMidnightTime()
			sunTimes.sunrise=new Date(Math.round(t1+7.0D*3600000.0D))
			sunTimes.sunset=new Date(Math.round(t1+19.0D*3600000.0D))
			t=0L
		}
		Long a,b,c,d = 0L
		try{
			a=(Long)((Date)todaysSunrise).getTime() // requires FW 2.2.3.132 or later
			b=(Long)((Date)todaysSunset).getTime()
			c=(Long)((Date)tomorrowsSunrise).getTime()
			d=(Long)((Date)tomorrowsSunset).getTime()
		} catch(e) {
		}
		t0=[
			sunrise: (Long)((Date)sunTimes.sunrise).getTime(),
			sunset: (Long)((Date)sunTimes.sunset).getTime(),
			todayssunrise: a,
			todayssunset: b,
			tomorrowssunrise: c, 
			tomorrowssunset: d, 
			updated: t,
			nextM: getNextMidnightTime()
		]
		rtD.sunTimes=t0
		if(t!=0L){
			svSunTFLD=t0
			mb()
			if(eric())log.debug 'updating global sunrise'
		}
	}
	rtD.sunrise=(Long)rtD.sunTimes.sunrise
	rtD.sunset=(Long)rtD.sunTimes.sunset
}

private Long getSunriseTime(Map rtD){
	initSunriseAndSunset(rtD)
	return (Long)rtD.sunrise
}

private Long getSunsetTime(Map rtD){
	initSunriseAndSunset(rtD)
	return (Long)rtD.sunset
}

private Long getNextSunriseTime(Map rtD){
	if(rtD.nextsunrise==null)rtD.nextsunrise=getNextOccurance(rtD, 'Sunrise')
	return (Long)rtD.nextsunrise
}

private Long getNextSunsetTime(Map rtD){
	if(rtD.nextsunset==null)rtD.nextsunset=getNextOccurance(rtD, 'Sunset')
	return (Long)rtD.nextsunset
}

// This is trying to ensure we don't fire sunsets or sunrises twice in same day by ensuring we fire a bit later than actual sunrise or sunset
private Long getNextOccurance(Map rtD, String ttyp){
	Long t0=(Long)"get${ttyp}Time"(rtD)
	if(now()>t0){
		Long a
		if(ttyp=='Sunrise') a=(Long)rtD.sunTimes.tomorrowssunrise
		if(ttyp=='Sunset') a=(Long)rtD.sunTimes.tomorrowssunset
		if(a>now()) return a

		List t1=getLocationEventsSince("${ttyp.toLowerCase()}Time", new Date()-2)
		def t2
		if((Integer)t1.size()>0) t2=t1[0]
		if(t2!=null && t2.value){
			a=Math.round(stringToTime((String)t2.value)+1000L*1.0D)
			if(a>now())return a
		}
	}else return t0

	Long t4=Math.round(t0+86400000.0D)

	Date t1=new Date(t4)
	Integer curMon=(Integer)t1.month
	curMon=location.latitude>0 ? curMon:((curMon+6)%12) // normalize for southern hemisphere

	Integer addr
	if((curMon>5 && ttyp=='Sunset') || (curMon<=5 && ttyp=='Sunrise'))addr=1000 // minimize skew when sunrise or sunset moving earlier in day
	else{
		Integer t2=Math.abs(location.latitude)
		Integer t3=curMon%6
		Integer t5=(Integer)Math.round(t3*365.0D/12.0D+(Integer)t1.date) // days into period
		addr=Math.round((t5>37 && t5<(182-37)? t2*2.8D:t2*1.9D)*1000.0D)
	}
	return t4+addr.toLong()
}

private Long getMidnightTime(){
	return timeToday('00:00', location.timeZone).getTime()
}

private Long getNextMidnightTime(){
	return timeTodayAfter('23:59', '00:00', location.timeZone).getTime()
}

private Long getNoonTime(){
	return timeToday('12:00', location.timeZone).getTime()
}

private Long getNextNoonTime(){
	return timeTodayAfter('23:59', '12:00', location.timeZone).getTime()
}

private void getLocalVariables(Map rtD, List<Map> vars, Map atomState){
	rtD.localVars=[:]
	Map<String,Object> values=(Map<String,Object>)atomState.vars
	for(Map var in vars){
		String t0=(String)var.t
		def t1=values[(String)var.n]
		Map<String,Object> variable=[t:t0, v:var.v!=null ? var.v:((Boolean)t0.endsWith(sRB) ? (t1 instanceof Map ? t1:[:]):cast(rtD, t1, t0)), f: !!var.v] //f means fixed value - we won't save this to the state
		if(var.v!=null && (String)var.a==sS && !(Boolean)t0.endsWith(sRB)) variable.v=evaluateExpression(rtD, (Map)evaluateOperand(rtD, null, (Map)var.v), t0).v
		rtD.localVars[(String)var.n]=variable
	}
}

private LinkedHashMap getSystemVariablesAndValues(Map rtD){
	LinkedHashMap<String,LinkedHashMap> result=getSystemVariables()
	LinkedHashMap<String,LinkedHashMap> t0=(LinkedHashMap)rtD.cachePersist
	rtD.args=t0[sDOLARGS]
	for(variable in result){
		String keyt1=(String)variable.key
		if(variable.value.d!=null && (Boolean)variable.value.d) variable.value.v=getSystemVariableValue(rtD, keyt1)
		else if(t0[keyt1]!=null)variable.value.v=t0[keyt1].v
	}
	return result
}

// UI will not display anything that starts with $current or $previous; variables without d: true will not display variable value
private static LinkedHashMap<String,LinkedHashMap> getSystemVariables(){
	return [
		'$args':[t:sDYN, d:true],
		'$json':[t:sDYN, d:true],
		'$places':[t:sDYN, d:true],
		'$response':[t:sDYN, d:true],
		'$nfl':[t:sDYN, d:true],
		'$weather':[t:sDYN, d:true],
		'$incidents':[t:sDYN, d:true],
		'$hsmTripped':[t:sBOOLN, d:true],
		'$hsmStatus':[t:sSTR, d:true],
		'$httpContentType':[t:sSTR, v:null],
		'$httpStatusCode':[t:sINT, v:null],
		'$httpStatusOk':[t:sBOOLN, v:null],
		'$currentEventAttribute':[t:sSTR, v:null],
		'$currentEventDescription':[t:sSTR, v:null],
		'$currentEventDate':[t:sDTIME, v:null],
		'$currentEventDelay':[t:sINT, v:null],
		'$currentEventDevice':[t:sDEV, v:null],
		'$currentEventDeviceIndex':[t:sINT, v:null],
		'$currentEventDevicePhysical':[t:sBOOLN, v:null],
//		'$currentEventReceived':[t:sDTIME, v:null],
		'$currentEventValue':[t:sDYN, v:null],
		'$currentEventUnit':[t:sSTR, v:null],
//		'$currentState':[t:sSTR, v:null],
//		'$currentStateDuration':[t:sSTR, v:null],
//		'$currentStateSince':[t:sDTIME, v:null],
//		'$nextScheduledTime':[t:sDTIME, v:null],
		'$name':[t:sSTR, d:true],
		'$state':[t:sSTR, d:true],
		'$device':[t:sDEV, v:null],
		'$devices':[t:sDEV, v:null],
		'$index':[t:sDCML, v:null],
		'$iftttStatusCode':[t:sINT, v:null],
		'$iftttStatusOk':[t:sBOOLN, v:null],
		'$location':[t:sDEV, v:null],
		'$locationMode':[t:sSTR, d:true],
		'$localNow':[t:sDTIME, d:true],
		'$now':[t:sDTIME, d:true],
		'$hour':[t:sINT, d:true],
		'$hour24':[t:sINT, d:true],
		'$minute':[t:sINT, d:true],
		'$second':[t:sINT, d:true],
		'$zipCode':[t:sSTR, d:true],
		'$latitude':[t:sSTR, d:true],
		'$longitude':[t:sSTR, d:true],
		'$meridian':[t:sSTR, d:true],
		'$meridianWithDots':[t:sSTR, d:true],
		'$day':[t:sINT, d:true],
		'$dayOfWeek':[t:sINT, d:true],
		'$dayOfWeekName':[t:sSTR, d:true],
		'$month':[t:sINT, d:true],
		'$monthName':[t:sSTR, d:true],
		'$year':[t:sINT, d:true],
		'$midnight':[t:sDTIME, d:true],
		'$noon':[t:sDTIME, d:true],
		'$sunrise':[t:sDTIME, d:true],
		'$sunset':[t:sDTIME, d:true],
		'$nextMidnight':[t:sDTIME, d:true],
		'$nextNoon':[t:sDTIME, d:true],
		'$nextSunrise':[t:sDTIME, d:true],
		'$nextSunset':[t:sDTIME, d:true],
		'$time':[t:sSTR, d:true],
		'$time24':[t:sSTR, d:true],
		'$utc':[t:sDTIME, d:true],
		'$mediaId':[t:sSTR, d:true],
		'$mediaUrl':[t:sSTR, d:true],
		'$mediaType':[t:sSTR, d:true],
		'$mediaSize':[t:sINT, d:true],
		'$previousEventAttribute':[t:sSTR, v:null],
		'$previousEventDescription':[t:sSTR, v:null],
		'$previousEventDate':[t:sDTIME, v:null],
		'$previousEventDelay':[t:sINT, v:null],
		'$previousEventDevice':[t:sDEV, v:null],
		'$previousEventDeviceIndex':[t:sINT, v:null],
		'$previousEventDevicePhysical':[t:sBOOLN, v:null],
//		'$previousEventExecutionTime':[t:sINT, v:null],
//		'$previousEventReceived':[t:sDTIME, v:null],
		'$previousEventValue':[t:sDYN, v:null],
		'$previousEventUnit':[t:sSTR, v:null],
//		'$previousState':[t:sSTR, v:null],
//		'$previousStateDuration':[t:sSTR, v:null],
//		'$previousStateSince':[t:sDTIME, v:null],
		'$random':[t:sDCML, d:true],
		'$randomColor':[t:sSTR, d:true],
		'$randomColorName':[t:sSTR, d:true],
		'$randomLevel':[t:sINT, d:true],
		'$randomSaturation':[t:sINT, d:true],
		'$randomHue':[t:sINT, d:true],
		'$temperatureScale':[t:sSTR, d:true],
		'$tzName':[t:sSTR, d:true],
		'$tzId':[t:sSTR, d:true],
		'$tzOffset':[t:sINT, d:true],
		'$version':[t:sSTR, d:true],
		'$versionH':[t:sSTR, d:true]
	]
}

private getSystemVariableValue(Map rtD, String name){
	switch (name){
	case '$args': return "${rtD.args}".toString()
	case '$json': return "${rtD.json}".toString()
	case '$places': return "${rtD.settings?.places}".toString()
	case '$response': return "${rtD.response}".toString()
	case '$weather': return "${rtD.weather}".toString()
	case '$nfl': return "${rtD.nfl}".toString()
	case '$incidents': return "${rtD.incidents}".toString()
	case '$hsmTripped': return rtD.incidents instanceof List && (Integer)rtD.incidents.size()>0
	case '$hsmStatus': return (String)location.hsmStatus
	case '$mediaId': return rtD.mediaId
	case '$mediaUrl': return (String)rtD.mediaUrl
	case '$mediaType': return (String)rtD.mediaType
	case '$mediaSize': return (rtD.mediaData!=null ? (Integer)rtD.mediaData.size():0)
	case '$name': return (String)app.label
	case '$state': return (String)rtD.state?.new
	case '$tzName': return (String)location.timeZone.displayName
	case '$tzId': return (String)location.timeZone.getID()
	case '$tzOffset': return (Integer)location.timeZone.rawOffset
	case '$version': return version()
	case '$versionH': return HEversion()
	case '$localNow': //return (Long)localTime()
	case '$now':
	case '$utc': return (Long)now()
	case '$hour': Integer h=(Integer)localDate().hours; return (h==0 ? 12:(h>12 ? h-12:h))
	case '$hour24': return (Integer)localDate().hours
	case '$minute': return (Integer)localDate().minutes
	case '$second': return (Integer)localDate().seconds
	case '$zipCode': return location.zipCode
	case '$latitude': return location.latitude.toString()
	case '$longitude': return location.longitude.toString()
	case '$meridian': Integer h=(Integer)localDate().hours; return (h<12 ? 'AM' : 'PM')
	case '$meridianWithDots': Integer h=(Integer)localDate().hours; return (h<12 ? 'A.M.' : 'P.M.')
	case '$day': return (Integer)localDate().date
	case '$dayOfWeek': return (Integer)localDate().day
	case '$dayOfWeekName': return (String)weekDaysFLD[(Integer)localDate().day]
	case '$month': return (Integer)localDate().month+1
	case '$monthName': return (String)yearMonthsFLD[(Integer)localDate().month+1]
	case '$year': return (Integer)localDate().year+1900
	case '$midnight': return getMidnightTime()
	case '$noon': return getNoonTime()
	case '$sunrise': return getSunriseTime(rtD)
	case '$sunset': return getSunsetTime(rtD)
	case '$nextMidnight': return getNextMidnightTime()
	case '$nextNoon': return getNextNoonTime()
	case '$nextSunrise': return getNextSunriseTime(rtD)
	case '$nextSunset': return getNextSunsetTime(rtD)
	case '$time': Date t=localDate(); Integer h=(Integer)t.hours; Integer m=(Integer)t.minutes; return ((h==0 ? 12:(h>12 ? h-12:h))+sCOLON+(m<10 ? "0$m":"$m")+sSPC+(h <12 ? 'A.M.' : 'P.M.')).toString()
	case '$time24': Date t=localDate(); Integer h=(Integer)t.hours; Integer m=(Integer)t.minutes; return (h+sCOLON+(m<10 ? "0$m":"$m")).toString()
	case '$random':
		def tresult=getRandomValue(rtD, name)
		Double result
		if(tresult!=null)result=(Double)tresult
		else{
			result=(Double)Math.random()
			setRandomValue(rtD, name, result)
		}
		return result
	case '$randomColor':
		def tresult=getRandomValue(rtD, name)
		String result
		if(tresult!=null)result=(String)tresult
		else{
			result=(String)getRandomColor().rgb
			setRandomValue(rtD, name, result)
		}
		return result
	case '$randomColorName':
		def tresult=getRandomValue(rtD, name)
		String result
		if(tresult!=null)result=(String)tresult
		else{
			result=(String)getRandomColor().name
			setRandomValue(rtD, name, result)
		}
		return result
	case '$randomLevel':
		def tresult=getRandomValue(rtD, name)
		Integer result
		if(tresult!=null)result=(Integer)tresult
		else{
			result=(Integer)Math.round(100.0D*Math.random())
			setRandomValue(rtD, name, result)
		}
		return result
	case '$randomSaturation':
		def tresult=getRandomValue(rtD, name)
		Integer result
		if(tresult!=null)result=(Integer)tresult
		else{
			result=(Integer)Math.round(50.0D+50.0D*Math.random())
			setRandomValue(rtD, name, result)
		}
		return result
	case '$randomHue':
		def tresult=getRandomValue(rtD, name)
		Integer result
		if(tresult!=null)result=(Integer)tresult
		else{
			result=(Integer)Math.round(360.0D*Math.random())
			setRandomValue(rtD, name, result)
		}
		return result
	case '$locationMode':return (String)location.getMode()
	case '$temperatureScale':return (String)location.getTemperatureScale()
	}
}

private static void setSystemVariableValue(Map rtD, String name, value, Boolean cachePersist=true){
	Map<String,Object> var=(Map)rtD.systemVars[name]
	if(var==null)return
	if(cachePersist){
		if(name in [
			sDOLARGS,
			sHTTPCONTENT,
			sHTTPSTSCODE,
			sHTTPSTSOK,
			sIFTTTSTSCODE,
			sIFTTTSTSOK ]){

			LinkedHashMap<String,LinkedHashMap> t0=(LinkedHashMap)rtD.cachePersist
			t0[name]=[:]+var+[v:value]
			rtD.cachePersist=t0
		}
	}
	if(var.d!=null)return
	rtD.systemVars[name].v=value
}

private static getRandomValue(Map rtD, String name){
	return rtD.temp.randoms[name]
}

private static void setRandomValue(Map rtD, String name, value){
	rtD.temp.randoms[name]=value
}

private static void resetRandomValues(Map rtD){
	rtD.temp=[randoms:[:]]
}

private Map getColorByName(String name){
	Map t1=getColors().find{ (String)it.name==name }
	return t1
}

private Map getRandomColor(){
	Integer random=Math.round(Math.random()*((Integer)getColors().size()-1)*1.0D)
	Map t1=getColors()[random]
	return t1
}

private Class HubActionClass(){
	return 'hubitat.device.HubAction' as Class
}

private Class HubProtocolClass(){
	return 'hubitat.device.Protocol' as Class
}

/*private Boolean isHubitat(){
	return hubUID!=sNULL
}*/

@Field static Map<String,Map> theAttributesFLD

//uses i, p, t, m
private Map<String,Map<String,Object>> Attributes(){
	Map result=theAttributesFLD
	if(result==null){
		theAttributesFLD=(Map)parent.getChildAttributes()
	}
	return theAttributesFLD
}

@Field static Map<String,Map> theComparisonsFLD

//uses p, t
private Map<String,Map<String,Map<String,Object>>> Comparisons(){
	Map result=theComparisonsFLD
	if(result==null){
		theComparisonsFLD=(Map)parent.getChildComparisons()
	}
	return theComparisonsFLD
}

@Field static Map<String,Map> theVirtCommandsFLD

//uses o (override phys command), a (aggregate commands)
private Map<String,Map<String,Object>> VirtualCommands(){
	Map result=theVirtCommandsFLD
	if(result==null){
		theVirtCommandsFLD=(Map)parent.getChildVirtCommands()
	}
	return theVirtCommandsFLD
}

//uses c and r
// the physical command r: is replaced with command c. If the VirtualCommand c exists and has o: true we will use that virtual command; otherwise it will be replaced with a physical command
@Field static final Map CommandsOverrides=[
		push:[c:"push",	s:null, r:"pushMomentary"],
		flash:[c:"flash",	s:null, r:"flashNative"] //flash native command conflicts with flash emulated command. Also needs "o" option on command described later
]

@Field static Map<String,Map> theVirtDevicesFLD

//uses ac, o
private Map<String,Map<String,Object>> VirtualDevices(){
	Map result=theVirtDevicesFLD
	if(result==null){
		theVirtDevicesFLD=(Map)parent.getChildVirtDevices()
	}
	return theVirtDevicesFLD
}

@Field static Map<String,Map> thePhysCommandsFLD

//uses a, v
private Map<String,Map<String,Object>> PhysicalCommands(){
	Map result=thePhysCommandsFLD
	if(result==null){
		thePhysCommandsFLD=(Map)parent.getChildCommands()
	}
	return thePhysCommandsFLD
}

@Field static List<Map> theColorsFLD

private List<Map<String,Object>> getColors(){
	List result=theColorsFLD
	if(result==null){
		theColorsFLD=(List)parent.getColors()
	}
	return theColorsFLD
}
