/*
 *  webCoRE - Community's own Rule Engine - Web Edition for HE
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
 *  along with this program.  If not see <http://www.gnu.org/licenses/>.
 *
 * Last update December 28, 2021 for Hubitat
*/

//file:noinspection GroovySillyAssignment
//file:noinspection GrDeprecatedAPIUsage
//file:noinspection GroovyDoubleNegation
//file:noinspection GroovyUnusedAssignment
//file:noinspection unused

@Field static final String sVER='v0.3.113.20210203'
@Field static final String sHVER='v0.3.113.20211120_HE'

static String version(){ return sVER }
static String HEversion(){ return sHVER }

/** webCoRE DEFINITION	**/

static String handle(){ return 'webCoRE' }

import groovy.json.*
import hubitat.helper.RMUtils
import groovy.transform.Field

import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.concurrent.Semaphore

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

@Field static final String sPMAIN='pageMain'
@Field static final String sPRUN='pageRun'
@Field static final String sPCLR='pageClear'
@Field static final String sPCLRALL='pageClearAll'
@Field static final String sPDPIS='pageDumpPiston'
@Field static final String sPDPIS1='pageDumpPiston1'
preferences{
	page((sNM):sPMAIN)
	page((sNM):sPRUN)
	page((sNM):sPCLR)
	page((sNM):sPCLRALL)
	page((sNM):sPDPIS)
	page((sNM):sPDPIS1)
}

static Boolean eric(){ return false }
static Boolean eric1(){ return false }

//#include ady624.webCoRElib1

@Field static final String sNULL=(String)null
@Field static final String sSNULL='null'
@Field static final String sBOOLN='boolean'
@Field static final String sLONG='long'
@Field static final String sSTR='string'
@Field static final String sINT='integer'
@Field static final String sDEC='decimal'
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
@Field static final String sMODE='mode'
@Field static final String sID='id'
@Field static final String sBIN='bin'
@Field static final String sATHR='author'
@Field static final String sNM='name'
@Field static final String sTYPE='type'
@Field static final String sTIT='title'
@Field static final String sVAL='value'
@Field static final String sERROR='error'
@Field static final String sWARN='warn'
@Field static final String sDBG='debug'
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
@Field static final String sA='a'
@Field static final String sV='v'
@Field static final String sVT='vt'
@Field static final String sP='p'
@Field static final String sL='l'
@Field static final String sM='m'
@Field static final String sO='o'
@Field static final String sG='g'
@Field static final String sS='s'
@Field static final String sC='c'
@Field static final String sH='h'
@Field static final String sR='r'
@Field static final String sB='b'
@Field static final String sI='i'
@Field static final String sT='t'
@Field static final String sE='e'
@Field static final String sD='d'
@Field static final String sN='n'
@Field static final String sZ='z'
@Field static final String sX='x'
@Field static final String sMS='ms'
@Field static final String sLB='['
@Field static final String sRB=']'
@Field static final String sLRB='[]'
@Field static final String sAT='@'
@Field static final String sDLR='$'
@Field static final String sRULE='rule'
@Field static final String sHSMSTS='hsmStatus'
@Field static final String sHSMALRT='hsmAlert'
@Field static final String sHSMSARM='hsmSetArm'
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
@Field static final String sAPPFORM='application/x-www-form-urlencoded'
@Field static final String sASYNCREP='wc_async_reply'
@Field static final String sCHNK='chunk:'
@Field static final String sCLRC='clearc'
@Field static final String sCLRL='clearl'
@Field static final String sLOGNG='logging'
@Field static final String sGET='GET'
@Field static final String sDELETE='DELETE'
@Field static final String sHEAD='HEAD'
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
@Field static final String sLIFX='lifx'
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
@Field static final String s1='1'
@Field static final String s2='2'
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
@Field static final String sDOLJSON='$json'
@Field static final String sDOLRESP='$response'
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
@Field static final String sHNDLEVT='handleEvents'
@Field static final String sVALUEN='(value1, value2,..., valueN)'
@Field static final String sDATTRH='([device:attribute])'
@Field static final String sDATTRHT='([device:attribute] [,.., [device:attribute]],threshold)'
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
@Field static final String sUNDS='_'

@Field static final Long lZ=0L
@Field static final Integer iN1=-1
@Field static final Integer iN2=-2
@Field static final Integer iN3=-3
@Field static final Integer iN5=-5
@Field static final Integer iN9=-9
@Field static final Integer iZ=0
@Field static final Integer i1=1
@Field static final Integer i2=2
@Field static final Integer i3=3
@Field static final Integer i4=4
@Field static final Integer i5=5
@Field static final Integer i6=6
@Field static final Long lTHOUS=1000L
@Field static final Long lMSDAY=86400000L
@Field static final Double dZ=0.0D
@Field static final Double d1=1.0D
@Field static final Double d2=2.0D
@Field static final Double d100=100.0D
@Field static final Double d3d6=3.6D
@Field static final Double d1000=1000.0D
@Field static final Double d60=60.0D
@Field static final Double dSECHR=3600.0D
@Field static final Double dMSECHR=3600000.0D
@Field static final Double dMSMINT=60000.0D
@Field static final Double dMSDAY=86400000.0D

/** CONFIGURATION PAGES	**/

def pageMain(){
	return dynamicPage((sNM):sPMAIN,(sTIT):sBLK,install:true,uninstall:(Integer)state.build!=null){
		if(parent==null || !(Boolean)parent.isInstalled()){
			section(){
				paragraph 'Sorry you cannot install a piston directly from the HE console; please use the webCoRE dashboard (dashboard.webcore.co) instead.'
			}
			section(sectionTitleStr('Installing webCoRE')){
				paragraph 'If you are trying to install webCoRE please go back one step and choose webCoRE, not webCoRE Piston. You can also visit wiki.webcore.co for more information on how to install and use webCoRE'
				if(parent!=null){
					String t0=(String)parent.getWikiUrl()
					href sBLK,(sTIT):imgTitle('app-CoRE.png',inputTitleStr('More information')),description:t0,style:'external',url:t0,required:false
				}
			}
		}else{
			section(sectionTitleStr('General')){
				label([(sNM):sNM,(sTIT):'Name',required:true,state:(name ? 'complete':sNULL),defaultValue:(String)parent.generatePistonName(),submitOnChange:true])
			}

			section(sectionTitleStr('Dashboard')){
				String dashboardUrl=(String)parent.getDashboardUrl()
				if(dashboardUrl!=sNULL){
					dashboardUrl=dashboardUrl+'piston/'+hashId(sAppId())
					href sBLK,(sTIT):imgTitle('dashboard.png',inputTitleStr('View piston in dashboard')),style:'external',url:dashboardUrl,required:false
				}else paragraph 'Sorry your webCoRE dashboard does not seem to be enabled; please go to the parent app and enable the dashboard if needed.'
			}

			section(sectionTitleStr('Application Info')){
				LinkedHashMap<String,Object> rtD=getTemporaryRunTimeData()
				if(!(Boolean)rtD.enabled)paragraph 'Piston is disabled by webCoRE'
				if(!(Boolean)rtD.active)paragraph 'Piston is paused'
				if((String)rtD.bin!=sNULL){
					paragraph 'Automatic backup bin code: '+(String)rtD.bin
				}
				paragraph 'Version: '+sVER
				paragraph 'VersionH: '+sHVER
				paragraph 'Memory Usage: '+mem()
				paragraph 'RunTime History: '+runTimeHis(rtD)
				rtD=null
			}

			section(sectionTitleStr('Recovery')){
				href sPRUN,(sTIT):'Test run this piston'
				href sPCLR,(sTIT):'Clear logs',description:'This will remove logs but no variables'
				href sPCLRALL,(sTIT):'Clear all data',description:'This will reset all data stored in local variables'
			}

			section(){
				input 'dev',"capability.*",(sTIT):'Devices',description:'Piston devices',multiple:true
				input sLOGNG,sENUM,(sTIT):'Logging Level',options:["0":"None","1":"Minimal","2":"Medium","3":"Full"],description:'Piston logging',defaultValue:state.logging? state.logging.toString() : '0'
				input 'logsToHE',sBOOL,(sTIT):'Piston logs are also displayed in HE console logs?',description:"Logs are available in webCoRE console; also display in HE console 'Logs'?",defaultValue:false
				input 'maxStats',sNUMBER,(sTIT):'Max number of timing history stats',description:'Max number of stats',range:'2..300',defaultValue:50
				input 'maxLogs',sNUMBER,(sTIT):'Max number of history logs',description:'Max number of logs',range:'0..300',defaultValue:50
			}
			if(eric() || settings.logging?.toInteger()>i2){
				section('Debug'){
					href sPDPIS,(sTIT):'Dump piston structure',description:sBLK
					href sPDPIS1,(sTIT):'Dump cached piston structure',description:sBLK
				}
			}
		}
	}
}

def pageRun(){
	test()
	return dynamicPage((sNM):sPRUN,(sTIT):sBLK,uninstall:false){
		section('Run'){
			paragraph 'Piston tested'
			Map<String,String> t0=(Map)parent.getWCendpoints()
			String t1="/execute/${hashId(sAppId())}?access_token=${t0.at}".toString()
			paragraph "Cloud Execute endpoint ${t0.ep}${t1}".toString()
			paragraph "Local Execute endpoint ${t0.epl}${t1}".toString()
		}
	}
}

def pageClear(){
	clear1(false,true,true,false)
	return dynamicPage((sNM):sPCLR,(sTIT):sBLK,uninstall:false){
		section('Clear'){
			paragraph 'All non-essential data has been cleared.'
		}
	}
}

void clear1(Boolean ccache=false,Boolean some=true,Boolean most=false,Boolean all=false,Boolean reset=false){
	String meth='clear1'
	if(some)state.logs=[]
	if(most){ state.trace=[:];state.stats=[:] }
	if(reset){app.clearSetting('maxLogs'); app.clearSetting('maxStats')}
	if(all){
		meth +=' all'
		LinkedHashMap<String,Object> tRtData=getTemporaryRunTimeData()
		Boolean act=(Boolean)tRtData.active
		Boolean dis=!(Boolean)tRtData.enabled
		tRtData=null
		state.cache=[:]
		state.vars=[:]
		state.store=[:]
		state.pauses=lZ
		clearMyCache(meth)

		String semaName=sAppId()
		getTheLock(semaName,meth)
		theSemaphoresVFLD[semaName]=lZ
		theSemaphoresVFLD=theSemaphoresVFLD
		theQueuesVFLD[semaName]=[]
		theQueuesVFLD=theQueuesVFLD // this forces volatile cache flush
		releaseTheLock(semaName)

		if(act && !dis){
			tRtData=getTemporaryRunTimeData()
			LinkedHashMap rtD=getRunTimeData(tRtData,null,true,true) //reinitializes cache variables; caches piston
			rtD=null
			tRtData=null
		}
	}
	clearMyCache(meth)
	if(ccache) clearMyPiston(meth)
}

def pageClearAll(){
	clear1(true,true,true,true)
	return dynamicPage((sNM):sPCLRALL,(sTIT):sBLK,uninstall:false){
		section('Clear All'){
			paragraph 'All local data has been cleared.'
		}
	}
}

static String dumpListDesc(data,Integer level,List<Boolean> lastLevel,String listLabel,Boolean html=false){
	String str=sBLK
	Integer cnt=i1
	List<Boolean> newLevel=lastLevel

	List list1=data?.collect{it}
	Integer sz=list1.size()
	String sSP='<span>'
	String sSSP='</span>'
	list1?.each{ par ->
		Integer t0=cnt-i1
		String myStr="${listLabel}[${t0}]".toString()
		if(par instanceof Map){
			Map newmap=[:]
			newmap[myStr]=(Map)par
			Boolean t1= cnt==sz
			newLevel[level]=t1
			str+=dumpMapDesc(newmap,level,newLevel,!t1,html)
		}else if(par instanceof List || par instanceof ArrayList){
			Map newmap=[:]
			newmap[myStr]=par
			Boolean t1= cnt==sz
			newLevel[level]=t1
			str+=dumpMapDesc(newmap,level,newLevel,!t1,html)
		}else{
			String lineStrt='\n'
			for(Integer i=iZ; i<level; i++){
				lineStrt+= (i+i1<level)? (!lastLevel[i] ? '     │' : '      '):'      '
			}
			lineStrt+= (cnt==i1 && sz>i1)? '┌─ ':(cnt<sz ? '├─ ' : '└─ ')
			if(html)str+= sSP
			str+= "${lineStrt}${listLabel}[${t0}]: ${par} (${getObjType(par)})".toString()
			if(html)str+= sSSP
		}
		cnt+=i1
	}
	return str
}

@SuppressWarnings('GrReassignedInClosureLocalVar')
static String dumpMapDesc(data,Integer level,List<Boolean> lastLevel,Boolean listCall=false,Boolean html=false){
	String str=sBLK
	String sSP='<span>'
	String sSSP='</span>'
	Integer cnt=i1
	Integer sz=data?.size()
	Map newMap=[:]
	Map svMap=[:]
	Map svLMap=[:]
	data?.each{ par ->
		if(par.value instanceof Map){
			svMap+= [(par.key): par.value]
		} else if(par.value instanceof List || par.value instanceof ArrayList){
			svLMap+= [(par.key): par.value]
		} else newMap+= [(par.key):par.value]
	}
	newMap+=svMap+svLMap
	Integer lvlpls=level+i1
	newMap?.each{ par ->
		String lineStrt
		List<Boolean> newLevel=lastLevel
		Boolean thisIsLast= cnt==sz && !listCall
		if(level>iZ){
			newLevel[(level-i1)]=thisIsLast
		}
		Boolean theLast=thisIsLast
		if(level==iZ){
			lineStrt='\n\n • '
		}else{
			theLast= theLast && thisIsLast
			lineStrt='\n'
			for(Integer i=iZ; i<level; i++){
				lineStrt+= (i+i1<level)? (!newLevel[i] ? '     │' : '      '):'      '
			}
			lineStrt+= ((cnt<sz || listCall) && !thisIsLast) ? '├─ ' : '└─ '
		}
		String objType=getObjType(par.value)
		if(par.value instanceof Map){
			if(html)str+= sSP
			str+= "${lineStrt}${(String)par.key}: (${objType})".toString()
			if(html)str+= sSSP
			newLevel[lvlpls]=theLast
			str+= dumpMapDesc((Map)par.value,lvlpls,newLevel,false,html)
		}
		else if(par.value instanceof List || par.value instanceof ArrayList){
			if(html)str+= sSP
			str+= "${lineStrt}${(String)par.key}: [${objType}]".toString()
			if(html)str+= sSSP
			newLevel[lvlpls]=theLast
			str+= dumpListDesc(par.value,lvlpls,newLevel,sBLK,html)
		}
		else{
			if(html)str+= sSP
			str+= "${lineStrt}${(String)par.key}: (${par.value}) (${objType})".toString()
			if(html)str+= sSSP
		}
		cnt+=i1
	}
	return str
}

static String getObjType(obj){
	return "<span style='color:orange'>"+myObj(obj)+"</span>"
}

static String getMapDescStr(data){
	String str
	List<Boolean> lastLevel=[true]
	str=dumpMapDesc(data,0,lastLevel,false,true)
	return str!=sBLK ? str:'No Data was returned'
}

def pageDumpPiston1(){
	LinkedHashMap rtD=getRunTimeData()
	LinkedHashMap pis=recreatePiston(true,true)
	rtD.piston=pis
	subscribeAll(rtD,false)
	String message=getMapDescStr((Map)rtD.piston)
	rtD=null
	pis=null
	return dynamicPage((sNM):sPDPIS1,(sTIT):sBLK,uninstall:false){
		section('Cached Piston dump'){
			paragraph message
		}
	}
}

def pageDumpPiston(){
	LinkedHashMap rtD=getRunTimeData()
	String message=getMapDescStr((Map)rtD.piston)
	rtD=null
	return dynamicPage((sNM):sPDPIS,(sTIT):sBLK,uninstall:false){
		section('Full Piston dump'){
			paragraph message
		}
	}
}

void installed(){
	if(app.id==null)return
	Long t=(Long)now()
	state.created=t
	state.modified=t
	state.build=iZ
	state.vars=(Map)state.vars ?: [:]
	state.subscriptions=(Map)state.subscriptions ?: [:]
	state.logging=iZ
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
	svSunTFLD=null; mb()
	String tt1=(String)settings.logging
	Integer tt2=(Integer)state.logging
	String tt3=tt2.toString()
	Map a
	if(tt1==sNULL)a=setLoggingLevel(tt2 ? tt3:'0',false)
	else if(tt1!=tt3)a=setLoggingLevel(tt1,false)
	if((Boolean)state.active)a=resume()
	else{
		cleanState()
		clearMyCache('initialize')
	}
}

@Field static final List<String> clST=['hash','piston','cVersion','hVersion','disabled','logPExec','settings','svSunT','temp','debugLevel']

void cleanState(){
//cleanups between releases
	for(sph in ((Map<String,Object>)state).findAll{ ((String)it.key).startsWith('sph')})state.remove(sph.key.toString())
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
			(sID): (String)rtD.id,
			(sATHR): (String)rtD.author,
			(sNM): (String)rtD.name,
			created: (Long)rtD.created,
			modified: (Long)rtD.modified,
			build: (Integer)rtD.build,
			(sBIN): (String)rtD.bin,
			active: (Boolean)rtD.active,
			category: rtD.category
		],
		piston: (LinkedHashMap)rtD.piston
	]+(minimal ? [:]:[ // use state as getRunTimeData re-initializes these
		systemVars: getSystemVariablesAndValues(rtD),
		subscriptions: (Map)state.subscriptions,
		state: (Map)state.state,
		(sLOGNG): state.logging!=null ? (Integer)state.logging:iZ,
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
	Integer lsz=logs.size()
	Long llt=lastLogTimestamp!=null && lastLogTimestamp instanceof String && ((String)lastLogTimestamp).isLong()? ((String)lastLogTimestamp).toLong():lZ
	Integer index=(llt!=lZ && lsz>iZ)? logs.findIndexOf{ it?.t==llt }:iZ
	index=index>iZ ? index:(llt!=lZ ? iZ:lsz)
	Map rVal=[
		(sNM): (String)t0.name,
		state: (Map)t0.state,
		logs: index>iZ ? logs[0..index-i1]:[],
		trace: (Map)t0.trace,
		localVars: (Map)t0.vars,// not reporting global or system variable changes
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
	Map st=[:]+(Map)t0.state
	def a=st.remove('old')
	Map rVal=[
		(sA):(Boolean)t0.active,
		(sC):t0.category,
		(sT):(Long)t0.lastExecuted,
		(sN):(Long)t0.nextSchedule,
		(sZ):(String)t0.pistonZ,
		(sS):st,
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
	return value.replaceAll(/(\:%[0-9A-F]{2}%[0-9A-F]{2}%[0-9A-F]{2}%[0-9A-F]{2}\:)/,{ m -> URLDecoder.decode(m[0].substring(1,13),'UTF-8')})
}

@Field static Map<String,Map> thePistonCacheFLD=[:]

private void clearMyPiston(String meth=sNULL){
	String pisName=sAppId()
	if(pisName.length()==iZ)return
	Boolean cleared=false
	Map pData=(Map)thePistonCacheFLD[pisName]
	if(pData!=null){
		LinkedHashMap<String,Object> t0=(LinkedHashMap<String,Object>)pData.pis
		if(t0){
			thePistonCacheFLD[pisName].pis=null
			mb()
			cleared=true
		}
	}
	if(cleared && eric()){
		log.debug 'clearing piston-code-cache '+meth
		dumpPCsize()
	}
}

private LinkedHashMap recreatePiston(Boolean shorten=false,Boolean useCache=true){
	if(shorten && useCache){
		String pisName=sAppId()
		Map pData=(Map)thePistonCacheFLD[pisName]
		if(pData==null || pData.cnt==null){
			pData=[cnt:iZ,pis:null]
			thePistonCacheFLD[pisName]=pData
			mb()
		}
		//pData.cnt+=i1
		if(pData.pis!=null)return (LinkedHashMap)(pData.pis+[cached:true])
	}

	if(eric())log.debug "recreating piston $shorten $useCache"
	String sdata=sBLK
	Integer i=iZ
	String s
	while(true){
		s=(String)settings."${sCHNK}$i"
		if(s!=sNULL)sdata+= s
		else break
		i++
	}
	if(sdata!=sBLK){
		def data=(LinkedHashMap)new JsonSlurper().parseText(decodeEmoji(new String(sdata.decodeBase64(),'UTF-8')))
		LinkedHashMap<String,Object> piston=[
			(sO): data.o ?: [:],
			(sR): data.r ?: [],
			rn: !!data.rn,
			rop: data.rop ?: sAND,
			(sS): data.s ?: [],
			(sV): data.v ?: [],
			(sZ): data.z ?: sBLK
		]
		state.pistonZ=(String)piston.z
		clearMsetIds(piston)
		Integer a=msetIds(shorten,piston)
		return piston
	}
	return [:]
}

Map setup(LinkedHashMap data,Map<String,String>chunks){
	if(data==null){
		log.error 'setup: no data'
		return [:]
	}
	String meth='setup'
	clearMyCache(meth)

	String semaName=sAppId()
	getTheLock(semaName,meth)

	state.modified=(Long)now()
	state.build=(Integer)state.build!=null ? (Integer)state.build+i1:i1
	LinkedHashMap<String,Object> piston=[
		o: data.o ?: [:],
		r: data.r ?: [],
		rn: !!data.rn,
		rop: data.rop ?: sAND,
		s: data.s ?: [],
		(sV): data.v ?: [],
		(sZ): data.z ?: sBLK
	]
	clearMyPiston(meth)
	clearMsetIds(piston)
	Integer a=msetIds(false,piston)

	for(chunk in ((Map<String,Object>)settings).findAll{ ((String)it.key).startsWith(sCHNK) && !chunks[(String)it.key] }){
		app.clearSetting((String)chunk.key)
	}
	for(chunk in chunks)app.updateSetting((String)chunk.key,[(sTYPE):sTEXT,(sVAL):chunk.value])
	app.updateSetting(sBIN,[(sTYPE):sTEXT,(sVAL):(String)state.bin ?: sBLK])
	app.updateSetting(sATHR,[(sTYPE):sTEXT,(sVAL):(String)state.author ?: sBLK])

	state.pep=(Integer)piston.o?.pep ? true:false // parallel execute piston

	String lbl=(String)data.n
	if(lbl){
		state.svLabel=lbl
		atomicState.svLabel=lbl
		app.updateLabel(lbl)
	}
	state.schedules=[]
	state.vars=(Map)state.vars ?: [:]
	state.modifiedVersion=sVER

	state.cache=[:]
	state.logs=[]
	state.trace=[:]

	Map rtD=[:]
	rtD.piston=piston
	releaseTheLock(semaName)
	if((Integer)state.build==i1 || (Boolean)state.active)rtD=resume(piston)
	else clearMyCache(meth)
	return [active:(Boolean)state.active,build:(Integer)state.build,modified:(Long)state.modified,state:(Map)state.state,rtData:rtD]
}

private void clearMsetIds(node){
	if(node==null)return
	for(list in node.findAll{ it.value instanceof List }){
		for(item in ((List)list.value).findAll{ it instanceof Map })clearMsetIds(item)
	}
	if(node instanceof Map && node[sDLR]!=null) node[sDLR]=null

	for(item in node.findAll{ it.value instanceof Map })clearMsetIds(item.value)
}

@Field static List<String> ListCmd=[]

private Integer msetIds(Boolean shorten,node,Integer mId=0,Map<String,Integer> existingIds=[:],List<Map> requiringIds=[],Integer level=iZ){
	List<Map> nodeE=node?.ei
	String nodeT=node?.t
	Integer maxId=mId
	//Boolean lg= eric() && settings.logging?.toInteger()>i2
	if(!ListCmd) ListCmd=[sIF,sACTION,sCONDITION,sWHILE,sREPEAT,sFOR,sEACH,sSWITCH,sEVERY,sRESTRIC,sGROUP,sDO,sON,sEVENT,sEXIT,sBREAK]
	if(nodeT in ListCmd){
		Integer id=node[sDLR]!=null ? (Integer)node[sDLR] :iZ
		if(id==iZ || existingIds[id.toString()]!=null){
			Boolean a=requiringIds.push(node)
			//if(lg) log.warn "adding id for node $nodeT ${existingIds}"
		}else{
			maxId=maxId<id ? id:maxId
			existingIds[id.toString()]=id
		}
		if(nodeT==sIF && nodeE){
			Boolean a=((List<Map>)node.ei).removeAll{ Map it -> !it.c && !it.s }
			for(Map elseIf in (List<Map>)node.ei){
				id=elseIf[sDLR]!=null ? (Integer)elseIf[sDLR]:iZ
				if(id==iZ || existingIds[id.toString()]!=null) Boolean aa=requiringIds.push(elseIf)
				else{
					maxId=maxId<id ? id:maxId
					existingIds[id.toString()]=id
				}
			}
		}
		if(nodeT==sSWITCH && node.cs){
			for(Map _case in (List<Map>)node.cs){
				id=_case[sDLR]!=null ? (Integer)_case[sDLR]:iZ
				if(id==iZ || existingIds[id.toString()]!=null) Boolean a=requiringIds.push(_case)
				else{
					maxId=maxId<id ? id:maxId
					existingIds[id.toString()]=id
				}
			}
		}
		if(nodeT==sACTION && node.k){
			for(Map task in (List<Map>)node.k){
				id=task[sDLR]!=null ? (Integer)task[sDLR]:iZ
				if(id==iZ || existingIds[id.toString()]!=null) Boolean a=requiringIds.push(task)
				else{
					maxId=maxId<id ? id:maxId
					existingIds[id.toString()]=id
				}
			}
		}
	}
	for(list in node.findAll{ it.value instanceof List }){
		for(item in ((List)list.value).findAll{ it instanceof Map })maxId=msetIds(shorten,item,maxId,existingIds,requiringIds,level+i1)
	}
	if(level==iZ){
		//if(lg) log.warn "start id $maxId"
		for(item in requiringIds){
			maxId+= i1
			item[sDLR]=maxId
			/*if(eric() && settings.logging?.toInteger()>i2){
				String ty=item?.t
				if(!ty) ty=item?.c
				if(!ty) ty="case / elseif"
				if(lg) log.warn "adding id $maxId for node ${ty}"
			}*/
		}
		if(shorten)cleanCode(node)
	}
	return maxId
}

@Field static List<String> ListC1=[]
@Field static List<String> ListC2=[]
@Field static List<String> ListC3=[]

private void cleanCode(item){
	if(item==null || !(item instanceof Map))return

	if(!ListC1){
		// sP phys/avg sD, sV virt, sS preset, sX variable, sC constant, sE expr, 'u' argument
		ListC1=[sC,sS,sV,sE]	// not adjusting sP phys, sD device, sX var, u arg
		ListC2=[sC,sS,sX,sV,sE]	//sD device, sP phys, u arg
		ListC3=[sS,sX,sV,sE]	// sD, sP, sC (const), u
		if(!LT1){ LT1=fill_TIM() }
		mb()
	}
	String av='avg'
	def a
	String ty=(String)item.t
	if(ty in ListC2) // operand values that don't need d
		if(item.d instanceof List)a=item.remove(sD)
	if(ty in ListC3 || (ty==sC && !((String)item.vt in LT1)) ) // operand values that don't need c
		a=item.remove(sC)
	if(ty==sNULL && item.size()==i4 && item.d instanceof List && !item.d && (String)item.g==av && item.f==sL && item.vt){
		a=item.remove(sD); a=item.remove(sG)
	}
	if(ty in ListC1){ // operand values that don't need g,a
		if((String)item.g==av)a=item.remove(sG)
		if(item.a instanceof String)a=item.remove(sA)
	}
	if(ty==sX && (String)item.vt!=sDEV) // operand values that don't need f, g
		if((String)item.g==av)a=item.remove(sG)
	if((String)item.f==sL)a=item.remove('f')
	if(item.fs instanceof List && !item.fs)a=item.remove('fs')
	if(item.ts instanceof List && !item.ts)a=item.remove('ts')
	if(item.e instanceof List && !item.e)a=item.remove(sE)
	if(item.ei instanceof List && !item.ei)a=item.remove('ei')
	if(item.s instanceof List && !item.s)a=item.remove(sS)
	if(item.r instanceof List && !item.r)a=item.remove(sR)
	if(item.d instanceof List && !item.d)a=item.remove(sD)

	if(item.str!=null)a=item.remove('str')
	if(item.ok!=null)a=item.remove('ok')
	if(item.z!=null)a=item.remove(sZ)
	if(item.zc!=null)a=item.remove('zc')
	if(item.e!=null && item.e instanceof String)a=item.remove(sE)
	if(item.l!=null && item.l instanceof String)a=item.remove(sL)

	if(item.v!=null)cleanCode(item.v)
	if(item.exp!=null)cleanCode(item.exp)
	if(item.lo!=null)cleanCode(item.lo)
	if(item.lo2!=null)cleanCode(item.lo2)
	if(item.lo3!=null)cleanCode(item.lo3)
	if(item.ro!=null){
		if(item.ro instanceof String || fndEmptyOper((Map)item.ro))a=item.remove('ro')
		else cleanCode(item.ro)
	}
	if(item.ro2!=null){
		if(fndEmptyOper((Map)item.ro2))a=item.remove('ro2')
		else cleanCode(item.ro2)
	}
	if(item.to!=null){
		if(fndEmptyOper((Map)item.to))a=item.remove('to')
		else cleanCode(item.to)
	}
	if(item.to2!=null){
		if(fndEmptyOper((Map)item.to2))a=item.remove('to2')
		else cleanCode(item.to2)
	}
	for(list in item.findAll{ it.value instanceof List }){
		for(itemA in ((List)list.value).findAll{ it instanceof Map })cleanCode(itemA)
	}
}

static Boolean fndEmptyOper(Map oper){
	if(oper.size()==i3 && (String)oper.t==sC && !oper.d && (String)oper.g==sANY)return true
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
		if(act && !dis) app.updateLabel(savedLabel)
		if(!act || dis){
			String tstr='(Paused)'
			if(act && dis) tstr='(Disabled) Kill switch is active'
			String res=appLbl+" <span style='color:orange'>"+tstr+"</span>"
			app.updateLabel(res)
		}
	}
}

void config(Map data){ // creates a new piston
	if(data==null)return
	if((String)data.bin!=sNULL){
		state.bin=(String)data.bin
		app.updateSetting(sBIN,[(sTYPE):sTEXT,(sVAL):(String)state.bin])
	}
	if((String)data.author!=null){
		state.author=(String)data.author
		app.updateSetting(sATHR,[(sTYPE):sTEXT,(sVAL):(String)state.author])
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
	app.updateSetting(sBIN,[(sTYPE):sTEXT,(sVAL):bin])
	String typ='setBin'
	clearMyCache(typ)
	return [:]
}

Map pausePiston(){
	state.active=false
	clearMyCache('pauseP')

	LinkedHashMap rtD=getRunTimeData()
	Boolean lg= (Integer)rtD.logging>iZ
	Map msg
	if(lg){
		info 'Stopping piston...',rtD,iZ
		msg=timer 'Piston successfully stopped',rtD,iN1
	}
	state.schedules=[]
	rtD.stats.nextSchedule=lZ
	rtD.nextSchedule=lZ
	state.nextSchedule=lZ
	unsubscribe()
	unschedule()
//	state.trace=[:]
	state.subscriptions=[:]
	if(lg)//noinspection GroovyVariableNotAssigned
		info msg,rtD
	updateLogs(rtD)
	state.active=false
	state.state=[:]+(Map)rtD.state
	def a=state.remove('lastEvent')
	clear1(true,false,false,false)	// calls clearMyCache(meth) && clearMyPiston
	Map nRtd=shortRtd(rtD)
	rtD=null
	return nRtd
}

Map resume(LinkedHashMap piston=null){
	state.active=true
	state.subscriptions=[:]
	state.schedules=[]

	String semName=sAppId()
	getTheLock(semName,'resume')
	theSemaphoresVFLD[semName]=lZ
	theSemaphoresVFLD=theSemaphoresVFLD
	theQueuesVFLD[semName]=[]
	theQueuesVFLD=theQueuesVFLD
	releaseTheLock(semName)

	clearMyCache('resumeP')

	LinkedHashMap<String,Object> tmpRtD=getTemporaryRunTimeData()
	Map msg=timer 'Piston successfully started',tmpRtD,iN1
	if(piston!=null)tmpRtD.piston=piston
	LinkedHashMap rtD=getRunTimeData(tmpRtD,null,true,false) //performs subscribeAll(rtD); reinitializes cache variables
	Boolean lg= (Integer)rtD.logging>iZ
	if(lg)info 'Starting piston... ('+sHVER+')',rtD,iZ
	checkVersion(rtD)
	if(lg)info msg,rtD
	updateLogs(rtD)
	state.state=[:]+(Map)rtD.state
	Map nRtd=shortRtd(rtD)
	nRtd.result=[active:true,subscriptions:(Map)state.subscriptions]
	tmpRtD=null
	rtD=null
	return nRtd
}

static Map shortRtd(Map rtD){
	Map st=[:]+(Map)rtD.state
	def a=st.remove('old')
	Map myRt=[
		(sID):(String)rtD.id,
		active:(Boolean)rtD.active,
		category:rtD.category,
		stats:[
			nextSchedule:(Long)rtD.nextSchedule
		],
		piston:[
			(sZ):(String)rtD.pistonZ
		],
		state:st,
		Cached:(Boolean)rtD.Cached ?: false
	]
	return myRt
}

Map setLoggingLevel(String level,Boolean clearC=true){
	Integer mlogging=level.isInteger()? level.toInteger():iZ
	mlogging=Math.min(Math.max(iZ,mlogging),i3)
	app.updateSetting(sLOGNG,[(sTYPE):sENUM,(sVAL):mlogging.toString()])
	state.logging=mlogging
	if(mlogging==iZ)state.logs=[]
	if(clearC) clearMyCache('setLoggingLevel')
	return [(sLOGNG):mlogging]
}

Map setCategory(String category){
	state.category=category
	clearMyCache('setCategory')
	return [category:category]
}

Map test(){
	handleEvents([(sDATE):new Date(),(sDEV):location,(sNM):'test',(sVAL):now()])
	return [:]
}

Map execute(data,source){
	handleEvents([(sDATE):new Date(),(sDEV):location,(sNM):'execute',(sVAL): source!=null ? source:now(),jsonData:data],false)
	return [:]
}

Map clickTile(index){
	handleEvents([(sDATE):new Date(),(sDEV):location,(sNM):'tile',(sVAL):index])
	return (Map)state.state ?: [:]
}

Map clearCache(){
	handleEvents([(sDATE):new Date(),(sDEV):location,(sNM):sCLRC,(sVAL):now()])
	return [:]
}

Map clearLogsQ(){
	handleEvents([(sDATE):new Date(),(sDEV):location,(sNM):sCLRL,(sVAL):now()])
	return [:]
}

private Map getCachedAtomicState(){
	Long atomStart=(Long)now()
	def atomState
	atomicState.loadState()
	atomState=atomicState.@backingMap
	if(settings.logging?.toInteger()>i2)log.debug "AtomicState generated in ${elapseT(atomStart)}ms"
	return atomState
}

@Field volatile static Map<String,Long> lockTimesVFLD=[:]
@Field volatile static Map<String,String> lockHolderVFLD=[:]

void getTheLock(String qname,String meth=sNULL,Boolean longWait=false){
	Boolean a=getTheLockW(qname,meth,longWait)
}

Boolean getTheLockW(String qname,String meth=sNULL,Boolean longWait=false){
	Long waitT=longWait? lTHOUS:60L
	Boolean wait=false
	Integer semaNum=getSemaNum(qname)
	String semaSNum=semaNum.toString()
	Semaphore sema=getSema(semaNum)
	while(!(sema.tryAcquire())){
		// did not get the lock
		Long t=lockTimesVFLD[semaSNum]
		if(t==null){
			t=(Long)now()
			lockTimesVFLD[semaSNum]=t
			lockTimesVFLD=lockTimesVFLD
		}
		if(eric())log.warn "waiting for ${qname} ${semaSNum} lock access, $meth, long: $longWait, holder: ${(String)lockHolderVFLD[semaSNum]}"
		pauseExecution(waitT)
		wait=true
		if(elapseT(t)>30000L){
			releaseTheLock(qname)
			if(eric())log.warn "overriding lock $meth"
		}
	}
	lockTimesVFLD[semaSNum]=(Long)now()
	lockTimesVFLD=lockTimesVFLD
	lockHolderVFLD[semaSNum]=sAppId()+sSPC+meth
	lockHolderVFLD=lockHolderVFLD
	return wait
}

void releaseTheLock(String qname){
	Integer semaNum=getSemaNum(qname)
	String semaSNum=semaNum.toString()
	Semaphore sema=getSema(semaNum)
	lockTimesVFLD[semaSNum]=null
	lockTimesVFLD=lockTimesVFLD
//	lockHolderVFLD[semaSNum]=sNULL
//	lockHolderVFLD=lockHolderVFLD
	sema.release()
}

@Field static Semaphore theLock0FLD=new Semaphore(1)
@Field static Semaphore theLock1FLD=new Semaphore(1)
@Field static Semaphore theLock2FLD=new Semaphore(1)
@Field static Semaphore theLock3FLD=new Semaphore(1)
@Field static Semaphore theLock4FLD=new Semaphore(1)
@Field static Semaphore theLock5FLD=new Semaphore(1)
@Field static Semaphore theLock6FLD=new Semaphore(1)
@Field static Semaphore theLock7FLD=new Semaphore(1)
@Field static Semaphore theLock8FLD=new Semaphore(1)
@Field static Semaphore theLock9FLD=new Semaphore(1)
@Field static Semaphore theLock10FLD=new Semaphore(1)
@Field static Semaphore theLock11FLD=new Semaphore(1)
@Field static Semaphore theLock12FLD=new Semaphore(1)
@Field static Semaphore theLock13FLD=new Semaphore(1)
@Field static Semaphore theLock14FLD=new Semaphore(1)
@Field static Semaphore theLock15FLD=new Semaphore(1)
@Field static Semaphore theLock16FLD=new Semaphore(1)
@Field static Semaphore theLock17FLD=new Semaphore(1)
@Field static Semaphore theLock18FLD=new Semaphore(1)
@Field static Semaphore theLock19FLD=new Semaphore(1)
@Field static Semaphore theLock20FLD=new Semaphore(1)
@Field static Semaphore theLock21FLD=new Semaphore(1)
@Field static Semaphore theLock22FLD=new Semaphore(1)
@Field static Semaphore theLock23FLD=new Semaphore(1)
@Field static Semaphore theLock24FLD=new Semaphore(1)

static Integer getSemaNum(String name){
	if(name==sTCCC)return 22
	if(name==sTSLF)return 23
	if(name==sTGBL)return 24
	Integer stripes=22
	if(name.isNumber())return name.toInteger()%stripes
	Integer hash=smear(name.hashCode())
	return Math.abs(hash)%stripes
//	if(eric())log.info "sema $name # $sema"
}

Semaphore getSema(Integer snum){
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
		default:log.error "bad hash result $snum"
			return null
	}
}

private static Integer smear(Integer hashC){
	Integer hashCode=hashC
	hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12)
	return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4)
}

void getCacheLock(String meth=sNULL){
	getTheLock(sTCCC,meth+sSPC+sTCL)
}

void releaseCacheLock(){
	releaseTheLock(sTCCC)
}

@Field volatile static Map<String,List<Map>> theQueuesVFLD=[:]
@Field volatile static Map<String,Long> theSemaphoresVFLD=[:]

// This can a) lock semaphore b) wait for semaphore c) queue event d) just fall through (no locking or waiting)
private Map lockOrQueueSemaphore(Boolean synchr,event,Boolean queue,Map rtD){
	Long tt1=(Long)now()
	Long startTime=tt1
	Long r_semaphore=lZ
	Long semaphoreDelay=lZ
	String semaphoreName=sNULL
	Boolean didQ=false
	Boolean waited=false

	if(synchr){
		String semaName=sAppId()
		waited=getTheLockW(semaName,sLCK1)
		tt1=(Long)now()

		Long lastSemaphore
		Boolean clearC=false
		Integer qsize=iZ
		while(true){
			Long t0=theSemaphoresVFLD[semaName]
			Long tt0=t0!=null ? t0:lZ
			lastSemaphore=tt0
			if(lastSemaphore==lZ || tt1-lastSemaphore>100000L){
				theSemaphoresVFLD[semaName]=tt1
				theSemaphoresVFLD=theSemaphoresVFLD
				semaphoreName=semaName
				semaphoreDelay=waited ? tt1-startTime:lZ
				r_semaphore=tt1
				break
			}
			if(queue){
				if(event!=null){
					Map myEvent=[
						(sT):((Date)event.date).getTime(),
						(sNM):(String)event.name,
						(sVAL):event.value,
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
						myEvent.device=[(sID):event.device?.id,(sNM):event.device?.name,label:event.device?.label]
						if(event.device?.hubs!=null){
							myEvent.device.hubs=[(sT):'tt']
						}
					}
					List<Map> evtQ=theQueuesVFLD[semaName]
					evtQ=evtQ!=null ? evtQ:[]
					qsize=evtQ.size()
					if(qsize>12) clearC=true
					else{
						Boolean a=evtQ.push(myEvent)
						theQueuesVFLD[semaName]=evtQ
						theQueuesVFLD=theQueuesVFLD
						didQ=true
					}
				}
				break
			}else{
				releaseTheLock(semaName)
				waited=true
				pauseExecution(100L)
				getTheLock(semaName,sLCK2)
				tt1=(Long)now()
			}
		}
		releaseTheLock(semaName)
		if(clearC){
			error "large queue size ${qsize} clearing",rtD
			clear1(true,true,true,true)
		}
	}
	return [
		semaphore:r_semaphore,
		semaphoreName:semaphoreName,
		semaphoreDelay:semaphoreDelay,
		waited:waited,
		exitOut:didQ
	]
}

private LinkedHashMap<String,Object> getTemporaryRunTimeData(Long startTime=(Long)now()){
	if(thePhysCommandsFLD==null){ //do one time load once
		String semName=sTSLF
		getTheLock(semName,sGETTRTD,true)
		if(thePhysCommandsFLD==null){ // load caches
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
	rtD.logs=[[(sT):startTime]]
	rtD.debugLevel=iZ
	rtD.eric=eric1() && (Integer)rtD.logging>i2
	return rtD
}

@Field volatile static LinkedHashMap<String,LinkedHashMap<String,Object>> theCacheVFLD=[:] // each piston has a map

private void clearMyCache(String meth=sNULL){
	Boolean clrd=false
	String appStr=sAppId()
	String myId=hashId(appStr)
	if(!myId)return
	String semaName=appStr
	String str='clearMyCache'
	getTheLock(semaName,str)
	getCacheLock(str)
	Map t0=theCacheVFLD[myId]
	if(t0){
		theCacheVFLD[myId]=null
		theCacheVFLD=theCacheVFLD
		clrd=true
		t0=null
	}
	releaseCacheLock()
	releaseTheLock(semaName)
	if(clrd && eric())log.debug 'clearing piston data cache '+meth
}

private LinkedHashMap<String,Object> getCachedMaps(String meth=sNULL,Boolean retry=true,Boolean Upd=true){
	String s=sAppId()
	String myId=hashId(s)
	LinkedHashMap<String,Object> result=theCacheVFLD[myId]
	if(result!=null){
		if(result.cache instanceof Map && result.build instanceof Integer) return result
		String semaName=s
		getTheLock(semaName,sI)
		theCacheVFLD[myId]=null
		theCacheVFLD=theCacheVFLD
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

private LinkedHashMap<String,Object> getDSCache(String meth,Boolean Upd=true){
	String appStr=sAppId()
	String appId=hashId(appStr)
	String myId=appId
	LinkedHashMap<String,Object> pC=getParentCache()
	LinkedHashMap<String,Object> result=theCacheVFLD[myId]

	if(result!=null) result.stateAccess=null
	Boolean sendM=false
	if(result==null){
		String lockTyp='getDSCache'
		String semaName=appStr
		getTheLock(semaName,lockTyp)
		result=theCacheVFLD[myId]
		if(result==null){
			Long stateStart=(Long)now()
			if(state.pep==null){ // upgrades of older pistons
				LinkedHashMap piston=recreatePiston()
				state.pep=(Integer)piston.o?.pep ? true:false
			}
			Integer bld=(Integer)state.build
			String ttt=(String)state.svLabel
			if(ttt==sNULL){
				ttt=(String)app.label
				if(bld>iZ){
					state.svLabel=ttt
					atomicState.svLabel=ttt
				}
			}
			Map t1=[
				(sID): appId,
				(sLOGNG): (Integer)state.logging!=null ? (Integer)state.logging:iZ,
				svLabel: ttt,
				(sNM): ttt,
				active: (Boolean)state.active,
				category: state.category ?: iZ,
				pep: (Boolean)state.pep,
				created: (Long)state.created,
				modified: (Long)state.modified,
				build: bld,
				(sATHR): (String)state.author,
				(sBIN): (String)state.bin,
				logsToHE: (Boolean)settings.logsToHE
			] as Map
			Long stateEnd=(Long)now()
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
			t1.devices= settings.dev && settings.dev instanceof List ? ((List)settings.dev).collectEntries{ it -> [(hashId(it.id)):it]} : [:]

			sendM=true
			if(Upd){
				t1.Cached=true
				theCacheVFLD[myId]= t1 as LinkedHashMap
				theCacheVFLD=theCacheVFLD
			}
			result= t1 as LinkedHashMap<String,Object>
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
	LinkedHashMap<String,Object> rtD=(LinkedHashMap)(pC+result)
	pC=null
	result=null
	if(sendM && rtD.build!=iZ)checkLabel(rtD)
	return rtD
}

@Field volatile static LinkedHashMap<String,LinkedHashMap<String,Object>> theParentCacheVFLD=[:]

void clearParentCache(String meth=sNULL){
	String lockTyp='clearParentCache'
	String semName=sTSLF
	String wName=parent.id.toString()
	getTheLock(semName,lockTyp)

	theParentCacheVFLD[wName]=null
	theParentCacheVFLD=theParentCacheVFLD

	getCacheLock(lockTyp)
	theCacheVFLD=[:] // all pistons reset their cache
	clearHashMap(wName)
	theVirtDevicesFLD=null
	releaseCacheLock()

	releaseTheLock(semName)

	if(eric())log.debug "clearing parent cache and all piston caches $meth"
}

private LinkedHashMap<String,Object> getParentCache(){
	String lockTyp='getParentCache'
	String wName=parent.id.toString()
	LinkedHashMap<String,Object> result=theParentCacheVFLD[wName]
	if(result==null){
		String semName=sTSLF
		getTheLock(semName,lockTyp)
		result=theParentCacheVFLD[wName]
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
				lifx: (Map)t0.lifx,
				logPExec: (Boolean)t0.logPExec,
				locationId: (String)t0.locationId,
				oldLocationId: hashId(((Long)location.id).toString()+'L'),//backwards compatibility
				incidents: (List)t0.incidents,
				useLocalFuelStreams: (Boolean)t0.useLocalFuelStreams
			]
			result=t1
			theParentCacheVFLD[wName]=t1
			theParentCacheVFLD=theParentCacheVFLD
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

private LinkedHashMap<String,Object> getRunTimeData(LinkedHashMap<String,Object> irtD=null,Map retSt=null,Boolean fetchWrappers=false,Boolean shorten=false){
	LinkedHashMap<String,Object> rtD=irtD
	Long started=(Long)now()
	List logs=[]
	Long lstarted=lZ
	Long lended=lZ
	LinkedHashMap piston
	Integer dbgLevel=iZ
	if(rtD!=null){
		logs=rtD.logs!=null ? (List)rtD.logs:[]
		lstarted=rtD.lstarted!=null ? (Long)rtD.lstarted:lZ
		lended=rtD.lended!=null ? (Long)rtD.lended:lZ
		piston=rtD.piston!=null ? (LinkedHashMap)rtD.piston:null
		dbgLevel=rtD.debugLevel!=null ? (Integer)rtD.debugLevel:iZ
	}else rtD=getTemporaryRunTimeData(started)
	Long timestamp=(Long)rtD.timestamp

	if(rtD.temporary!=null) def a=rtD.remove('temporary')

	LinkedHashMap<String,Object> m1=[:]
	Boolean b=retSt!=null
	m1.semaphore= b?(Long)retSt.semaphore:lZ
	m1.semaphoreName=b?(String)retSt.semaphoreName:sNULL
	m1.semaphoreDelay=b?(Long)retSt.semaphoreDelay:lZ
	rtD=(LinkedHashMap)(rtD+m1)

	rtD.timestamp=timestamp
	rtD.lstarted=lstarted
	rtD.lended=lended
	//rtD.logs=[]
	if(logs!=[] && logs.size()>iZ) rtD.logs=logs
	else rtD.logs=[[(sT):timestamp]]
	rtD.debugLevel=dbgLevel

	rtD.trace=[(sT):timestamp,points:[:]]
	rtD.stats=[nextSchedule:lZ]
	rtD.newCache=[:]
	rtD.schedules=[]
	rtD.cancelations=[statements:[],conditions:[],all:false]
	rtD.updateDevices=false
	rtD.systemVars=getSystemVariables()

	Map atomState=getCachedMaps('getRTD')
	atomState=atomState!=null?atomState:[:]
	Map st=(Map)atomState.state
	rtD.state=st!=null && st instanceof Map ? [:]+st : [old:sBLK,new:sBLK]
	rtD.state.old=(String)rtD.state.new

	rtD.pStart=(Long)now()

	if(piston==null) piston=recreatePiston(shorten)
	Boolean doSubScribe=!(Boolean)piston.cached

	rtD.piston=piston

	getLocalVariables(rtD,atomState)
	piston=null

	if(doSubScribe || fetchWrappers){
		subscribeAll(rtD,fetchWrappers)
		String pisName=sAppId()
		Map pData=(Map)thePistonCacheFLD[pisName]
		if(shorten && pisName!=sBLK && pData!=null && pData.pis==null){
			pData.pis=[:]+(LinkedHashMap)rtD.piston
			thePistonCacheFLD[pisName]=[:]+pData
			pData=null
			mb()
			if(eric()){
				log.debug 'creating piston-code-cache'
				dumpPCsize()
			}
		}
	}
	Long t0=(Long)now()
	rtD.pEnd=t0
	rtD.ended=t0
	rtD.generatedIn=t0-started
	return rtD
}

private void dumpPCsize(){
	Map pL
	Integer t0=iZ
	Integer t1=iZ
	try{
		pL=[:]+thePistonCacheFLD
		t0=pL.size()
		t1="${pL}".size()
	}catch(ignored){}
	pL=null
	String mStr="piston plist is ${t0} elements, and ${t1} bytes".toString()
	log.debug mStr
	if(t1>40000000){
		thePistonCacheFLD=[:]
		mb()
		log.warn "clearing entire "+mStr
	}
}

private void checkVersion(Map rtD){
	String ver=sHVER
	String t0=(String)rtD.hcoreVersion
	if(ver!=t0){
		String tt0="child app's version($ver)".toString()
		String tt1="parent app's version($t0)".toString()
		String tt2=' is newer than the '
		String msg
		if(ver>t0) msg=tt0+tt2+tt1
		else msg=tt1+tt2+tt0
		warn "WARNING: Results may be unreliable because the "+msg+". Please update both apps to the same version.",rtD
	}
	if(location.timeZone==null)
		error 'Your location is not setup correctly - timezone information is missing. Please select your location by placing the pin and radius on the map, then tap Save, and then tap Done. You may encounter error or incorrect timing until this is fixed.',rtD
}

/** EVENT HANDLING								**/

void deviceHandler(event){
	handleEvents(event)
}

void timeHandler(event){
	timeHelper(event,false)
}

void timeHelper(event,Boolean recovery){
	handleEvents([(sDATE):new Date((Long)event.t),(sDEV):location,(sNM):sTIME,(sVAL):(Long)event.t,schedule:event,recovery:recovery],!recovery)
}

void executeHandler(event){
	handleEvents([(sDATE):event.date,(sDEV):location,(sNM):'execute',(sVAL):event.value,jsonData:event.jsonData])
}

@Field static final Map getPistonLimits=[
	scheduleRemain: 35000L, // need this or longer remaining executionTime to process additional schedules
	scheduleVariance: 63L,
	executionTime: 40000L, // time we stop this execution
	slTime: 6300L, // time before we start inserting pauses
	useBigDelay: 20000L, // transition from short delay to Long delay
	taskShortDelay: 150L,
	taskLongDelay: 500L,
	taskMaxDelay: 250L,
	deviceMaxDelay: 1000L,
	maxStats: 50,
	maxLogs: 50,
]

@SuppressWarnings(['GroovyFallthrough', 'GroovyFallthrough'])
void handleEvents(evt,Boolean queue=true,Boolean callMySelf=false){
	def event=evt
	Long startTime=(Long)now()
	LinkedHashMap<String,Object> tmpRtD=getTemporaryRunTimeData(startTime)
	Map msg=timer 'Event processed successfully',tmpRtD,iN1
	String evntName=(String)event.name
	String evntVal="${event.value}".toString()
	Long eventDelay=Math.round(d1*startTime-((Date)event.date).getTime())
	if((Integer)tmpRtD.logging!=iZ){
		String devStr="${event.device?.label ?: event.device?.name ?: location}".toString()
		String recStr=evntName==sTIME && (Boolean)event.recovery ? '/recovery':sBLK
		String valStr=evntVal+(evntName==sHSMALRT && evntVal==sRULE ? ','+(String)event.descriptionText:sBLK)
		String mymsg='Received event ['+devStr+'].'+evntName+recStr+' = '+valStr+" with a delay of ${eventDelay}ms, canQueue: ${queue}, calledMyself: ${callMySelf}".toString()
		info mymsg,tmpRtD,iZ
	}

	Boolean clearC=evntName==sCLRC
	Boolean clearL=evntName==sCLRL

	Boolean act=(Boolean)tmpRtD.active
	Boolean dis=!(Boolean)tmpRtD.enabled
	if(!act || dis){
		if((Integer)tmpRtD.logging!=iZ){
			String tstr=' active,aborting piston execution.'
			if(!act) msg.m='Piston is not'+tstr+' (Paused)' // this is pause/resume piston
			if(dis) msg.m='Kill switch is'+tstr
			info msg,tmpRtD
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
	serializationOn=!myPep && serializationOn
	Boolean doSerialization=serializationOn && !callMySelf

	tmpRtD.lstarted=(Long)now()
	Map retSt=[semaphore:lZ,semaphoreName:sNULL,semaphoreDelay:lZ]
	if(doSerialization){
		retSt=lockOrQueueSemaphore(doSerialization,event,queue,tmpRtD)
		if((Boolean)retSt.exitOut){
			if((Integer)tmpRtD.logging!=iZ){
				msg.m='Event queued'
				info msg,tmpRtD
			}
			updateLogs(tmpRtD)
			event=null
			tmpRtD=null
			return
		}
		if((Long)retSt.semaphoreDelay>lZ)warn 'Piston waited for semaphore '+(Long)retSt.semaphoreDelay+sMS,tmpRtD
	}
	tmpRtD.lended=(Long)now()

//measure how Long first state access takes
	Long stAccess=lZ
	if((Integer)tmpRtD.logging>iZ && !myPep){
		if(tmpRtD.stateAccess==null){
			Long stStart=(Long)now()
			Long b=(Long)state.nextSchedule
			List a=(List)state.schedules
			Map pEvt=(Map)state.lastEvent
			Long stEnd=(Long)now()
			stAccess=stEnd-stStart
		}else stAccess=(Long)tmpRtD.stateAccess
	}

	tmpRtD.cachePersist=[:]
	LinkedHashMap<String,Object> rtD=getRunTimeData(tmpRtD,retSt,false,true)
	tmpRtD=null
	checkVersion(rtD)

	Long theend=(Long)now()
	Long t0=theend-startTime
	Long t1=(Long)rtD.lended-(Long)rtD.lstarted
	Long t2=(Long)rtD.generatedIn
	Long t3=(Long)rtD.pEnd-(Long)rtD.pStart
	Long missing=t0-t1-t2
	rtD.curStat=[(sI):t0,(sL):t1,(sR):t2,(sP):t3,(sS):stAccess]
	Integer lg=(Integer)rtD.logging
	if(lg>i1){
		Long t4=(Long)rtD.lended-startTime
		Long t5=theend-(Long)rtD.lended
		if(lg>i2)debug "RunTime initialize > ${t0} LockT > ${t1}ms > rtDT > ${t2}ms > pistonT > ${t3}ms (first state access ${missing} $t4 $t5)".toString(),rtD
		String adMsg=sBLK
		if(eric())adMsg=" (Init:$t0, Lock: $t1, pistonT $t3 first state access $missing ($t4 $t5) $stAccess".toString()
		trace "Runtime (${"$rtD".size()} bytes) successfully initialized in ${t2}ms (${sHVER})".toString()+adMsg,rtD
	}

	resetRandomValues(rtD)
	rtD.tPause=lZ
	rtD.stats.timing=[(sT):startTime,(sD):eventDelay>lZ ? eventDelay:lZ,(sL):elapseT(startTime)]

	String semName=(String)rtD.semaphoreName
	Long lS=(Long)rtD.semaphore

	if(clearC||clearL){
		if(clearL) clear1(true,true,true,false,true)
		else if(rtD.lastExecuted==null || elapseT((Long)rtD.lastExecuted)>3660000L) clear1(true,false,false,false)
	}else{
		startTime=(Long)now()
		Map msg2=null
		if(lg>i1)msg2=timer "Execution stage complete.",rtD,iN1
		Boolean success=true
		Boolean firstTime=true
		if(!(evntName in [sTIME,sASYNCREP])){
			if(lg>i1)trace "Execution stage started",rtD,i1
			success=executeEvent(rtD,event)
			firstTime=false
		}
		if(evntName==sTIME && !(Boolean)event.recovery){
			rtD.stats.nextSchedule=lZ
			rtD.nextSchedule=lZ
			state.nextSchedule=lZ
		}

		if(!ListAsync) ListAsync=[sHTTPR,sSTOREM,sLIFX,sSENDE,sIFTTM]
		Boolean syncTime=true
		Boolean sv_syncTime=syncTime

		List<Map> schedules
		Map tt0
		Boolean a
		String semaName=sAppId()
		Map sch=null
		String myId=(String)rtD.id
		Long sVariance=(Long)getPistonLimits.scheduleVariance
		while(success && (Long)getPistonLimits.executionTime+(Long)rtD.timestamp-(Long)now()>(Long)getPistonLimits.scheduleRemain){
			// if no queued events
			if(!firstTime && serializationOn){
				Boolean inq=false
				getTheLock(semaName,sHNDLEVT)
				List<Map> evtQ=theQueuesVFLD[semaName]
				if(evtQ) inq=true
				releaseTheLock(semaName)
				if(inq){
					if(eric()) log.warn "found pending queued events"
					break
				}
			}

			schedules=sgetSchedules(sHNDLEVT,myPep)
			if(schedules==null || schedules==(List<Map>)[] || schedules.size()==iZ)break
			Long t=(Long)now()

			if(evntName==sASYNCREP)
				event.schedule=schedules.sort{ Map it -> (Long)it.t }.find{ Map it -> (String)it.d==evntVal }
			else{
				//anything less than scheduleVariance (63ms) in the future is considered due; do some pause to sync with it
				//doing this because many times the scheduler will run a job early
				sch=schedules.sort{ Map it -> (Long)it.t }.find{ Map it -> (Long)it.t<t+sVariance }
				if(!sch) break

				evntName=sTIME
				evntVal=t.toString()
				event=[(sDATE):(Date)event.date,(sDEV):location,(sNM):evntName,(sVAL):t,schedule:sch]
			}

			if(event.schedule==null) break

			schedules=sgetSchedules(sHNDLEVT+s1,myPep)
			a=schedules.remove(event.schedule)

			updateSchCache(rtD,schedules,sHNDLEVT+s1,sX,myPep)
			tt0=null

			if(!firstTime){
				rtD.cachePersist=[:]
				Map<String,Map>sysV=(Map<String,Map>)rtD.systemVars
				sysV[sDLLRINDX].v=null
				sysV[sDLLRDEVICE].v=null
				sysV[sDLLRDEVS].v=null
				sysV[sHTTPCONTENT].v=null
				sysV[sHTTPSTSCODE].v=null
				sysV[sHTTPSTSOK].v=null
				sysV[sIFTTTSTSCODE].v=null
				sysV[sIFTTTSTSOK].v=null
				rtD.systemVars=sysV

				event.date=new Date((Long)sch.t)
			}

			if(evntName==sASYNCREP){
				syncTime=false
				if((Boolean)rtD.eric)myDetail rtD,"async event $event",iN2
				Integer rCode=(Integer)event.responseCode
				Boolean sOk=rCode>=200 && rCode<=299
				switch(evntVal){
					case sHTTPR:
						if(event.schedule.stack!=null){
							event.schedule.stack.response=event.responseData
							event.schedule.stack.json=event.jsonData
						}
						setSystemVariableValue(rtD,sHTTPCONTENT,(String)event.contentType)
					case sSTOREM:
						if((Map)event.setRtData){
							for(item in (Map<String,Object>)event.setRtData){
								rtD[(String)item.key]=item.value
							}
						}
					case sLIFX:
					case sSENDE:
						setSystemVariableValue(rtD,sHTTPSTSCODE,rCode)
						setSystemVariableValue(rtD,sHTTPSTSOK,sOk)
						break
					case sIFTTM:
						setSystemVariableValue(rtD,sIFTTTSTSCODE,rCode)
						setSystemVariableValue(rtD,sIFTTTSTSOK,sOk)
						break
					default:
						error "unknown async event "+evntVal,rtD
				}
				evntName=sTIME
				event.name=evntName
				event.value=t
				evntVal=t.toString()
			}else{
				String ttyp=(String)event.schedule.d
				if(ttyp in ListAsync){
					error "Timeout Error "+ttyp,rtD
					syncTime=false
					Integer rCode=408
					Boolean sOk=false
					switch(ttyp){
						case sHTTPR:
							setSystemVariableValue(rtD,sHTTPCONTENT,sBLK)
							if(event.schedule.stack!=null) event.schedule.stack.response=null
						case sSTOREM:
							setSystemVariableValue(rtD,sHTTPSTSCODE,rCode)
							setSystemVariableValue(rtD,sHTTPSTSOK,sOk)
							break
						case sLIFX:
						case sSENDE:
							break
						case sIFTTM:
							setSystemVariableValue(rtD,sIFTTTSTSCODE,rCode)
							setSystemVariableValue(rtD,sIFTTTSTSOK,sOk)
							break
					}
				}
			}

			if(syncTime && strictSync){
				Long delay=Math.round((Long)event.schedule.t-d1*(Long)now())
				if(delay>lZ){
					delay=delay<sVariance ? delay:sVariance
					doPause("Synchronizing scheduled event, waiting for ${delay}ms".toString(),delay,rtD,true)
				}
			}
			if(lg>i1 && firstTime){
				msg2=timer "Execution stage complete.",rtD,iN1
				trace "Execution stage started",rtD,i1
			}
			success=executeEvent(rtD,event)
			firstTime=false
			syncTime=sv_syncTime
		} // end while

		rtD.stats.timing.e=elapseT(startTime)
		if(lg>iZ)info msg2,rtD
		if(!success)msg.m='Event processing failed'
		if(eric()){
			msg.m=(String)msg.m+' Total Pauses ms: '+((Long)rtD.tPause).toString()
			if(firstTime) msg.m=(String)msg.m+' found nothing to do'
		}
		finalizeEvent(rtD,msg,success)

		if((Boolean)rtD.logPExec){
			Map rtCE=(Map)rtD.currentEvent
			if(rtCE!=null){
				String desc='webCoRE piston \''+(String)app.label+'\' was executed'
				sendLocationEvent((sNM):'webCoRE',(sVAL):'pistonExecuted',isStateChange:true,displayed:false,linkText:desc,descriptionText:desc,
					data:[
						(sID):appId,
						(sNM):(String)app.label,
						event:[(sDATE):new Date((Long)rtCE.date),delay:(Long)rtCE.delay,(sDURATION):elapseT((Long)rtCE.date),(sDEV):"${rtD.event.device}".toString(),(sNM):(String)rtCE.name,(sVAL):rtCE.value,physical:(Boolean)rtCE.physical,index:(Integer)rtCE.index],
						state:[old:(String)rtD.state.old,new:(String)rtD.state.new]
					]
				)
			}
		}
	}

	if((Boolean)rtD.updateDevices) clearMyCache('updateDeviceList')

	List<String>data=rtD.collect{ (String)it.key }
	for(String item in data)a=rtD.remove(item)
	event=null
	rtD=null

// any queued events?
	String msgt=sNULL
	if(lg>i2)msgt='Exiting'
	while(doSerialization && semName!=sNULL){
		getTheLock(semName,sHNDLEVT+s2)
		List<Map> evtQ=theQueuesVFLD[semName]
		if(!evtQ){
			if(theSemaphoresVFLD[semName]<=lS){
				if(lg>i2)msgt='Released Lock and exiting'
				theSemaphoresVFLD[semName]=lZ
				theSemaphoresVFLD=theSemaphoresVFLD
			}
			releaseTheLock(semName)
			break
		}else{
			Map theEvent
			evtQ=theQueuesVFLD[semName]
			List<Map>evtList=evtQ.sort{ Map it ->(Long)it.t }
			theEvent=evtList.remove(0)
			Integer qsize=evtList.size()
			theQueuesVFLD[semName]=evtList
			theQueuesVFLD=theQueuesVFLD
			releaseTheLock(semName)

			if(qsize>8) log.error "large queue size ${qsize}".toString()
			theEvent.date=new Date((Long)theEvent.t)
			handleEvents(theEvent,false,true)
		}
	}
	if(lg>i2) log.debug msgt
}

@Field static List<String> ListAsync=[]

private Boolean executeEvent(Map rtD,event){
	String myS=sNULL
	String evntName=(String)event.name
	if((Boolean)rtD.eric){
		myS='executeEvent '+evntName+sSPC+event.value.toString()
		myDetail rtD,myS,i1
	}
	Boolean ended=false
	Boolean lg=(Integer)rtD.logging>i2
	try{
		// see lockOrQueueSemphore for description of queued Events
		rtD.event=event
		Map pEvt=(Map)state.lastEvent
		if(pEvt==null)pEvt=[:]
		rtD.previousEvent=pEvt
		Integer index=iZ //event?.index ?: iZ
		if(event.jsonData!=null){
			Map attribute=Attributes()[evntName]
			String attrI=attribute!=null ? (String)attribute.i:sNULL
			if(attrI!=sNULL && event.jsonData[attrI]) // .i is the attribute to lookup
				index=((String)((Map)event.jsonData)[attrI]).toInteger()
			if(!index)index=i1
		}

		Map srcEvent=null
		rtD.args=[:]
		rtD.json=[:]
		rtD.response=[:]

		Map<String,Map>sysV=(Map<String,Map>)rtD.systemVars

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
					index=(Integer)srcEvent?.index ?: iZ
// more to restore here?
					rtD.systemVars=sysV
				}
			}
		}
		setSystemVariableValue(rtD,sDOLARGS,rtD.args)
		sysV=(Map<String,Map>)rtD.systemVars

		String theDevice=srcEvent!=null ? (String)srcEvent.device:sNULL
		def theDevice1=theDevice==sNULL && event.device ? event.device.id:null
		String theFinalDevice=theDevice!=sNULL ? theDevice : (theDevice1!=null ? (!isDeviceLocation(event.device) ? hashId(theDevice1.toString()) : (String)rtD.locationId) : (String)rtD.locationId)
		Map myEvt=[
			(sDATE):((Date)event.date).getTime(),
			delay:rtD.stats?.timing?.d ? (Long)rtD.stats.timing.d : lZ,
			(sDEV):theFinalDevice,
			index:index
		]
		if(srcEvent!=null){
			myEvt=myEvt+[
				(sNM):(String)srcEvent.name,
				(sVAL):srcEvent.value,
				descriptionText:(String)srcEvent.descriptionText,
				unit:srcEvent.unit,
				physical:(Boolean)srcEvent.physical,
			]
		}else{
			myEvt=myEvt+[
				(sNM):evntName,
				(sVAL):event.value,
				descriptionText:(String)event.descriptionText,
				unit:event.unit,
				physical:!!event.physical,
			]
		}
		rtD.currentEvent=myEvt
		state.lastEvent=myEvt

		rtD.cndtnStChgd=false
		rtD.pstnStChgd=false
		rtD.ffTo=iZ
		rtD.stmtLvl=iZ
		rtD.break=false
		rtD.resumed=false
		rtD.terminated=false
		if(evntName==sTIME)
			rtD.ffTo=(Integer)event.schedule.i

		sysV[sPEVDATE].v=pEvt.date ?: (Long)now()
		sysV[sPEVDELAY].v=pEvt.delay ?: lZ
		sysV[sPEVDEV].v=[pEvt.device]
		sysV[sPEVDEVINDX].v=pEvt.index ?: iZ
		sysV[sPEVATTR].v=pEvt.name ?: sBLK
		sysV[sPEVDESC].v=pEvt.descriptionText ?: sBLK
		sysV[sPEVVALUE].v=pEvt.value ?: sBLK
		sysV[sPEVUNIT].v=pEvt.unit ?: sBLK
		sysV[sPEVPHYS].v=!!pEvt.physical

		sysV[sCURDATE].v=(Long)myEvt.date
		sysV[sCURDELAY].v=(Long)myEvt.delay
		sysV[sCURDEV].v=[myEvt.device]
		sysV[sCURDEVINDX].v=myEvt.index!=sBLK && myEvt.index!=null? (Integer)myEvt.index:iZ
		sysV[sCURATTR].v=(String)myEvt.name
		sysV[sCURDESC].v=(String)myEvt.descriptionText
		sysV[sCURVALUE].v=myEvt.value
		sysV[sCURUNIT].v=myEvt.unit
		sysV[sCURPHYS].v=(Boolean)myEvt.physical
		rtD.systemVars=sysV

		rtD.stack=[(sC):iZ,(sS):iZ,cs:[],ss:[]]
		try{
			Boolean allowed=!rtD.piston.r || ((List)rtD.piston.r).size()==iZ || evaluateConditions(rtD,(Map)rtD.piston,sR,true)
			rtD.restricted=!(Integer)rtD.piston.o?.aps && !allowed //allowPreScheduled tasks to execute during restrictions
			if(allowed || (Integer)rtD.ffTo!=iZ){
				if((Integer)rtD.ffTo in [iN3,iN5]){
					if((Integer)rtD.ffTo==iN3){
						//device related time schedules
						def data=event.schedule.d
						if(data!=null && (String)data.d && (String)data.c){
							//we have a device schedule, execute it
							def device=getDevice(rtD,(String)data.d)
							if(device!=null){
								if(!(Boolean)rtD.restricted || (Boolean)data.ig){
									//executing scheduled physical command
									//used by command execution delay, fades, flashes,etc.
									Boolean dco= data.dc!=null ? (Boolean)data.dc : true
									executePhysicalCommand(rtD,device,(String)data.c,data.p,lZ,sNULL,dco,false,false)
								}else{
									if(lg)debug 'Piston device timer execution aborted due to restrictions in effect',rtD
								}
							}
						}
					}else{ // iN5
						if(!(Boolean)rtD.restricted){
							Map jq=event.schedule.jq
							if(jq!=null) {
								Map statement=[tcp:jq.tcp, $:jq.$]
								rtD.currentAction=statement
								runRepeat(rtD, jq)
								rtD.remove('currentAction')
							}
						}else{
							if(lg)debug 'Piston repeat task timer execution aborted due to restrictions in effect',rtD
						}
					}
				}else{
					if(executeStatements(rtD,(List)rtD.piston.s)){
						ended=true
						tracePoint(rtD,sEND,lZ,iZ)
					}
					processSchedules rtD
				}
			}else{
				if(lg)debug 'Piston execution aborted due to restrictions in effect; updating piston states',rtD
				//we need to run through all to update stuff
				rtD.ffTo=iN9
				Boolean a=executeStatements(rtD,(List)rtD.piston.s)
				ended=true
				tracePoint(rtD,sEND,lZ,iZ)
				processSchedules rtD
			}
			if(!ended){ ended=true; tracePoint(rtD,sBREAK,lZ,iZ) }
		}catch(all){
			error 'An error occurred while executing the event:',rtD,iN2,all
		}
		if((Boolean)rtD.eric)myDetail rtD,myS+' Result:TRUE'
		return true
	}catch(all){
		error 'An error occurred within executeEvent:',rtD,iN2,all
	}
	if(!ended){ ended=true; tracePoint(rtD,sBREAK,lZ,iZ) }
	processSchedules rtD
	if((Boolean)rtD.eric)myDetail rtD,myS+' Result:FALSE'
	return false
}

@Field static final List<String> cleanData=['allDevices','cachePersist','mem','break','powerSource','oldLocationId','incidents','lstarted','lended','pStart','pEnd','generatedIn','ended','semaphoreDelay','vars','stateAccess','author','bin','build','newCache','mediaData','weather','logs','trace','systemVars','localVars','currentAction','previousEvent','json','response','cache','store','settings','locationModeId','locationId','coreVersion','hcoreVersion','cancelations','cndtnStChgd','pstnStChgd','ffTo','resumed','terminated','instanceId','wakingUp','stmtLvl','args','nfl','temp']

private void finalizeEvent(Map rtD,Map initialMsg,Boolean success=true){
	Long startTime=(Long)now()
	Boolean myPep=(Boolean)rtD.pep

	processSchedules(rtD,true)

	if(success){
		if((Integer)rtD.logging>iZ)info initialMsg,rtD
	}else error initialMsg,rtD

	updateLogs(rtD,(Long)rtD.timestamp)

	String myId=(String)rtD.id

	rtD.trace.d=elapseT((Long)rtD.trace.t)

	//flush the new cache value
	for(item in (Map<String,Map>)rtD.newCache) ((Map<String,Object>)rtD.cache)[(String)item.key]=item.value

	//overwrite state might have changed meanwhile
	String str='finalize'
	Map t0=getCachedMaps(str)
	String semaName=sAppId()
	if(t0!=null){
		getTheLock(semaName,str)
		Map nc=theCacheVFLD[myId]
		if(nc){
			nc.lastPCmdQ=rtD.lastPCmdQ
			nc.lastPCmdSnt=rtD.lastPCmdSnt
			// store across runs
			nc.cache=[:]+(Map)rtD.cache
			nc.store=[:]+(Map)rtD.store
			nc.state=[:]+(Map)rtD.state
			nc.trace=[:]+(Map)rtD.trace
			theCacheVFLD[myId]=nc
			theCacheVFLD=theCacheVFLD
		}
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
	def aa
	for(String foo in cleanData) aa=rtD.remove(foo)
	if(!(rtD.event instanceof com.hubitat.hub.domain.Event)){
		if(rtD.event?.responseData)rtD.event.responseData=[:]
		if(rtD.event?.jsonData)rtD.event.jsonData=[:]
		if(rtD.event?.setRtData)rtD.event.setRtData=[:]
		if(rtD.event?.schedule?.stack)rtD.event.schedule.stack=[:]
	}

	if((Boolean)rtD.updateDevices) updateDeviceList(rtD,((List)((Map)rtD.devices)*.value.id))
	aa=rtD.remove('devices')

	Boolean a
	if(rtD.gvCache!=null || rtD.gvStoreCache!=null){
		LinkedHashMap tpiston=(LinkedHashMap)rtD.piston
		rtD.piston=[:]
		rtD.piston.z=(String)tpiston.z
		tpiston=null
		if(rtD.gvCache!=null){
			String semName=sTGBL
			String wName=parent.id.toString()
			getTheLock(semName,str)
			for(var in (Map<String,Map>)rtD.gvCache){
				Map vars=globalVarsVFLD[wName]
				String varName=(String)var.key
				if(varName && varName.startsWith(sAT) && vars[varName] && var.value.v!=vars[varName].v){
					globalVarsVFLD[wName][varName].v=var.value.v
					globalVarsVFLD=globalVarsVFLD
				}
			}
			releaseTheLock(semName)
		}
		parent.pCallupdateRunTimeData(rtD)
		aa=rtD.remove('gvCache')
		aa=rtD.remove('gvStoreCache')
		rtD.initGStore=false
	}else{
		Map myRt=shortRtd(rtD)
		myRt.t=(Long)now()
		parent.pCallupdateRunTimeData(myRt)
	}
	rtD.piston=null

	rtD.stats.timing.u=elapseT(startTime)
//update graph data
	Map stats
	if(myPep)stats=(Map)atomicState.stats
	else stats=(Map)state.stats
	stats=stats ?: [:]

	List<Map> tlist=(List<Map>)stats.timing ?: []
	Map lastST= tlist.size() ? [:]+tlist.last() :null
	Map newMap=[:]+(Map)rtD.stats.timing
	if(lastST && newMap){
		lastST.t=(Long)newMap.t-10L
		a=tlist.push(lastST)
	}
	a=tlist.push(newMap)
	Integer mS=(Integer)getPistonLimits.maxStats
	Integer t1=settings.maxStats!=null ? (Integer)settings.maxStats: mS
	if(t1<=iZ)t1=mS
	if(t1<i2)t1=i2
	Integer t2=tlist.size()
	if(t2>t1)tlist=tlist[t2-t1..t2-i1]

	stats.timing=tlist
	if(myPep)atomicState.stats=stats
	else state.stats=stats
	rtD.stats.timing=null

	t0=getCachedMaps(str+s1)
	if(t0!=null){
		Long totTime=elapseT((Long)rtD.timestamp)
		t1=20
		String t4=mem()
		getTheLock(semaName,str+s1)
		Map nc=theCacheVFLD[myId]
		if(nc){
			nc.mem=t4
			nc.runStats=[:]+(Map)rtD.curStat
			List hisList=(List)nc.runTimeHis
			Boolean b=hisList.push(totTime)
			t2=hisList.size()
			if(t2>t1)hisList=hisList[t2-t1..t2-i1]
			nc.runTimeHis=hisList
			theCacheVFLD[myId]=nc
			theCacheVFLD=theCacheVFLD
		}
		releaseTheLock(semaName)
	}
}

private List<Map> sgetSchedules(String t,Boolean myPep){
	List<Map> schedules
	Map t0=getCachedMaps(t)
	if(t0!=null)schedules=(List<Map>)[]+(List<Map>)t0.schedules
	else schedules=myPep ? (List<Map>)atomicState.schedules:(List<Map>)state.schedules
	return schedules
}

private void updateSchCache(Map rtD,List<Map> schedules,String t,String lt,Boolean myPep){
	if(myPep)atomicState.schedules=schedules
	else state.schedules=(List<Map>)[]+schedules

	String myId=(String)rtD.id
	String semaName=sAppId()
	Map t0=getCachedMaps(t)
	if(t0!=null){
		getTheLock(semaName,lt)
		Map nc=theCacheVFLD[myId]
		if(nc){
			nc.schedules=(List<Map>)[]+schedules
			theCacheVFLD[myId]=nc
			theCacheVFLD=theCacheVFLD
		}
		releaseTheLock(semaName)
	}
}

private void processSchedules(Map rtD,Boolean scheduleJob=false){
	Boolean myPep=(Boolean)rtD.pep
	String str='processSchedules'

	//if automatic piston states set it based on the autoNew - if any
	if(!(Integer)rtD.piston.o?.mps) rtD.state.new=(String)rtD.state.autoNew ?: sTRUE
	rtD.state.old=(String)rtD.state.new

	List<Map> schedules=sgetSchedules(str,myPep)

	Boolean a
	if((Boolean)rtD.cancelations.all){
		//a=schedules.removeAll{ (Integer)it.i>iZ }
		//if we have any other pending -3 events (device schedules) we cancel them all
		a=schedules.removeAll{ Map it -> (Integer)it.i>iZ || (Integer)it.i in [iN3,iN5] }
	}

	//cancel statements
	a=schedules.removeAll{ Map schedule -> !!((List<Map>)rtD.cancelations.statements).find{ Map cancelation -> (Integer)cancelation.id==(Integer)schedule.s && (!cancelation.data || (String)cancelation.data==(String)schedule.d)}}

	//cancel on conditions
	for(Integer cid in (List<Integer>)rtD.cancelations.conditions)
		a=schedules.removeAll{ Map it -> cid in (List)it.cs }

	//cancel on piston state change
	if((Boolean)rtD.pstnStChgd)
		a=schedules.removeAll{ Map it -> (Integer)it.ps!=iZ }

	rtD.cancelations=[statements:[],conditions:[],all:false]

	schedules=(schedules+(List<Map>)rtD.schedules)//.sort{ (Long)it.t }
	updateSchCache(rtD,schedules,str+s1,sT,myPep)

	if(scheduleJob){
		Long nextT=lZ
		Integer ssz=schedules.size()
		if(ssz>iZ){
			Map tnext=schedules.sort{ Map it -> (Long)it.t }[iZ]
			nextT=(Long)tnext.t
			Long t=(nextT-(Long)now())+30L
			Long sVariance=(Long)getPistonLimits.scheduleVariance
			t=(t<sVariance ? sVariance:t)
			runInMillis(t,timeHandler,[data: tnext])

			if((Integer)rtD.logging>iZ) info 'Setting up scheduled job for '+formatLocalTime(nextT)+' (in '+t.toString()+'ms)'+(ssz>i1 ? ',with '+(ssz-i1).toString()+' more job'+(ssz>i2 ? sS : sBLK)+' pending' : sBLK),rtD
		}
		if(nextT==lZ && (Long)rtD.nextSchedule!=lZ) unschedule(timeHandler)

		rtD.nextSchedule=nextT
		rtD.stats.nextSchedule=nextT
		state.nextSchedule=nextT
		Map t0=getCachedMaps(str+s2)
		if(t0!=null){
			String myId=(String)rtD.id
			String semaName=sAppId()
			getTheLock(semaName,sT+s1)
			Map nc=theCacheVFLD[myId]
			if(nc){
				nc.nextSchedule=nextT
				theCacheVFLD[myId]=nc
				theCacheVFLD=theCacheVFLD
			}
			releaseTheLock(semaName)
		}
	}
	rtD.schedules=[]
}

private void updateLogs(Map rtD,Long lastExecute=null){
	if(!rtD || !rtD.logs)return

	String str='updateLogs'
	String myId=(String)rtD.id
	Map cacheMap
	String semaName=sAppId()
	if(lastExecute!=null){
		state.lastExecuted=lastExecute
		cacheMap=getCachedMaps(str)
		if(cacheMap!=null){
			getTheLock(semaName,sE)
			Map nc=theCacheVFLD[myId]
			if(nc){
				nc.lastExecuted=lastExecute
				nc.temp=[:]+(Map)rtD.temp
				nc.cachePersist=[:]+(Map)rtD.cachePersist
				theCacheVFLD[myId]=nc
				theCacheVFLD=theCacheVFLD
			}
			releaseTheLock(semaName)
		}
	}

	if(((List)rtD.logs).size()>i1){
		Boolean myPep=(Boolean)rtD.pep
		Integer myL=(Integer)getPistonLimits.maxLogs
		Integer lim=settings.maxLogs!=null ? (Integer)settings.maxLogs:myL
		if(lim<iZ)lim=myL

		List t0
		cacheMap=getCachedMaps(str+s1)
		if(cacheMap!=null)t0=[]+(List)cacheMap.logs
		else t0=myPep ? (List)atomicState.logs:(List)state.logs
		List logs=[]+(List)rtD.logs+t0
		if(lim>=iZ){
			Integer lsz=logs.size()
			if(lim==iZ || lsz==iZ) logs=[]
			else{
				if(lim< lsz-i1){
					logs=logs[0..lim]
					lsz=logs.size()
				}
				if(lsz>50){
					state.logs=logs //this mixes state and AS
					if(state.toString().size()>75000){
						lim-= Math.min(50L,Math.round(lim/d2)).toInteger()
						logs=logs[0..lim]
					}
				}
			}
		}
		if(myPep)atomicState.logs=logs
		else state.logs=logs
		cacheMap=getCachedMaps(str+s2)
		if(cacheMap!=null){
			getTheLock(semaName,sE+s1)
			Map nc=theCacheVFLD[myId]
			if(nc){
				nc.logs=logs
				theCacheVFLD[myId]=nc
				theCacheVFLD=theCacheVFLD
			}
			releaseTheLock(semaName)
		}
	}
	rtD.logs=[]
}

private Boolean executeStatements(Map rtD,List<Map> statements,Boolean async=false){
	Integer t=(Integer)rtD.stmtLvl
	rtD.stmtLvl=t+i1
	for(Map statement in statements){
		//only execute statements that are enabled
		Boolean disab=statement.di!=null && (Boolean)statement.di
		if(!disab && !executeStatement(rtD,statement,async)){
			//stop processing
			rtD.stmtLvl=t
			return false
		}
	}
	//continue processing
	rtD.stmtLvl=t
	return true
}

@Field static List<String> ls0=[]
@Field static List<String> ls1=[]

@SuppressWarnings('GroovyAssignabilityCheck')
private Boolean executeStatement(Map rtD,Map statement,Boolean asynch=false){
	String str='executeStatement '
	//if rtD.ffTo is a positive non-zero number, we need to fast forward through all branches
	//until we locate the statement with a matching id, then we continue
	if(statement==null)return false
	Boolean lg=(Integer)rtD.logging>i2
	Integer stmtNm=statement.$!=null ? (Integer)statement.$:iZ
	if((Integer)rtD.ffTo==iZ){
		String s="Skipping execution for statement #${stmtNm} because "
		switch((String)statement.tep){ // Task Execution Policy - only execute on ""- always (def), c-condition state change only, p- piston state change only, b-condition or piston change only
			case sC:
				if(!(Boolean)rtD.cndtnStChgd){
					if(lg)debug s+'condition state did not change',rtD
					return true
				}
				break
			case sP:
				if(!(Boolean)rtD.pstnStChgd){
					if(lg)debug s+'piston state did not change',rtD
					return true
				}
				break
			case sB:
				if( !(Boolean)rtD.cndtnStChgd && !(Boolean)rtD.pstnStChgd){
					if(lg)debug s+'neither condition state nor piston state changed',rtD
					return true
				}
				break
		}
	}
	String stateType=(String)statement.t
	String mySt=sNULL
	if((Boolean)rtD.eric){
		mySt=str+ffwding(rtD)+stateType+sSPC+"async: $asynch"
		myDetail rtD,mySt,i1
	}
	Boolean a=((List<Integer>)rtD.stack.ss).push((Integer)rtD.stack.s)
	rtD.stack.s=stmtNm
	Long t=(Long)now()
	Boolean value=true
	Integer c=(Integer)rtD.stack.c
	Boolean stacked=true /* cancelable on condition change */
	if(stacked)a=((List<Integer>)rtD.stack.cs).push(c)
	Boolean svCSC=(Boolean)rtD.cndtnStChgd
	//def parentAsync=asynch
	Map<String,Map>sysV=(Map<String,Map>)rtD.systemVars
	Double svIndex=(Double)sysV[sDLLRINDX].v
	List svDevice=(List)sysV[sDLLRDEVICE].v

	if(!ls0){
		ls0=[sEVERY,sON]
		if(!ls1) ls1=[sWHILE,sREPEAT,sFOR,sEACH]
	}

	Boolean selfAsync= (String)statement.a==s1 || (stateType in ls0) // execution method (async)
	Boolean async= asynch||selfAsync
	Boolean myPep=(Boolean)rtD.pep
	Boolean perform=false
	Boolean repeat=true
	Double index=null
	Boolean allowed=!(List)statement.r || ((List)statement.r).size()==iZ || evaluateConditions(rtD,statement,sR,async)
	Boolean isIf=false
	Boolean isEach=false
	if(allowed || (Integer)rtD.ffTo!=iZ){
		while(repeat){
			//noinspection GroovyFallthrough
			switch(stateType){
				case sACTION:
					value=executeAction(rtD,statement,async)
					break
				case sIF:
					isIf=true
				case sWHILE:
					//check conditions for if and while
					perform=evaluateConditions(rtD,statement,sC,async)
					//override current condition so child statements can cancel on it
					rtD.stack.c=stmtNm
					if(isIf && perform && (Integer)rtD.ffTo==iZ && !(Integer)rtD.piston.o?.mps && (Integer)rtD.stmtLvl==i1){
						//automatic piston state
						rtD.state.autoNew=sTRUE
					}
					if(perform || (Integer)rtD.ffTo!=iZ){
						if(!executeStatements(rtD,(List)statement.s,async)){
							//stop processing
							value=false
							if((Integer)rtD.ffTo==iZ)break
						}
						value=true
						if((Integer)rtD.ffTo==iZ)break
					}
					if(!perform || (Integer)rtD.ffTo!=iZ){
						if(isIf){
							//look for else-ifs
							for(Map elseIf in (List<Map>)statement.ei){
								perform=evaluateConditions(rtD,elseIf,sC,async)
								if(perform || (Integer)rtD.ffTo!=iZ){
									if(!executeStatements(rtD,(List)elseIf.s,async)){
										//stop processing
										value=false
										if((Integer)rtD.ffTo==iZ)break
									}
									value=true
									if((Integer)rtD.ffTo==iZ)break
								}
							}
							if((Integer)rtD.ffTo==iZ && !(Integer)rtD.piston.o?.mps && (Integer)rtD.stmtLvl==i1){
								//automatic piston state
								rtD.state.autoNew=sFALSE
							}
							if((!perform || (Integer)rtD.ffTo!=iZ) && !executeStatements(rtD,(List)statement.e,async)){
								//stop processing
								value=false
								if((Integer)rtD.ffTo==iZ)break
							}
						}
					}
					break
				case sEVERY:
					Boolean ownEvent= rtD.event!=null && (String)rtD.event.name==sTIME && rtD.event.schedule!=null && (Integer)rtD.event.schedule.s==stmtNm && (Integer)rtD.event.schedule.i<iZ

					List<Map> schedules=sgetSchedules(str,myPep)
					if(ownEvent || !schedules.find{ Map it -> (Integer)it.s==stmtNm }){
						//if the time has come for our timer schedule the next timer
						// NOT VALID: if no next time is found quick enough a new schedule with i=-2 will be setup so that a new attempt can be made at a later time
						if(ownEvent)rtD.ffTo=iZ
						scheduleTimer(rtD,statement, ownEvent ? (Long)rtD.event.schedule.t:lZ)
					}
					//override current condition so child statements can cancel on it
					rtD.stack.c=stmtNm
					if(ownEvent)rtD.ffTo=iZ
					//don't want to run this if there are piston restrictions in effect
					if((Integer)rtD.ffTo!=iZ || (ownEvent && allowed && !(Boolean)rtD.restricted)){
						//only execute the every if i=-1 (for rapid timers with large restrictions i.e. every second, but only on Mondays)
						if((Integer)rtD.ffTo!=iZ || (Integer)rtD.event.schedule.i==iN1)a=executeStatements(rtD,(List)statement.s,true)
						//we exit a timer; only runs the scheduled code block and nothing else
						if(ownEvent){
							rtD.terminated=true
							if(lg)debug "Exiting piston on completion of Every timer block",rtD
						}
						value=false
						break
					}
					value=true
					break
				case sREPEAT:
					//override current condition so child statements can cancel on it
					rtD.stack.c=stmtNm
					if(!executeStatements(rtD,(List)statement.s,async)){
						//stop processing
						value=false
						if((Integer)rtD.ffTo==iZ)break
					}
					value=true
					perform= !evaluateConditions(rtD,statement,sC,async)
					break
				case sON:
					perform=false
					if((Integer)rtD.ffTo==iZ){
						//look to see if any of the event matches
						String deviceId= rtD.event.device!=null ? hashId(rtD.event.device.id):sNULL
						for(event in (List<Map>)statement.c){
							def operand=event.lo
							if(operand!=null && (String)operand.t){
								switch((String)operand.t){
									case sP:
										if(deviceId!=sNULL && (String)rtD.event.name==(String)operand.a && (List)operand.d!=[] && deviceId in expandDeviceList(rtD,(List)operand.d,true)) perform=true
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
					value= (Integer)rtD.ffTo!=iZ || perform ? executeStatements(rtD,(List)statement.s,async):true
					break
				case sEACH:
					isEach=true
				case sFOR:
					List devices=[]
					Double startValue=dZ
					Double endValue
					Double stepValue=d1
					Integer dsiz=devices.size()
					if(isEach){
						List t0=(List)((Map)evaluateOperand(rtD,null,(Map)statement.lo)).v
						devices=t0 ?: []
						dsiz=devices.size()
						endValue=dsiz-d1
					}else{
						startValue=(Double)evaluateScalarOperand(rtD,statement,(Map)statement.lo,null,sDEC).v
						endValue=(Double)evaluateScalarOperand(rtD,statement,(Map)statement.lo2,null,sDEC).v
						Double t0=(Double)evaluateScalarOperand(rtD,statement,(Map)statement.lo3,null,sDEC).v
						stepValue=t0 ?: d1
					}
					String cntrVar=(String)getVariable(rtD,(String)statement.x).t!=sERROR ? (String)statement.x:sNULL
					String sidx='f:'+stmtNm.toString()
					if( (startValue<=endValue && stepValue>dZ) || (startValue>=endValue && stepValue<dZ) || (Integer)rtD.ffTo!=iZ){
						//initialize the for loop
						if((Integer)rtD.ffTo!=iZ)index=(Double)cast(rtD,((Map<String,Object>)rtD.cache)[sidx],sDEC)
						if(index==null){
							index=(Double)cast(rtD,startValue,sDEC)
							//index=startValue
							rtD.cache[sidx]=index
						}
						rtD.systemVars[sDLLRINDX].v=index
						if(isEach && (Integer)rtD.ffTo in [iZ,iN9])setSystemVariableValue(rtD,sDLLRDEVICE,index<dsiz ? [devices[index.toInteger()]]:[])
						if(cntrVar!=sNULL && (Integer)rtD.ffTo==iZ)Map m=setVariable(rtD,cntrVar, isEach ? (index<dsiz ? [devices[index.toInteger()]]:[]):index)
						//do the loop
						perform=executeStatements(rtD,(List)statement.s,async)
						if(!perform){
							//stop processing
							value=false
							if((Boolean)rtD.break){
								//reached a break continue execution outside of the for
								value=true
								rtD.break=false
								//perform=false
							}
							break
						}
						//don't do the rest if fast forwarding
						if((Integer)rtD.ffTo!=iZ)break
						index=index+stepValue
						rtD.systemVars[sDLLRINDX].v=index
						if(isEach && (Integer)rtD.ffTo==iZ)setSystemVariableValue(rtD,sDLLRDEVICE,index<dsiz ? [devices[index.toInteger()]]:[])
						if(cntrVar!=sNULL && (Integer)rtD.ffTo==iZ)Map n=setVariable(rtD,cntrVar, isEach ? (index<dsiz ? [devices[index.toInteger()]]:[]):index)
						rtD.cache[sidx]=index
						if((stepValue>dZ && index>endValue) || (stepValue<dZ && index<endValue)){
							perform=false
							break
						}
					}
					break
				case sSWITCH:
					Map lo=[operand: (Map)statement.lo,values: (List)evaluateOperand(rtD,statement,(Map)statement.lo)]
					Boolean fnd=false
					Boolean implctBr= (String)statement.ctp==sI // case traversal policy, i- autobreak (def), e- fall thru
					Boolean fallThru=!implctBr
					perform=false
					if(lg)debug "Evaluating switch with values $lo.values",rtD
					//go through all cases
					String sisir='is_inside_of_range'
					String sis='is'
					for(Map _case in (List<Map>)statement.cs){
						Map ro=[operand: (Map)_case.ro,values: (List)evaluateOperand(rtD,_case,(Map)_case.ro)]
						Boolean isR=(String)_case.t==sR // _case.t - r- range, s- single value
						Map ro2= isR ? [operand: (Map)_case.ro2,values: (List)evaluateOperand(rtD,_case,(Map)_case.ro2,null,false,true)]:null
						perform=perform || evaluateComparison(rtD,(isR ? sisir : sis),lo,ro,ro2)
						fnd=fnd || perform
						if(perform || (fnd && fallThru) || (Integer)rtD.ffTo!=iZ){
							Integer ffTo=(Integer)rtD.ffTo
							if(!executeStatements(rtD,(List)_case.s,async)){
								//stop processing
								value=false
								if((Boolean)rtD.break){
									//reached a break continue execution outside of the switch
									value=true
									fnd=true
									fallThru=false
									rtD.break=false
								}
								if((Integer)rtD.ffTo==iZ) break
							}
							//if the fast forwarding ended during this execution, assume fnd is true
							fnd=fnd || (ffTo!=(Integer)rtD.ffTo)
							value=true
							//if implicit breaks
							if(implctBr && (Integer)rtD.ffTo==iZ){
								fallThru=false
								break
							}
						}
					}
					if(statement.e && ((List)statement.e).size() && (value || (Integer)rtD.ffTo!=iZ) && (!fnd || fallThru || (Integer)rtD.ffTo!=iZ)){
						//no case found, do the default
						if(!executeStatements(rtD,(List)statement.e,async)){
							//stop processing
							value=false
							if((Boolean)rtD.break){
								//reached a break, want to continue execution outside of the switch
								value=true
								rtD.break=false
							}
							if((Integer)rtD.ffTo==iZ)break
						}
					}
					break
				case sDO:
					value=executeStatements(rtD,(List)statement.s,async)
					break
				case sBREAK:
					if((Integer)rtD.ffTo==iZ) rtD.break=true
					value=false
					break
				case sEXIT:
					if((Integer)rtD.ffTo==iZ){
						def ss=((Map)evaluateOperand(rtD,null,(Map)statement.lo)).v
						String s= matchCast(rtD,ss,sSTR) ? (String)ss : (String)cast(rtD,ss,sSTR)
						Long l=vcmd_setState(rtD,null,[s])
						rtD.terminated=true
						if(lg)debug "Exiting piston due to exit statement",rtD
					}
					value=false
					break
			}
			//break the loop
			if((Integer)rtD.ffTo!=iZ || isIf)perform=false

			//is this statement a loop
			Boolean loop=(stateType in ls1)
			if(loop && !value && (Boolean)rtD.break){
				//someone requested a break from the loop
				rtD.break=false
				//allowing the rest to continue
				value=true
				perform=false
			}
			//repeat the loop?
			repeat=perform && value && loop && (Integer)rtD.ffTo==iZ

			Long overBy=checkForSlowdown(rtD)
			if(overBy>lZ){
				Long delay= overBy>(Long)getPistonLimits.useBigDelay ? (Long)getPistonLimits.taskLongDelay : (Long)getPistonLimits.taskShortDelay
				String mstr=str+":Execution time exceeded by ${overBy}ms, ".toString()
				if(repeat && overBy>(Long)getPistonLimits.executionTime){
					error mstr+'Terminating',rtD
					rtD.terminated=true
					repeat=false
				}else doPause(mstr+'Waiting for '+delay+sMS,delay,rtD)
			}
		} // end while
	}
	if((Integer)rtD.ffTo==iZ){
		Map schedule
		if(stateType==sEVERY){
			Map t0=((List<Map>)rtD.schedules).find{ Map it -> (Integer)it.s==stmtNm}
			if(t0==null){
				List<Map> schedules=sgetSchedules(str+s1,myPep)
				schedule=schedules.find{ Map it -> (Integer)it.s==stmtNm }
			}else schedule=t0
		}
		String myS="s:${stmtNm}".toString()
		Long myL=elapseT(t)
		def v
		if(schedule!=null) //timers need to show the remaining time
			v=elapseT((Long)schedule.t)
		else v=value
		tracePoint(rtD,myS,myL,v)
	}
	//if(statement.a==s1){
	//when an async action requests the thread termination, we continue to execute the parent
		//when an async action terminates as a result of a time event we exit completely
		//value=(rtD.event.name!=sTIME)
	//}
	if(selfAsync){
		//if running in async mode return true (to continue execution)
		value=!(Boolean)rtD.resumed
		rtD.resumed=false
	}
	if((Boolean)rtD.terminated) value=false
	//restore current condition
	rtD.stack.c=c
	if(stacked){ Integer tc=((List<Integer>)rtD.stack.cs).pop() }
	rtD.stack.s=(Integer)((List<Integer>)rtD.stack.ss).pop()
	rtD.systemVars[sDLLRINDX].v=svIndex
	rtD.systemVars[sDLLRDEVICE].v=svDevice
	rtD.cndtnStChgd=svCSC
	Boolean ret=value || (Integer)rtD.ffTo!=iZ
	if((Boolean)rtD.eric)myDetail rtD,mySt+" result:"+ret.toString()
	return ret
}

private Long checkForSlowdown(Map rtD){
	//return how long over the time limit
	Long t2=(Long)rtD.tPause
	t2=t2!=null ? t2: lZ
	Long curRunTime=elapseT((Long)rtD.timestamp)-t2-(Long)getPistonLimits.slTime
	Long overBy= curRunTime>lZ ? curRunTime : lZ
	return overBy
}

private void doPause(String mstr,Long delay,Map rtD,Boolean ign=false){
	Long actDelay=lZ
	Long t0=(Long)now()
	if((Long)rtD.lastPause==null || ign || (t0-(Long)rtD.lastPause)>(Long)getPistonLimits.slTime){
		if((Integer)rtD.logging>i1)trace mstr+'; lastPause: '+rtD.lastPause,rtD
		rtD.lastPause=t0
		pauseExecution(delay)
		Long t1=(Long)now()
		actDelay=t1-t0
		Long t2=(Long)rtD.tPause
		t2=t2!=null ? t2:lZ
		rtD.tPause=t2+actDelay
		rtD.lastPause=t1
		t2=(Long)state.pauses
		t2=t2!=null ? t2:lZ
		state.pauses=t2+1L
	}
	//return actDelay
}

private Boolean executeAction(Map rtD,Map statement,Boolean async){
	String mySt=sNULL
	if((Boolean)rtD.eric){
		mySt='executeAction '+ffwding(rtD)
		myDetail rtD,mySt,i1
	}
	List svDevices=(List)rtD.systemVars[sDLLRDEVS].v
	//if override
	if((Integer)rtD.ffTo==iZ && (String)statement.tsp!=sA) // Task scheduling policy - a- allow multiple schedules, ""-override existing (def)
		cancelStatementSchedules(rtD,(Integer)statement.$)
	Boolean result=true
	List<String> deviceIds=expandDeviceList(rtD,(List)statement.d)
	List devices=deviceIds.collect{ String it -> getDevice(rtD,it)}
	rtD.currentAction=statement
	for(Map task in (List<Map>)statement.k){
		if(task.$!=null && (Integer)task.$==(Integer)rtD.ffTo){
			//resuming a waiting task need to bring back the devices
			if(rtD.event && (Map)rtD.event.schedule && (Map)rtD.event.schedule.stack){
				rtD.systemVars[sDLLRINDX].v=(Double)rtD.event.schedule.stack.index
				rtD.systemVars[sDLLRDEVICE].v=(List)rtD.event.schedule.stack.device
				if(rtD.event.schedule.stack.devices instanceof List){
					deviceIds=(List)rtD.event.schedule.stack.devices
					rtD.systemVars[sDLLRDEVS].v=deviceIds
					devices=deviceIds.collect{ getDevice(rtD,(String)it)}
				}
			}
		}
		rtD.systemVars[sDLLRDEVS].v=deviceIds
		result=executeTask(rtD,devices,statement,task,async)
		if(!result && (Integer)rtD.ffTo==iZ) break
	}
	rtD.remove('currentAction')
	rtD.systemVars[sDLLRDEVS].v=svDevices
	if((Boolean)rtD.eric)myDetail rtD,mySt+"result:$result".toString()
	return result
}

private Boolean executeTask(Map rtD,List devices,Map statement,Map task,Boolean async){
	Long t=(Long)now()
	String myS='t:'+(Integer)task.$
	if((Integer)rtD.ffTo!=iZ){
		if((Integer)task.$==(Integer)rtD.ffTo){
			//finally reached the resuming point play nicely from hereon
			tracePoint(rtD,myS,elapseT(t),null)
			rtD.ffTo=iZ
			//restore $device and $devices
			rtD.resumed=true
		}
		//not doing anything we are fast forwarding
		return true
	}
	if(task.m!=null && task.m instanceof List && ((List)task.m).size()>iZ){
		if(rtD.locationModeId==null){
			def mode=location.getCurrentMode()
			rtD.locationModeId=mode!=null ? hashId((Long)mode.getId()):null
		}
		if(!((String)rtD.locationModeId in (List)task.m)){
			if((Integer)rtD.logging>i2)debug "Skipping task ${(Integer)task.$} because of mode restrictions",rtD
			return true
		}
	}
	String mySt=sNULL
	if((Boolean)rtD.eric){
		mySt='executeTask '+(String)task.c+" async:${async} devices: ${devices.size()} ".toString()
		myDetail rtD,mySt,i1
	}
	//parse parameters
	List params=[]
	for(Map param in (List<Map>)task.p){
		def p=null
		switch((String)param.vt){
			case sVARIABLE: // vcmd_setVariable command, first argument is the variable name
				if((String)param.t==sX) p=param.x instanceof List ? (List)param.x : (String)param.x+((String)param.xi!=sNULL ? sLB+(String)param.xi+sRB:sBLK)
				break
			default:
				Map v=(Map)evaluateOperand(rtD,null,param)
				String tt1=((String)param.vt).replace(sLRB,sBLK)
				def t0=v.v
				//if not selected, return the null to fill in parameter
				p= t0==null || matchCast(rtD,t0,tt1) ? t0 : evaluateExpression(rtD,v,tt1).v
		}
		//ensure value type is successfuly passed through
		Boolean a=params.push(p)
	}

	//handle duplicate command "push" which was replaced with fake command "pushMomentary"
	def override=CommandsOverrides.find{ (String)it.value.r==(String)task.c }
	String command=override ? (String)override.value.c:(String)task.c

	def virtualDevice=devices.size()!=iZ ? null:location
// If the VirtualCommand exists and has o:true use that virtual command otherwise try the physical command
	Map vcmd=VirtualCommands()[command]
	Long delay=lZ
	if((Boolean)rtD.eric)myDetail rtD,mySt+"params: $params",iN2
	for(device in (virtualDevice!=null ? [virtualDevice]:devices)){
		if(virtualDevice==null && device?.hasCommand(command) && !(vcmd && vcmd.o /* virtual command does not override physical command */)){
			Map msg=timer "Executed [$device].${command}",rtD
			try{
				delay="cmd_${command}"(rtD,device,params)
			}catch(ignored){
				executePhysicalCommand(rtD,device,command,params)
			}
			if((Integer)rtD.logging>i1)trace msg,rtD
		}else{
			if(vcmd!=null){
				delay=executeVirtualCommand(rtD,vcmd.a ? devices:device,command,params)
				//aggregate commands only run once for all devices at the same time
				if(vcmd.a)break
			}
		}
	}
	//negative delays force us to reschedule
	Boolean reschedule= delay<lZ
	delay=reschedule ? -delay:delay

	//if we don't have to wait, home free
	String pStr= "executeTask: Waiting for "
	if(delay!=lZ){
		//get remaining piston time
		if(reschedule || async || delay>(Long)getPistonLimits.taskMaxDelay){
			//schedule a wake up
			Long msec=delay
			if((Integer)rtD.logging>i1)trace "Requesting a wake up for ${formatLocalTime(Math.round((Long)now()*d1+delay))} (in ${msec}ms)",rtD
			tracePoint(rtD,myS,elapseT(t),-delay)
			requestWakeUp(rtD,statement,task,delay,(String)task.c)
			if((Boolean)rtD.eric)myDetail rtD,mySt+"result:FALSE"
			return false
		}else doPause(pStr+"${delay}ms",delay,rtD,true)
	}
	tracePoint(rtD,myS,elapseT(t),delay)

	//get remaining piston time
	Long overBy=checkForSlowdown(rtD)
	if(overBy>lZ){
		Long mdelay= overBy>(Long)getPistonLimits.useBigDelay ? (Long)getPistonLimits.taskLongDelay : (Long)getPistonLimits.taskShortDelay
		doPause(pStr+"${mdelay}ms, Execution time exceeded by ${overBy}ms",mdelay,rtD)
	}
	if((Boolean)rtD.eric)myDetail rtD,mySt+"result:TRUE"
	return true
}

private Long executeVirtualCommand(Map rtD,devices,String command,List params){
	Map msg=timer "Executed virtual command ${devices ? (devices instanceof List ? "$devices.":"[$devices]."):sBLK}${command}",rtD
	Long delay=lZ
	try{
		delay="vcmd_${command}"(rtD,devices,params)
		if((Integer)rtD.logging>i1)trace msg,rtD
	}catch(all){
		msg.m="Error executing virtual command ${devices instanceof List ? "$devices":"[$devices]"}.${command}:"
		msg.e="$all"
		error msg,rtD,iN2,all
	}
	return delay
}

private void executePhysicalCommand(Map rtD,device,String command,params=[],Long idel=lZ,String isched=sNULL,Boolean dco=false,Boolean doced=true, Boolean canq=true){
	Long delay=idel
	String scheduleDevice=isched
	Boolean willQ=delay!=lZ && scheduleDevice!=sNULL

	Boolean elg=(Boolean)rtD.eric
	//delay on device commands is not supported in hubitat; using schedules instead
	String s=sBLK
	String s1=sBLK
	if(elg)s1="wait before command delay: $delay "
	Boolean ignRest=false
	if(doced){
		Long t0=(Integer)rtD.piston.o?.ced ? ((Integer)rtD.piston.o.ced).toLong():lZ
		if(t0>lZ){
			Long t1=(Long)getPistonLimits.deviceMaxDelay
			t0=t0>t1 ? t1:t0
			Long cmdqt= (Long)rtD.lastPCmdQ ?: lZ
			Long cmdsnt=(Long)rtD.lastPCmdSnt ?: lZ
			Long lastcmdSent= cmdqt&&cmdsnt ? Math.max(cmdqt,cmdsnt) : (cmdqt ?: cmdsnt)
			Long waitT= t0+lastcmdSent-(Long)now()
			String sst=sBLK
			if(elg)sst=s1+"cmdqt: $cmdqt cmdsnt: $cmdsnt waitT: $waitT lastcmdSent: $lastcmdSent ced: $t0 "
			s="No command execution delay required "+s1
			if(waitT>t0/i4){
				t1=delay
				ignRest= !willQ
				delay= waitT>delay ? waitT:delay
				scheduleDevice= scheduleDevice ?: hashId(device.id)
				willQ=true
				if(waitT>t1) s="Injecting command execution delay of ${waitT-t1}ms before [$device].$command() added schedule "
			}
			if(elg)s+=sst+"updated delay: $delay ignore restrictions: $ignRest"
		}
	}

	if(willQ && canq){
		Map statement=(Map)rtD.currentAction
		// cancel on c- condition state change (def), p- piston state change, b- condition or piston state change, ""- never cancel
		List<Integer> cs=[]+ ((String)statement.tcp in [sB,sC] ? (rtD.stack?.cs!=null ? (List<Integer>)rtD.stack.cs:[]):[]) // task cancelation policy
		Integer ps= (String)statement.tcp in [sB,sP] ? i1:iZ
		Boolean a=cs.removeAll{ Integer it -> it==iZ }
		Long ttt=Math.round((Long)now()*d1+delay)
		rtD.lastPCmdQ=ttt
		Map schedule=[
			(sT):ttt,
			(sS):(Integer)statement.$,
			(sI):iN3,
			cs:cs,
			ps:ps,
			(sD):[
				(sD):scheduleDevice,
				(sC):command,
				(sP):params
			]
		]
		if(ignRest){
			schedule.d.dc=dco
			schedule.d.ig=ignRest
		}
		if(elg)trace s+"Requesting a physical command wake up for ${formatLocalTime(ttt)}",rtD
		a=((List<Map>)rtD.schedules).push(schedule)
	}else{
		try{
			List nparams=(params instanceof List) ? (List)params : (params!=null ? [params]:[])
			//cleanup the params so that SONOS works
			Integer psz=nparams.size()
			def a
			while (psz>iZ && nparams[psz-i1]==null){ a=nparams.pop(); psz=nparams.size() }
			Boolean doL=(Integer)rtD.logging>i2
			String tailStr=sNULL
			if(!canq && delay>lZ){
				Long t1=(Long)getPistonLimits.deviceMaxDelay
				delay=delay>t1 ? t1:delay
				doPause("PAUSE wait before device command: Waiting for ${delay}ms",delay,rtD,true)
				if(doL) tailStr="[delay: $delay])".toString()
			}
			Map msg=null
			if(doL)msg=timer sBLK,rtD
			Boolean skip=false
			// disableCommandOptimization
			if(!(Integer)rtD.piston.o?.dco && !dco && !(command in [sSCLRTEMP,sSCLR,sSHUE,sSSATUR])){
				Map cmd=PhysicalCommands()[command]
				if(cmd!=null && (String)cmd.a!=sNULL){
					if(cmd.v!=null && psz==iZ){
						//commands with no parameter that set an attribute to a preset value
						if ((String)getDeviceAttributeValue(rtD,device,(String)cmd.a)==(String)cmd.v) skip=true
					}else if(psz==i1){
						if(getDeviceAttributeValue(rtD, device, (String)cmd.a)==nparams[iZ])
							skip=(command in [sSTLVL,sSTIFLVL] ? (String)getDeviceAttributeValue(rtD,device,sSWITCH)==sON:true)
					}
				}
			}

			String tstr=sNULL
			if(doL) tstr=' physical command ['+"${(String)device.label ?: (String)device.name}".toString()+'].'+command+'('
			if(skip){
				if(doL) msg.m='Skipped execution of'+tstr+"$nparams".toString()+') because it would make no change to the device.'+s
			}else{
				if(doL) tstr='Executed'+tstr
				rtD.lastPCmdSnt=(Long)now()
				if(psz>iZ){
					if(doL) msg.m=tstr+nparams.join(',')+"${tailStr ? ','+tailStr : ')'}"
					device."$command"(nparams as Object[])
				}else{
					if(doL) msg.m=tstr+"${tailStr ?: ')'}"
					device."$command"()
				}
			}
			if(doL)debug msg,rtD
		}catch(all){
			error "Error while executing physical command $device.$command($nparams):",rtD,iN2,all
		}
	}
}

private void scheduleTimer(Map rtD,Map timer,Long lastRun=lZ){
	//if already scheduled once during this run, don't do it again
	if(((List<Map>)rtD.schedules).find{ Map it -> (Integer)it.s==(Integer)timer.$ })return
	String mySt=sNULL
	if((Boolean)rtD.eric){
		mySt="scheduleTimer ${timer.$} ${timer.lo} ${timer.lo2} ${timer.lo3} $lastRun"
		myDetail rtD,mySt,i1
	}
	//complicated stuff follows
	String tinterval="${((Map)evaluateOperand(rtD,null,(Map)timer.lo)).v}".toString()
	Boolean exitOut=false
	Integer interval=iZ
	if(tinterval.isInteger()){
		interval=tinterval.toInteger()
		if(interval<=iZ)exitOut=true
	}else exitOut=true
	if(exitOut){
		if((Boolean)rtD.eric)myDetail rtD,mySt
		return
	}
	String intervalUnit=(String)timer.lo.vt
	Integer level=iZ
	Long delta=lZ
	switch(intervalUnit){
		case sMS: level=i1; delta=1L; break
		case sS: level=i2; delta=lTHOUS; break
		case sM: level=i3; delta=dMSMINT.toLong(); break
		case sH: level=i4; delta=dMSECHR.toLong(); break
		case sD: level=i5; break
		case 'w': level=i6; break
		case sN: level=7; break
		case 'y': level=8; break
	}

	Long time=lZ
	if(delta==lZ){
		//let's get the offset
		time=(Long)evaluateExpression(rtD,(Map)evaluateOperand(rtD,null,(Map)timer.lo2),sDTIME).v
		if((String)timer.lo2.t!=sC){
			Map offset=(Map)evaluateOperand(rtD,null,(Map)timer.lo3)
			time+= (Long)evaluateExpression(rtD,rtnMap1(sDURATION,offset.v,(String)offset.vt),sLONG).v
		}
		//resulting is sDTIME
		if(lastRun==lZ) //first run, just adjust the time so in the future
			time=pushTimeAhead(time,(Long)now())
	}
	delta=Math.round(delta*interval*d1)
	Boolean priorActivity=lastRun!=lZ

	Long rightNow=(Long)now()
	Long lastR=lastRun!=lZ ? lastRun:rightNow
	Long nextSchedule=lastR

	if(lastR>rightNow) //sometimes timers run early, so make sure at least in the near future
		rightNow=Math.round(lastR+d1)

	if(intervalUnit==sH){
		Long min=(Long)cast(rtD,timer.lo.om,sLONG)
		nextSchedule=Math.round(dMSECHR*Math.floor(nextSchedule/dMSECHR)+(min*dMSMINT))
	}

	//next date
	Integer cycles=100
	while(cycles!=iZ){
		if(delta!=lZ){
			if(nextSchedule<(rightNow-delta)){
				//behind, catch up to where the next future occurrence
				Long cnt=Math.floor((rightNow-nextSchedule)/delta*d1).toLong()
				//if((Integer)rtD.logging>i2)debug "Timer fell behind by $cnt interval${cnt>i1 ? sS:sBLK}, catching up",rtD
				nextSchedule=Math.round(nextSchedule+delta*cnt*d1)
			}
			nextSchedule=nextSchedule+delta
		}else{
			//advance ahead of rightNow if in the past
			time=pushTimeAhead(time,rightNow)
			Long lastDay=Math.floor(nextSchedule/dMSDAY).toLong()
			Long thisDay=Math.floor(time/dMSDAY).toLong()

			Date adate=new Date(time)
			Integer dyYear=adate.year
			Integer dyMon=adate.month
			Integer dyDay=adate.day

			//the repeating interval is not necessarily constant
			//noinspection GroovyFallthrough
			switch(intervalUnit){
				case sD:
					if(priorActivity){
						//add the required number of days
						nextSchedule=time+Math.round(dMSDAY*(interval-(thisDay-lastDay)))
					}else nextSchedule=time
					break
				case 'w':
					//figure out the first day of the week matching the requirement
					Long currentDay=dyDay //(new Date(time)).day
					Long requiredDay=(Long)cast(rtD,timer.lo.odw,sLONG)
					if(currentDay>requiredDay)requiredDay+= 7
					//move to first matching day
					nextSchedule=time+Math.round(dMSDAY*(requiredDay-currentDay))
					if(nextSchedule<rightNow) nextSchedule=Math.round(nextSchedule+604800000.0D*interval)
					break
				case sN:
				case 'y':
					//figure out the first day of the week matching the requirement
					Integer odm=timer.lo.odm.toInteger()
					def odw=timer.lo.odw
					Integer omy=intervalUnit=='y' ? timer.lo.omy.toInteger():iZ
					Integer day
					Date date= adate // new Date(time)
					Integer year=dyYear //date.year
					Integer month=Math.round((intervalUnit==sN ? dyMon /*date.month*/:omy)+(priorActivity ? interval:((nextSchedule<rightNow)? d1:dZ))*(intervalUnit==sN ? d1:12.0D)).toInteger()
					if(month>=12){
						year+= Math.floor(month/12.0D).toInteger()
						month= month % 12
					}
					date.setDate(1)
					date.setMonth(month)
					date.setYear(year)

					Integer lastDayOfMonth= (new Date(date.year,date.month+i1,0)).date
					if(odw==sD){
						if(odm>iZ) day=(odm<=lastDayOfMonth)? odm:iZ
						else{
							day=lastDayOfMonth+i1+odm
							day=(day>=i1)? day:iZ
						}
					}else{
						Integer iodw=odw.toInteger()
						Double d7=7.0D
						//locate the nth week day of the month
						if(odm>iZ){
							//going forward
							Integer firstDayOfMonthDOW=(new Date(date.year,date.month,1)).day
							//locate the first matching day
							Integer firstMatch=Math.round(i1+iodw-firstDayOfMonthDOW+(iodw<firstDayOfMonthDOW ? d7:dZ)).toInteger()
							day=Math.round(firstMatch+d7*(odm-d1)).toInteger()
							day=(day<=lastDayOfMonth)? day:iZ
						}else{
							//going backwards
							Integer lastDayOfMonthDOW=(new Date(date.year,date.month+i1,0)).day
							//locate the first matching day
							Integer firstMatch=lastDayOfMonth+iodw-lastDayOfMonthDOW-(iodw>lastDayOfMonthDOW ? 7:iZ)
							day=Math.round(firstMatch+d7*(odm+i1)).toInteger()
							day=(day>=i1)? day:iZ
						}
					}
					if(day){
						date.setDate(day)
						nextSchedule=date.getTime()
					}
					break
			}
		}
		//check to see if it fits the restrictions
		if(nextSchedule>=rightNow){
			Long offset=checkTimeRestrictions(rtD,(Map)timer.lo,nextSchedule,level,interval)
			if(offset==lZ)break
			if(offset>lZ)nextSchedule+= offset
		}
		time=nextSchedule
		priorActivity=true
		cycles-= i1
	}

	if(nextSchedule>lastR){
		Boolean a=((List<Map>)rtD.schedules).removeAll{ Map it -> (Integer)it.s==(Integer)timer.$ }
		requestWakeUp(rtD,timer,[(sDLR):iN1],nextSchedule)
	}
	if((Boolean)rtD.eric)myDetail rtD,mySt
}

private Long pushTimeAhead(Long pastTime,Long curTime){
	Long retTime=pastTime
	while(retTime<curTime){
		Long t0=Math.round(retTime+dMSDAY)
		Long t1=Math.round(t0+(((TimeZone)location.timeZone).getOffset(retTime)-((TimeZone)location.timeZone).getOffset(t0))*d1)
		retTime=t1
	}
	return retTime
}

private void scheduleTimeCondition(Map rtD,Map condition){
	if((Boolean)rtD.eric)myDetail rtD,"scheduleTimeCondition",i1
	Integer conditionNum=(Integer)condition.$
	//if already scheduled once during this run, don't do it again
	if(((List<Map>)rtD.schedules).find{ Map it -> (Integer)it.s==conditionNum && (Integer)it.i==iZ })return
	String co=(String)condition.co
	Map comparison=Comparisons().conditions[co]
	Boolean trigger=false
	if(comparison==null){
		comparison=Comparisons().triggers[co]
		if(comparison==null)return
		trigger=true
	}
	cancelStatementSchedules(rtD,conditionNum)
	Integer pCnt=comparison.p!=null ? (Integer)comparison.p:iZ
	if(!pCnt)return

	Map tv1=condition.ro!=null && (String)condition.ro.t!=sC ? (Map)evaluateOperand(rtD,null,(Map)condition.to):null
	Long v1=(Long)evaluateExpression(rtD,(Map)evaluateOperand(rtD,null,(Map)condition.ro),sDTIME).v + (tv1!=null ? (Long)evaluateExpression(rtD,rtnMap1(sDURATION,tv1.v,(String)tv1.vt),sLONG).v : lZ)
	Map tv2=condition.ro2!=null && (String)condition.ro2.t!=sC && pCnt>i1 ? (Map)evaluateOperand(rtD,null,(Map)condition.to2):null
	Long v2=trigger ? v1 : (pCnt>i1 ? ((Long)evaluateExpression(rtD,(Map)evaluateOperand(rtD,null,(Map)condition.ro2,null,false,true),sDTIME).v + (tv2!=null ? (Long)evaluateExpression(rtD,rtnMap1(sDURATION,tv2.v,(String)tv2.vt)).v : lZ)) : (String)condition.lo.v==sTIME ? getMidnightTime():v1 )
	Long n=Math.round(d1*(Long)now()+2000L)
	if((String)condition.lo.v==sTIME){
		v1=pushTimeAhead(v1,n)
		v2=pushTimeAhead(v2,n)
	}
	//figure out the next time
	v1=v1<n ? v2:v1
	v2=v2<n ? v1:v2
	n=v1<v2 ? v1:v2
	if(n>(Long)now()){
		if((Integer)rtD.logging>i2)debug "Requesting time schedule wake up at ${formatLocalTime(n)}",rtD
		requestWakeUp(rtD,condition,[(sDLR):iZ],n)
	}
	if((Boolean)rtD.eric)myDetail rtD,"scheduleTimeCondition"
}

private static Long checkTimeRestrictions(Map rtD,Map operand,Long time,Integer level,Integer interval){
	//returns 0 if restrictions are passed
	//returns a positive number as millisecond offset to apply to nextSchedule for fast forwarding
	//returns a negative number as a failed restriction with no fast forwarding offset suggestion

	// on minute of hour
	List<Integer> om=level<=i2 && operand.om instanceof List && ((List)operand.om).size()>iZ ? (List<Integer>)operand.om:null
	// on hours
	List<Integer> oh=level<=i3 && operand.oh instanceof List && ((List)operand.oh).size()>iZ ? (List<Integer>)operand.oh:null
	// on day(s) of week
	List<Integer> odw=level<=i5 && operand.odw instanceof List && ((List)operand.odw).size()>iZ ? (List<Integer>)operand.odw:null
	// on day(s) of month
	List<Integer> odm=level<=i6 && operand.odm instanceof List && ((List)operand.odm).size()>iZ ? (List<Integer>)operand.odm:null
	// on weeks of month
	List<Integer> owm=level<=i6 && odm==null && operand.owm instanceof List && ((List)operand.owm).size()>iZ ? (List<Integer>)operand.owm:null
	// on month of year
	List<Integer> omy=level<=7 && operand.omy instanceof List && ((List)operand.omy).size()>iZ ? (List<Integer>)operand.omy:null

	if(om==null && oh==null && odw==null && odm==null && owm==null && omy==null)return lZ
	Date date=new Date(time)
	Integer dyYear=date.year
	Integer dyMon=date.month
	Integer dyDate=date.date
	Integer dyDay=date.day
	Integer dyHr=date.hours
	Integer dyMins=date.minutes

	Double dminDay=1440.0D
	Double dsecDay=86400.0D

	Long lMO=-1L
	Long result=lMO
	//month restrictions
	if(omy!=null && omy.indexOf(dyMon+i1)<iZ){
		List<Integer> tI=omy.sort{ Integer it -> it }
		Integer month=(tI.find{ Integer it -> it>dyMon+i1 } ?: 12+tI[iZ]) -i1
		Integer year=dyYear+(month>=12 ? i1:iZ)
		month=(month>=12 ? month-12:month)
		Long ms=(new Date(year,month,1)).getTime()-time
		switch(level){
			case i2: //by second
				result=Math.round(interval*(Math.floor(ms/d1000/interval)-d2)*d1000)
				break
			case i3: //by minute
				result=Math.round(interval*(Math.floor(ms/dMSMINT/interval)-d2)*dMSMINT)
				break
		}
		return result>lZ ? result:lMO
	}

	Double d7=7.0D
	//week of month restrictions
	if(owm!=null && !(owm.indexOf(getWeekOfMonth(date))>=iZ || owm.indexOf(getWeekOfMonth(date,true))>=iZ)){
		switch(level){
			case i2: //by second
				result=Math.round(interval*(Math.floor(((d7-dyDay)*dsecDay-dyHr*dSECHR-dyMins*d60)/interval)-d2)*d1000)
				break
			case i3: //by minute
				result=Math.round(interval*(Math.floor(((d7-dyDay)*dminDay-dyHr*d60-dyMins)/interval)-d2)*dMSMINT)
				break
		}
		return result>lZ ? result:lMO
	}

	//day of month restrictions
	if(odm!=null && odm.indexOf(dyDate)<iZ){
		Integer lastDayOfMonth=new Date(dyYear,dyMon+i1,0).date
		if(odm.find{ Integer it -> it<i1 }){
			//we need to add the last days
			odm= []+odm as List<Integer> //copy the array
			if(odm.indexOf(-1)>=iZ)Boolean a=odm.push(lastDayOfMonth)
			if(odm.indexOf(-2)>=iZ)Boolean a=odm.push(lastDayOfMonth-i1)
			if(odm.indexOf(-3)>=iZ)Boolean a=odm.push(lastDayOfMonth-i2)
			Boolean a=odm.removeAll{ Integer it -> it<i1 }
		}
		List<Integer> tI=odm.sort{ Integer it -> it }
		switch(level){
			case i2: //by second
				result=Math.round(interval*(Math.floor((((tI.find{ Integer it -> it>dyDate } ?: lastDayOfMonth+tI[iZ])-dyDate)*dsecDay-dyHr*dSECHR-dyMins*d60)/interval)- d2)*d1000)
				break
			case i3: //by minute
				result=Math.round(interval*(Math.floor((((tI.find{ Integer it -> it>dyDate } ?: lastDayOfMonth+tI[iZ])-dyDate)*dminDay-dyHr*d60-dyMins)/interval)-d2)*dMSMINT)
				break
		}
		return result>lZ ? result:lMO
	}

	//day of week restrictions
	if(odw!=null && odw.indexOf(dyDay)<iZ ){
		List<Integer> tI=odw.sort{ Integer it -> it }
		switch(level){
			case i2: //by second
				result=Math.round(interval*(Math.floor((((tI.find{ Integer it -> it>dyDay } ?: d7+tI[iZ])-dyDay)*dsecDay-dyHr*dSECHR-dyMins*d60)/interval)-d2)*d1000)
				break
			case i3: //by minute
				result=Math.round(interval*(Math.floor((((tI.find{ Integer it -> it>dyDay } ?: d7+tI[iZ])-dyDay)*dminDay-dyHr*d60-dyMins)/interval)-d2)*dMSMINT)
				break
		}
		return result>lZ ? result:lMO
	}

	//hour restrictions
	if(oh!=null && oh.indexOf(dyHr)<iZ ){
		Double d24=24.0D
		List<Integer> tI=oh.sort{ Integer it -> it }
		switch(level){
			case i2: //by second
				result=Math.round(interval*(Math.floor((((tI.find{ Integer it -> it>dyHr } ?: d24+tI[iZ])-dyHr)*dSECHR-dyMins*d60)/interval)-d2)*d1000)
				break
			case i3: //by minute
				result=Math.round(interval*(Math.floor((((tI.find{ Integer it -> it>dyHr } ?: d24+tI[iZ])-dyHr)*d60-dyMins)/interval)-d2)*dMSMINT)
				break
		}
		return result>lZ ? result:lMO
	}

	//minute restrictions
	if(om!=null && om.indexOf(dyMins)<iZ ){
		//get the next highest minute
	//suggest an offset to reach the next minute
		List<Integer> tI=om.sort{ Integer it -> it }
		result=Math.round(interval*(Math.floor(((tI.find{ Integer it -> it>dyMins } ?: d60+tI[iZ])-dyMins-d1)*d60/interval)-d2)*d1000)
		return result>lZ ? result:lMO
	}
	return lZ
}

//return the number of occurrences of same day of week up until the date or from the end of the month if backwards,i.e. last Sunday is -1, second-last Sunday is -2
private static Integer getWeekOfMonth(Date date,Boolean backwards=false){
	Integer day=date.date
	if(backwards){
		Integer month=date.month
		Integer year=date.year
		Integer lastDayOfMonth=(new Date(year,month+i1,0)).date
		return -(i1+Math.floor((lastDayOfMonth-day)/7))
	}else return i1+Math.floor((day-i1)/7) //1 based
}

private void requestWakeUp(Map rtD,Map statement,Map task,Long timeOrDelay,String data=sNULL){
	Long time=timeOrDelay>9999999999L ? timeOrDelay:(Long)now()+timeOrDelay
	// cancel on c- condition state change (def), p- piston state change, b- condition or piston state change, ""- never cancel
	List<Integer> cs=[]+ ((String)statement.tcp in [sB,sC] ? (rtD.stack?.cs!=null ? (List<Integer>)rtD.stack.cs:[]):[]) // task cancelation policy
	Integer ps= (String)statement.tcp in [sB,sP] ? i1:iZ
	Boolean a=cs.removeAll{ Integer it -> it==iZ }
// state to save across a sleep
	Boolean fnd=false
	def myResp=rtD.response
	if(myResp.toString().size()>10000){ myResp=[:]; fnd=true } // state can only be total 100KB
	def myJson=rtD.json
	if(myJson.toString().size()>10000){ myJson=[:]; fnd=true }
	if(fnd) debug 'trimming from scheduled wakeup saved $response and/or $json due to large size',rtD
	Map<String,Map>sysV=(Map<String,Map>)rtD.systemVars
	Map mmschedule=[
		(sT):time,
		(sS):(Integer)statement.$,
		(sI):task?.$!=null ? (Integer)task.$:iZ,
		cs:cs,
		ps:ps,
		(sD):data,
		evt:(Map)rtD.currentEvent,
		args:rtD.args,
		stack:[
			index:(Double)sysV[sDLLRINDX].v,
			(sDEV):(List)sysV[sDLLRDEVICE].v,
			devices:(List)sysV[sDLLRDEVS].v,
			json:myJson ?: [:],
			response:myResp ?: [:]
// what about previousEvent httpContentType httpStatusCode httpStatusOk iftttStatusCode iftttStatusOk "\$mediaId" "\$mediaUrl" "\$mediaType" mediaData (big)
// currentEvent in case of httpRequest
		]
	]
	a=((List<Map>)rtD.schedules).push(mmschedule)
}

private Long do_setLevel(Map rtD,device,List params,String attr,Integer val=null){
	Integer arg=val!=null ? val:(Integer)params[iZ]
	Integer psz=params.size()
	String mat=psz>i1 ? (String)params[i1]:sNULL
	if(mat!=sNULL && (String)getDeviceAttributeValue(rtD,device,sSWITCH)!=mat) return lZ
	if(attr==sSCLRTEMP && psz>i2){ // setColorTemp takes level and seconds duration arguments (optional)
		Integer lvl=(Integer)params[i2]
		Long delay=psz>i3 ? (Long)params[i3]:lZ
		List larg=[arg]
		if(lvl||delay)larg.push(lvl)
		if(delay)larg.push(delay.toInteger())
		executePhysicalCommand(rtD,device,attr,larg)
	}else{
		Long delay=psz>i2 ? (Long)params[i2]:lZ
		if(attr==sSTLVL && delay>lZ){ // setLevel takes seconds duration argument (optional)
			List larg=[arg,delay.toInteger()]
			executePhysicalCommand(rtD,device,attr,larg)
		}else executePhysicalCommand(rtD,device,attr,arg,delay)
	}
	return lZ
}

private Long cmd_setLevel(Map rtD,device,List params){
	return do_setLevel(rtD,device,params,sSTLVL)
}

private Long cmd_setInfraredLevel(Map rtD,device,List params){
	return do_setLevel(rtD,device,params,sSTIFLVL)
}

private Long cmd_setHue(Map rtD,device,List params){
	Integer hue= Math.round((Integer)params[iZ]/d3d6).toInteger()
	return do_setLevel(rtD,device,params,sSHUE,hue)
}

private Long cmd_setSaturation(Map rtD,device,List params){
	return do_setLevel(rtD,device,params,sSSATUR)
}

private Long cmd_setColorTemperature(Map rtD,device,List params){
	return do_setLevel(rtD,device,params,sSCLRTEMP)
}

private Map getColor(Map rtD,String colorValue){
	Map color=(colorValue=='Random')? getRandomColor():getColorByName(colorValue)
	if(color!=null){
		color=[
			hex:(String)color.rgb,
			(sHUE):Math.round((Integer)color.h/d3d6).toInteger(),
			(sSATUR):(Integer)color.s,
			(sLVL):(Integer)color.l
		]
	}else{
		color=hexToColor(colorValue)
		if(color!=null){
			color=[
				hex:(String)color.hex,
				(sHUE):Math.round((Integer)color.hue/d3d6).toInteger(),
				(sSATUR):(Integer)color.saturation,
				(sLVL):(Integer)color.level
			]
		}
	}
	return color
}

private Long cmd_setColor(Map rtD,device,List params){
	Map color=getColor(rtD,(String)params[iZ])
	if(!color){
		error "ERROR: Invalid color $params",rtD
		return lZ
	}
	Integer psz=params.size()
	String mat=psz>i1 ? (String)params[i1]:sNULL
	if(mat!=sNULL && (String)getDeviceAttributeValue(rtD,device,sSWITCH)!=mat) return lZ
	Long delay=psz>i2 ? (Long)params[i2]:lZ
	executePhysicalCommand(rtD,device,sSCLR,color,delay)
	return lZ
}

private Long cmd_setAdjustedColor(Map rtD,device,List params){
	Map color=getColor(rtD,(String)params[iZ])
	if(!color){
		error "ERROR: Invalid color $params",rtD
		return lZ
	}
	Integer psz=params.size()
	String mat=psz>i2 ? (String)params[i2]:sNULL
	if(mat!=sNULL && (String)getDeviceAttributeValue(rtD,device,sSWITCH)!=mat) return lZ
	Long duration=matchCastL(rtD,params[i1])
	Long delay=psz>i3 ? (Long)params[i3]:lZ
	executePhysicalCommand(rtD,device,'setAdjustedColor',[color,duration],delay)
	return lZ
}

private Long cmd_setAdjustedHSLColor(Map rtD,device,List params){
	Integer psz=params.size()
	String mat=psz>i4 ? (String)params[i4]:sNULL
	if(mat!=sNULL && (String)getDeviceAttributeValue(rtD,device,sSWITCH)!=mat) return lZ

	Long duration=matchCastL(rtD,params[i3])
	Integer hue= Math.round((Integer)params[iZ]/d3d6).toInteger()
	Integer saturation=(Integer)params[i1]
	Integer level=(Integer)params[i2]
	def color=[
		(sHUE): hue,
		(sSATUR): saturation,
		(sLVL): level
	]
	Long delay=psz>i5 ? (Long)params[i5]:lZ
	executePhysicalCommand(rtD,device,'setAdjustedColor',[color,duration],delay)
	return lZ
}

private Long cmd_setLoopDuration(Map rtD,device,List params){
	Integer duration=Math.round(matchCastL(rtD,params[iZ])/d1000).toInteger()
	executePhysicalCommand(rtD,device,'setLoopDuration',duration)
	return lZ
}

private Long cmd_setVideoLength(Map rtD,device,List params){
	Integer duration=Math.round(matchCastL(rtD,params[iZ])/d1000).toInteger()
	executePhysicalCommand(rtD,device,'setVideoLength',duration)
	return lZ
}

private Long cmd_setVariable(Map rtD,device,List params){
	def var=params[i1]
	executePhysicalCommand(rtD,device,'setVariable',var)
	return lZ
}

private Long vcmd_log(Map rtD,device,List params){
	String command=params[iZ] ? (String)params[iZ]:sBLK
	String message=(String)params[i1]
	Map a=log(message,rtD,iN2,null,command.toLowerCase().trim(),true)
	return lZ
}

private Long vcmd_setState(Map rtD,device,List params){
	String value=params[iZ]
	if((Integer)rtD.piston.o?.mps){
		rtD.state.new=value
		rtD.pstnStChgd=(Boolean)rtD.pstnStChgd || (String)rtD.state.old!=(String)rtD.state.new
	}else error "Cannot set the piston state while in automatic mode. Please edit the piston settings to disable the automatic piston state if you want to manually control the state.",rtD
	return lZ
}

private Long vcmd_setTileColor(Map rtD,device,List params){
	Integer index=matchCastI(rtD,params[iZ])
	if(index<i1 || index>16)return lZ
	String sIdx=index.toString()
	rtD.state[sC+sIdx]=(String)getColor(rtD,(String)params[i1])?.hex
	rtD.state[sB+sIdx]=(String)getColor(rtD,(String)params[i2])?.hex
	rtD.state['f'+sIdx]=!!params[i3]
	return lZ
}

private Long vcmd_setTileTitle(Map rtD,device,List params){
	return helper_setTile(rtD,sI,params)
}

private Long vcmd_setTileText(Map rtD,device,List params){
	return helper_setTile(rtD,sT,params)
}

private Long vcmd_setTileFooter(Map rtD,device,List params){
	return helper_setTile(rtD,sO,params)
}

private Long vcmd_setTileOTitle(Map rtD,device,List params){
	return helper_setTile(rtD,sP,params)
}

private Long helper_setTile(Map rtD,String typ,List params){
	Integer index=matchCastI(rtD,params[iZ])
	if(index<i1 || index>16)return lZ
	rtD.state["${typ}$index".toString()]=(String)params[i1]
	return lZ
}

private Long vcmd_setTile(Map rtD,device,List params){
	Integer index=matchCastI(rtD,params[iZ])
	if(index<i1 || index>16)return lZ
	String sIdx=index.toString()
	rtD.state[sI+sIdx]=(String)params[i1]
	rtD.state[sT+sIdx]=(String)params[i2]
	rtD.state[sO+sIdx]=(String)params[i3]
	rtD.state[sC+sIdx]=(String)getColor(rtD,(String)params[i4])?.hex
	rtD.state[sB+sIdx]=(String)getColor(rtD,(String)params[i5])?.hex
	rtD.state['f'+sIdx]=!!params[i6]
	return lZ
}

private Long vcmd_clearTile(Map rtD,device,List params){
	Integer index=matchCastI(rtD,params[iZ])
	if(index<i1 || index>16)return lZ
	String sIdx=index.toString()
	Map t0=(Map)rtD.state
	t0.remove(sI+sIdx)
	t0.remove(sT+sIdx)
	t0.remove(sC+sIdx)
	t0.remove(sO+sIdx)
	t0.remove(sB+sIdx)
	t0.remove('f'+sIdx)
	t0.remove(sP+sIdx)
	rtD.state=t0
	return lZ
}

private Long vcmd_setLocationMode(Map rtD,device,List params){
	String mIdOrNm=(String)params[iZ]
	def mode=((List)location.getModes())?.find{ hashId((Long)it.id)==mIdOrNm || (String)it.name==mIdOrNm }
	if(mode) location.setMode((String)mode.name)
	else error "Error setting location mode. Mode '$mIdOrNm' does not exist.",rtD
	return lZ
}

private Long vcmd_setAlarmSystemStatus(Map rtD,device,List params){
	String sIdOrNm=(String)params[iZ]
	Map vd=VirtualDevices()['alarmSystemStatus']
	Map<String,String> options=(Map<String,String>)vd?.ac
	List status=options?.find{ (String)it.key==sIdOrNm || (String)it.value==sIdOrNm }?.collect{ [(sID):(String)it.key,(sNM):it.value] }

	if(status && status.size()!=iZ) sendLocationEvent((sNM):sHSMSARM,(sVAL):status[iZ].id)
	else error "Error setting HSM status. Status '$sIdOrNm' does not exist.",rtD
	return lZ
}

private Long vcmd_sendEmail(Map rtD,device,List params){
	Map<String,String> data=[
		i: (String)rtD.id,
		n: (String)app.label,
		t:(String)params[iZ],
		s: (String)params[i1],
		m: (String)params[i2]
	]

	Map requestParams=[
		uri: 'https://api.webcore.co/email/send/'+(String)rtD.locationId,
		query: null,
		headers: [:],//(auth ? [Authorization: auth]:[:]),
		requestContentType: sAPPJSON,
		body: data,
		timeout:20
	]
	String msg='Unknown error'

	try{
		asynchttpPost('ahttpRequestHandler',requestParams,[command:sSENDE,em:data])
		return 24000L
	}catch(all){
		error "Error sending email to ${data.t}: $msg",rtD,iN2,all
	}
	return lZ
}

private static Long vcmd_noop(Map rtD,device,List params){
	return lZ
}

private Long vcmd_wait(Map rtD,device,List params){
	return matchCastL(rtD,params[iZ])
}

private Long vcmd_waitRandom(Map rtD,device,List params){
	Long min=matchCastL(rtD,params[iZ])
	Long max=matchCastL(rtD,params[i1])
	if(max<min){
		Long t=max
		max=min
		min=t
	}
	return min+Math.round(d1*(max-min)*Math.random())
}

private Long vcmd_waitForTime(Map rtD,device,List params){
	Long time
	time=(Long)cast(rtD,(Long)cast(rtD,params[iZ],sTIME),sDTIME,sTIME)
	Long rightNow=(Long)now()
	time=pushTimeAhead(time,rightNow)
	return time-rightNow
}

private Long vcmd_waitForDateTime(Map rtD,device,List params){
	Long time=(Long)cast(rtD,params[iZ],sDTIME)
	Long rightNow=(Long)now()
	return time>rightNow ? time-rightNow:lZ
}

private Long vcmd_setSwitch(Map rtD,device,List params){
	//noinspection GroovyAssignabilityCheck
	executePhysicalCommand(rtD,device,(Boolean)cast(rtD,params[iZ],sBOOLN) ? sON : sOFF)
	return lZ
}

private Long vcmd_toggle(Map rtD,device,List params){
	executePhysicalCommand(rtD,device,(String)getDeviceAttributeValue(rtD,device,sSWITCH)==sOFF ? sON : sOFF)
	return lZ
}

private Long vcmd_toggleRandom(Map rtD,device,List params){
	Integer probability=matchCastI(rtD,params.size()==1 ? params[iZ]:50)
	if(probability<=iZ)probability=50
	executePhysicalCommand(rtD,device,(Integer)Math.round(d100*Math.random()).toInteger()<=probability ? sON : sOFF)
	return lZ
}

private Long vcmd_toggleLevel(Map rtD,device,List params){
	Integer level=(Integer)params[iZ]
	executePhysicalCommand(rtD,device,sSTLVL,(Integer)getDeviceAttributeValue(rtD,device,sLVL)==level ? iZ : level)
	return lZ
}

private Long do_adjustLevel(Map rtD,device,List params,String attr,String attr1,Integer val=null,Boolean big=false){
	Integer arg=val!=null ? val : matchCastI(rtD,params[iZ])
	Integer psz=params.size()
	String mat=psz>i1 ? (String)params[i1]:sNULL
	if(mat!=sNULL && (String)getDeviceAttributeValue(rtD,device,sSWITCH)!=mat) return lZ
	Long delay=psz>i2 ? (Long)params[i2]:lZ
	arg=arg+matchCastI(rtD,getDeviceAttributeValue(rtD,device,attr))
	Integer low=big ? 1000:iZ
	Integer hi=big ? 30000:100
	arg=(arg<low)? low:((arg>hi)? hi:arg)
	executePhysicalCommand(rtD,device,attr1,arg,delay)
	return lZ
}

private Long vcmd_adjustLevel(Map rtD,device,List params){
	return do_adjustLevel(rtD,device,params,sLVL,sSTLVL)
}

private Long vcmd_adjustInfraredLevel(Map rtD,device,List params){
	return do_adjustLevel(rtD,device,params,sIFLVL,sSTIFLVL)
}

private Long vcmd_adjustSaturation(Map rtD,device,List params){
	return do_adjustLevel(rtD,device,params,sSATUR,sSSATUR)
}

private Long vcmd_adjustHue(Map rtD,device,List params){
	Integer hue= Math.round((Integer)params[iZ]/d3d6).toInteger()
	return do_adjustLevel(rtD,device,params,sHUE,sSHUE,hue)
}

private Long vcmd_adjustColorTemperature(Map rtD,device,List params){
	return do_adjustLevel(rtD,device,params,sCLRTEMP,sSCLRTEMP,null,true)
}

private Long do_fadeLevel(Map rtD,device,List params,String attr,String attr1,Integer val=null,Integer val1=null,Boolean big=false){
	Integer startLevel
	Integer endLevel
	if(val==null){
		def d=params[iZ]
		def d1= d!=null ? d:getDeviceAttributeValue(rtD,device,attr)
		startLevel= matchCastI(rtD,d1)
		endLevel=matchCastI(rtD,params[i1])
	}else{
		startLevel=val
		endLevel=val1
	}
	String mat=params.size()>i3 ? (String)params[i3]:sNULL
	if(mat!=sNULL && (String)getDeviceAttributeValue(rtD,device,sSWITCH)!=mat) return lZ
	Long duration=matchCastL(rtD,params[i2])
	Integer low=big ? 1000:iZ
	Integer hi=big ? 30000:100
	startLevel=(startLevel<low)? low:((startLevel>hi)? hi:startLevel)
	endLevel=(endLevel<low)? low:((endLevel>hi)? hi:endLevel)
	return vcmd_internal_fade(rtD,device,attr1,startLevel,endLevel,duration)
}

private Long vcmd_fadeLevel(Map rtD,device,List params){
	return do_fadeLevel(rtD,device,params,sLVL,sSTLVL)
}

private Long vcmd_fadeInfraredLevel(Map rtD,device,List params){
	return do_fadeLevel(rtD,device,params,sIFLVL,sSTIFLVL)
}

private Long vcmd_fadeSaturation(Map rtD,device,List params){
	return do_fadeLevel(rtD,device,params,sSATUR,sSSATUR)
}

private Long vcmd_fadeHue(Map rtD,device,List params){
	Integer startLevel= params[iZ]!=null ? Math.round((Integer)params[iZ]/d3d6).toInteger() : matchCastI(rtD,getDeviceAttributeValue(rtD,device,sHUE))
	Integer endLevel= Math.round((Integer)params[i1]/d3d6).toInteger()
	return do_fadeLevel(rtD,device,params,sHUE,sSHUE,startLevel,endLevel)
}

private Long vcmd_fadeColorTemperature(Map rtD,device,List params){
	return do_fadeLevel(rtD,device,params,sCLRTEMP,sSCLRTEMP,null,null,true)
}

private Long vcmd_internal_fade(Map rtD,device,String command,Integer startLevel,Integer endLevel,Long idur){
	Long duration=idur
	Long minInterval
	if(duration<=5000L){
		minInterval=500L
	}else if(duration<=10000L){
		minInterval=lTHOUS
	}else if(duration<=30000L){
		minInterval=3000L
	}else minInterval=5000L
	if(startLevel==endLevel || duration<500L){
		//if the fade is too fast, or not changing anything, go to the end level directly
		executePhysicalCommand(rtD,device,command,endLevel)
		return lZ
	}
	Integer delta=endLevel-startLevel
	//the max number of steps we can do
	Integer steps=delta>iZ ? delta:-delta
	//figure out the interval
	Long interval=Math.round(duration/steps)
	if(interval<minInterval){
		//interval is too small adjust to do one change per 500ms
		steps=Math.floor(d1*duration/minInterval).toInteger()
		interval=Math.round(d1*duration/steps)
	}
	String scheduleDevice=hashId(device.id)
	Integer oldLevel=startLevel
	executePhysicalCommand(rtD,device,command,startLevel)
	Map jq=[
		s:i1,
		cy:steps,
		f1C:command,
		f1P: startLevel,
		f1Padd: delta*d1/steps,
		f1ID:interval,
		f1D:interval,
		s2C:sNULL,
		s2P: null,
		s2D:lZ,
		sDev:scheduleDevice,
		l1C:command,
		l1P: endLevel,
		l1D:500L,
		l2C:sNULL,
		l2P: null,
		l2D:lZ
	]
	Long wt=stRepeat(rtD,jq)
	return wt+750L
}

private Long vcmd_emulatedFlash(Map rtD,device,List params){
	vcmd_flash(rtD,device,params)
}

private Long vcmd_flash(Map rtD,device,List params){
	Long onDuration=matchCastL(rtD,params[iZ])
	Long offDuration=matchCastL(rtD,params[i1])
	Integer cycles=matchCastI(rtD,params[i2])
	String mat=params.size()>i3 ? (String)params[i3]:sNULL
	String currentState=(String)getDeviceAttributeValue(rtD,device,sSWITCH)
	if(mat!=sNULL && currentState!=mat) return lZ
	//if the flash is too fast, ignore it
	if((onDuration+offDuration)<500L) return lZ
	String firstCommand=currentState==sON ? sOFF:sON
	Long firstDuration=firstCommand==sON ? onDuration:offDuration
	String secondCommand=firstCommand==sON ? sOFF:sON
	Long secondDuration=firstCommand==sON ? offDuration:onDuration
	String scheduleDevice=hashId(device.id)
	Map jq=[
		s:i1,
		cy:cycles,
		f1C:firstCommand,
		f1P: null,
		f1ID:lZ,
		f1D:firstDuration,
		s2C:secondCommand,
		s2P: null,
		s2D:secondDuration,
		sDev:scheduleDevice,
		l1C:currentState,
		l1P: [],
		l1D:500L,
		l2C:sNULL,
		l2P: null,
		l2D:lZ
	]
	Long wt=stRepeat(rtD,jq)
	return wt+750L
}

// return an estimate of how long
private Long stRepeat(Map rtD,Map jq){
	Integer start=(Integer)jq.s
	Integer cycles=(Integer)jq.cy
	String fCmd=(String)jq.f1C
	Long firstDuration=(Long)jq.f1D
	String sCmd=(String)jq.s2C
	Long secondDuration= (Long)jq.s2D

	// this attempts to add command delays ced
	Long t0=(Integer)rtD.piston.o?.ced ? ((Integer)rtD.piston.o.ced).toLong():lZ
	if(t0>lZ) {
		Long t1= (Long)getPistonLimits.deviceMaxDelay
		t0= t0>t1 ? t1:t0
		firstDuration= t0>firstDuration ? t0:firstDuration
		if(sCmd)secondDuration= t0>secondDuration ? t0:secondDuration
	}

	Long dur=(Long)jq.f1ID
	for(Integer i=start;i<=cycles;i++){
		dur+= firstDuration
		if(sCmd)dur+= secondDuration
	}
	dur += (Long)jq.l1D+(Long)jq.l2D+20L
	runRepeat(rtD,jq)
	return dur
}

void runRepeat(Map rtD,Map ijq){
	Map jq=[:]+ijq

	String scheduleDevice=(String)jq.sDev
	def device=getDevice(rtD,scheduleDevice)
	if(device!=null){
		Integer start=(Integer)jq.s
		Integer cycles=(Integer)jq.cy
		String fCmd=(String)jq.f1C

		def p1=jq.f1P
		Boolean doNotSend=false
		Double i=(Double)jq.f1Padd
		if(i!=null){
			Integer p=(Integer)p1
			Integer oldL= Math.round(p+i*(start-i1)).toInteger()
			Integer newL= Math.round(p+i*start).toInteger()
			p1= newL
			if(oldL==newL) doNotSend=true
		}

		Long firstDuration=(Long)jq.f1D
		String sCmd=(String)jq.s2C
		def p2=jq.s2P
		Long secondDuration=(Long)jq.s2D

		Long dur= start==1 ? (Long)jq.f1ID:lZ
		if(start<=cycles){
			if(!doNotSend) {
				executePhysicalCommand(rtD,device,fCmd,p1,dur,scheduleDevice,true)
				dur+= firstDuration
			}
			if(sCmd){
				executePhysicalCommand(rtD,device,sCmd,p2,dur,scheduleDevice,true)
				dur+= secondDuration
			}
			start++
		}
		if(start>cycles){
			Long d=(Long)jq.l1D
			String c=(String)jq.l1C
			if(c){
				executePhysicalCommand(rtD,device,c,jq.l1P,dur,scheduleDevice,true)
				dur+= d
			}
			c=(String)jq.l2C
			if(c){
				executePhysicalCommand(rtD,device,c,jq.l2P,dur,scheduleDevice,true)
			}
		}else{
			jq.s=start
			qrunRepeat(rtD,dur,jq)
		}
	}
}

void qrunRepeat(Map rtD,Long dur,Map jq){
	//void executePhysicalCo iN3
	Map statement=(Map)rtD.currentAction
	jq=[
		tcp:(String)statement.tcp,
		$:(Integer)statement.$
	]+jq
	// cancel on c- condition state change (def), p- piston state change, b- condition or piston state change, ""- never cancel
	List<Integer> cs=[]+ ((String)statement.tcp in [sB,sC] ? (rtD.stack?.cs!=null ? (List<Integer>)rtD.stack.cs:[]):[]) // task cancelation policy
	Integer ps= (String)statement.tcp in [sB,sP] ? i1:iZ
	Boolean a=cs.removeAll{ Integer it -> it==iZ }
	Long ttt=Math.round((Long)now()*d1+dur)
	Map schedule=[
		(sT):ttt,
		(sS):(Integer)statement.$,
		(sI):iN5,
		cs:cs,
		ps:ps,
		jq:jq,
	]
	if((Boolean)rtD.eric)trace "Requesting a repeat task wake up for ${formatLocalTime(ttt)}",rtD
	a=((List<Map>)rtD.schedules).push(schedule)
}

private Long vcmd_flashLevel(Map rtD,device,List params){
	Integer level1=matchCastI(rtD,params[iZ])
	Long duration1=matchCastL(rtD,params[i1])
	Integer level2=matchCastI(rtD,params[i2])
	Long duration2=matchCastL(rtD,params[i3])
	Integer cycles=matchCastI(rtD,params[i4])
	String mat=params.size()>i5 ? (String)params[i5]:sNULL
	String currentState=(String)getDeviceAttributeValue(rtD,device,sSWITCH)
	if(mat!=sNULL && currentState!=mat) return lZ
	//if the flash is too fast, ignore it
	if((duration1+duration2)<500L) return lZ
	Integer currentLevel=(Integer)getDeviceAttributeValue(rtD,device,sLVL)
	String scheduleDevice=hashId(device.id)
	Map jq=[
		s:i1,
		cy:cycles,
		f1C:sSTLVL,
		f1P: [level1],
		f1ID:lZ,
		f1D:duration1,
		s2C:sSTLVL,
		s2P: [level2],
		s2D:duration2,
		sDev:scheduleDevice,
		l1C:sSTLVL,
		l1P: [currentLevel],
		l1D:500L,
		l2C:currentState,
		l2P: [],
		l2D:200L
	]
	Long wt=stRepeat(rtD,jq)
	return wt+750L
}

private Long vcmd_flashColor(Map rtD,device,List params){
	Map color1=getColor(rtD,(String)params[iZ])
	Long duration1=matchCastL(rtD,params[i1])
	Map color2=getColor(rtD,(String)params[i2])
	Long duration2=matchCastL(rtD,params[i3])
	Integer cycles=matchCastI(rtD,params[i4])
	String mat=params.size()>i5 ? (String)params[i5]:sNULL
	String currentState=(String)getDeviceAttributeValue(rtD,device,sSWITCH)
	if(mat!=sNULL && currentState!=mat) return lZ
	//if the flash is too fast, ignore it
	if((duration1+duration2)<500L) return lZ
	String scheduleDevice=hashId(device.id)
	Map jq=[
		s:i1,
		cy:cycles,
		f1C:sSCLR,
		f1P: [color1],
		f1ID:lZ,
		f1D:duration1,
		s2C:sSCLR,
		s2P: [color2],
		s2D:duration2,
		sDev:scheduleDevice,
		l1C:currentState,
		l1P: [],
		l1D:500L,
		l2C:sNULL,
		l2P: [],
		l2D:lZ
	]
	Long wt=stRepeat(rtD,jq)
	return wt+750L
}

private Long vcmd_sendNotification(Map rtD,device,List params){
	String message="Hubitat does not support sendNotification "+(String)params[iZ]
	Map a=log(message,rtD,iN2,"Err",sWARN,true)
	//sendNotificationEvent(message)
	return lZ
}

private Long vcmd_sendPushNotification(Map rtD,device,List params){
	String message=(String)params[iZ]
	if(rtD.initPush==null){
		rtD.pushDev=(List)parent.getPushDev()
		rtD.initPush=true
	}
	List t0=(List)rtD.pushDev
	try{
		t0*.deviceNotification(message)
	}catch(ignored){
		message="Default push device not set properly in webCoRE "+message
		error message,rtD
	}
	return lZ
}

private Long vcmd_sendSMSNotification(Map rtD,device,List params){
	String msg=(String)params[iZ]
	msg="HE SMS notifications are being removed,please convert to a notification device "+msg
	warn msg,rtD
	return lZ
}

private Long vcmd_sendNotificationToContacts(Map rtD,device,List params){
	// HE does not have Contact Book; falling back onto PUSH notifications
	String message=(String)params[iZ]
	Boolean save=!!params[i2]
	return vcmd_sendPushNotification(rtD,device,[message,save])
}

private static Map<String,String> parseVariableName(String name){
	Map result=[
		(sNM): name,
		index: sNULL
	]
	if(name!=sNULL && !name.startsWith(sDLR) && name.endsWith(sRB)){
		List<String> parts=name.replace(sRB,sBLK).tokenize(sLB)
		if(parts.size()==i2){
			result=[
				(sNM): parts[iZ],
				index: parts[i1]
			]
		}
	}
	return result
}

private Long vcmd_setVariable(Map rtD,device,List params){
	String name=(String)params[iZ]
	def value=params[i1]
	Map t0=setVariable(rtD,name,value)
	if((String)t0.t==sERROR){
		String message=(String)t0.v+sSPC+name
		error message,rtD
	}
	return lZ
}

private Long vcmd_executePiston(Map rtD,device,List params){
	String selfId=(String)rtD.id
	String pistonId=(String)params[iZ]
	List<String> arguments=(params[i1] instanceof List ? (List<String>)params[i1]:params[i1].toString().tokenize(sCOMMA)).unique()
	//noinspection GroovyAssignabilityCheck
	Boolean wait= params.size()>i2 ? (Boolean)cast(rtD,params[i2],sBOOLN):false
	String desc="webCoRE: Piston ${(String)app.label} requested execution of piston $pistonId".toString()
	Map data=[:]
	for(String argument in arguments) if(argument)data[argument]=getVariable(rtD,argument).v
	if(wait) wait=(Boolean)parent.executePiston(pistonId,data,selfId)
	if(!wait){
		sendLocationEvent((sNM):pistonId,(sVAL):selfId,isStateChange:true,displayed:false,linkText:desc,descriptionText:desc,data:data)
	}
	return lZ
}

private Long vcmd_pausePiston(Map rtD,device,List params){
//	String selfId=(String)rtD.id
	String pistonId=(String)params[iZ]
	if(!(Boolean)parent.pausePiston(pistonId)){
		String message="Piston not found "+pistonId
		error message,rtD
	}
	return lZ
}

private Long vcmd_resumePiston(Map rtD,device,List params){
//	String selfId=(String)rtD.id
	String pistonId=(String)params[iZ]
	if(!(Boolean)parent.resumePiston(pistonId)){
		String message="Piston not found "+pistonId
		error message,rtD
	}
	return lZ
}

private Long vcmd_executeRule(Map rtD,device,List params){
	String ruleId=(String)params[iZ]
	String action=(String)params[i1]
	//Boolean wait=(params.size()>i2)? (Boolean)cast(rtD,params[i2],sBOOLN):false
	String ruleAction=sNULL
	if(action=="Run")ruleAction="runRuleAct"
	if(action=="Stop")ruleAction="stopRuleAct"
	if(action=="Pause")ruleAction="pauseRule"
	if(action=="Resume")ruleAction="resumeRule"
	if(action=="Evaluate")ruleAction="runRule"
	if(action=="Set Boolean True")ruleAction="setRuleBooleanTrue"
	if(action=="Set Boolean False")ruleAction="setRuleBooleanFalse"
	if(!ruleAction){
		String message="No Rule action found "+action
		error message,rtD
	}else{
		Boolean sent=false
		['4.1', '5.0'].each{ String ver->
			List<Map> rules=RMUtils.getRuleList(ver ?: sNULL)
			List myRule=[]
			rules.each{rule->
				List t0=rule.find{ hashId((String)it.key)==ruleId }.collect{(String)it.key}
				myRule+= t0
			}
			if(myRule){
				RMUtils.sendAction(myRule,ruleAction,(String)app.label, ver ?: sNULL)
				sent=true
			}
		}
		if(!sent){
			String message="Rule not found "+ruleId
			error message,rtD
		}
	}
	return lZ
}

private Long vcmd_setHSLColor(Map rtD,device,List params){
	Integer hue= Math.round((Integer)params[iZ]/d3d6).toInteger()
	Integer saturation=(Integer)params[i1]
	Integer level=(Integer)params[i2]
	def color=[
		(sHUE): hue,
		(sSATUR): saturation,
		(sLVL): level
	]
	Integer psz=params.size()
	String mat=psz>i3 ? (String)params[i3]:sNULL
	if(mat!=sNULL && (String)getDeviceAttributeValue(rtD,device,sSWITCH)!=mat)return lZ
	Long delay=psz>i4 ? (Long)params[i4]:lZ
	executePhysicalCommand(rtD,device,sSCLR,color,delay)
	return lZ
}

private Long vcmd_wolRequest(Map rtD,device,List params){
	String mac=(String)params[iZ]
	String secureCode=(String)params[i1]
	mac=mac.replace(sCOLON,sBLK).replace(sMINUS,sBLK).replace(sDOT,sBLK).replace(sSPC,sBLK).toLowerCase()

	sendHubCommand(HubActionClass().newInstance(
		"wake on lan $mac".toString(),
		HubProtocolClass().LAN,
		null,
		secureCode ? [secureCode: secureCode]:[:]
	))
	return lZ
}

private Long vcmd_iftttMaker(Map rtD,device,List params){
	String key=sNULL
	if(rtD.settings==null){
		error "no settings",rtD
	}else{
		key=((String)rtD.settings.ifttt_url ?: sBLK).trim().replace('https://',sBLK).replace('http://',sBLK).replace('maker.ifttt.com/use/',sBLK)
	}
	if(!key){
		error "Failed to send IFTTT event, because the IFTTT integration is not properly set up. Please visit Settings in your webCoRE dashboard and configure the IFTTT integration.",rtD
		return lZ
	}
	String event=params[iZ]
	Integer psz=params.size()
	def v1=psz>i1 ? params[i1]:sBLK
	def v2=psz>i2 ? params[i2]:sBLK
	def v3=psz>i3 ? params[i3]:sBLK
	def body=[:]
	if(v1)body.value1=v1
	if(v2)body.value2=v2
	if(v3)body.value3=v3
	Map data=[
		t:event,
		p1:v1,
		p2:v2,
		p3:v3
	]
	Map requestParams=[
		uri: "https://maker.ifttt.com/trigger/${java.net.URLEncoder.encode(event,"UTF-8")}/with/key/".toString()+key,
		requestContentType: sAPPJSON,
		body: body,
		timeout:20
	]
	try{
		asynchttpPost('ahttpRequestHandler',requestParams,[command:sIFTTM,em: data])
		return 24000L
	}catch(all){
		error "Error iftttMaker to ${requestParams.uri} ${data.t}: ${data.p1}, ${data.p2}, ${data.p3}",rtD,iN2,all
	}
	return lZ
}

private Long do_lifx(Map rtD,String cmd,String path,Map body,duration,String c){
	String token=rtD.settings?.lifx_token
	if(!token){
		error "Sorry, enable the LIFX integration in the dashboard's Settings section before trying to execute a LIFX operation.",rtD
		return lZ
	}
	Map requestParams=[
		uri: "https://api.lifx.com",
		path: path,
		headers: [ "Authorization": "Bearer $token" ],
		requestContentType: sAPPJSON,
		timeout:10,
		body: body
	]
	try{
		if((Integer)rtD.logging>i2)debug "Sending lifx ${c} web request to: $path",rtD
		"asynchttp${cmd}"('ahttpRequestHandler',requestParams,[command:sLIFX,em: [(sT):c]])
		Long ldur=duration ? Math.round(duration * d1000) : lZ
		return ldur>11000L ? ldur : 11000L
	}catch(all){
		error "Error while activating LIFX $c:",rtD,iN2,all
	}
	return lZ
}

private Long vcmd_lifxScene(Map rtD,device,List params){
	String sceneId=(String)params[iZ]
	Long duration=params.size()>i1 ? Math.round( matchCastL(rtD,params[i1]) / d1000) : lZ
	Map scn=(Map)rtD.lifx?.scenes
	if(!scn){
		error "Sorry, there seems to be no available LIFX scenes, please ensure the LIFX integration is working.",rtD
		return lZ
	}
	sceneId=scn.find{ (String)it.key==sceneId || (String)it.value==sceneId }?.key
	if(!sceneId){
		error "Sorry, could not find the specified LIFX scene.",rtD
		return lZ
	}
	String path="/v1/scenes/scene_id:${sceneId}/activate"
	Map body= duration ? [duration: duration]:null
	return do_lifx(rtD,'Put',path,body,duration,'scene')
}

private Long lifxErr(Map rtD){
	error "Sorry, could not find the specified LIFX selector.",rtD
	return lZ
}

private static String getLifxSelector(Map rtD,String selector){
	String selectorId=sBLK
	if(selector=='all')return selector
	Integer i=iZ
	List<String> a=['scene_',sBLK,'group_','location_']
	for(String m in ['scenes','lights','groups','locations']){
		String obj=((Map)rtD.lifx."${m}")?.find{ it.key==selector || it.value==selector }?.key
		if(obj)return "${a[i]}id:${obj}".toString()
		i+=i1
	}
	return selectorId
}

private Long vcmd_lifxState(Map rtD,device,List params){
	String selector=getLifxSelector(rtD,(String)params[iZ])
	if(!selector)return lifxErr(rtD)
	String power=(String)params[i1]
	Map color=getColor(rtD,(String)params[i2])
	Integer level=(Integer)params[i3]
	Integer infrared=(Integer)params[i4]
	Long duration=Math.round( matchCastL(rtD,params[i5]) / d1000 )
	String path= "/v1/lights/${selector}/state"
	Map body= [:]+(power ? ([power: power]) : [:])+(color ? ([color: color.hex]) : [:])+(level != null ? ([brightness: level / 100.0]) : [:])+(infrared != null ? [infrared: infrared] : [:])+(duration ? [duration: duration] : [:])
	return do_lifx(rtD,'Put',path,body,duration,'state')
}

private Long vcmd_lifxToggle(Map rtD,device,List params){
	String selector=getLifxSelector(rtD,(String)params[iZ])
	if(!selector)return lifxErr(rtD)
	Long duration=Math.round( matchCastL(rtD,params[i1]) / d1000 )
	String path= "/v1/lights/${selector}/toggle"
	Map body= [:]+(duration ? [duration: duration] : [:])
	return do_lifx(rtD,'Post',path,body,duration,'toggle')
}

private Long vcmd_lifxBreathe(Map rtD,device,List params){
	String selector=getLifxSelector(rtD,(String)params[iZ])
	if(!selector)return lifxErr(rtD)
	Map color=getColor(rtD,(String)params[i1])
	Map fromColor= (params[i2]==null) ? null:getColor(rtD,(String)params[i2])
	Long period= (params[i3]==null) ? null:Math.round( matchCastL(rtD,params[i3]) / d1000)
	Integer cycles=(Integer)params[i4]
	Integer peak=(Integer)params[i5]
	Boolean powerOn=(params[i6]==null) ? null:cast(rtD,params[i6],sBOOLN)
	Boolean persist=(params[7]==null) ? null:cast(rtD,params[7],sBOOLN)
	String path= "/v1/lights/${selector}/effects/breathe"
	Map body= [color: color.hex]+(fromColor ? ([from_color: fromColor.hex]) : [:])+(period != null ? ([period: period]) : [:])+(cycles ? ([cycles: cycles]) : [:])+(powerOn != null ? ([power_on: powerOn]) : [:])+(persist != null ? ([persist:persist]) : [:])+(peak != null ? ([peak: peak / 100]) : [:])
	Long ldur=Math.round( (period ? period : i1) * (cycles ? cycles : i1) )
	return do_lifx(rtD,'Post',path,body,ldur,'breathe')
}

private Long vcmd_lifxPulse(Map rtD,device,List params){
	String selector=getLifxSelector(rtD,(String)params[iZ])
	if(!selector)return lifxErr(rtD)
	Map color=getColor(rtD,(String)params[i1])
	Map fromColor=(params[i2]==null) ? null:getColor(rtD,(String)params[i2])
	Long period=(params[i3]==null) ? null:Math.round( matchCastL(rtD,params[i3]) / d1000)
	Integer cycles=(Integer)params[i4]
	Boolean powerOn=(params[i5]==null)? null:cast(rtD,params[i5],sBOOLN)
	Boolean persist=(params[i6]==null) ? null:cast(rtD,params[i6],sBOOLN)
	String path= "/v1/lights/${selector}/effects/pulse"
	Map body= [color: color.hex]+(fromColor ? ([from_color: fromColor.hex]) : [:])+(period != null ? ([period: period]) : [:])+(cycles ? ([cycles: cycles]) : [:])+(powerOn != null ? ([power_on: powerOn]) : [:])+(persist != null ? ([persist:persist]) : [:])
	Long ldur=Math.round( (period ? period : i1) * (cycles ? cycles : i1) )
	return do_lifx(rtD,'Post',path,body,ldur,'pulse')
}

private Long vcmd_httpRequest(Map rtD,device,List params){
	String uri=((String)params[iZ]).replace(sSPC,"%20")
	if(!uri){
		error "Error executing external web request:no URI",rtD
		return lZ
	}
	String method=(String)params[i1]
	Boolean useQryS= (method in [sGET,sDELETE,sHEAD])
	String reqBodyT=(String)params[i2]
	def variables=params[i3]
	String auth=sNULL
	def requestBody=null
	String cntntT=sNULL
	if(params.size()==i5){
		auth=(String)params[i4]
	}else if(params.size()==7){
		requestBody=(String)params[i4]
		cntntT=(String)params[i5] ?: 'text/plain'
		auth=(String)params[i6]
	}
	String protocol="https"
	String reqCntntT=(method==sGET || reqBodyT=='FORM')? sAPPFORM : (reqBodyT=='JSON')? sAPPJSON:cntntT
	String userPart=sBLK
	String[] uriParts=uri.split("://")
	if(uriParts.size()>i2){
		warn "Invalid URI for web request:$uri",rtD
		return lZ
	}
	if(uriParts.size()==i2){
		//remove the httpX:// from the uri
		protocol=(String)uriParts[iZ].toLowerCase()
		uri=(String)uriParts[i1]
	}
	//support for user:pass@IP
	if(uri.contains(sAT)){
		String[] uriSubParts= uri.split(sAT as String)
		userPart=uriSubParts[iZ]+sAT
		uri=uriSubParts[i1]
	}
	def data=null
	if(reqBodyT=='CUSTOM' && !useQryS){
		data=requestBody
	}else if(variables instanceof List){
		for(String variable in ((List)variables).findAll{ !!it }){
			data=data ?: [:]
			data[variable]=getVariable(rtD,variable).v
		}
	}
	if(!useQryS && reqCntntT==sAPPFORM && data instanceof Map){
		data=data.collect{ String k,v -> encodeURIComponent(k)+'='+encodeURIComponent(v) }.join(sAMP)
	}
	try{
		Map requestParams=[
			uri: protocol+'://'+userPart+uri,
			query: useQryS ? data:null,
			headers: (auth ? ((auth.startsWith('{') && auth.endsWith('}'))? (new JsonSlurper().parseText(auth)):[Authorization: auth]):[:]),
			contentType: '*/*',
			requestContentType: reqCntntT,
			body: !useQryS ? data:null,
			timeout:20
		]
		String func=sBLK
		switch(method){
			case sGET:
				func='asynchttpGet'
				break
			case 'POST':
				func='asynchttpPost'
				break
			case 'PUT':
				func='asynchttpPut'
				break
			case sDELETE:
				func='asynchttpDelete'
				break
			case sHEAD:
				func='asynchttpHead'
				break
		}
		if((Integer)rtD.logging>i2)debug "Sending ${func} web request to: $uri",rtD
		if(func!=sBLK){
			"$func"('ahttpRequestHandler',requestParams,[command:sHTTPR])
			return 24000L
		}
	}catch(all){
		error "Error executing external web request:",rtD,iN2,all
	}
	return lZ
}

void ahttpRequestHandler(resp,Map callbackData){
	Boolean binary=false
	def t0=resp.getHeaders()
	String t1=t0!=null ? (String)t0."Content-Type" : sNULL
	String mediaType=t1 ? (String)(t1.toLowerCase()?.tokenize(';')[iZ]):sNULL
	//noinspection GroovyFallthrough
	switch(mediaType){
		case 'image/jpeg':
		case 'image/png':
		case 'image/gif':
			binary=true
	}
	def data=null
	def json=null
	Map setRtData=[:]
	String callBackC=(String)callbackData?.command
	Integer responseCode=resp.status
	//if(eric1() && (Integer)state.logging>i2) log.debug "http status ${responseCode}\nmediaType ${mediaType}\nheaders $t0"

	Boolean success=false
	String erMsg=sNULL
	if(resp.hasError()){
		erMsg=" Response Status: ${resp.status} error Message: ${resp.getErrorMessage()}".toString()
		if(!responseCode) responseCode=500
	}
	Boolean respOk=(responseCode>=200 && responseCode<300)

	switch(callBackC){
		case sHTTPR:
			if(responseCode==204){ // no content
				mediaType=sBLK
			}else{
				if(respOk && resp.data){
					if(!binary){
						data=resp.data
						//if(eric1() && (Integer)state.logging>i2) log.debug "http mediaType $mediaType RESP ${data}"
						if(data!=null && !(data instanceof Map) && !(data instanceof List)){
							def ndata=parseMyResp(data,mediaType)
							if(ndata) data=ndata
						}
					}else{
						if(resp.data!=null && resp.data instanceof java.io.ByteArrayInputStream){
							setRtData.mediaType=mediaType
							setRtData.mediaData=resp.data.decodeBase64() // HE binary data is b64encoded resp.data.getBytes()
						}
					}
				}else erMsg='http'+erMsg
			}
			break
		case sLIFX:
			def em=callbackData?.em
			if(!respOk) erMsg="lifx Error lifx sending ${em?.t}".toString()+erMsg
			break
		case sSENDE:
			String msg='Unknown error'
			def em=callbackData?.em
			if(respOk){
				data=resp.getJson()
				if(data!=null){
					if((String)data.result=='OK') success=true
					else msg=((String)data.result).replace('ERROR ',sBLK)
				}
			}
			if(!success) erMsg="Error sending email to ${em?.t}: ${msg}".toString()
			break
		case sIFTTM:
			def em=callbackData?.em
			if(!respOk) erMsg="ifttt Error iftttMaker to ${em?.t}: ${em?.p1},${em?.p2},${em?.p3} ".toString()+erMsg
			break
		case sSTOREM:
			def mediaId=sNULL
			def mediaUrl=sNULL
			if(respOk){
				data=resp.getJson()
				if((String)data.result=='OK' && data.url){
					mediaId=data.id
					mediaUrl=data.url
				}else if(data.message) erMsg="storeMedia Error storing media item: $data.message"+erMsg
				data=null
			}else erMsg='ifttt'+erMsg
			setRtData=[mediaId:mediaId,mediaUrl:mediaUrl]
	}
	if(erMsg!=sNULL) error erMsg,[:]

	handleEvents([(sDATE):new Date(),(sDEV):location,(sNM):sASYNCREP,(sVAL):callBackC,contentType:mediaType,responseData:data,jsonData:json,responseCode:responseCode,setRtData:setRtData])
}

private parseMyResp(aa,String mediaType=sNULL){
	def ret=null
	if(aa instanceof String || aa instanceof GString){
		String a=aa.toString()
		Boolean expectJson= mediaType ? mediaType.contains('json') : false
		try{
			if(a.startsWith('{') && a.endsWith('}')){
				ret=(LinkedHashMap)new JsonSlurper().parseText(a)
			}else if(a.startsWith(sLB) && a.endsWith(sRB)){
				ret=(List)new JsonSlurper().parseText(a)
			}else if(expectJson || (mediaType in ['application/octet-stream'] && a.size()%i4 == iZ) ){ // HE can return data Base64
				String dec=new String(a.decodeBase64())
				if(dec!=sNULL){
					def t0=parseMyResp(dec,sBLK)
					ret=t0==null ? dec:t0
				}
			}
		}catch(ignored){}
	}
	return ret
}

private Long vcmd_writeToFuelStream(Map rtD,device,List params){
	String canister=(String)params[iZ]
	String name=(String)params[i1]
	def data=params[i2]
	def source=params[i3]

	Map req=[
		c: canister,
		n: name,
		s: source,
		d: data,
		i: (String)rtD.instanceId
	]
	if((Boolean)rtD.useLocalFuelStreams && name!=sNULL) parent.writeToFuelStream(req)
	else{
		Map requestParams=[
			uri: "https://api-"+(String)rtD.region+'-'+((String)rtD.instanceId)[32]+".webcore.co:9247",
			path: "/fuelStream/write",
			headers: [ 'ST': (String)rtD.instanceId ],
			body: req,
			contentType: sAPPJSON,
			requestContentType: sAPPJSON,
			timeout:20
		]
		asynchttpPut('asyncFuel',requestParams,[bbb:iZ])
	}
	return lZ
}

void asyncFuel(response,data){
	if(response.status!=200) error "Error storing fuel stream: $response?.data?.message",[:]
}

private Long vcmd_storeMedia(Map rtD,device,List params){
	if(!rtD.mediaData || !rtD.mediaType || (Integer)rtD.mediaData.size()<=iZ){
		error 'No media is available to store; operation aborted.',rtD
		return lZ
	}
	String data=new String(rtD.mediaData as byte[],'ISO_8859_1')
	Map requestParams=[
		uri: "https://api-"+(String)rtD.region+'-'+((String)rtD.instanceId)[32]+".webcore.co:9247",
		path: "/media/store",
		headers: [
			'ST':(String)rtD.instanceId,
			'media-type':rtD.mediaType
		],
		body: data,
		requestContentType: rtD.mediaType,
		timeout:20
	]
	asynchttpPut('asyncRequestHandler',requestParams,[command:sSTOREM])
	return 24000L
}

private Long vcmd_saveStateLocally(Map rtD,device,List params,Boolean global=false){
	List<String> attributes=((String)cast(rtD,params[iZ],sSTR)).tokenize(sCOMMA)
	String canister=(params.size()>i1 ? (String)cast(rtD,params[i1],sSTR)+sCOLON : sBLK)+hashId(device.id)+sCOLON
	//noinspection GroovyAssignabilityCheck
	Boolean overwrite=!(params.size()>i2 ? (Boolean)cast(rtD,params[i2],sBOOLN):false)
	for(String attr in attributes){
		String n=canister+attr
		if(global && !(Boolean)rtD.initGStore){
			rtD.globalStore=(Map)parent.getGStore()
			rtD.initGStore=true
		}
		if(overwrite || (global ? (rtD.globalStore[n]==null):(rtD.store[n]==null))){
			def value=getDeviceAttributeValue(rtD,device,attr)
			if(attr==sHUE)value=value*d3d6
			if(global){
				rtD.globalStore[n]=value
				LinkedHashMap<String,Object> cache= (LinkedHashMap<String,Object>)rtD.gvStoreCache ?: [:] as LinkedHashMap<String,Object>
				cache[n]=value
				rtD.gvStoreCache=cache
			}else rtD.store[n]=value
		}
	}
	return lZ
}

private Long vcmd_saveStateGlobally(Map rtD,device,List params){
	return vcmd_saveStateLocally(rtD,device,params,true)
}

private Long vcmd_loadStateLocally(Map rtD,device,List params,Boolean global=false){
	List<String> attributes=((String)cast(rtD,params[iZ],sSTR)).tokenize(sCOMMA)
	String canister=(params.size()>i1 ? (String)cast(rtD,params[i1],sSTR)+sCOLON : sBLK)+hashId(device.id)+sCOLON
	//noinspection GroovyAssignabilityCheck
	Boolean empty=params.size()>i2 ? (Boolean)cast(rtD,params[i2],sBOOLN):false
	for(String attr in attributes){
		String n=canister+attr
		if(global && !(Boolean)rtD.initGStore){
			rtD.globalStore=(Map)parent.getGStore()
			rtD.initGStore=true
		}
		def value=global ? rtD.globalStore[n]:rtD.store[n]
		if(attr==sHUE)value=(Double)cast(rtD,value,sDEC)/d3d6
		def a
		if(empty){
			if(global){
				a=((Map)rtD.globalStore).remove(n)
				Map cache=(Map)rtD.gvStoreCache ?: [:]
				cache[n]=null
				rtD.gvStoreCache=cache
			}else a=((Map)rtD.store).remove(n)
		}
		if(value==null)continue
		String exactCommand=sNULL
		String fuzzyCommand=sNULL
		for(command in PhysicalCommands()){
			if((String)command.value.a==attr){
				if(command.value.v==null) fuzzyCommand=(String)command.key
				else{
					if((String)command.value.v==value){
						exactCommand=(String)command.key
						break
					}
				}
			}
		}
		String t0="Restoring attribute '$attr' to value '$value' using command".toString()
		Boolean lg=(Integer)rtD.logging>i2
		if(exactCommand!=sNULL){
			if(lg)debug "${t0} $exactCommand()",rtD
			executePhysicalCommand(rtD,device,exactCommand)
			continue
		}
		if(fuzzyCommand!=sNULL){
			if(lg)debug "${t0} $fuzzyCommand($value)",rtD
			executePhysicalCommand(rtD,device,fuzzyCommand,value)
			continue
		}
		warn "Could not find a command to set attribute '$attr' to value '$value'",rtD
	}
	return lZ
}

private Long vcmd_loadStateGlobally(Map rtD,device,List params){
	return vcmd_loadStateLocally(rtD,device,params,true)
}

private Long vcmd_parseJson(Map rtD,device,List params){
	String data=(String)params[iZ]
	try{
		if(data.startsWith('{') && data.endsWith('}')){
			rtD.json=(LinkedHashMap)new JsonSlurper().parseText(data)
		}else if(data.startsWith(sLB) && data.endsWith(sRB)){
			rtD.json=(List)new JsonSlurper().parseText(data)
		}else rtD.json=[:]
	}catch(all){
		error "Error parsing JSON data $data",rtD,iN2,all
	}
	return lZ
}

private static Long vcmd_cancelTasks(Map rtD,device,List params){
	rtD.cancelations.all=true
	return lZ
}

@Field static final String sFF='ffwd: '
private static String ffwding(Map rtD){
	if((Integer)rtD.ffTo==iZ)return sBLK
	return sFF+sTRUE+": ${rtD.ffTo} "
}

private Boolean evaluateConditions(Map rtD,Map conditions,String collection,Boolean async){
	String myS=sBLK
	Boolean ntf=(Boolean)rtD.eric
	if(ntf){
		myS="evaluateConditions "+ffwding(rtD)
		myDetail rtD,myS, i1
	}
	Long t=(Long)now()
	Map msg=null
	Boolean lg=(Integer)rtD.logging>i2
	if(lg)msg=timer sBLK,rtD
	//override condition id
	Integer c=(Integer)rtD.stack.c
	Integer myC=conditions.$!=null ? (Integer)conditions.$:iZ
	rtD.stack.c=myC
	Boolean collC= collection==sC
	Boolean not= collC ? !!conditions.n:!!conditions.rn
	String grouping= collC ? (String)conditions.o:(String)conditions.rop // operator, restriction operator
	Boolean value= grouping!=sOR

	if(grouping=='followed by' && collC){
		if((Integer)rtD.ffTo==iZ || (Integer)rtD.ffTo==myC){
			//dealing with a followed by condition
			String sidx='c:fbi:'+myC.toString()
			Integer ladderIndex=matchCastI(rtD,((Map<String,Object>)rtD.cache)[sidx])
			String sldt='c:fbt:'+myC.toString()
			Long ladderUpdated=(Long)cast(rtD,((Map<String,Object>)rtD.cache)[sldt],sDTIME)
			Integer steps=conditions[collection] ? ((List)conditions[collection]).size():iZ
			if(ladderIndex>=steps) value=false
			else{
				Map condition=((List<Map>)conditions[collection])[ladderIndex]
				Long duration=lZ
				if(ladderIndex){
					Map tv=(Map)evaluateOperand(rtD,null,(Map)condition.wd)
					duration=(Long)evaluateExpression(rtD,rtnMap1(sDURATION,tv.v,(String)tv.vt),sLONG).v
				}
				// wt: l- loose, s- strict, n- negated (lack of expected event resets group)
				if(ladderUpdated && duration!=lZ && (ladderUpdated+duration<(Long)now())){
					//time has expired
					value=((String)condition.wt==sN)
					if(!value) if(lg)debug "Conditional ladder step failed due to a timeout",rtD
				}else{
					value=evaluateCondition(rtD,condition,collection,async)
					if((String)condition.wt==sN){
						if(value) value=false
						else value=null
					}
					//we allow loose matches to work even if other events happen
					if((String)condition.wt==sL && !value)value=null
				}
				if(value){
					//successful step, move on
					ladderIndex+= i1
					ladderUpdated=(Long)now()
					cancelStatementSchedules(rtD,myC)
					if(lg)debug "Condition group #${myC} made progress up the ladder; currently at step $ladderIndex of $steps",rtD
					if(ladderIndex<steps){
						//delay decision, there are more steps to go through
						value=null
						condition=((List<Map>)conditions[collection])[ladderIndex]
						Map tv=(Map)evaluateOperand(rtD,null,(Map)condition.wd)
						duration=(Long)evaluateExpression(rtD,rtnMap1(sDURATION,tv.v,(String)tv.vt),sLONG).v
						requestWakeUp(rtD,conditions,conditions,duration)
					}
				}
			}

			//noinspection GroovyFallthrough
			switch(value){
				case null:
					//we need to exit time events set to work out the timeouts...
					if((Integer)rtD.ffTo==myC)rtD.terminated=true
					break
				case true:
				case false:
					//ladder either collapsed or finished, reset data
					ladderIndex=iZ
					ladderUpdated=lZ
					cancelStatementSchedules(rtD,myC)
					break
			}
			if((Integer)rtD.ffTo==myC)rtD.ffTo=iZ
			rtD.cache[sidx]=ladderIndex
			rtD.cache[sldt]=ladderUpdated
		}
	}else{
		Boolean res
		for(Map condition in (List<Map>)conditions[collection]){
			res=evaluateCondition(rtD,condition,collection,async)
			value= grouping==sOR ? value||res : value&&res
			//cto == disable condition traversal optimizations
			if((Integer)rtD.ffTo==iZ && !(Integer)rtD.piston.o?.cto && ((value && grouping==sOR) || (!value && grouping==sAND)))break
		}
	}
	Boolean result=false
	if(value!=null) result=not ? !value:value
	if(value!=null && myC!=iZ){
		String mC="c:${myC}".toString()
		if((Integer)rtD.ffTo==iZ)tracePoint(rtD,mC,elapseT(t),result)
		Boolean oldResult=!!(Boolean)((Map<String,Object>)rtD.cache)[mC]
		rtD.cndtnStChgd=(oldResult!=result)
		if((Boolean)rtD.cndtnStChgd) //condition change, perform Task Cancellation Policy TCP
			cancelConditionSchedules(rtD,myC)
		rtD.cache[mC]=result
		//true/false actions
		if(collC){
			if((result || (Integer)rtD.ffTo!=iZ) && conditions.ts!=null && ((List)conditions.ts).size())Boolean a=executeStatements(rtD,(List)conditions.ts,async)
			if((!result || (Integer)rtD.ffTo!=iZ) && conditions.fs!=null && ((List)conditions.fs).size())Boolean a=executeStatements(rtD,(List)conditions.fs,async)
		}
		if((Integer)rtD.ffTo==iZ && lg){
			msg.m="Condition group #${myC} evaluated $result (state ${(Boolean)rtD.cndtnStChgd ? 'changed' : 'did not change'})".toString()
			debug msg,rtD
		}
	}
	//restore condition id
	rtD.stack.c=c
	if(ntf)myDetail rtD,myS+"result:$result"
	return result
}

@SuppressWarnings('GroovyFallthrough')
private evaluateOperand(Map rtD,Map node,Map oper,index=null,Boolean trigger=false,Boolean nextMidnight=false){
	String myS=sBLK
	Boolean ntf=(Boolean)rtD.eric
	if(ntf){
		myS="evaluateOperand: "+ffwding(rtD)+"$oper "
		myDetail rtD,myS,i1
	}
	List<Map> values=[]
	Map operand=oper
	//older pistons don't have the 'to' operand (time offset), simulating an empty one
	if(!operand)operand=[(sT):sC]
	String ovt=(String)operand.vt
	Map movt=ovt ? [(sVT):ovt] : [:]
	String nodeI="${node?.$}:$index:0".toString()
	Map mv=null
	switch((String)operand.t){
		case sBLK: //optional, nothing selected
			mv=rtnMap(ovt,null)
			break
		case sP: //physical device
			String operA=(String)operand.a
			Map attribute=operA ? Attributes()[operA]:[:]
			Map aM=attribute && attribute.p ? [p:operand.p]:[:] // device support p- physical vs. s- digital, a-any
			Boolean a
			for(String deviceId in expandDeviceList(rtD,(List)operand.d)){
				Map value=[(sI): deviceId+sCOLON+operA,(sV):getDeviceAttribute(rtD,deviceId,operA,operand.i,trigger)+movt+aM]
				updateCache(rtD,value)
				a=values.push(value)
			}
			if(values.size()>i1 && !((String)operand.g in [sANY,sALL])){
				//if we have multiple values and a grouping other than any or all we need to apply that function
				// count, avg, median, least, most, stdev, min, max, variance etc..
				try{
					mv=(Map)"func_${(String)operand.g}"(rtD,values*.v)+movt
				}catch(ignored){
					error "Error applying grouping method ${(String)operand.g}",rtD
				}
			}
			break
		case sD: //devices
			List deviceIds=[]
			Boolean a
			for(String d in expandDeviceList(rtD,(List)operand.d))
				if(getDevice(rtD,d))a=deviceIds.push(d)
			nodeI="${node?.$}:d".toString()
			mv=rtnMap(sDEV,deviceIds.unique())
			break
		case sV: //virtual devices
			String rEN=(String)rtD.event.name
			String evntVal="${rtD.event.value}".toString()
			nodeI="${node?.$}:v".toString()
			String oV=(String)operand.v
			switch(oV){
				case sTIME:
				case sDATE:
				case sDTIME:
					mv=rtnMap(oV,(Long)cast(rtD,(Long)now(),oV,sLONG))
					break
				case sMODE:
				case sHSMSTS:
				case 'alarmSystemStatus':
					mv=getDeviceAttribute(rtD,(String)rtD.locationId,oV)
					break
				case sHSMALRT:
				case 'alarmSystemAlert':
					String valStr=evntVal+(rEN==sHSMALRT && evntVal==sRULE ? ",${(String)rtD.event.descriptionText}".toString():sBLK)
					mv=rtnMap(sSTR,(rEN==sHSMALRT ? valStr:sNULL))
					break
				case sHSMSARM:
				case 'alarmSystemEvent':
					mv=rtnMap(sSTR,(rEN==sHSMSARM ? evntVal:sNULL))
					break
				case 'alarmSystemRule':
					mv=rtnMap(sSTR,(rEN=='hsmRules' ? evntVal:sNULL))
					break
				case 'powerSource':
					mv=rtnMap(sENUM,rtD.powerSource)
					break
				case 'routine':
					mv=rtnMap(sSTR,(rEN=='routineExecuted' ? hashId(evntVal):sNULL))
					break
				case 'systemStart':
					mv=rtnMap(sSTR,(rEN=='systemStart' ? evntVal:sNULL))
					break
				case 'tile':
					mv=rtnMap(sSTR,(rEN==oV ? evntVal:sNULL))
					break
				case 'ifttt':
					mv=rtnMap(sSTR,(rEN==('ifttt.'+evntVal)? evntVal:sNULL))
					break
				case 'email':
					mv=rtnMap('email',(rEN==('email.'+evntVal)? evntVal:sNULL))
					break
			}
			break
		case sS: //preset
			Boolean time=false
			switch(ovt){
				case sTIME:
					time=true
				case sDTIME:
					Long v=lZ
					switch((String)operand.s){
						case 'sunset': v=getSunsetTime(rtD); break
						case 'sunrise': v=getSunriseTime(rtD); break
						case 'midnight': v=nextMidnight ? getNextMidnightTime():getMidnightTime(); break
						case 'noon': v=getNoonTime(); break
					}
					if(time&&v)v=(Long)cast(rtD,v,ovt,sDTIME)
					mv=rtnMap(ovt,v)
					break
				default:
					mv=rtnMap(ovt,operand.s)
					break
			}
			break
		case sX: //variable
			if(ovt==sDEV && operand.x instanceof List){
				//we could have multiple devices selected
				List asum=[]
				Map avar
				for(String x in (List)operand.x){
					avar=getVariable(rtD,x)
					if(avar.v instanceof List){
						//noinspection GroovyAssignabilityCheck
						asum+=(List)avar.v
					}else Boolean a=asum.push(avar.v)
				}
				mv=rtnMap(sDEV,asum)+movt
			}else{
				Boolean hasI=(String)operand.xi!=sNULL
				if(hasI)movt=ovt ? [(sVT):ovt.replace(sLRB,sBLK)] : [:]
				mv=getVariable(rtD,(String)operand.x+(hasI ? sLB+(String)operand.xi+sRB:sBLK))+movt
			}
			break
		case sC: //constant
			switch(ovt){
				case sTIME:
					Long offset=(operand.c instanceof Integer)? ((Integer)operand.c).toLong():(Long)cast(rtD,operand.c,sLONG)
					mv=rtnMap(ovt,(offset%1440L)*60000L)	//convert mins to time
					break
				case sDATE:
				case sDTIME:
					mv=rtnMap(ovt,operand.c)
					break
			}
			if(mv)break
		case sE: //expression
			mv=movt+evaluateExpression(rtD,(Map)operand.exp)
			break
		case 'u': //argument
			mv=getArgument(rtD,(String)operand.u)
			break
	}
	if(mv) values=[[(sI):nodeI,(sV):mv]]

	if(node==null){ // return a Map instead of a List
		Map ret
		if(values.size())ret=(Map)values[iZ].v
		else ret=rtnMap(sDYN,null)
		if(ntf)myDetail rtD,myS+"result:$ret"
		return ret
	}
	if(ntf)myDetail rtD,myS+"result:$values"
	return values
}

private Map evaluateScalarOperand(Map rtD,Map node,Map operand,index=null,String dataType=sSTR){
	Map value=(Map)evaluateOperand(rtD,null,operand,index)
	return rtnMap(dataType,cast(rtD,(value ? value.v:sBLK),dataType))
}

private Boolean evaluateCondition(Map rtD,Map condition,String collection,Boolean async){
	String myS=sBLK
	String str='evaluateCondition '
	if((Boolean)rtD.eric){
		myS=str+ffwding(rtD)+"$condition".toString()
		myDetail rtD,myS,i1
	}

	if((String)condition.t==sGROUP){
		Boolean tt1=evaluateConditions(rtD,condition,collection,async)
		if((Boolean)rtD.eric)myDetail rtD,myS+" result:$tt1"
		return tt1
	}

	Long t=(Long)now()
	Map msg=[:]
	if((Integer)rtD.logging>i2)msg=timer sBLK,rtD
	//override condition id
	Integer c=(Integer)rtD.stack.c
	Integer conditionNum=condition.$!=null ? (Integer)condition.$:iZ
	rtD.stack.c=conditionNum
	String sIndx="c:${conditionNum}".toString()
	Boolean oldResult=!!(Boolean)((Map<String,Object>)rtD.cache)[sIndx]
	Boolean result=false

	Boolean not=!!condition.n
	String co=(String)condition.co
	Map comparison=Comparisons().triggers[co]
	Boolean trigger=comparison!=null
	if(!trigger)comparison=Comparisons().conditions[co]
	rtD.wakingUp=(String)rtD.event.name==sTIME && rtD.event.schedule!=null && (Integer)rtD.event.schedule.s==conditionNum
	if((Integer)rtD.ffTo!=iZ || comparison!=null){
		Boolean isStays=co.startsWith('stays')
		if((Integer)rtD.ffTo in [iZ,iN9]){
			Integer pCnt=comparison.p!=null ? (Integer)comparison.p:iZ
			Map lo=null
			Map ro=null
			Map ro2=null
			for(Integer i=iZ; i<=pCnt; i++){
				Map operand=(i==iZ ? (Map)condition.lo:(i==i1 ? (Map)condition.ro : (Map)condition.ro2))
				//parse the operand
				List values=(List)evaluateOperand(rtD,condition,operand,i,trigger)
				switch(i){
					case iZ:
						lo=[operand:operand,values:values]
						break
					case i1:
						ro=[operand:operand,values:values]
						break
					case i2:
						ro2=[operand:operand,values:values]
						break
				}
			}

			//we now have all the operands,their values, and the comparison, let's get to work
			Boolean t_and_compt=(trigger && comparison.t!=null)
			Map options=[
					//we ask for matching/non-matching devices if the user requested it or if the trigger is timed
					//setting matches to true will force the condition group to evaluate all members (disables evaluation optimizations)
					matches: lo.operand.dm!=null || lo.operand.dn!=null || t_and_compt,
					forceAll: t_and_compt
			]
			Map to=(comparison.t!=null || (ro!=null && (String)lo.operand.t==sV && (String)lo.operand.v==sTIME && (String)ro.operand.t!=sC)) && condition.to!=null ? [operand: (Map)condition.to,values: (Map)evaluateOperand(rtD,null,(Map)condition.to)]:null
			Map to2=ro2!=null && (String)lo.operand.t==sV && (String)lo.operand.v==sTIME && (String)ro2.operand.t!=sC && condition.to2!=null ? [operand: (Map)condition.to2,values: (Map)evaluateOperand(rtD,null,(Map)condition.to2)]:null

			if((Boolean)rtD.eric && trigger && (Integer)rtD.ffTo==iZ && (Integer)rtD.stmtLvl!=i1)
				myDetail rtD,"trigger comparison ${co} at level>1 level: ${rtD.stmtLvl}",iN2

			result=evaluateComparison(rtD,co,lo,ro,ro2,to,to2,options)

			//save new values to cache
			if(lo)for(Map value in (List<Map>)lo.values)updateCache(rtD,value)
			if(ro)for(Map value in (List<Map>)ro.values)updateCache(rtD,value)
			if(ro2)for(Map value in (List<Map>)ro2.values)updateCache(rtD,value)
			if(lo.operand.dm!=null && options.devices!=null)Map m=setVariable(rtD,(String)lo.operand.dm,options.devices.matched!=null ? (List)options.devices.matched:[])
			if(lo.operand.dn!=null && options.devices!=null)Map n=setVariable(rtD,(String)lo.operand.dn,options.devices.unmatched!=null ? (List)options.devices.unmatched:[])

			//do the stays logic here
			if(t_and_compt && (Integer)rtD.ffTo==iZ){
				//trigger on device:attribute and timed trigger
				if(eric())log.debug "stays check ${co} isStays: $isStays result: $result options: $options"
				if(to!=null){
					Map tvalue=(Map)to.operand && (Map)to.values ? (Map)to.values+[f: to.operand.f]:null
					if(tvalue!=null){
						Long delay=(Long)evaluateExpression(rtD,rtnMap1(sDURATION,tvalue.v,(String)tvalue.vt),sLONG).v

						List<Map> schedules=sgetSchedules(str,(Boolean)rtD.pep)

						if((String)lo.operand.t==sP && (String)lo.operand.g==sANY && ((List)lo.values).size()>i1){
							List<String> chkList=(List)options.devices.matched
							if(eric())log.debug "$co stays check device options: $options"
							//if(!isStays) chkList=(List)options.devices.unmatched
							for(value in (List<Map>)lo.values){
								String dev=(String)value.v?.d
								doStaysProcess(rtD,schedules,co,condition,conditionNum,delay,(dev in chkList),dev)
							}
						}else{
							if(eric())log.debug "$co stays check"
							doStaysProcess(rtD,schedules,co,condition,conditionNum,delay,result,sNULL)
						}
					}else{ log.error "expecting time for stay and value not found $to $tvalue" }	//; result=false }
				}else{ log.error "expecting time for stay and operand not found $to" } //;	result=false }
				if(isStays)result=false
			}
			result=not ? !result:result
		}else if((String)rtD.event.name==sTIME && (Integer)rtD.ffTo==conditionNum){ // we are ffwding & stays timer fired, pickup at result of if statement
			rtD.ffTo=iZ
			rtD.resumed=true
			if(isStays) result=!not
		}else{ // continue ffwding
			result=oldResult
		}
	}
	if((Integer)rtD.ffTo==iZ)tracePoint(rtD,sIndx,elapseT(t),result)

	rtD.wakingUp=false
	rtD.cndtnStChgd=oldResult!=result
	if((Boolean)rtD.cndtnStChgd) //condition change, perform Task Cancellation Policy TCP
		cancelConditionSchedules(rtD,conditionNum)
	((Map)rtD.cache)[sIndx]=result
	//true/false actions
	if((result || (Integer)rtD.ffTo!=iZ) && condition.ts!=null && ((List)condition.ts).size()!=iZ)Boolean a=executeStatements(rtD,(List)condition.ts,async)
	if((!result || (Integer)rtD.ffTo!=iZ) && condition.fs!=null && ((List)condition.fs).size()!=iZ)Boolean a=executeStatements(rtD,(List)condition.fs,async)
	//restore condition id
	rtD.stack.c=c
	if((Integer)rtD.ffTo==iZ && (Integer)rtD.logging>i2){
		msg.m="Condition #${conditionNum} evaluated $result"
		debug msg,rtD
	}
	if((Integer)rtD.ffTo<=iZ && (Boolean)condition.s && (String)condition.t==sCONDITION && condition.lo!=null && (String)condition.lo.t==sV){
		if(!LT1){ LT1=fill_TIM(); mb() }
		if((String)condition.lo.v in LT1){ scheduleTimeCondition(rtD,condition) }
	}
	if((Boolean)rtD.eric)myDetail rtD,myS+" result:$result"
	return result
}

void doStaysProcess(Map rtD,List<Map>schedules,String co,Map condition,Integer conditionNum,Long delay,Boolean result,String dev){
	Boolean canc=false
	Boolean schd=false
	Boolean isStaysUnchg= co=='stays_unchanged'
	Boolean isStays=co.startsWith('stays')
	Boolean lg=(Integer)rtD.logging>i2
	String s=sBLK
	if(isStays && result){
		//if we find the comparison true (ie reason to time stays has begun) set a timer if we haven't already
		if(lg)s= dev ? " $co match in list" : " $co result $result"
		if(!schedules.find{ Map it -> (Integer)it.s==conditionNum && (!dev || (String)it.d==dev) }){
			//schedule a wake up if there's none otherwise just move on
			if(lg)s+= " scheduling timer "
			schd=true
		}else s+= " found timer "
	}else{ // the comparison failed, normally cancel except for stays_unchanged
		if(lg)s= dev ? " $co device did not match" : " $co result $result"
		if(isStaysUnchg){
			if(lg)s+= " $co result $result (it changed)"
			if(!schedules.find{ Map it -> (Integer)it.s==conditionNum && (!dev || (String)it.d==dev) }){
				if(lg)s+= " no timer found creating timer "
				schd=true
			}else{
				if(lg)s+= " with timer active cancel timer "
				canc=true
			}
		}else{
			//cancel any schedule
			if(lg)s+= " cancel any timers "
			canc=true
		}
	}
	if(lg){
		String d= dev ? "for device $dev " : ""
		s="timed trigger schedule${s}${d}for condition ${conditionNum}"
	}
	if(canc){
		if(lg)debug "Cancelling any $s",rtD
		cancelStatementSchedules(rtD,conditionNum,dev)
	}
	if(schd){
		if(lg)debug "Adding a $s",rtD
		requestWakeUp(rtD,condition,condition,delay,dev)
	}
	if(!schd && !canc){
		if(lg)debug "Doing nothing found $s",rtD
	}
}

private void updateCache(Map rtD,Map<String,Object> value){
	Map oldValue=(Map)((Map<String,Object>)rtD.cache)[(String)value.i]
	if(oldValue==null || (String)oldValue.t!=(String)value.v.t || oldValue.v!=value.v.v){
		((Map<String,Map>)rtD.newCache)[(String)value.i]=(Map)value.v+[(sS):(Long)now()]
	}
}

private Boolean evaluateComparison(Map rtD,String comparison,Map lo,Map ro=null,Map ro2=null,Map to=null,Map to2=null,Map options=[:]){
	String mySt=sBLK
	if((Boolean)rtD.eric){
		mySt="evaluateComparison "+ffwding(rtD)+"$comparison "
		myDetail rtD,mySt,i1
	}
	Boolean lg=(Integer)rtD.logging>i2
	String fn="comp_"+comparison
	String loG= (String)lo.operand.g
	Boolean result= loG!=sANY
	Boolean oM=(Boolean)options.matches
	if(oM){ options.devices=[matched: [],unmatched: []] }
	//if multiple left values go through each
	Map tvalue=to && to.operand && to.values ? (Map)to.values+[f: to.operand.f]:null
	Map tvalue2=to2 && to2.operand && to2.values ? (Map)to2.values:null
	if(!LT1){ LT1=fill_TIM(); mb() }
	for(Map<String,Map> value in (List<Map>)lo.values){
		Boolean res=false
		//x=eXclude- if a momentary attribute is looked for and the device does not match the current device, then we must ignore this during comparisons
		if(value && value.v && (!value.v.x || (Boolean)options.forceAll)){
			try{
				//physical support
				//value.p=lo.operand.p
				if(value && (String)value.v.t==sDEV)value.v=evaluateExpression(rtD,(Map)value.v,sDYN)
				if(!ro){
					Map msg=[:]
					if(lg)msg=timer sBLK,rtD
					if(comparison=='event_occurs'){
						String compS=(String)lo.operand.v
						if(compS=='alarmSystemStatus') compS=sHSMSTS
						if(compS=='alarmSystemAlert') compS=sHSMALRT
						if(compS=='alarmSystemEvent') compS=sHSMSARM
						if((String)lo.operand.t==sV && (String)rtD.event.name==compS){
							res=true
						}else if((String)value.v.d==hashId(rtD.event.device?.id) && (String)value.v.a==(String)rtD.event.name){
							res=true
							compS=(String)value.v.a
						}
						if(res && lg)msg.m="Comparison (string) ${compS} $comparison = $res"
					}else{
						res=(Boolean)"$fn"(rtD,value,null,null,tvalue,tvalue2)
						if(lg)msg.m="Comparison (${value.v.t}) ${value.v.v} $comparison = $res"
					}
					if(lg)debug msg,rtD
				}else{
					Boolean rres
					String roG= (String)ro.operand.g
					res= roG!=sANY
					//if multiple right values go through each
					for(Map<String,Map> rvalue in (List<Map>)ro.values){
						if(rvalue && (String)rvalue.v.t==sDEV)rvalue.v=evaluateExpression(rtD,(Map)rvalue.v,sDYN)
						if(!ro2){
							Map msg=[:]
							if(lg)msg=timer sBLK,rtD
							rres=(Boolean)"$fn"(rtD,value,rvalue,null,tvalue,tvalue2)
							if(lg){
								msg.m="Comparison (${value.v.t}) ${value.v.v} $comparison (${rvalue?.v?.t}) ${rvalue?.v?.v} = $rres"
								debug msg,rtD
							}
						}else{
							String ro2G= (String)ro2.operand.g
							rres=ro2G!=sANY
							//if multiple right2 values go through each
							for(Map<String,Map> r2value in (List<Map>)ro2.values){
								if(r2value && (String)r2value.v.t==sDEV)r2value.v=evaluateExpression(rtD,(Map)r2value.v,sDYN)
								Map msg=[:]
								if(lg)msg=timer sBLK,rtD
//if((Boolean)rtD.eric)myDetail rtD,"$fn $value $rvalue $r2value $tvalue $tvalue2",i1
								Boolean r2res=(Boolean)"$fn"(rtD,value,rvalue,r2value,tvalue,tvalue2)
//if((Boolean)rtD.eric)myDetail rtD,"$r2res ${myObj(value?.v?.v)} ${myObj(rvalue?.v?.v)} $fn $value $rvalue $r2value $tvalue $tvalue2"
								if(lg){
									msg.m="Comparison (${value.v.t}) ${value.v.v} $comparison (${rvalue?.v?.t}) ${rvalue?.v?.v} .. (${r2value?.v?.t}) ${r2value?.v?.v} = $r2res"
									debug msg,rtD
								}
								rres= ro2G==sANY ? rres||r2res : rres&&r2res
								if((ro2G==sANY && rres) || (ro2G!=sANY && !rres))break
							}
						}
						res=(roG==sANY ? res||rres : res&&rres)
						if((roG==sANY && res) || (roG!=sANY && !res))break
					}
				}
			}catch(all){
				error "Error calling comparison $fn:",rtD,iN2,all
				res=false
			}

			if(res && (String)lo.operand.t==sV && (String)lo.operand.v in LT1){
				Boolean pass=(checkTimeRestrictions(rtD,(Map)lo.operand,(Long)now(),5,i1)==lZ)
				if(lg)debug "Time restriction check ${pass ? 'passed' : 'failed'}",rtD
				if(!pass)res=false
			}
		}
		result= loG==sANY ? result||res : result&&res
		if(oM){
			String vVD=(String)value.v.d
			if(vVD){
				Boolean a
				if(res) a=((List)options.devices.matched).push(vVD)
				else a=((List)options.devices.unmatched).push(vVD)
			}
		}else{
			// if not matching, see if we are done
			//logical OR if using the ANY keyword
			if(loG==sANY && res) break
			//logical AND if using the ALL keyword
			if(loG==sALL && !result) break
		}
	}
	if((Boolean)rtD.eric)myDetail rtD,mySt+"result:$result"
	return result
}

private void cancelStatementSchedules(Map rtD,Integer statementId,String data=sNULL){
	//cancel all schedules that are pending for statement statementId
	Boolean fnd=false
	for(Map item in (List<Map>)rtD.cancelations.statements){
		fnd=(statementId==(Integer)item.id && (!data || data==(String)item.data))
		if(fnd)break
	}
	if((Integer)rtD.logging>i2)debug "Cancelling statement #${statementId}'s schedules...",rtD
	if(!fnd)Boolean a=((List<Map>)rtD.cancelations.statements).push([(sID): statementId,data: data])
}

private void cancelConditionSchedules(Map rtD,Integer conditionId){
	//cancel all schedules that are pending for condition conditionId
	if((Integer)rtD.logging>i2)debug "Cancelling condition #${conditionId}'s schedules...",rtD
	if(!(conditionId in (List<Integer>)rtD.cancelations.conditions)){
		Boolean a=((List<Integer>)rtD.cancelations.conditions).push(conditionId)
	}
}

private static Boolean matchDeviceSubIndex(list,deviceSubIndex){
	//if(!list || !(list instanceof List) || list.size()==iZ)return true
	//return list.collect{ "$it".toString() }.indexOf("$deviceSubIndex".toString())>=iZ
	return true
}

private static Boolean matchDeviceInteraction(String option,Map rtD){
	Boolean isPhysical=(Boolean)rtD.currentEvent.physical
	// device support p- physical vs. s- digital, a-any
	return !((option==sP && !isPhysical) || (option==sS && isPhysical))
}

private List<Map> listPreviousStates(device,String attr,Long threshold,Boolean excludeLast){
	List<Map> result=[]
	List events=device.events([all: true,max: 100]).findAll{ it -> (String)it.name==attr}
	//if we got any events let's go through them
	//if we need to exclude last event we start at the second event as the first one is the event that triggered this function. The attribute's value has to be different from the current one to qualify for quiet
	Integer sz=events.size()
	if(sz!=iZ){
		Long thresholdTime=elapseT(threshold)
		Long endTime=(Long)now()
		for(Integer i=iZ; i<sz; i++){
			Long startTime=((Date)events[i].date).getTime()
			Long duration=endTime-startTime
			if(duration>=1L && (i>iZ || !excludeLast)){
				Boolean a=result.push([(sVAL):events[i].value,startTime:startTime,duration:duration])
			}
			if(startTime<thresholdTime) break
			endTime=startTime
		}
	}else{
		def currentState=device.currentState(attr,true)
		if(currentState){
			Long startTime=((Date)currentState.getDate()).getTime()
			Boolean a=result.push([(sVAL):currentState.value,startTime:startTime,duration:elapseT(startTime)])
		}
	}
	return result
}

private static Map valueCacheChanged(Map rtD,Map<String,Object> comparisonValue){
	def oV=((Map<String,Object>)rtD.cache)[(String)comparisonValue.i]
	Map newValue=(Map)comparisonValue.v
	Map oldValue= oV instanceof Map ? oV:null
	return (oldValue!=null && ((String)oldValue.t!=(String)newValue.t || "${oldValue.v}"!="${newValue.v}")) ? [(sI):(String)comparisonValue.i,(sV):oldValue] :null
}

private Boolean valueWas(Map rtD,Map comparisonValue,Map rightValue,Map rightValue2,Map timeValue,String func){
	if(comparisonValue==null || comparisonValue.v==null || !(String)comparisonValue.v.d || !(String)comparisonValue.v.a || timeValue==null || !timeValue.v || !(String)timeValue.vt){
		return false
	}
	def device=getDevice(rtD,(String)comparisonValue.v.d)
	if(device==null)return false
	String attr=(String)comparisonValue.v.a
	Long threshold=(Long)evaluateExpression(rtD,rtnMap1(sDURATION,timeValue.v,(String)timeValue.vt),sLONG).v

	Boolean thisEventWokeUs=(rtD.event.device?.id==device.id && (String)rtD.event.name==attr)
	List<Map> states=listPreviousStates(device,attr,threshold,false) // thisEventWokeUs)
	Boolean result
	Long duration=lZ
	Integer i=i1
	for(Map stte in states){
		String comp_t=(String)comparisonValue.v.t
		if(!(i==i1 && thisEventWokeUs)){
			if(!("comp_$func"(rtD,[(sI):(String)comparisonValue.i,(sV):rtnMap(comp_t,cast(rtD,stte.value,comp_t))],rightValue,rightValue2,timeValue)))break
			duration+= (Long)stte.duration
		}
		i+=i1
	}
	if(duration==lZ)return false
	result=((String)timeValue.f==sG)? duration>=threshold:duration<threshold // 'l' or 'g'
	if((Integer)rtD.logging>i2)
		debug "Duration ${duration}ms for ${func.replace('is_','was_')} ${(String)timeValue.f==sG ? sGTHE : sLTH} ${threshold}ms threshold = ${result}",rtD
	return result
}

private Boolean valueChanged(Map rtD,Map comparisonValue,Map timeValue){
	if(comparisonValue==null || comparisonValue.v==null || !(String)comparisonValue.v.d || !(String)comparisonValue.v.a || timeValue==null || !timeValue.v || !(String)timeValue.vt){
		return false
	}
	def device=getDevice(rtD,(String)comparisonValue.v.d)
	if(device==null)return false
	String attr=(String)comparisonValue.v.a
	Long threshold=(Long)evaluateExpression(rtD,rtnMap1(sDURATION,timeValue.v,(String)timeValue.vt),sLONG).v

	List<Map> states=listPreviousStates(device,attr,threshold,false)
	if(states.size()==iZ)return false
	def value=states[iZ].value
	for(Map tstate in states) if(tstate.value!=value)return true
	return false
}

private static Boolean match(String str,String pattern){
	Integer sz=pattern.size()
	if(sz>i2 && pattern.startsWith(sDIV) && pattern.endsWith(sDIV)){
		def ppattern = ~pattern.substring(i1,sz-i1)
		return !!(str =~ ppattern)
	}
	return str.contains(pattern)
}

//comparison low level functions
private Boolean comp_is					(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return ((String)evaluateExpression(rtD,(Map)lv.v,sSTR).v==(String)evaluateExpression(rtD,(Map)rv.v,sSTR).v)|| (lv.v.n && (String)cast(rtD,lv.v.n,sSTR)==(String)cast(rtD,rv.v.v,sSTR))}
private Boolean comp_is_not				(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !comp_is(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_is_equal_to		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ String dt= (String)lv?.v?.t==sDEC || (String)rv?.v?.t==sDEC ? sDEC:((String)lv?.v?.t==sINT || (String)rv?.v?.t==sINT ? sINT:sDYN); return evaluateExpression(rtD,(Map)lv.v,dt).v==evaluateExpression(rtD,(Map)rv.v,dt).v }
private Boolean comp_is_not_equal_to	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !comp_is_equal_to(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_is_different_than	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_not_equal_to(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_is_less_than		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (Double)evaluateExpression(rtD,(Map)lv.v,sDEC).v<(Double)evaluateExpression(rtD,(Map)rv.v,sDEC).v }
private Boolean comp_is_less_than_or_equal_to	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (Double)evaluateExpression(rtD,(Map)lv.v,sDEC).v<=(Double)evaluateExpression(rtD,(Map)rv.v,sDEC).v }
private Boolean comp_is_greater_than	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (Double)evaluateExpression(rtD,(Map)lv.v,sDEC).v>(Double)evaluateExpression(rtD,(Map)rv.v,sDEC).v }
private Boolean comp_is_greater_than_or_equal_to	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (Double)evaluateExpression(rtD,(Map)lv.v,sDEC).v>=(Double)evaluateExpression(rtD,(Map)rv.v,sDEC).v }
private Boolean comp_is_even			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (Integer)evaluateExpression(rtD,(Map)lv.v,sINT).v % i2 ==iZ }
private Boolean comp_is_odd				(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (Integer)evaluateExpression(rtD,(Map)lv.v,sINT).v % i2 !=iZ }
private Boolean comp_is_true			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (Boolean)evaluateExpression(rtD,(Map)lv.v,sBOOLN).v }
private Boolean comp_is_false			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !(Boolean)evaluateExpression(rtD,(Map)lv.v,sBOOLN).v }
private Boolean comp_is_inside_of_range		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Double v=(Double)evaluateExpression(rtD,(Map)lv.v,sDEC).v; Double v1=(Double)evaluateExpression(rtD,(Map)rv.v,sDEC).v; Double v2=(Double)evaluateExpression(rtD,(Map)rv2.v,sDEC).v; return (v1<v2) ? (v>=v1 && v<=v2):(v>=v2 && v<=v1)}
private Boolean comp_is_outside_of_range	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !comp_is_inside_of_range(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_is_any_of			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){
	String v=(String)evaluateExpression(rtD,(Map)lv.v,sSTR).v
	for(String vi in ((String)rv.v.v).tokenize(sCOMMA))
		if(v==(String)evaluateExpression(rtD,[(sT):(String)rv.v.t,(sV):"$vi".toString().trim(),(sI):rv.v.i,(sA):rv.v.a,(sVT):(String)rv.v.vt],sSTR).v) return true
	return false
}
private Boolean comp_is_not_any_of		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !comp_is_any_of(rtD,lv,rv,rv2,tv,tv2)}

private Boolean comp_was				(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is')}
private Boolean comp_was_not			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_not')}
private Boolean comp_was_equal_to		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_equal_to')}
private Boolean comp_was_not_equal_to	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_not_equal_to')}
private Boolean comp_was_different_than		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_different_than')}
private Boolean comp_was_less_than		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_less_than')}
private Boolean comp_was_less_than_or_equal_to		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_less_than_or_equal_to')}
private Boolean comp_was_greater_than	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_greater_than')}
private Boolean comp_was_greater_than_or_equal_to	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_greater_than_or_equal_to')}
private Boolean comp_was_even			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_even')}
private Boolean comp_was_odd			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_odd')}
private Boolean comp_was_true			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_true')}
private Boolean comp_was_false			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_false')}
private Boolean comp_was_inside_of_range		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_inside_of_range')}
private Boolean comp_was_outside_of_range		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_outside_of_range')}
private Boolean comp_was_any_of			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_any_of')}
private Boolean comp_was_not_any_of		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueWas(rtD,lv,rv,rv2,tv,'is_not_any_of')}

private Boolean comp_changed			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,tv2=null){ return valueChanged(rtD,lv,tv)}
private Boolean comp_did_not_change		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !valueChanged(rtD,lv,tv)}

private static Boolean comp_is_any		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return true }
private Boolean comp_is_before			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Long offset1=tv ? (Long)evaluateExpression(rtD,rtnMap1(sDURATION,tv.v,(String)tv.vt),sLONG).v:lZ; return (Long)cast(rtD,(Long)evaluateExpression(rtD,(Map)lv.v,sDTIME).v+2000L,(String)lv.v.t)< (Long)cast(rtD,(Long)evaluateExpression(rtD,(Map)rv.v,sDTIME).v+offset1,(String)lv.v.t)}
private Boolean comp_is_after			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !comp_is_before(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_is_between			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){
	Long offset1=tv ? (Long)evaluateExpression(rtD,rtnMap1(sDURATION,tv.v,(String)tv.vt),sLONG).v:lZ
	Long offset2=tv2 ? (Long)evaluateExpression(rtD,rtnMap1(sDURATION,tv2.v,(String)tv2.vt),sLONG).v:lZ
	Long v=(Long)cast(rtD,(Long)evaluateExpression(rtD,(Map)lv.v,sDTIME).v+2000L,(String)lv.v.t)
	Long v1=(Long)cast(rtD,(Long)evaluateExpression(rtD,(Map)rv.v,sDTIME).v+offset1,(String)lv.v.t)
	Long v2=(Long)cast(rtD,(Long)evaluateExpression(rtD,(Map)rv2.v,sDTIME).v+offset2,(String)lv.v.t)
	return v1<v2 ? v>=v1 && v<v2 : v<v2 || v>=v1
}
private Boolean comp_is_not_between		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !comp_is_between(rtD,lv,rv,rv2,tv,tv2)}

/*triggers*/
private Boolean comp_gets				(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (String)cast(rtD,lv.v.v,sSTR)==(String)cast(rtD,rv.v.v,sSTR) && matchDeviceSubIndex(lv.v.i,(Integer)rtD.currentEvent.index)}
private Boolean comp_executes			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_arrives			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (String)rtD.event.name=='email' && match(rtD.event?.jsonData?.from ?: sBLK,(String)evaluateExpression(rtD,(Map)rv.v,sSTR).v) && match(rtD.event?.jsonData?.message ?: sBLK,(String)evaluateExpression(rtD,(Map)rv2.v,sSTR).v)}
private static Boolean comp_event_occurs		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return false }
private static Boolean comp_happens_daily_at		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return (Boolean)rtD.wakingUp }
private static Boolean comp_changes		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueCacheChanged(rtD,lv)!=null && matchDeviceInteraction((String)lv.v.p,rtD)}
private static Boolean comp_changes_to	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueCacheChanged(rtD,lv)!=null && ("${lv.v.v}"=="${rv.v.v}") && matchDeviceInteraction((String)lv.v.p,rtD)}
private static Boolean comp_receives	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return ("${lv.v.v}"=="${rv.v.v}") && matchDeviceInteraction((String)lv.v.p,rtD)}
private static Boolean comp_changes_away_from		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && ("${oldValue.v.v}"=="${rv.v.v}") && matchDeviceInteraction((String)lv.v.p,rtD)}
private Boolean comp_drops				(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && (Double)cast(rtD,oldValue.v.v,sDEC)>(Double)cast(rtD,lv.v.v,sDEC)}
private Boolean comp_does_not_drop		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !comp_drops(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_drops_below		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && (Double)cast(rtD,oldValue.v.v,sDEC)>=(Double)cast(rtD,rv.v.v,sDEC) && (Double)cast(rtD,lv.v.v,sDEC)<(Double)cast(rtD,rv.v.v,sDEC)}
private Boolean comp_drops_to_or_below	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && (Double)cast(rtD,oldValue.v.v,sDEC)>(Double)cast(rtD,rv.v.v,sDEC) && (Double)cast(rtD,lv.v.v,sDEC)<=(Double)cast(rtD,rv.v.v,sDEC)}
private Boolean comp_rises				(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && (Double)cast(rtD,oldValue.v.v,sDEC)<(Double)cast(rtD,lv.v.v,sDEC)}
private Boolean comp_does_not_rise		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !comp_rises(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_rises_above		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && (Double)cast(rtD,oldValue.v.v,sDEC)<=(Double)cast(rtD,rv.v.v,sDEC) && (Double)cast(rtD,lv.v.v,sDEC)>(Double)cast(rtD,rv.v.v,sDEC)}
private Boolean comp_rises_to_or_above	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && (Double)cast(rtD,oldValue.v.v,sDEC)<(Double)cast(rtD,rv.v.v,sDEC) && (Double)cast(rtD,lv.v.v,sDEC)>=(Double)cast(rtD,rv.v.v,sDEC)}
private Boolean comp_remains_below		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && (Double)cast(rtD,oldValue.v.v,sDEC)<(Double)cast(rtD,rv.v.v,sDEC) && (Double)cast(rtD,lv.v.v,sDEC)<(Double)cast(rtD,rv.v.v,sDEC)}
private Boolean comp_remains_below_or_equal_to		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && (Double)cast(rtD,oldValue.v.v,sDEC)<=(Double)cast(rtD,rv.v.v,sDEC) && (Double)cast(rtD,lv.v.v,sDEC)<=(Double)cast(rtD,rv.v.v,sDEC)}
private Boolean comp_remains_above		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && (Double)cast(rtD,oldValue.v.v,sDEC)>(Double)cast(rtD,rv.v.v,sDEC) && (Double)cast(rtD,lv.v.v,sDEC)>(Double)cast(rtD,rv.v.v,sDEC)}
private Boolean comp_remains_above_or_equal_to		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && ((Double)cast(rtD,oldValue.v.v,sDEC)>=(Double)cast(rtD,rv.v.v,sDEC)) && ((Double)cast(rtD,lv.v.v,sDEC)>=(Double)cast(rtD,rv.v.v,sDEC))}
private Boolean comp_enters_range		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); if(oldValue==null)return false; Double ov=(Double)cast(rtD,oldValue.v.v,sDEC); Double v=(Double)cast(rtD,lv.v.v,sDEC); Double v1=(Double)cast(rtD,rv.v.v,sDEC); Double v2=(Double)cast(rtD,rv2.v.v,sDEC); if(v1>v2){ Double vv=v1; v1=v2; v2=vv }; return (ov<v1 || ov>v2) && v>=v1 && v<=v2}
private Boolean comp_exits_range		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); if(oldValue==null)return false; Double ov=(Double)cast(rtD,oldValue.v.v,sDEC); Double v=(Double)cast(rtD,lv.v.v,sDEC); Double v1=(Double)cast(rtD,rv.v.v,sDEC); Double v2=(Double)cast(rtD,rv2.v.v,sDEC); if(v1>v2){ Double vv=v1; v1=v2; v2=vv }; return ov>=v1 && ov<=v2 && (v<v1 || v>v2)}
private Boolean comp_remains_inside_of_range		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); if(oldValue==null)return false; Double ov=(Double)cast(rtD,oldValue.v.v,sDEC); Double v=(Double)cast(rtD,lv.v.v,sDEC); Double v1=(Double)cast(rtD,rv.v.v,sDEC); Double v2=(Double)cast(rtD,rv2.v.v,sDEC); if(v1>v2){ Double vv=v1; v1=v2; v2=vv }; return ov>=v1 && ov<=v2 && v>=v1 && v<=v2}
private Boolean comp_remains_outside_of_range		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); if(oldValue==null)return false; Double ov=(Double)cast(rtD,oldValue.v.v,sDEC); Double v=(Double)cast(rtD,lv.v.v,sDEC); Double v1=(Double)cast(rtD,rv.v.v,sDEC); Double v2=(Double)cast(rtD,rv2.v.v,sDEC); if(v1>v2){ Double vv=v1; v1=v2; v2=vv }; return (ov<v1 || ov>v2) && (v<v1 || v>v2)}
private Boolean comp_becomes_even		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv);return oldValue!=null && (Integer)cast(rtD,oldValue.v.v,sINT)%i2!=iZ && (Integer)cast(rtD,lv.v.v,sINT)%i2==iZ}
private Boolean comp_becomes_odd		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv);return oldValue!=null && (Integer)cast(rtD,oldValue.v.v,sINT)%i2==iZ && (Integer)cast(rtD,lv.v.v,sINT)%i2!=iZ}
private Boolean comp_remains_even		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv);return oldValue!=null && (Integer)cast(rtD,oldValue.v.v,sINT)%i2==iZ && (Integer)cast(rtD,lv.v.v,sINT)%i2==iZ}
private Boolean comp_remains_odd		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv);return oldValue!=null && (Integer)cast(rtD,oldValue.v.v,sINT)%i2!=iZ && (Integer)cast(rtD,lv.v.v,sINT)%i2!=iZ}

private Boolean comp_changes_to_any_of			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return valueCacheChanged(rtD,lv)!=null && comp_is_any_of(rtD,lv,rv,rv2,tv,tv2) && matchDeviceInteraction((String)lv.v.p,rtD)}
private Boolean comp_changes_away_from_any_of		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ Map oldValue=valueCacheChanged(rtD,lv); return oldValue!=null && comp_is_any_of(rtD,oldValue,rv,rv2) && matchDeviceInteraction((String)lv.v.p,rtD)}

private Boolean comp_stays				(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is(rtD,lv,rv,rv2,tv,tv2)}
//private Boolean comp_stays_unchanged			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return true }
private static Boolean comp_stays_unchanged			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return !comp_changes(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_not				(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_not(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_equal_to			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_equal_to(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_different_than		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_different_than(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_less_than			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_less_than(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_less_than_or_equal_to	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_less_than_or_equal_to(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_greater_than			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_greater_than(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_greater_than_or_equal_to	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_greater_than_or_equal_to(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_even			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_even(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_odd			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_odd(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_true			(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_true(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_false		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_false(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_inside_of_range		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_inside_of_range(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_outside_of_range		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_outside_of_range(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_any_of		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_any_of(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_away_from	(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_not_equal_to(rtD,lv,rv,rv2,tv,tv2)}
private Boolean comp_stays_away_from_any_of		(Map rtD,Map lv,Map rv=null,Map rv2=null,Map tv=null,Map tv2=null){ return comp_is_not_any_of(rtD,lv,rv,rv2,tv,tv2)}

private void traverseStatements(node,Closure closure,parentNode=null,Map<String,Boolean> data=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(item in (List<Map>)node)
			if(!item.di){
				Boolean lastTimer=(data!=null && (Boolean)data.timer)
				if(data!=null && (String)item.t==sEVERY) data.timer=true // force downgrade of triggers
				traverseStatements(item,closure,parentNode,data)
				if(data!=null) data.timer=lastTimer
			}
		return
	}

	//got a statement
	if(closure instanceof Closure) closure(node,parentNode,data)

	//if the statement has substatements go through them
	if(node.s instanceof List) traverseStatements((List)node.s,closure,node,data)
	if(node.e instanceof List) traverseStatements((List)node.e,closure,node,data)
}

private void traverseEvents(node,Closure closure,parentNode=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(item in (List)node) traverseEvents(item,closure,parentNode)
		return
	}
	if(closure instanceof Closure) closure(node,parentNode)
}

private void traverseConditions(node,Closure closure,parentNode=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(item in (List)node) traverseConditions(item,closure,parentNode)
		return
	}
	//got a condition
	if(node.t==sCONDITION && (closure instanceof Closure)) closure(node,parentNode)
	//if the statement has subconditions go through them
	if(node.c instanceof List){
		if(closure instanceof Closure)closure(node,parentNode)
		traverseConditions((List)node.c,closure,node)
	}
}

private void traverseRestrictions(node,Closure closure,parentNode=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(item in (List)node) traverseRestrictions(item,closure,parentNode)
		return
	}
	//got a restriction
	if(node.t==sRESTRIC && (closure instanceof Closure)) closure(node,parentNode)
	//if the statement has subrestrictions go through them
	if(node.r instanceof List){
		if(closure instanceof Closure)closure(node,parentNode)
		traverseRestrictions((List)node.r,closure,node)
	}
}

private void traverseExpressions(node,Closure closure,param,parentNode=null){
	if(!node)return
	//if a statements element, go through each item
	if(node instanceof List){
		for(item in (List)node) traverseExpressions(item,closure,param,parentNode)
		return
	}
	//got a statement
	if(closure instanceof Closure) closure(node,parentNode,param)
	//if the statement has subexpression go through them
	if(node.i instanceof List) traverseExpressions((List)node.i,closure,param,node)
}

private void updateDeviceList(Map rtD,List deviceIdList){
	app.updateSetting('dev',[(sTYPE):'capability',(sVAL):deviceIdList.unique()])// settings update do not happen till next execution
}

@SuppressWarnings('GroovyFallthrough')
private void subscribeAll(Map rtD,Boolean doit=true){
	if(eric())log.debug "subscribeAll $doit"
	try{
		if(!rtD){ log.error "no rtD subscribeAll"; return }
		Map<String,Integer> ss=[
			events: iZ,
			controls: iZ,
			devices: iZ,
		]
		Integer lg=(Integer)rtD.logging
		Map msg=timer "Finished subscribing",rtD,iN1
		if(doit){
			removeAllInUseGlobalVar()
			unsubscribe()
			rtD.devices=[:]
			if(lg>i1)trace "Subscribing to devices...",rtD,i1
		}
		Map<String,Map<String,Integer>> devices=[:]
		Map<String,Object> rawDevices=[:]
		Map<String,Map<String,Object>> subscriptions=[:]
		Boolean hasTriggers=false
		Map<String,Boolean> stmtData=[timer:false] // downGrade of triggers
		Boolean dwnGrdTrig=false // EVERY statement only has timer trigger
		String never='never'
		//traverse all statements
		Closure expressionTraverser
		Closure operandTraverser
		Closure eventTraverser
		Closure conditionTraverser
		Closure restrictionTraverser
		Closure statementTraverser
		expressionTraverser={ Map expression,parentExpression,String comparisonType ->
			String subsId=sNULL
			String deviceId=sNULL
			String attr=sNULL
			String exprID=(String)expression.id
			if((String)expression.t==sDEV && exprID){
				if(exprID==(String)rtD.oldLocationId)exprID=(String)rtD.locationId
				devices[exprID]=[(sC):(comparisonType ? i1:iZ)+(devices[exprID]?.c ? (Integer)devices[exprID].c:iZ)]
				deviceId=exprID
				attr=(String)expression.a
				subsId=deviceId+attr
			}
			String exprX=(String)expression.x
			if((String)expression.t==sVARIABLE && exprX && exprX.startsWith(sAT)){
				deviceId=(String)rtD.locationId
				if(exprX.startsWith('@@')){
					String vn=exprX.substring(2)
					def hg=getGlobalVar(vn) // check if it exists
					if(hg){
						subsId=vn
						attr=sVARIABLE+sCOLON+vn
					} else warn "hub varible not found while subscribing: $vn",rtD
				}else{
					subsId=exprX
					attr=(String)rtD.instanceId+sDOT+exprX
				}
			}
			if(subsId!=sNULL && deviceId!=sNULL){
				String ct=(String)subscriptions[subsId]?.t ?: sNULL
				if(ct==sTRIG || comparisonType==sTRIG){
					ct=sTRIG
				}else ct=ct ?: comparisonType
				subscriptions[subsId]=[(sD):deviceId, (sA):attr, (sT):ct, (sC):(subscriptions[subsId] ? (List)subscriptions[subsId].c:[])+(comparisonType? [expression]:[])]
				if(deviceId!=(String)rtD.locationId && deviceId.startsWith(sCOLON)){
					if(doit && !rawDevices[deviceId])rawDevices[deviceId]=getDevice(rtD,deviceId)
					devices[deviceId]=[(sC):(comparisonType ? i1:iZ)+(devices[deviceId]?.c ? (Integer)devices[deviceId].c:iZ)]
				}
			}
		}
		operandTraverser={ Map node,Map operand,value,String comparisonType ->
			if(!operand)return
			switch((String)operand.t){
				case sP: //physical device
					for(String mdeviceId in expandDeviceList(rtD,(List)operand.d,true)){
						String deviceId=mdeviceId
						if(deviceId==(String)rtD.oldLocationId)deviceId=(String)rtD.locationId
						devices[deviceId]=[(sC):(comparisonType ? i1:iZ)+(devices[deviceId]?.c ? (Integer)devices[deviceId].c:iZ)]
						String attr=(String)operand.a
						String subsId=deviceId+attr
						//if we have any trigger it takes precedence over anything else
						String ct=(String)subscriptions[subsId]?.t ?: sNULL
						Boolean allowAval=(Boolean)null
						List<String> avals=[]
						if(ct==sTRIG || comparisonType==sTRIG){
							ct=sTRIG
							String msgVal
							hasTriggers=true

							allowAval= subscriptions[subsId]?.allowA==null ? true : (Boolean)subscriptions[subsId].allowA
							String attrVal=sNULL
							if(allowAval && ((String)node.co in ['receives','gets']) && value && (String)value.t==sC && value.c){
								attrVal=(String)value.c
								//msgVal='Attempting Attribute value'
								avals=(List)subscriptions[subsId]?.avals ?: []
							}else allowAval=false
							if(allowAval && attrVal!=sNULL){
								if(! (attrVal in avals)) avals << attrVal
								msgVal="Attempting Attribute $attr value "+avals
							}else{
								allowAval=false
								msgVal="Using Attribute $attr"
								avals=[]
							}
							if(doit && lg>i2)debug msgVal+' subscription',rtD
						}else ct=ct ?: comparisonType
						subscriptions[subsId]=[(sD):deviceId,(sA):attr,(sT):ct,(sC):(subscriptions[subsId] ? (List)subscriptions[subsId].c:[])+(comparisonType?[node]:[]),allowA: allowAval,avals: avals]
						if(doit && deviceId!=(String)rtD.locationId && deviceId.startsWith(sCOLON) && !rawDevices[deviceId]){
							rawDevices[deviceId]=getDevice(rtD,deviceId)
						}
					}
					break
				case sV: //virtual device
					String deviceId=(String)rtD.locationId
					//if we have any trigger, it takes precedence over anything else
					devices[deviceId]=[(sC):(comparisonType ? i1:iZ)+(devices[deviceId]?.c ? (Integer)devices[deviceId].c:iZ)]
					String subsId=sNULL
					String attr=sNULL
					String operV=(String)operand.v
					String tsubId=deviceId+operV
					switch(operV){
						case sTIME:
						case sDATE:
						case sDTIME:
						case sMODE:
						case 'powerSource':
						case 'systemStart':
							subsId=tsubId
							attr=operV
							break
						case sHSMSTS:
						case 'alarmSystemStatus':
							subsId=tsubId
							attr=sHSMSTS
							break
						case sHSMALRT:
						case 'alarmSystemAlert':
							subsId=tsubId
							attr=sHSMALRT
							break
						case sHSMSARM:
						case 'alarmSystemEvent':
							subsId=tsubId
							attr=sHSMSARM
							break
						case 'alarmSystemRule':
							subsId=tsubId
							attr="hsmRules"
							break
						case 'email':
							subsId="$deviceId${operV}${(String)rtD.id}".toString()
							attr="email.${(String)rtD.id}".toString()// receive email does not work
							break
						case 'ifttt':
							if(value && (String)value.t==sC && value.c){
								Map<String,String> options=(Map)VirtualDevices()[operV]?.o
								String item=options ? (String)options[(String)value.c]:(String)value.c
								if(item){
									subsId="$deviceId${operV}${item}".toString()
									String attrVal=".${item}".toString()
									attr="${operV}${attrVal}".toString()
								}
							}
							break
					}
					if(subsId!=sNULL){
						String ct=(String)subscriptions[subsId]?.t ?: sNULL
						if(ct==sTRIG || comparisonType==sTRIG){
							ct=sTRIG
							hasTriggers=true
						}else ct=ct ?: comparisonType
						subscriptions[subsId]=[(sD):deviceId,(sA):attr,(sT):ct,(sC):(subscriptions[subsId] ? (List)subscriptions[subsId].c:[])+(comparisonType?[node]:[])]
						break
					}
					break
				case sX:
					String operX=(String)operand.x
					if(operX && operX.startsWith(sAT)){
						String subsId=operX
						String attr="${(String)rtD.instanceId}.${operX}".toString()
						if(operX.startsWith('@@')){
							String vn=operX.substring(2)
							def hg=getGlobalVar(vn) // check if it exists
							if(hg){
								subsId=vn
								attr=sVARIABLE+sCOLON+vn
							} else warn "hub varible not found while subscribing: $vn",rtD
						}
						String ct=(String)subscriptions[subsId]?.t ?: sNULL
						if(ct==sTRIG || comparisonType==sTRIG){
							ct=sTRIG
							hasTriggers=true
						}else ct=ct ?: comparisonType
						subscriptions[subsId]=[(sD):(String)rtD.locationId,(sA):attr,(sT):ct,(sC):(subscriptions[subsId] ? (List)subscriptions[subsId].c:[])+(comparisonType?[node]:[])]
					}
					break
				case sC: //constant
				case sE: //expression
					traverseExpressions(operand.exp?.i,expressionTraverser,comparisonType)
					break
			}
		}
		eventTraverser={ Map event,parentEvent ->
			if(event.lo){
				String comparisonType=sTRIG
				operandTraverser(event,(Map)event.lo,null,comparisonType)
			}
		}
		conditionTraverser={ Map condition,parentCondition ->
			String co=(String)condition.co
			if(co){
				Map comparison=Comparisons().conditions[co]
				String comparisonType=sCONDITION
				if(comparison==null){
					comparison=Comparisons().triggers[co]
					if(comparison!=null && !(dwnGrdTrig || (String)condition.sm==never)){ // not force condition
						hasTriggers=true
						comparisonType=sTRIG //subscription method
					}
				}
				if(comparison!=null){
					condition.ct=(String)comparisonType.take(1) // modifies the code
					Integer pCnt=comparison.p!=null ? (Integer)comparison.p: iZ
					for(Integer i=iZ; i<=pCnt; i++){
						//get the operand to parse
						Map operand=(i==iZ ? (Map)condition.lo:(i==i1 ? (Map)condition.ro:(Map)condition.ro2))
						operandTraverser(condition,operand,condition.ro,comparisonType)
					}
				}
			}
			if(condition.ts instanceof List)traverseStatements((List)condition.ts,statementTraverser,condition,stmtData)
			if(condition.fs instanceof List)traverseStatements((List)condition.fs,statementTraverser,condition,stmtData)
		}
		restrictionTraverser={ Map restriction,parentRestriction ->
			String rco=(String)restriction.co
			if(rco){
				Map comparison=Comparisons().conditions[rco]
				if(comparison==null) comparison=Comparisons().triggers[rco]
				if(comparison!=null){
					Integer pCnt=comparison.p!=null ? (Integer)comparison.p: iZ
					for(Integer i=iZ; i<=pCnt; i++){
						//get the operand to parse
						Map operand=(i==iZ ? (Map)restriction.lo:(i==i1 ? (Map)restriction.ro:(Map)restriction.ro2))
						operandTraverser(restriction,operand,null,sNULL)
					}
				}
			}
		}
		statementTraverser={ Map node,parentNode,Map data ->
			dwnGrdTrig=data!=null && (Boolean)data.timer
			if(node.r)traverseRestrictions(node.r,restrictionTraverser)
			for(String mdeviceId in (List<String>)node.d){
				String deviceId=mdeviceId
				if(deviceId==(String)rtD.oldLocationId)deviceId=(String)rtD.locationId
				devices[deviceId]=devices[deviceId] ?: [(sC):iZ]
				if(doit && deviceId!=(String)rtD.locationId && deviceId.startsWith(sCOLON) && !rawDevices[deviceId]){
					rawDevices[deviceId]=getDevice(rtD,deviceId)
				}
			}
			switch((String)node.t){
				case sACTION:
					if(node.k){
						for(Map k in (List<Map>)node.k) traverseStatements(k.p?:[],statementTraverser,k,data)
					}
					break
				case sIF:
					if(node.ei){
						for(Map ei in (List<Map>)node.ei){
							traverseConditions(ei.c?:[],conditionTraverser)
							traverseStatements(ei.s?:[],statementTraverser,ei,data)
						}
					}
				case sWHILE:
				case sREPEAT:
					traverseConditions(node.c,conditionTraverser)
					break
				case sON:
					traverseEvents(node.c?:[],eventTraverser)
					break
				case sSWITCH:
					operandTraverser(node,(Map)node.lo,null,sCONDITION)
					for(Map c in (List<Map>)node.cs){
						operandTraverser(c,(Map)c.ro,null,sNULL)
						//if case is a range traverse the second operand too
						if((String)c.t==sR)operandTraverser(c,(Map)c.ro2,null,sNULL)
						if(c.s instanceof List) traverseStatements((List)c.s,statementTraverser,node,data)
					}
					break
				case sEVERY:
					hasTriggers=true
					break
			}
		}
		if(rtD.piston.r)traverseRestrictions((List)rtD.piston.r,restrictionTraverser)
		if(rtD.piston.s)traverseStatements((List)rtD.piston.s,statementTraverser,null,stmtData)
		//device variables could be device type variable, or another type using device attributes to fill in
		for(Map variable in ((List<Map>)rtD.piston.v).findAll{ Map it -> /*(String)it.t==sDEV && */ it.v!=null && it.v.d!=null && it.v.d instanceof List}){
			for(String mdeviceId in (List<String>)variable.v.d){
				String deviceId=mdeviceId
				if(deviceId==(String)rtD.oldLocationId)deviceId=(String)rtD.locationId
				devices[deviceId]=[(sC): iZ+(devices[deviceId]?.c ? (Integer)devices[deviceId].c:iZ)]
				if(doit && deviceId!=(String)rtD.locationId && !rawDevices[deviceId]){
					rawDevices[deviceId]=getDevice(rtD,deviceId)
				}
			}
		}
		if(!LT1){ LT1=fill_TIM(); mb() }
		if(!LTHR){ LTHR=fill_THR(); mb() }
		Map<String,Integer> dds=[:]
		String always='always'
		for(subscription in subscriptions){
			String devStr=(String)subscription.value.d
			String altSub=never
			for(condition in (List<Map>)subscription.value.c){
				if(condition){
					condition.s=false // this modifies the code
					String tt0=(String)condition.sm
					altSub= tt0==always ? tt0 : (altSub!=always && tt0!=never ? tt0 : altSub)
				}
			}
			// check for disabled event subscriptions
			if(!(Integer)rtD.piston.o?.des && (String)subscription.value.t && !!subscription.value.c && altSub!=never && ((String)subscription.value.t==sTRIG || altSub==always || !hasTriggers)){
				def device= devStr.startsWith(sCOLON)? getDevice(rtD,devStr):null
				Boolean allowA=subscription.value.allowA!=null?(Boolean)subscription.value.allowA:false
				String a=(String)subscription.value.a
				if(a in LTHR){
					a=sTHREAX
					allowA=false
				}
				if(device!=null){
					for(condition in (List<Map>)subscription.value.c){
						if(condition){
							String t1=(String)condition.sm
							condition.s= t1!=never && ((String)condition.ct==sT || t1==always || !hasTriggers) // this modifies the code
						}
					}
					if(!(a in LT1)){ // timers don't have subscription
						Integer cnt=ss.events
						List<String> avals=(List)subscription.value.avals
						if(allowA && avals.size()<9){
							for(String aval in avals){
								String myattr=a+sDOT+aval
								if(doit){
									if(lg>iZ)info "Subscribing to $device.${myattr}...",rtD
									subscribe(device,myattr,deviceHandler)
								}
								cnt+=i1
							}
						}else{
							if(doit){
								if(lg>iZ)info "Subscribing to $device.${a}...",rtD
								subscribe(device,a,deviceHandler)
							}
							cnt+=i1
						}
						ss.events=cnt
						String didS=device.id.toString()
						if(!dds[didS]){
							ss.devices+=i1
							dds[didS]=i1
						}
					}
				}else{
					error "Failed subscribing to $devStr.${a}, device not found",rtD
				}
			}else{
				for(condition in (List<Map>)subscription.value.c){
					if(condition){ condition.s=false } // this modifies the code
				}
				if(devices[devStr]) devices[devStr].c=(Integer)devices[devStr].c-i1
			}
		}

		//not using fake subscriptions; piston has devices inuse in settings
		for(d in devices.findAll{ ((Integer)it.value.c<=iZ || (Integer)rtD.piston.o?.des) && (String)it.key!=(String)rtD.locationId }){
			def device= ((String)d.key).startsWith(sCOLON)? getDevice(rtD,(String)d.key):null
			if(device!=null && !isDeviceLocation(device)){
				String didS=device.id.toString()
				if(lg>i1 && doit)trace "Piston utilizes $device...",rtD
				ss.controls+=i1
				if(!dds[didS]){
					ss.devices+=i1
					dds[didS]=i1
				}
			}
		}
		if(doit){
			//save devices
			List deviceIdList=rawDevices.collect{ it && it.value ? it.value.id:null }
			rawDevices=null
			Boolean a=deviceIdList.removeAll{ it==null }
			updateDeviceList(rtD,deviceIdList)

			state.subscriptions=ss
			if(lg>i1)trace msg,rtD

			//subscribe(app,appHandler)
			subscribe(location,(String)rtD.id,executeHandler)
			Map event=[(sDATE):new Date(),(sDEV):location,(sNM):sTIME,(sVAL):(Long)now(),schedule:[(sT):lZ,(sS):iZ,(sI):iN9]]
			a=executeEvent(rtD,event)
			processSchedules rtD,true
			//save cache collected through dummy run
			for(item in (Map<String,Map>)rtD.newCache)((Map<String,Object>)rtD.cache)[(String)item.key]=item.value

			state.cache=(Map)rtD.cache
			String str='subAll'
			Map t0=getCachedMaps(str)
			String myId=(String)rtD.id
			if(t0!=null){
				getCacheLock(str)
				Map nc=theCacheVFLD[myId]
				if(nc){
					nc.cache=[:]+(Map)rtD.cache
					theCacheVFLD[myId]=nc
					theCacheVFLD=theCacheVFLD
				}
				releaseCacheLock()
			}
		}

	}catch(all){
		error "An error has occurred while subscribing: ",rtD,iN2,all
	}
}

private List<String> expandDeviceList(Map rtD,List devs,Boolean localVarsOnly=false){
	Boolean mlocalVars=false	//allowing global vars
	List<String>devices=devs
	List<String> result=[]
	for(String deviceId in devices){
		if(deviceId){
			if(isWcDev(deviceId)) Boolean a=result.push(deviceId)
			else{
				if(mlocalVars){
					//during subscriptions we can use local vars only to make sure we don't subscribe to "variable" lists of devices
					Map var=(Map)rtD.localVars[deviceId]
					if(var && (String)var.t==sDEV && var.v instanceof Map && (String)var.v.t==sD && var.v.d instanceof List)result+= (List)var.v.d
				}else{
					Map var=getVariable(rtD,deviceId)
					if((String)var.t==sDEV)
						//noinspection GroovyAssignabilityCheck
						result+= (var.v instanceof List) ? (List)var.v : []
					else{
						def device=getDevice(rtD,(String)cast(rtD,var.v,sSTR))
						if(device!=null)result+= [hashId(device.id)]
					}
				}
			}
		}
	}
	return result.unique()
}

//def appHandler(evt){
//}

private static String sanitizeVariableName(String name){
	String rname=name!=sNULL ? name.trim().replace(sSPC,sUNDS):sNULL
	return rname
}

private getDevice(Map rtD,String idOrName){
	if((String)rtD.locationId==idOrName || (String)rtD.oldLocationId==idOrName)return location
	Map<String,Object> dM=(Map<String,Object>)rtD.devices
	def t0=dM[idOrName]
	def device=t0!=null ? t0 : dM.find{ (String)it.value.getDisplayName()==idOrName }?.value
	if(device==null){
		if(rtD.allDevices==null){
			Map msg=timer "Device missing from piston. Loading all from parent",rtD
			rtD.allDevices=(Map)parent.listAvailableDevices(true)
			if(eric()||(Integer)rtD.logging>i2)debug msg,rtD
		}
		if(rtD.allDevices!=null){
			def deviceMap=((Map<String,Object>)rtD.allDevices).find{ (idOrName==(String)it.key)|| (idOrName==(String)it.value.getDisplayName())}
			if(deviceMap!=null){
				device=deviceMap.value
				rtD.updateDevices=true
				rtD.devices[(String)deviceMap.key]=device
			}
		}else{
			error "Device ${idOrName} was not found. Please review your piston.",rtD
		}
	}
	return device
}

@Field static List<String> LDAV
@Field static final String sSTS='$status'

private getDeviceAttributeValue(Map rtD,device,String attr){
	String rtDEvN=rtD.event!=null ? (String)rtD.event.name:sBLK
	Boolean rtDEdID=rtD.event!=null ? rtD.event.device?.id==device.id:false
	if(rtDEvN==attr && rtDEdID) return rtD.event.value
	else{
		def result
		String msg="Error reading current value for ${device}.".toString()
		if(!LDAV){
			if(!LTHR){ LTHR=fill_THR() }
			LDAV=[sSTS]+LTHR
			mb()
		}
		if(attr in LDAV){
			switch(attr){
				case sSTS:
					return device.getStatus()
				default:
					Map xyz
					try{ xyz= rtDEvN==sTHREAX && rtDEdID && rtD.event.value ? rtD.event.value : null }catch(ignored){}
					if(xyz==null){
						try{
							xyz=device.currentValue(sTHREAX,true)
						}catch(al){
							error msg+sTHREAX+sCOLON,rtD,iN2,al
							break
						}
					}
					switch(attr){
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
				result=device.currentValue(attr,true)
				if(result instanceof BigDecimal) result=result.toDouble()
			}catch(all){
				error msg+attr+sCOLON,rtD,iN2,all
			}
		}
		return result!=null ? result:sBLK
	}
}

@Field static List<String> LTHR

private static List<String> fill_THR(){ return [sORIENT,sAXISX,sAXISY,sAXISZ] }

@SuppressWarnings('GroovyFallthrough')
private Map getDeviceAttribute(Map rtD,String deviceId,String attr,subDeviceIndex=null,Boolean trigger=false){
	if(deviceId==(String)rtD.locationId || deviceId==(String)rtD.oldLocationId){ //backwards compatibility
		//we have the location here
		switch(attr){
			case sMODE:
				def mode=location.getCurrentMode()
				return rtnMap(sSTR,hashId((Long)mode.getId()))+[(sN):(String)mode.getName()]
			case sHSMSTS:
			case 'alarmSystemStatus':
				String v=location.hsmStatus
				String n=VirtualDevices()['alarmSystemStatus']?.o[v]
				return rtnMap(sSTR,v)+[(sN):n]
		}
		return rtnMap(sSTR,(String)location.getName())
	}
	def device=getDevice(rtD,deviceId)
	if(device!=null){
		Map dattr=[(sT):sSTR /*, m:false */]
		Map attribute=dattr
		String atT=(String)attribute.t
		def value="$device"
		def t0=null
		if(attr!=sNULL){
			attribute=Attributes()[attr]
			if(attribute==null){
				// ask the device what is the type
				def at=device.getSupportedAttributes().find{ (String)it.name==attr }
				// enum,string,json_object -> string; number, date?, vector3?
				if(at && at.getDataType()=='NUMBER') attribute=[(sT):sDEC]
				else attribute=dattr
			}
			t0=getDeviceAttributeValue(rtD,device,attr)
			atT=(String)attribute.t
//	String tt2=myObj(t0)
//	log.warn "attr: $attr t0: ($tt2) $t0 atT: $atT"
			if(attr==sHUE) t0=(Double)cast(rtD,t0,sDEC)*d3d6
			value= matchCast(rtD,t0,atT) ? t0:cast(rtD,t0,atT)
		}
		//have to compare ids and type for hubitat since the locationid can be the same as the deviceid
		def tt0=rtD.event?.device!=null ? rtD.event.device:location
		Boolean deviceMatch=device?.id==tt0.id && isDeviceLocation(device)==isDeviceLocation(tt0)
		//x=eXclude- if a momentary attribute is looked for and the device does not match the current device, then we must ignore this during comparisons
		if(!LTHR){ LTHR=fill_THR(); mb() }
		return [
			(sT):atT,
			(sV):value,
			(sD):deviceId,
			(sA):attr,
			(sI):subDeviceIndex,
			(sX):(attribute.m!=null || trigger) && (!deviceMatch || (attr in LTHR ? sTHREAX:attr)!=(String)rtD.event.name)
		]
	}
	return rtnMap(sERROR,"Device '${deviceId}' not found")
}

@SuppressWarnings('GroovyFallthrough')
private Map getJsonData(Map rtD,data,String name,String feature=sNULL){
	if(data!=null){
		try{
			List<String> parts=name.replace('][','].[').tokenize(sDOT)
			def args=(data instanceof Map ? [:]+(Map)data : (data instanceof List ? []+(List)data : new JsonSlurper().parseText((String)data)))
			Integer partIndex=-i1
			for(String part in parts){
				partIndex+=i1
				if(args instanceof String || args instanceof GString){
					def narg=parseMyResp(args.toString())
					if(narg)args=narg
				}
				if(args instanceof List){
					List largs=(List)args
					Integer sz=largs.size()
					switch(part){
						case 'length':
							return rtnMap(sINT,sz)
						case 'first':
							args=sz>iZ ? largs[iZ]:sBLK
							continue
						case 'second':
							args=sz>i1 ? largs[i1]:sBLK
							continue
						case 'third':
							args=sz>i2 ? largs[i2]:sBLK
							continue
						case 'fourth':
							args=sz>i3 ? largs[i3]:sBLK
							continue
						case 'fifth':
							args=sz>i4 ? largs[i4]:sBLK
							continue
						case 'sixth':
							args=sz ? largs[i5]:sBLK
							continue
						case 'seventh':
							args=sz>i6 ? largs[i6]:sBLK
							continue
						case 'eighth':
							args=sz>7 ? largs[7]:sBLK
							continue
						case 'ninth':
							args=sz>8 ? largs[8]:sBLK
							continue
						case 'tenth':
							args=sz>9 ? largs[9]:sBLK
							continue
						case 'last':
							args=sz>iZ ? largs[sz- 1]:sBLK
							continue
					}
				}
				if(!(args instanceof Map) && !(args instanceof List))return rtnMap(sDYN,sBLK)
				//nfl overrides
				Boolean overrideArgs=false
				if(feature=='NFL' && partIndex==i1 && !!args && !!args.games){
					def offset=null
					def start=null
					def end=null
					Date date=localDate()
					Integer dow=date.day
					switch(((String)part.tokenize(sLB)[iZ]).toLowerCase()){
						case 'yesterday':
							offset=-i1
							break
						case 'today':
							offset=iZ
							break
						case 'tomorrow':
							offset=i1
							break
						case 'mon':
						case 'monday':
							offset=dow<=i2 ? i1-dow:8-dow
							break
						case 'tue':
						case 'tuesday':
							offset=dow<=i2 ? i2-dow:9-dow
							break
						case 'wed':
						case 'wednesday':
							offset=dow<=i2 ? -4 -dow:i3-dow
							break
						case 'thu':
						case 'thursday':
							offset=dow<=i2 ? iN3 -dow:i4-dow
							break
						case 'fri':
						case 'friday':
							offset=dow<=i2 ? iN2 -dow:i5-dow
							break
						case 'sat':
						case 'saturday':
							offset=dow<=i2 ? iN1 -dow:i6-dow
							break
						case 'sun':
						case 'sunday':
							offset=dow<=i2 ? iZ -dow:7-dow
							break
						case 'lastweek':
							start=(dow<=i2 ? -4 -dow:i3-dow)-7
							end=(dow<=i2 ? i2 -dow:9-dow)-7
							break
						case 'thisweek':
							start=dow<=i2 ? -4 -dow:i3-dow
							end=dow<=i2 ? i2 -dow:9-dow
							break
						case 'nextweek':
							start=(dow<=i2 ? -4 -dow:i3-dow)+7
							end=(dow<=i2 ? i2 -dow:9-dow)+7
							break
					}
					if(offset!=null){
						date.setTime(Math.round(date.getTime()+offset*dMSDAY))
						def game=args.games.find{ it.year==date.year+1900 && it.month==date.month+i1 && it.day==date.date}
						args=game
						continue
					}
					if(start!=null){
						Date startDate=localDate()
						startDate.setTime(Math.round(date.getTime()+start*dMSDAY))
						Date endDate=localDate()
						endDate.setTime(Math.round(date.getTime()+end*dMSDAY))
						start=(startDate.year+1900)*372+(startDate.month*31)+(startDate.date-i1)
						end=(endDate.year+1900)*372+(endDate.month*31)+(endDate.date-i1)
						if(parts[iZ].size()>i3){
							def games=((List<Map>)args.games).findAll{ Map it -> (it.year*372+(it.month-i1)*31+(it.day-i1)>=start) && (it.year*372+(it.month-i1)*31+(it.day-i1)<=end)}
							args=games
							overrideArgs=true
						}else{
							def game=((List<Map>)args.games).find{ Map it -> (it.year*372+(it.month-i1)*31+(it.day-i1)>=start) && (it.year*372+(it.month-i1)*31+(it.day-i1)<=end)}
							args=game
							continue
						}
					}
				}
				def idx=iZ
				String newPart=part
				if(part.endsWith(sRB)){
					//array index
					Integer start=part.indexOf(sLB)
					if(start>=iZ){
						idx=part.substring(start+i1,part.size()-i1)
						newPart=part.substring(0,start)
						if(idx.isInteger()) idx=idx.toInteger()
						else{
							Map var=getVariable(rtD,"$idx".toString())
							idx=(String)var.t!=sERROR ? var.v:idx
						}
					}
					if(!overrideArgs && !!newPart)args=args[newPart]
					if(args instanceof List){
						Integer i= idx instanceof Integer ? idx:(Integer)cast(rtD,idx,sINT)
						args=((List)args)[i]
					} else args=((Map)args)[idx as String]
					continue
				}
				if(!overrideArgs)args=args[newPart]
			}
			return rtnMap(sDYN,"$args".toString())
		}catch(all){
			error "Error retrieving JSON data part $part",rtD,iN2,all
		}
	}
	rtnMap(sDYN,sBLK)
}

private Map getArgument(Map rtD,String name){
	return getJsonData(rtD,rtD.args,name)
}

private Map getJson(Map rtD,String name){
	return getJsonData(rtD,rtD.json,name)
}

private Map getPlaces(Map rtD,String name){
	return getJsonData(rtD,rtD.settings?.places,name)
}

private Map getResponse(Map rtD,String name){
	return getJsonData(rtD,rtD.response,name)
}

private Map getWeather(Map rtD,String name){
	if(rtD.weather==null){
		Map t0=parent.getWData()
		rtD.weather=t0!=null ? t0:[:]
	}
	return getJsonData(rtD,rtD.weather,name)
}

private Map getNFLDataFeature(String dataFeature){
	Map requestParams=[
			uri: "https://api.webcore.co/nfl/$dataFeature".toString(),
			//query: method==sGET ? data:null,
			query: null,
			timeout:20
	]
	httpGet(requestParams){ response ->
		if(response.status==200 && response.data){
			try{
				return response.data instanceof Map ? response.data : (LinkedHashMap)new JsonSlurper().parseText((String)response.data)
			}catch(ignored){}
		}
		return null
	}
}

private Map getNFL(Map rtD,String name){
	List parts=name.tokenize(sDOT)
	rtD.nfl=rtD.nfl!=null?rtD.nfl: [:]
	if(parts.size()>iZ){
		String dataFeature=(String)(((String)parts[iZ]).tokenize(sLB)[iZ])
		if(rtD.nfl[dataFeature]==null){
			rtD.nfl[dataFeature]=getNFLDataFeature(dataFeature)
		}
	}
	return getJsonData(rtD,rtD.nfl,name,'NFL')
}

private Map getIncidents(Map rtD,String name){
	return getJsonData(rtD,rtD.incidents,name)
}

@Field volatile static Map<String,Boolean> initGlobalVFLD=[:]
@Field volatile static Map<String,Map<String,Map>> globalVarsVFLD=[:]

void clearGlobalCache(String meth=sNULL){
	String lockTyp='clearGlobalCache '+meth
	String semaName=sTGBL
	String wName=parent.id.toString()
	getTheLock(semaName,lockTyp)
	globalVarsVFLD[wName]=null
	globalVarsVFLD=globalVarsVFLD
	initGlobalVFLD[wName]=false
	initGlobalVFLD=initGlobalVFLD
	releaseTheLock(semaName)
	if(eric())log.debug lockTyp
}

private void loadGlobalCache(){
	String wName=parent.id.toString()
	if(!initGlobalVFLD[wName]){
		String lockTyp='loadGlobalCache'
		String semaName=sTGBL
		getTheLock(semaName,lockTyp)
		globalVarsVFLD[wName]=(Map)parent.listAvailableVariables()
		globalVarsVFLD=globalVarsVFLD
		initGlobalVFLD[wName]=true
		initGlobalVFLD=initGlobalVFLD
		releaseTheLock(semaName)
		if(eric())log.debug lockTyp
	}
}

private Map getVariable(Map rtD,String name){
	Map<String,String> var=parseVariableName(name)
	String tn=sanitizeVariableName(var.name)
//	if(eric())log.debug "getVariable ${name} ${tn} ${var}"
	String mySt=sBLK
	if((Boolean)rtD.eric){
		mySt="getVariable ${tn} ${var} ${name} "
		myDetail rtD,mySt,i1
	}
	if(tn==sNULL)return rtnMap(sERROR,'Invalid empty variable name')
	Map res
	Map err=rtnMap(sERROR,"Variable '$tn' not found".toString())
	if(tn.startsWith(sAT)){
		if(tn.startsWith('@@')){
			String vn=tn.substring(2)
			//get a variable
			def hg=getGlobalVar(vn)
			if(hg){
				addInUseGlobalVar(vn)
				String typ=sNULL
				def vl=null
				Map ta=fixHeGType(false,(String)hg.type,hg.value,sNULL)
				ta.each{
					typ=(String)it.key
					vl=it.value
				}
				res=rtnMap(typ,vl)
			} else res=err
			if(eric())log.debug "getVariable hub variable ${vn} returning ${res} to webcore"
		}else{
			loadGlobalCache()
			String wName=parent.id.toString()
			def tresult=globalVarsVFLD[wName][tn]
			if(!(tresult instanceof Map))res=err
			else{
				res=(Map)tresult
				res.v=cast(rtD,res.v,(String)res.t)
			}
		}
	}else{
		if(tn.startsWith(sDLR)){
			Integer t0=tn.size()
			if(tn.startsWith(sDOLARGS+sDOT) && t0>i6){ // '$args.'
				res=getArgument(rtD,tn.substring(i6))
			}else if(tn.startsWith(sDOLARGS+sLB) && t0>i6){ //'$args['
				res=getArgument(rtD,tn.substring(i5))
			}else if(tn.startsWith(sDOLRESP+sDOT) && t0>10){
				res=getResponse(rtD,tn.substring(10))
			}else if(tn.startsWith(sDOLRESP+sLB) && t0>10){
				res=getResponse(rtD,tn.substring(9))
			}else if(tn.startsWith('$weather.') && t0>9){
				res=getWeather(rtD,tn.substring(9))
			}else if(tn.startsWith(sDOLJSON+sDOT) && t0>i6){
				res=getJson(rtD,tn.substring(i6))
			}else if(tn.startsWith(sDOLJSON+sLB) && t0>i6){
				res=getJson(rtD,tn.substring(i5))
			}else if(tn.startsWith('$incidents.') && t0>11){
				res=getIncidents(rtD,tn.substring(11))
			}else if(tn.startsWith('$incidents[') && t0>11){
				res=getIncidents(rtD,tn.substring(10))
			}else if(tn.startsWith('$nfl.') && t0>i5){
				res=getNFL(rtD,tn.substring(i5))
			}else if(tn.startsWith('$places.') && t0>8){
				res=getPlaces(rtD,tn.substring(8))
			}else if(tn.startsWith('$places[') && t0>8){
				res=getPlaces(rtD,tn.substring(7))
			}else{
				def tres=rtD.systemVars[tn]
				if(!(tres instanceof Map))res=err
				else{
					res=(Map)tres
					if(res!=null && res.d)res=rtnMap((String)res.t,getSystemVariableValue(rtD,tn))
				}
			}
		}else{
//			if(eric())log.debug "getVariable ${rtD.localVars}"
			def tlocV=rtD.localVars[tn]
			if(!(tlocV instanceof Map))res=err
			else{
				res=rtnMap((String)tlocV.t,tlocV.v)
				//make a local copy of the list
				if(res.v instanceof List)
				//noinspection GroovyAssignabilityCheck
					res.v=[]+(List)res.v
				//make a local copy of the map
				if(res.v instanceof Map)
				//noinspection GroovyAssignabilityCheck
					res.v=[:]+(Map)res.v
			}
		}
	}
	if(res!=null && ((String)res.t).endsWith(sRB)){
		res.t=((String)res.t).replace(sLRB,sBLK)
		if(res.v instanceof Map && var.index!=sNULL && var.index!=sBLK){
			if(!var.index.isNumber()){
				//indirect variable addressing
				Map indirectVar=getVariable(rtD,var.index)
				String t=(String)indirectVar.t
				def v=indirectVar.v
				if(t!=sERROR){
					def value= t==sDEC ? (Integer)cast(rtD,v,sINT,t):v
					String dataType= t==sDEC ? sINT:t
					var.index=(String)cast(rtD,value,sSTR,dataType)
				}
			}
			res.v=res.v[var.index]
		}
	}else{
		if(res.v instanceof Map){
			String tt0=(String)res.t
			res=(Map)evaluateOperand(rtD,null,(Map)res.v)
			res=(tt0!=null && tt0==(String)res.t) ? res : evaluateExpression(rtD,res,tt0)
		}
	}
	def v=res.v
	String t=(String)res.t
	if(t==sDEC && v instanceof BigDecimal)v=v.toDouble()
	res=rtnMap(t,v)
	if((Boolean)rtD.eric)myDetail rtD,mySt+"result:$res"
	res
}

private Map setVariable(Map rtD,String name,value){
	Map<String,String> var=parseVariableName(name)
	String tn=sanitizeVariableName(var.name)
	if(tn==sNULL)return rtnMap(sERROR,'Invalid empty variable name')
	if((Boolean)rtD.eric)myDetail rtD,"setVariable ${tn} value: ${value}",iN2
	Map err=rtnMap(sERROR,'Invalid variable')
	if(tn.startsWith(sAT)){
		if(tn.startsWith('@@')){
			String vn=tn.substring(2)
			def hg=getGlobalVar(vn)
			if(hg){ // we know it exists and if it has a value we can know its type (overloaded String, datetime)
				addInUseGlobalVar(vn)
				String typ=sNULL
				String wctyp=sNULL
				def vl=null
				Map tb=fixHeGType(false,(String)hg.type,hg.value,sNULL)
				tb.each{
					wctyp=(String)it.key
				}
				if(wctyp){ // if we know current type
					Map ta=fixHeGType(true,wctyp,value,sNULL)
					Map result=null
					ta.each{
						typ=(String)it.key
						vl=it.value
						if(eric())log.debug "setVariable setting Hub $vn to $vl with type ${typ} wc original type ${wctyp}"
						Boolean a=false
						try{
							a=setGlobalVar(vn,vl)
						}catch(all){
							error 'An error occurred while executing set hub variable',rtD,iN2,all
						}
						if(a){
							result=rtnMap(wctyp,value)
							if((Boolean)rtD.eric)myDetail rtD,"setVariable returning ${result} to webcore",iN2
						} else err.v='setGlobal failed'
					}
					if(result) return result
				} else err.v='setGlobal unknown wctyp'
			}
		} else{
			loadGlobalCache()
			String lockTyp='setGlobalvar'
			String semaName=sTGBL
			String wName=parent.id.toString()
			getTheLock(semaName,lockTyp)
			def tvariable=globalVarsVFLD[wName][tn]
			if(tvariable instanceof Map){
				Map variable=(Map)globalVarsVFLD[wName][tn]
				variable.v=cast(rtD,value,(String)variable.t)
				globalVarsVFLD=globalVarsVFLD
				Map<String,Map> cache=rtD.gvCache!=null ? (Map<String,Map>)rtD.gvCache:[:]
				cache[tn]=variable
				rtD.gvCache=cache
				releaseTheLock(semaName)
				return variable
			}
			releaseTheLock(semaName)
		}
	}else{
// global vars are removed by setting them to null via webcore dashboard
// local vars are removed by 'clear all data' via HE console
//		if(eric())log.debug "setVariable ${rtD.localVars}"
		def tvariable=rtD.localVars[tn]
//		if(eric())log.debug "setVariable tvariable ${tvariable}"
		if(tvariable instanceof Map){
			Map variable=(Map)rtD.localVars[tn]
			String t=(String)variable.t
//			if(eric())log.debug "setVariable found variable ${variable}"
			if(t.endsWith(sRB)){
				//dealing with a list
				variable.v=(variable.v instanceof Map)? variable.v:[:]
				if(var.index=='*CLEAR') ((Map)variable.v).clear()
				else{
					if(!var.index.isNumber()){
						//indirect variable addressing
						Map indirectVar=getVariable(rtD,var.index)
						String indt=(String)indirectVar.t
						if(indt!=sERROR){
							def a=indirectVar.v
							var.index=(a instanceof String)? (String)a : (String)cast(rtD,a,sSTR,indt)
						}
					}
					String at=t.replace(sLRB,sBLK)
					variable.v[var.index]= matchCast(rtD,value,at)?value:cast(rtD,value,at)
				}
			}else{
				def v=(value instanceof GString)? "$value".toString():value
				variable.v=matchCast(rtD,v,t) ? v:cast(rtD,v,t)
			}
			if(!variable.f){ // fixed
				Map<String,Object> vars
				Map t0=getCachedMaps('setVariable')
				if(t0!=null)vars=(Map<String,Object>)t0.vars
				else{ vars=(Boolean)rtD.pep ? (Map<String,Object>)atomicState.vars:(Map<String,Object>)state.vars }

				rtD.localVars[tn]=variable
				vars[tn]=variable.v
				mb()

				if((Boolean)rtD.pep)atomicState.vars=vars
				else state.vars=vars

				String myId=(String)rtD.id
				if(t0!=null){
					String semaName=sAppId()
					getTheLock(semaName,sV)
					Map nc=theCacheVFLD[myId]
					if(nc){
						nc.vars=vars
						theCacheVFLD[myId]=nc
						theCacheVFLD=theCacheVFLD
					}
					releaseTheLock(semaName)
				}
			}
			return variable
		}
	}
	return err
}

@Field static List<String> mL=[]
@Field static List<String> mL1=[]

private Integer matchCastI(Map rtD, v){ Integer res=matchCast(rtD,v,sINT) ? (Integer)v : (Integer)cast(rtD,v,sINT); return res }
private Long matchCastL(Map rtD, v){ Long res=matchCast(rtD,v,sLONG) ? (Long)v : (Long)cast(rtD,v,sLONG); return res }

private static Boolean matchCast(Map rtD, v, String t){
	if(!mL){
		mL=[sSTR,sENUM,sTEXT,sLONG,sBOOLN,sINT,sDEC]
		mL1=[sSTR,sENUM,sTEXT,sDYN]
	}
	Boolean match= v!=null && t in mL && (
			(t in mL1 && v instanceof String)||
			(t==sLONG && v instanceof Long)||
			(t==sINT && v instanceof Integer)||
			(t==sBOOLN && v instanceof Boolean)||
			(t==sDEC && v instanceof Double) )
	return match
}

Map setLocalVariable(String name,value){ // called by parent (IDE) to set a variable
	String tn=sanitizeVariableName(name)
	if(tn==sNULL || tn.startsWith(sAT))return [:]
	Map<String,Object> vars=(Map<String,Object>)atomicState.vars
	vars=vars!=null ? vars:[:]
	vars[tn]=value
	atomicState.vars=vars
	clearMyCache('setLocalVariable')
	return vars
}

/** EXPRESSION FUNCTIONS							**/

Map proxyEvaluateExpression(LinkedHashMap mrtD,Map expression,String dataType=sNULL){
	LinkedHashMap rtD=getRunTimeData(mrtD)
	resetRandomValues(rtD)
	try{
		Map result=evaluateExpression(rtD,expression,dataType)
		if((String)result.t==sDEV && result.a!=null){
			Map attr=Attributes()[(String)result.a]
			result=evaluateExpression(rtD,result,attr!=null && attr.t!=null ? (String)attr.t:sSTR)
		}
		rtD=null
		return result
	}catch(all){
		error 'An error occurred while executing the expression',rtD,iN2,all
	}
	return rtnMap(sERROR,'expression error')
}

private static Map simplifyExpression(Map express){
	Map expression=express
	while ((String)expression.t==sEXPR && expression.i && ((List)expression.i).size()==i1) expression=(Map)((List)expression.i)[iZ]
	return expression
}

@Field static List<String> LT0=[]
@Field static List<String> LS=[]
@Field static List<String> L1opt=[]
@Field static List<String> lPLSMIN=[]
@Field static List<String> LT1=[]
@Field static List<String> LN=[]
@Field static List<String> LD=[]
@Field static List<String> LT2=[]
@Field static List<String> tL2=[]
@Field static List<String> tL4=[]
@Field static List<String> tL6=[]
@Field static List<String> tL7=[]
@Field static List<String> tL8=[]
@Field static List<String> tL9=[]
@Field static List<String> tL10=[]
@Field static List<String> tL11=[]
@Field static List<String> tL12=[]
@Field static List<String> tL13=[]
@Field static List<String> tL14=[]
@Field static List<String> pn1=[]
@Field static List<String> pn2=[]
@Field static List<String> pn3=[]
@Field static List<String> pn4=[]

private static List<String> fill_TIM(){ return [sDTIME,sTIME,sDATE] }

@SuppressWarnings('GroovyFallthrough')
private Map evaluateExpression(Map rtD,Map express,String dataType=sNULL){
	//if dealing with an expression that has multiple items let's evaluate each item one by one
	if(!LT0){
		LT0=[sSTR,sTEXT]
		LS=[sSTR,sENUM]
		L1opt=[sPLUS,sMINUS,sPWR,sAMP,sBOR,sBXOR,sBNOT,sBNAND,sBNOR,sBNXOR,sLTH,sGTH,sLTHE,sGTHE,sEQ,sNEQ,sNEQA,sSBL,sSBR,sNEG,sDNEG,sQM]
		lPLSMIN=[sPLUS,sMINUS]
		if(!LT1){ LT1=fill_TIM() }
		LN=[sNUMBER,sINT,sLONG]
		LD=[sDEC,sFLOAT]
		LT2=[sDEV,sVARIABLE]
		tL2=[sNEG,sDNEG,sBNOT]
		tL4=[sMULP,sDIV,sMOD1,sMOD]
		tL6=[sSBL,sSBR]
		tL7=[sGTH,sLTH,sGTHE,sLTHE]
		tL8=[sEQ,sNEQ,sNEQA]
		tL9=[sAMP,sBNAND]
		tL10=[sBXOR,sBNXOR]
		tL11=[sBOR,sBNOR]
		tL12=[sLAND,sLNAND]
		tL13=[sLXOR,sLNXOR]
		tL14=[sLOR,sLNOR]
		pn1=[sMULP,sDIV,sMINUS,sPWR] // number fixes
		pn2=[sMOD1,sMOD,sAMP,sBOR,sBXOR,sBNAND,sBNOR,sBNXOR,sSBL,sSBR] // int fixes
		pn3=[sLAND,sLOR,sLXOR,sLNAND,sLNOR,sLNXOR,sNEG,sDNEG] // bool fixes
		pn4=[sEQ,sNEQ,sLTH,sGTH,sLTHE,sGTHE,sNEQA]
		mb()
	}
	if(!express)return rtnMap(sERROR,'Null expression')
	//not sure what it was needed for- need to comment more
	//if(express && express.v instanceof Map)return evaluateExpression(rtD,express.v,express.t)
	Long time=(Long)now()
	Map expression=simplifyExpression(express)
	String mySt=sNULL
	if((Boolean)rtD.eric){
		mySt="evaluateExpression $expression dataType: $dataType".toString()
		myDetail rtD,mySt,i1
	}
	Map result=expression
	String exprType=(String)expression.t
	def exprV=expression.v
	switch(exprType){
		case sINT:
		case sLONG:
		case sDEC:
			result=rtnMap(exprType,exprV)
			break
		case sTIME:
		case sDTIME:
			String st0="$exprV"
			try{
				if(st0.isNumber()){
					Long l1=st0.toLong()
					if( (l1>=lMSDAY && exprType==sDTIME) || (l1<lMSDAY && exprType==sTIME) ){
						result=rtnMap(exprType,l1)
						break
					}
				}
			}catch(ignored){}
		case sINT32:
		case sINT64:
		case sDATE:
			result=rtnMap(exprType,cast(rtD,exprV,exprType,dataType))
			break
		case sBOOL:
		case sBOOLN:
			if(exprV instanceof Boolean){
				result=rtnMap(sBOOLN,exprV)
				break
			}
			Boolean t1=cast(rtD,exprV,sBOOLN,dataType)
			result=rtnMap(sBOOLN,t1)
			break
		case sSTR:
		case sENUM:
		case sERROR:
		case sPHONE:
		case sURI:
		case sTEXT:
			if(exprV instanceof String){
				result=rtnMap(sSTR,(String)exprV)
				break
			}
			result=rtnMap(sSTR,(String)cast(rtD,exprV,sSTR,dataType))
			break
		case sNUMBER:
		case sFLOAT:
		case sDBL:
			if(exprV instanceof Double){
				result=rtnMap(sDEC,(Double)exprV)
				break
			}
			result=rtnMap(sDEC,(Double)cast(rtD,exprV,sDEC,dataType))
			break
		case sDURATION:
			String t0=(String)expression.vt
			if(t0==sNULL && exprV instanceof Long){ result=rtnMap(sLONG,(Long)exprV) }
			else result=rtnMap(sLONG,(Long)cast(rtD,exprV,t0!=sNULL ? t0:sLONG))
			break
		case sVARIABLE:
			//get variable {n:name,t:type,v:value}
			result=getVariable(rtD,(String)expression.x+((String)expression.xi!=sNULL ? sLB+(String)expression.xi+sRB:sBLK))
			break
		case sDEV:
			if(exprV instanceof List){
				//already parsed
				result=expression
			}else{
				List deviceIds=(expression.id instanceof List)? (List)expression.id:(expression.id ? [expression.id]:[])
				Boolean err=false
				if(deviceIds.size()==iZ){
					//get variable {n:name,t:type,v:value}
					Map var=getVariable(rtD,(String)expression.x)
					if((String)var.t!=sERROR){
						if((String)var.t==sDEV) deviceIds=(List)var.v
						else{
							def device=getDevice(rtD,(String)var.v)
							if(device!=null)deviceIds=[hashId(device.id)]
						}
					}else{
						err=true
						result=var // Invalid variable
					}
				}
				if(!err) result=rtnMap(sDEV,deviceIds)+[(sA):(String)expression.a]
			}
			break
		case sOPERAND:
			result=rtnMap(sSTR,(String)cast(rtD,exprV,sSTR))
			break
		case sFUNC:
			String fn='func_'+(String)expression.n
			//in a function, we look for device parameters,they may be lists- we need to reformat all parameters to send them to the function properly
			String myStr=sNULL
			try{
				List params=[]
				List<Map> t0=(List<Map>)expression.i
				if(t0 && t0.size()!=iZ){
					Map param
					Boolean a
					for(Map i in t0){
						param=simplifyExpression(i)
						if((String)param.t in LT2){ // sDEV or sVARIABLE
							param=evaluateExpression(rtD,param)
							//if multiple devices, spread into multiple params
							Integer sz=param.v instanceof List ? ((List)param.v).size():i1
							switch(sz){
								case iZ: break
								case i1: a=params.push(param); break
								default:
									for(v in (List)param.v){
										a=params.push(rtnMap((String)param.t,[v])+[(sA):(String)param.a])
									}
							}
						}else a=params.push(param)
					}
				}
				if((Boolean)rtD.eric){
					myStr='calling function '+fn+" $params"
					myDetail rtD,myStr,i1
				}
				result=(Map)"$fn"(rtD,params)
			}catch(all){
				error "Error executing $fn: ",rtD,iN2,all
				result=rtnMap(sERROR,"${all}")
			}
			if((Boolean)rtD.eric)myDetail rtD,myStr+sSPC+"${result}".toString()
			break
		case sEXPR:
			//if we have a single item, we simply traverse the expression
			List<Map> items=[]
			Integer operand=iN1
			Integer lastOperand=iN1
			Boolean a
			for(Map item in (List<Map>)expression.i){
				if((String)item.t==sOPER){
					String ito=(String)item.o
					Map mito=[(sO):ito]
					if(operand<iZ){
						if(ito in L1opt){
							a=items.push(rtnMap(sINT,iZ)+mito)
						} else switch(ito){
							case sCOLON:
								if(lastOperand>=iZ){
									//groovy-style support for(object ?: value)
									a=items.push(items[lastOperand]+mito)
								}else a=items.push(rtnMap(sINT,iZ)+mito)
								break
							case sMULP:
							case sDIV:
								a=items.push(rtnMap(sINT,i1)+mito)
								break
							case sLAND:
							case sLNAND:
								a=items.push(rtnMap(sBOOLN,true)+mito)
								break
							case sLOR:
							case sLNOR:
							case sLXOR:
							case sLNXOR:
								a=items.push(rtnMap(sBOOLN,false)+mito)
								break
						}
					}else{
						items[operand].o=ito
						operand=iN1
					}
				}else{
					Map tmap= [:]+evaluateExpression(rtD,item)
					a=items.push(tmap)
					operand=items.size()-i1
					lastOperand=operand
				}
			} // end for
			//clean up operators, ensure there's one for each
			Integer idx=iZ
			Integer itmSz=items.size()-i1
			for(Map item in items){
				if(!item.o){
					switch((String)item.t){
						case sINT:
						case sFLOAT:
						case sDBL:
						case sDEC:
						case sNUMBER:
							String nextType=sSTR
							if(idx<itmSz)nextType=(String)items[idx+i1].t
							item.o= nextType in LT0 ? sPLUS:sMULP // Strings
							break
						default:
							item.o=sPLUS
							break
					}
				}
				idx++
			}
			//do the job
			idx=iZ
			itmSz=items.size()
			def aa
			while (itmSz>i1){
				//ternary
				if(itmSz==i3 && (String)items[iZ].o==sQM && (String)items[i1].o==sCOLON){
					//we have a ternary operator
					if((Boolean)evaluateExpression(rtD,(Map)items[iZ],sBOOLN).v) items=[items[i1]]
					else items=[items[i2]]
					items[iZ].o=sNULL
					break
				}
				//order of operations
				idx=iZ
				//#2	!   !!   ~   -	Logical negation, logical double-negation, bitwise NOT, and numeric negation unary operators
				for(Map item in items){
					String t0=(String)item.o
					if(t0 in tL2 || ((String)item.t==sNULL && t0==sMINUS))break
					idx++
				}
				//#3	**	Exponent operator
				if(idx>=itmSz){
					//we then look for power **
					idx=iZ
					for(Map item in items){
						if((String)item.o==sPWR)break
						idx++
					}
				}
				//#4	*   /   \   % MOD	Multiplication, division, modulo
				if(idx>=itmSz){
					//we then look for * or /
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL4)break
						idx++
					}
				}
				//#5	+   -	Addition and subtraction
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in lPLSMIN)break
						idx++
					}
				}
				//#6	<<   >>	Shift left and shift right operators
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL6)break
						idx++
					}
				}
				//#7	<  <= >  >=	Comparisons: less than, less than or equal to,greater than, greater than or equal to
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL7)break
						idx++
					}
				}
				//#8	==   !=	Comparisons: equal and not equal
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL8)break
						idx++
					}
				}
				//#9	&	Bitwise AND
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL9)break
						idx++
					}
				}
				//#10	^	Bitwise exclusive OR (XOR)
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL10)break
						idx++
					}
				}
				//#11	|	Bitwise inclusive (normal)OR
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL11)break
						idx++
					}
				}
				//#12	&&	Logical AND
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL12)break
						idx++
					}
				}
				//#13	^^	Logical XOR
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL13)break
						idx++
					}
				}
				//#14	||	Logical OR
				if(idx>=itmSz){
					idx=iZ
					for(Map item in items){
						if((String)item.o in tL14)break
						idx++
					}
				}
				//if none selected get the first one
				if(idx>=itmSz-i1)idx=iZ

				String o=(String)items[idx].o

				String a1=(String)items[idx].a
				String t1=(String)items[idx].t
				def v1=items[idx].v

				Integer idxPlus=idx+i1
				String a2=(String)items[idxPlus].a
				String t2=(String)items[idxPlus].t
				def v2=items[idxPlus].v

				def v=null
				String t=t1

				//fix-ups
				if(t1==sDEV && a1!=sNULL && a1.length()>iZ){
					Map attr=Attributes()[a1]
					t1=attr!=null ? (String)attr.t:sSTR
				}
				if(t2==sDEV && a2!=sNULL && a2.length()>iZ){
					Map attr=Attributes()[a2]
					t2=attr!=null ? (String)attr.t:sSTR
				}
				if(t1==sDEV && t2==sDEV && (o in lPLSMIN)){
					List lv1=(v1 instanceof List)? (List)v1:[v1]
					List lv2=(v2 instanceof List)? (List)v2:[v2]
					v= o==sPLUS ? lv1+lv2:lv1-lv2
					//set the results
					items[idxPlus].t=sDEV
					items[idxPlus].v=v
				}else{
					Boolean t1d= (t1 in LT1)
					Boolean t2d= (t2 in LT1)
					Boolean t1i= (t1 in LN)
					Boolean t2i= (t2 in LN)
					Boolean t1f= (t1 in LD)
					Boolean t2f= (t2 in LD)
					Boolean t1n=t1i || t1f
					Boolean t2n=t2i || t2f
					//warn "Precalc ($t1) $v1 $o ($t2) $v2 >>> t1d=$t1d, t2d=$t2d, t1n=$t1n, t2n=$t2n",rtD
					if((o in lPLSMIN) && (t1d || t2d) && (t1d || t1n) && (t2n || t2d)){
						//if dealing with date +/- date/numeric then
						if(t1n) t=t2
						else if(t2n) t=t1
						else t= sLONG //t1==sDATE && t2==sDATE ? sDATE:(t1==sTIME && t2==sTIME ? sTIME:sDTIME)
					}else{
						if(o in lPLSMIN){
							//devices and others play nice
							if(t1==sDEV){
								t=t2
								t1=t2
							}else if(t2==sDEV){
								t=t1
								t2=t1
							}
						}
						//integer with decimal gives decimal also *,/ require decimals
						if(o in pn1){
							t= t1i && t2i ? (t1==sLONG || t2==sLONG ? sLONG:sINT):sDEC
							t1=t
							t2=t
						}
						if(o in pn2){
							t= t1==sLONG || t2==sLONG ? sLONG:sINT
							t1=t
							t2=t
						}
						if(o in pn3){
							t=sBOOLN
							t1=t
							t2=t
						}
						if(o==sPLUS && (t1 in LT0 || t2 in LT0)){
							t=sSTR
							t1=t
							t2=t
						}
						if(t1n && t2n){
							t= t1i && t2i ? ( t1==sLONG || t2==sLONG ? sLONG:sINT):sDEC
							t1=t
							t2=t
						}
						if(o in pn4){
							if(t1==sDEV)t1=sSTR
							if(t2==sDEV)t2=sSTR
							t1=t1==sSTR ? t2:t1
							t2=t2==sSTR ? t1:t2
							t=sBOOLN
						}
					}
					//v1=evaluateExpression(rtD,(Map)items[idx],t1).v
					if((String)items[idx].t==t1) v1=items[idx].v
					else v1=evaluateExpression(rtD,(Map)items[idx],t1).v

					//v2=evaluateExpression(rtD,(Map)items[idxPlus],t2).v
					if((String)items[idxPlus].t==t2) v2=items[idxPlus].v
					else v2=evaluateExpression(rtD,(Map)items[idxPlus],t2).v

					v1=v1==sSNULL ? null:v1
					v2=v2==sSNULL ? null:v2
					switch(o){
						case sQM:
						case sCOLON:
							error "Invalid ternary operator. Ternary operator's syntax is (condition ? trueValue:falseValue ). Please check your syntax.",rtD
							v=sBLK
							break
						case sMINUS:
							v=v1 - v2
							break
						case sMULP:
							v=v1 * v2
							break
						case sDIV:
							v=(v2!=iZ ? v1/v2:iZ)
							break
						case sMOD1:
							v=(Integer)Math.floor(v2!=iZ ? v1/v2:iZ)
							break
						case sMOD:
							v=(Integer)(v2!=iZ ? v1%v2:iZ)
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

					if((Integer)rtD.logging>i2)debug "Calculating ($t1)$v1 $o ($t2)$v2 >> ($t)$v",rtD

					//set the results
					items[idxPlus].t=t
					v=(v instanceof GString)? "$v".toString():v
					items[idxPlus].v=matchCast(rtD,v,t) ? v : cast(rtD,v,t)
				} // end else

				aa=items.remove(idx)

				itmSz=items.size()
			} //end while
			result=items[iZ] ? ((String)items[iZ].t==sDEV ? (Map)items[iZ] : evaluateExpression(rtD,(Map)items[iZ])) : rtnMap(sDYN,null)
			break
	} //end switch

	String ra=result.a
	//when dealing with devices they need to be "converted" unless the request is to return devices
	if(dataType && dataType!=sDEV && (String)result.t==sDEV){
		List atL= (result.v instanceof List)?(List)result.v:[result.v]
		switch(atL.size()){
			case iZ: result=rtnMap(sERROR,'Empty device list'); break
			case i1: result=getDeviceAttribute(rtD,(String)atL[iZ],ra,result.i); break
			default:result=rtnMap(sSTR,buildDeviceAttributeList(rtD,atL,ra)); break
		}
	}
	//return the value either directly or via cast if certain data type is requested
	if(dataType){
		String t0=(String)result.t
		def t1=result.v
		Boolean match=(dataType in LS && t0 in LS && t1 instanceof String)
		if(!match){
			if(!t0 || dataType==t0) match=matchCast(rtD,t1,dataType)
			if(!match)t1=cast(rtD,t1,dataType,t0)
		}
		result=rtnMap(dataType,t1)+(ra ? [(sA):ra]:[:])+(result.i ? [(sI):result.i]:[:])
	}
	result.d=elapseT(time)
	if((Boolean)rtD.eric)myDetail rtD,mySt+" result:$result".toString()
	return result
}

private static String buildList(List list,String suffix=sAND){
	if(!list)return sBLK
	Integer cnt=i1
	String result=sBLK
	Integer t0=list.size()
	Integer t1=t0-i1
	String a=sCOMMA+sSPC
	for(item in list){
		result+=item.toString()+(cnt<t0 ? (cnt==t1 ? sSPC+suffix+sSPC:a):sBLK)
		cnt++
	}
	return result
}

private String buildDeviceList(Map rtD,devices,String suffix=sAND){
	if(!devices)return sBLK
	List nlist=(devices instanceof List)? devices:[devices]
	List list=[]
	Boolean a
	def dev
	for(String device in nlist){
		dev=getDevice(rtD,device)
		if(dev!=null)a=list.push(dev)
	}
	return buildList(list,suffix)
}

private String buildDeviceAttributeList(Map rtD,List devices,String attr,String suffix=sAND){
	if(!devices)return sBLK
	List list=[]
	Boolean a
	def value
	for(String device in devices){
		value=getDeviceAttribute(rtD,device,attr).v
		a=list.push(value)
	}
	return buildList(list,suffix)
}

private static Boolean checkParams(Map rtD,List params,Integer minParams){
	if(params==null || !(params instanceof List) || params.size()<minParams) return false
	return true
}

private static Map rtnErr(String msg){
	return rtnMap(sERROR,sEXPECTING+msg)
}

private static Map rtnMap(String t,v){
	return [(sT):t,(sV):v]
}

private static Map rtnMap1(String t,v,String vt){
	return [(sT):t,(sV):v,(sVT):vt]
}

/** dewPoint returns the calculated dew point temperature			**/
/** Usage: dewPoint(temperature,relativeHumidity[, scale])			**/
private Map func_dewpoint(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('dewPoint(temperature,relativeHumidity[, scale])')
	Double t=(Double)evaluateExpression(rtD,params[iZ],sDEC).v
	Double rh=(Double)evaluateExpression(rtD,params[i1],sDEC).v
	//if no temperature scale is provided we assume the location's temperature scale
	Boolean fahrenheit=((String)cast(rtD,params.size()>i2 ? (String)evaluateExpression(rtD,params[i2]).v:(String)location.temperatureScale,sSTR)).toUpperCase()=='F'
	if(fahrenheit) t=(t-32.0D)*5.0D/9.0D
	//convert rh to percentage
	if((rh>dZ) && (rh<d1)) rh=rh*d100
	Double b=(Math.log(rh/d100)+((17.27D*t)/(237.3D+t)))/17.27D
	Double result=(237.3D*b)/(d1-b)
	if(fahrenheit) result=result*9.0D/5.0D+32.0D
	rtnMap(sDEC,result)
}

/** celsius converts temperature from Fahrenheit to Celsius			**/
/** Usage: celsius(temperature)							**/
private Map func_celsius(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('celsius(temperature)')
	Double t=(Double)evaluateExpression(rtD,params[iZ],sDEC).v
	rtnMap(sDEC,(Double)((t-32.0D)*5.0D/9.0D))
}

/** fahrenheit converts temperature from Celsius to Fahrenheit			**/
/** Usage: fahrenheit(temperature)						**/
private Map func_fahrenheit(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('fahrenheit(temperature)')
	Double t=(Double)evaluateExpression(rtD,params[iZ],sDEC).v
	rtnMap(sDEC,(Double)(t*9.0D/5.0D+32.0D))
}

/** fahrenheit converts temperature between Celsius and Fahrenheit if the	**/
/** units differ from location.temperatureScale					**/
/** Usage: convertTemperatureIfNeeded(celsiusTemperature,'C')			**/
private Map func_converttemperatureifneeded(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('convertTemperatureIfNeeded(temperature,unit)')
	String u=((String)evaluateExpression(rtD,params[i1],sSTR).v).toUpperCase()
	switch((String)location.temperatureScale){
		case u: // matches return value
			Double t=(Double)evaluateExpression(rtD,params[iZ],sDEC).v
			return rtnMap(sDEC,t)
		case 'F': return func_celsius(rtD,[params[iZ]])
		case 'C': return func_fahrenheit(rtD,[params[iZ]])
	}
	return [:]
}

/** integer converts a decimal to integer value			**/
/** Usage: integer(decimal or string)				**/
private Map func_integer(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('integer(decimal or string)')
	rtnMap(sINT,(Integer)evaluateExpression(rtD,params[iZ],sINT).v)
}
private Map func_int(Map rtD,List<Map> params){ return func_integer(rtD,params)}

/** decimal/float converts an integer value to it's decimal value		**/
/** Usage: decimal(integer or string)						**/
private Map func_decimal(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('decimal(integer or string)')
	rtnMap(sDEC,(Double)evaluateExpression(rtD,params[iZ],sDEC).v)
}
private Map func_float(Map rtD,List<Map> params){ return func_decimal(rtD,params)}
private Map func_number(Map rtD,List<Map> params){ return func_decimal(rtD,params)}

/** string converts an value to it's string value				**/
/** Usage: string(anything)							**/
private Map func_string(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('string(anything)')
	String result=sBLK
	for(Map param in params) result+=(String)evaluateExpression(rtD,param,sSTR).v
	rtnMap(sSTR,result)
}
private Map func_concat(Map rtD,List<Map> params){ return func_string(rtD,params)}
private Map func_text(Map rtD,List<Map> params){ return func_string(rtD,params)}

/** Boolean converts a value to it's Boolean value				**/
/** Usage: boolean(anything)							**/
private Map func_boolean(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('boolean(anything)')
	rtnMap(sBOOLN,(Boolean)evaluateExpression(rtD,params[iZ],sBOOLN).v)
}
private Map func_bool(Map rtD,List<Map> params){ return func_boolean(rtD,params)}

/** sqr converts a decimal to square decimal value			**/
/** Usage: sqr(integer or decimal or string)				**/
private Map func_sqr(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('sqr(integer or decimal or string)')
	rtnMap(sDEC,(Double)evaluateExpression(rtD,params[iZ],sDEC).v**i2)
}

/** sqrt converts a decimal to square root decimal value		**/
/** Usage: sqrt(integer or decimal or string)				**/
private Map func_sqrt(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('sqrt(integer or decimal or string)')
	rtnMap(sDEC,Math.sqrt((Double)evaluateExpression(rtD,params[iZ],sDEC).v))
}

/** power converts a decimal to power decimal value			**/
/** Usage: power(integer or decimal or string, power)			**/
private Map func_power(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('sqrt(integer or decimal or string, power)')
	rtnMap(sDEC,(Double)evaluateExpression(rtD,params[iZ],sDEC).v ** (Double)evaluateExpression(rtD,params[i1],sDEC).v)
}

/** round converts a decimal to rounded value			**/
/** Usage: round(decimal or string[, precision])		**/
private Map func_round(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('round(decimal or string[, precision])')
	Integer precision= params.size()>i1 ? (Integer)evaluateExpression(rtD,params[i1],sINT).v:iZ
	rtnMap(sDEC,Math.round((Double)evaluateExpression(rtD,params[iZ],sDEC).v * (10 ** precision))/(10 ** precision))
}

/** floor converts a decimal to closest lower integer value		**/
/** Usage: floor(decimal or string)					**/
private Map func_floor(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('floor(decimal or string)')
	rtnMap(sINT,(Integer)cast(rtD,Math.floor((Double)evaluateExpression(rtD,params[iZ],sDEC).v),sINT))
}

/** ceiling converts a decimal to closest higher integer value	**/
/** Usage: ceiling(decimal or string)						**/
private Map func_ceiling(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('ceiling(decimal or string)')
	rtnMap(sINT,(Integer)cast(rtD,Math.ceil((Double)evaluateExpression(rtD,params[iZ],sDEC).v),sINT))
}
private Map func_ceil(Map rtD,List<Map> params){ return func_ceiling(rtD,params)}


/** sprintf converts formats a series of values into a string			**/
/** Usage: sprintf(format, arguments)						**/
private Map func_sprintf(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('sprintf(format, arguments)')
	String format=sNULL
	List args=[]
	Boolean a
	try{
		format=(String)evaluateExpression(rtD,params[iZ],sSTR).v
		Integer sz=params.size()
		for(Integer x=i1; x<sz; x++) a=args.push(evaluateExpression(rtD,params[x]).v)
		return rtnMap(sSTR,sprintf(format,args))
	}catch(all){
		return rtnErr("$all $format $args".toString())
	}
}
private Map func_format(Map rtD,List<Map> params){ return func_sprintf(rtD,params)}

/** left returns a substring of a value					**/
/** Usage: left(string, count)						**/
private Map func_left(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('left(string, count)')
	String value=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	Integer cnt=(Integer)evaluateExpression(rtD,params[i1],sINT).v
	Integer sz=value.size()
	if(cnt>sz)cnt=sz
	rtnMap(sSTR,value.substring(0,cnt))
}

/** right returns a substring of a value				**/
/** Usage: right(string, count)						**/
private Map func_right(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('right(string, count)')
	String value=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	Integer cnt=(Integer)evaluateExpression(rtD,params[i1],sINT).v
	Integer sz=value.size()
	if(cnt>sz)cnt=sz
	rtnMap(sSTR,value.substring(sz-cnt,sz))
}

/** strlen returns the length of a string value				**/
/** Usage: strlen(string)						**/
private Map func_strlen(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('strlen(string)')
	String value=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	rtnMap(sINT,value.size())
}
private Map func_length(Map rtD,List<Map> params){ return func_strlen(rtD,params)}

/** coalesce returns the first non-empty parameter				**/
/** Usage: coalesce(value1[, value2[, ..., valueN]])				**/
private Map func_coalesce(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('coalesce(value1[, value2[, ..., valueN]])')
	Integer sz=params.size()
	for(Integer i=iZ; i<sz; i++){
		Map value=evaluateExpression(rtD,params[i])
		if(!(value.v==null || (value.v instanceof List ? value.v==[null] || value.v==[] || value.v==[sSNULL] : false) || (String)value.t==sERROR || value.v==sSNULL || (String)cast(rtD,value.v,sSTR)==sBLK)){
			return value
		}
	}
	rtnMap(sDYN,null)
}

/** trim removes leading and trailing spaces from a string			**/
/** Usage: trim(value)								**/
private Map func_trim(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('trim(value)')
	String t0=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	String value=t0.trim()
	rtnMap(sSTR,value)
}

/** trimleft removes leading spaces from a string				**/
/** Usage: trimLeft(value)							**/
private Map func_trimleft(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('trimLeft(value)')
	String t0=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	String value=t0.replaceAll('^\\s+',sBLK)
	rtnMap(sSTR,value)
}
private Map func_ltrim(Map rtD,List<Map> params){ return func_trimleft(rtD,params)}

/** trimright removes trailing spaces from a string				**/
/** Usage: trimRight(value)							**/
private Map func_trimright(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('trimRight(value)')
	String t0=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	String value=t0.replaceAll('\\s+$',sBLK)
	rtnMap(sSTR,value)
}
private Map func_rtrim(Map rtD,List<Map> params){ return func_trimright(rtD,params)}

/** substring returns a substring of a value					**/
/** Usage: substring(string, start, count)					**/
private Map func_substring(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('substring(string, start, count)')
	String value=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	Integer start=(Integer)evaluateExpression(rtD,params[i1],sINT).v
	Integer cnt=params.size()>i2 ? (Integer)evaluateExpression(rtD,params[i2],sINT).v:null
	//def end=null
	String result=sBLK
	Integer t0=value.size()
	if(start<t0 && start>-t0){
		if(cnt!=null){
			if(cnt<iZ){
				//reverse
				start=start<iZ ? -start:t0-start
				cnt=-cnt
				value=value.reverse()
			}
			if(start>=iZ){
				if(cnt>t0-start)cnt=t0-start
			}else if(cnt>-start)cnt=-start
		}
		start=start>=iZ ? start : t0+start
		if(cnt>t0-start)cnt=t0-start
		result= cnt==null ? value.substring(start) : value.substring(start,start+cnt)
	}
	rtnMap(sSTR,result)
}
private Map func_substr(Map rtD,List<Map> params){ return func_substring(rtD,params)}
private Map func_mid(Map rtD,List<Map> params){ return func_substring(rtD,params)}

/** replace replaces a search text inside of a value				**/
/** Usage: replace(string, search, replace[, [..],search, replace])		**/
private Map func_replace(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,i3) || sz%i2!=i1) return rtnErr('replace(string, search, replace[, [..],search, replace])')
	String value=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	Integer cnt=Math.floor((sz-i1)/i2).toInteger()
	for(Integer i=iZ; i<cnt; i++){
		String search=(String)evaluateExpression(rtD,params[i*i2+i1],sSTR).v
		String replace=(String)evaluateExpression(rtD,params[i*i2+i2],sSTR).v
		sz=search.size()
		if((sz>i2)&& search.startsWith(sDIV)&& search.endsWith(sDIV)){
			def ssearch= ~search.substring(i1,sz-i1)
			value=value.replaceAll(ssearch,replace)
		}else value=value.replace(search,replace)
	}
	rtnMap(sSTR,value)
}

/** rangeValue returns the matching value in a range					**/
/** Usage: rangeValue(input, defaultValue,point1, value1[, [..],pointN, valueN])	**/
private Map func_rangevalue(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,i2) || sz%i2!=iZ) return rtnErr('rangeValue(input, defaultValue,point1, value1[, [..],pointN, valueN])')
	Double input=(Double)evaluateExpression(rtD,params[iZ],sDEC).v
	Map value=params[i1]
	Integer cnt=Math.floor((sz-i2)/i2).toInteger()
	for(Integer i=iZ; i<cnt; i++){
		Double point=(Double)evaluateExpression(rtD,params[i*i2+i2],sDEC).v
		if(input>=point)value=params[i*i2 +i3]
	}
	return value
}

/** rainbowValue returns the matching value in a range				**/
/** Usage: rainbowValue(input, minInput, minColor,maxInput, maxColor)		**/
private Map func_rainbowvalue(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i5)) return rtnErr('rainbowValue(input, minColor,minValue,maxInput, maxColor)')
	Integer input=(Integer)evaluateExpression(rtD,params[iZ],sINT).v
	Integer minInput=(Integer)evaluateExpression(rtD,params[i1],sINT).v
	Map minColor=getColor(rtD,(String)evaluateExpression(rtD,params[i2],sSTR).v)
	Integer maxInput=(Integer)evaluateExpression(rtD,params[i3],sINT).v
	Map maxColor=getColor(rtD,(String)evaluateExpression(rtD,params[i4],sSTR).v)
	if(minInput>maxInput){
		Integer x=minInput
		minInput=maxInput
		maxInput=x
		Map x1=minColor
		minColor=maxColor
		maxColor=x1
	}
	input=(input<minInput ? minInput:(input>maxInput ? maxInput:input))
	if((input==minInput)|| (minInput==maxInput))return rtnMap(sSTR,(String)minColor.hex)
	if(input==maxInput)return rtnMap(sSTR,(String)maxColor.hex)
	List<Integer> start=hexToHsl((String)minColor.hex)
	List<Integer> end=hexToHsl((String)maxColor.hex)
	Double alpha=d1*(input-minInput)/(maxInput-minInput+i1)
	Integer h=Math.round(start[iZ]-((input-minInput)*(start[iZ]-end[iZ])/(maxInput-minInput))).toInteger()
	Integer s=Math.round(start[i1]+(end[i1]-start[i1])*alpha).toInteger()
	Integer l=Math.round(start[i2]+(end[i2]-start[i2])*alpha).toInteger()
	rtnMap(sSTR,hslToHex(h,s,l))
}

/** indexOf finds the first occurrence of a substring in a string		**/
/** Usage: indexOf(stringOrDeviceOrList, substringOrItem)			**/
private Map func_indexof(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,i2) || ((String)params[iZ].t!=sDEV && sz!=i2)) return rtnErr('indexOf(stringOrDeviceOrList, substringOrItem)')
	if((String)params[iZ].t==sDEV && sz>i2){
		Integer t0=sz-i1
		String item=(String)evaluateExpression(rtD,params[t0],sSTR).v
		for(Integer idx=iZ; idx<t0; idx++){
			Map it=evaluateExpression(rtD,params[idx],sSTR)
			if((String)it.v==item) return rtnMap(sINT,idx)
		}
		return rtnMap(sINT,iN1)
	}else if(params[iZ].v instanceof Map){
		String item=evaluateExpression(rtD,params[i1],(String)params[iZ].t).v
		def key=((Map)params[iZ].v).find{ it.value==item }?.key
		return rtnMap(sSTR,key)
	}else{
		String value=(String)evaluateExpression(rtD,params[iZ],sSTR).v
		String substring=(String)evaluateExpression(rtD,params[i1],sSTR).v
		return rtnMap(sINT,value.indexOf(substring))
	}
}

/** lastIndexOf finds the last occurrence of a substring in a string		**/
/** Usage: lastIndexOf(string, substring)					**/
private Map func_lastindexof(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,i2) || ((String)params[iZ].t!=sDEV && sz!=i2)) return rtnErr('lastIndexOf(string, substring)')
	if((String)params[iZ].t==sDEV && sz>i2){
		String item=(String)evaluateExpression(rtD,params[sz-i1],sSTR).v
		for(Integer idx=sz-i2; idx>=iZ; idx--){
			Map it=evaluateExpression(rtD,params[idx],sSTR)
			if((String)it.v==item){
				return rtnMap(sINT,idx)
			}
		}
		return rtnMap(sINT,iN1)
	}else if(params[iZ].v instanceof Map){
		String item=evaluateExpression(rtD,params[i1],(String)params[iZ].t).v
		def key=((Map)params[iZ].v).find{ it.value==item }?.key
		return rtnMap(sSTR,key)
	}else{
		String value=(String)evaluateExpression(rtD,params[iZ],sSTR).v
		String substring=(String)evaluateExpression(rtD,params[i1],sSTR).v
		return rtnMap(sINT,value.lastIndexOf(substring))
	}
}


/** lower returns a lower case value of a string				**/
/** Usage: lower(string)							**/
private Map func_lower(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('lower(string)')
	String result=sBLK
	for(Map param in params) result+=(String)evaluateExpression(rtD,param,sSTR).v
	rtnMap(sSTR,result.toLowerCase())
}

/** upper returns a upper case value of a string				**/
/** Usage: upper(string)							**/
private Map func_upper(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('upper(string)')
	String result=sBLK
	for(Map param in params) result+=(String)evaluateExpression(rtD,param,sSTR).v
	rtnMap(sSTR,result.toUpperCase())
}

/** title returns a title case value of a string				**/
/** Usage: title(string)							**/
private Map func_title(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('title(string)')
	String result=sBLK
	for(Map param in params) result+=(String)evaluateExpression(rtD,param,sSTR).v
	rtnMap(sSTR,((List)result.tokenize(sSPC))*.toLowerCase()*.capitalize().join(sSPC))
}

/** avg calculates the average of a series of numeric values			**/
/** Usage: avg(values)								**/
private Map func_avg(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('avg'+sVALUEN)
	Double sum=dZ
	for(Map param in params) sum+=(Double)evaluateExpression(rtD,param,sDEC).v
	rtnMap(sDEC,sum/params.size())
}

/** median returns the value in the middle of a sorted array			**/
/** Usage: median(values)							**/
private Map func_median(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('median'+sVALUEN)
	List<Map> data=params.collect{ Map it -> evaluateExpression(rtD,it,sDYN)}.sort{ Map it -> it.v }
	Integer i=Math.floor(data.size()/i2).toInteger()
	if(data) return data[i]
	rtnMap(sDYN,sBLK)
}

/** least returns the value that is least found a series of numeric values	**/
/** Usage: least(values)							**/
private Map func_least(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('least'+sVALUEN)
	Map<Object,Map> data=[:]
	for(Map param in params){
		Map value=evaluateExpression(rtD,param,sDYN)
		data[value.v]=rtnMap((String)value.t,value.v)+[(sC):(data[value.v]?.c ?: iZ)+i1]
	}
	Map value=data.sort{ it.value.c }.collect{ it.value }[iZ]
	rtnMap((String)value.t,value.v)
}

/** most returns the value that is most found a series of numeric values	**/
/** Usage: most(values)								**/
private Map func_most(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('most'+sVALUEN)
	Map<Object,Map> data=[:]
	for(Map param in params){
		Map value=evaluateExpression(rtD,param,sDYN)
		data[value.v]=rtnMap((String)value.t,value.v)+[(sC):(data[value.v]?.c ?: iZ)+i1]
	}
	Map value=data.sort{ -it.value.c }.collect{ it.value }[iZ]
	rtnMap((String)value.t,value.v)
}

/** sum calculates the sum of a series of numeric values			**/
/** Usage: sum(values)								**/
private Map func_sum(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('sum'+sVALUEN)
	Double sum=dZ
	for(Map param in params) sum+=(Double)evaluateExpression(rtD,param,sDEC).v
	rtnMap(sDEC,sum)
}

/** variance calculates the variance of a series of numeric values	**/
/** Usage: variance(values)							**/
private Map func_variance(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('variance'+sVALUEN)
	Double sum=dZ
	List values=[]
	for(Map param in params){
		Double value=(Double)evaluateExpression(rtD,param,sDEC).v
		Boolean a=values.push(value)
		sum+=value
	}
	Integer sz=values.size()
	Double avg=sum/sz
	sum=dZ
	for(Integer i=iZ; i<sz; i++) sum+=((Double)values[i]-avg)**i2
	rtnMap(sDEC,sum/sz)
}

/** stdev calculates the [population] standard deviation of a series of numeric values	**/
/** Usage: stdev(values)							**/
private Map func_stdev(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('stdev'+sVALUEN)
	Map<String,Object> result=func_variance(rtD,params)
	rtnMap(sDEC,Math.sqrt((Double)result.v))
}

/** min calculates the minimum of a series of numeric values			**/
/** Usage: min(values)								**/
private Map func_min(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('min'+sVALUEN)
	List<Map> data=params.collect{ Map it -> evaluateExpression(rtD,(Map)it,sDYN)}.sort{ Map it -> it.v }
	if(data) return data[iZ]
	rtnMap(sDYN,sBLK)
}

/** max calculates the maximum of a series of numeric values			**/
/** Usage: max(values)								**/
private Map func_max(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('max'+sVALUEN)
	List<Map> data=params.collect{ Map it -> evaluateExpression(rtD,(Map)it,sDYN)}.sort{ Map it -> it.v }
	if(data) return data[data.size()-i1]
	rtnMap(sDYN,sBLK)
}

/** abs calculates the absolute value of a number				**/
/** Usage: abs(number)								**/
private Map func_abs(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('abs(value)')
	Double value=(Double)evaluateExpression(rtD,params[iZ],sDEC).v
	String dataType=(value==Math.round(value).toDouble() ? sINT:sDEC)
	rtnMap(dataType,(Double)cast(rtD,Math.abs(value),dataType,sDEC))
}

/** hslToHex converts a hue/saturation/level trio to it hex #rrggbb representation	**/
/** Usage: hslToHex(hue,saturation, level)						**/
private Map func_hsltohex(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i3)) return rtnErr('hsl(hue,saturation, level)')
	Double hue=(Double)evaluateExpression(rtD,params[iZ],sDEC).v
	Double saturation=(Double)evaluateExpression(rtD,params[i1],sDEC).v
	Double level=(Double)evaluateExpression(rtD,params[i2],sDEC).v
	rtnMap(sSTR,hslToHex(hue,saturation,level))
}

/** count calculates the number of true/non-zero/non-empty items in a series of numeric values		**/
/** Usage: count(values)										**/
private Map func_count(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnMap(sINT,iZ)
	Integer cnt=iZ
	if(params.size()==i1 && ((String)params[iZ].t in [sSTR,sDYN])){
		String[] list=((String)evaluateExpression(rtD,params[iZ],sSTR).v).split(sCOMMA)
		Integer sz=list.size()
		for(Integer i=iZ; i<sz; i++){
			Boolean t1=cast(rtD,list[i],sBOOLN)
			cnt+=t1 ? i1:iZ
		}
	}else for(Map param in params) cnt+=(Boolean)evaluateExpression(rtD,param,sBOOLN).v ? i1:iZ
	rtnMap(sINT,cnt)
}

/** size returns the number of values provided				**/
/** Usage: size(values)							**/
private Map func_size(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnMap(sINT,iZ)
	Integer cnt
	Integer sz=params.size()
	if(sz==i1 && ((String)params[iZ].t in [sSTR,sDYN])){
		String[] list=((String)evaluateExpression(rtD,params[iZ],sSTR).v).split(sCOMMA)
		cnt=list.size()
	}else cnt=sz
	rtnMap(sINT,cnt)
}

/** age returns the number of milliseconds an attribute had the current value	**/
/** Usage: age([device:attribute])						**/
private Map func_age(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('age'+sDATTRH)
	Map param=evaluateExpression(rtD,params[iZ],sDEV)
	if((String)param.t==sDEV && (String)param.a && ((List)param.v).size()){
		def device=getDevice(rtD,(String)((List)param.v)[iZ])
		if(device!=null){
			def dstate=device.currentState((String)param.a,true)
			if(dstate){
				Long result=elapseT(((Date)dstate.getDate()).getTime())
				return rtnMap(sLONG,result)
			}
		}
	}
	rtnMap(sERROR,'Invalid device')
}

/** previousAge returns the number of milliseconds an attribute had the previous value		**/
/** Usage: previousAge([device:attribute])							**/
private Map func_previousage(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('previousAge'+sDATTRH)
	Map param=evaluateExpression(rtD,params[iZ],sDEV)
	if((String)param.t==sDEV && (String)param.a && ((List)param.v).size()){
		def device=getDevice(rtD,(String)((List)param.v)[iZ])
		if(device!=null && !isDeviceLocation(device)){
			List states=device.statesSince((String)param.a,new Date(elapseT(604500000L)),[max:i5])
			Integer sz=states.size()
			if(sz>i1){
				def newValue=states[iZ].getValue()
				//some events get duplicated look for the last "different valued" state
				for(Integer i=i1; i<sz; i++){
					if(states[i].getValue()!=newValue){
						Long result=elapseT(((Date)states[i].getDate()).getTime())
						return rtnMap(sLONG,result)
					}
				}
			}
			//saying 7 days though it may be wrong- but we have no data
			return rtnMap(sLONG,604800000L)
		}
	}
	rtnMap(sERROR,'Invalid device')
}

/** previousValue returns the previous value of the attribute				**/
/** Usage: previousValue([device:attribute])						**/
private Map func_previousvalue(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('previousValue'+sDATTRH)
	Map param=evaluateExpression(rtD,params[iZ],sDEV)
	if((String)param.t==sDEV && (String)param.a && ((List)param.v).size()){
		Map attribute=Attributes()[(String)param.a]
		if(attribute!=null){
			def device=getDevice(rtD,(String)((List)param.v)[iZ])
			if(device!=null && !isDeviceLocation(device)){
				List states=device.statesSince((String)param.a,new Date(elapseT(604500000L)),[max:i5])
				Integer sz=states.size()
				if(sz>i1){
					def newValue=states[iZ].getValue()
					//some events get duplicated want to look for the last "different valued" state
					for(Integer i=i1; i<sz; i++){
						def result=states[i].getValue()
						if(result!=newValue){
							String t=(String)attribute.t
							return rtnMap(t,cast(rtD,result,t))
						}
					}
				}
				//saying no value- we have no data
				return rtnMap(sSTR,sBLK)
			}
		}
	}
	rtnMap(sERROR,'Invalid device')
}

/** newer returns the number of devices whose attribute had the current		**/
/** value for less than the specified number of milliseconds			**/
/** Usage: newer([device:attribute] [,.., [device:attribute]],threshold)	**/
private Map func_newer(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('newer'+sDATTRHT)
	Integer t0=params.size()-i1
	Long threshold=(Long)evaluateExpression(rtD,params[t0],sLONG).v
	Integer result=iZ
	for(Integer i=iZ; i<t0; i++){
		Map age=func_age(rtD,[params[i]])
		if((String)age.t!=sERROR && (Long)age.v<threshold)result++
	}
	rtnMap(sINT,result)
}

/** older returns the number of devices whose attribute had the current		**/
/** value for more than the specified number of milliseconds			**/
/** Usage: older([device:attribute] [,.., [device:attribute]],threshold)	**/
private Map func_older(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('older'+sDATTRHT)
	Integer t0=params.size()-i1
	Long threshold=(Long)evaluateExpression(rtD,params[t0],sLONG).v
	Integer result=iZ
	for(Integer i=iZ; i<t0; i++){
		Map age=func_age(rtD,[params[i]])
		if((String)age.t!=sERROR && (Long)age.v>=threshold)result++
	}
	rtnMap(sINT,result)
}

/** startsWith returns true if a string starts with a substring			**/
/** Usage: startsWith(string, substring)					**/
private Map func_startswith(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('startsWith(string, substring)')
	String string=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	String substring=(String)evaluateExpression(rtD,params[i1],sSTR).v
	rtnMap(sBOOLN,string.startsWith(substring))
}

/** endsWith returns true if a string ends with a substring				**/
/** Usage: endsWith(string, substring)							**/
private Map func_endswith(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('endsWith(string, substring)')
	String string=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	String substring=(String)evaluateExpression(rtD,params[i1],sSTR).v
	rtnMap(sBOOLN,string.endsWith(substring))
}

/** contains returns true if a string contains a substring				**/
/** Usage: contains(string, substring)							**/
private Map func_contains(Map rtD,List<Map> params){
	Integer t0=params.size()
	if(!checkParams(rtD,params,i2) || ((String)params[iZ].t!=sDEV && t0!=i2)) return rtnErr('contains(string, substring)')
	if((String)params[iZ].t==sDEV && t0>i2){
		t0=t0-i1
		String item=evaluateExpression(rtD,params[t0],sSTR).v
		for(Integer idx=iZ; idx<t0; idx++){
			Map it=evaluateExpression(rtD,params[idx],sSTR)
			if(it.v==item) return rtnMap(sBOOLN,true)
		}
		return rtnMap(sBOOLN,false)
	}else{
		String string=(String)evaluateExpression(rtD,params[iZ],sSTR).v
		String substring=(String)evaluateExpression(rtD,params[i1],sSTR).v
		rtnMap(sBOOLN,string.contains(substring))
	}
}

/** matches returns true if a string matches a pattern					**/
/** Usage: matches(string, pattern)							**/
private Map func_matches(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('matches(string, pattern)')
	String string=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	String pattern=(String)evaluateExpression(rtD,params[i1],sSTR).v
	Boolean r=match(string,pattern)
	rtnMap(sBOOLN,r)
}

/** eq returns true if two values are equal					**/
/** Usage: eq(value1, value2)							**/
private Map func_eq(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('eq(value1, value2)')
	String t=(String)params[iZ].t==sDEV ? (String)params[i1].t:(String)params[iZ].t
	Map value1=evaluateExpression(rtD,params[iZ],t)
	Map value2=evaluateExpression(rtD,params[i1],t)
	rtnMap(sBOOLN,value1.v==value2.v)
}

/** lt returns true if value1<value2						**/
/** Usage: lt(value1, value2)							**/
private Map func_lt(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('lt(value1, value2)')
	Map value1=evaluateExpression(rtD,params[iZ])
	Map value2=evaluateExpression(rtD,params[i1],(String)value1.t)
	rtnMap(sBOOLN,value1.v<value2.v)
}

/** le returns true if value1<=value2						**/
/** Usage: le(value1, value2)							**/
private Map func_le(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('le(value1, value2)')
	Map value1=evaluateExpression(rtD,params[iZ])
	Map value2=evaluateExpression(rtD,params[i1],(String)value1.t)
	rtnMap(sBOOLN,value1.v<=value2.v)
}

/** gt returns true if value1>value2						**/
/** Usage: gt(value1, value2)							**/
private Map func_gt(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('gt(value1, value2)')
	Map value1=evaluateExpression(rtD,params[iZ])
	Map value2=evaluateExpression(rtD,params[i1],(String)value1.t)
	rtnMap(sBOOLN,value1.v>value2.v)
}

/** ge returns true if value1>=value2						**/
/** Usage: ge(value1, value2)							**/
private Map func_ge(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('ge(value1, value2)')
	Map value1=evaluateExpression(rtD,params[iZ])
	Map value2=evaluateExpression(rtD,params[i1],(String)value1.t)
	rtnMap(sBOOLN,value1.v>=value2.v)
}

/** not returns the negative Boolean value					**/
/** Usage: not(value)								**/
private Map func_not(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('not(value)')
	Boolean value=(Boolean)evaluateExpression(rtD,params[iZ],sBOOLN).v
	rtnMap(sBOOLN,!value)
}

/** if evaluates a Boolean and returns value1 if true,otherwise value2		**/
/** Usage: if(condition, valueIfTrue,valueIfFalse)				**/
private Map func_if(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i3)) return rtnErr('if(condition, valueIfTrue,valueIfFalse)')
	Boolean value=(Boolean)evaluateExpression(rtD,params[iZ],sBOOLN).v
	return value ? evaluateExpression(rtD,params[i1]):evaluateExpression(rtD,params[i2])
}

/** isEmpty returns true if the value is empty					**/
/** Usage: isEmpty(value)							**/
private Map func_isempty(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('isEmpty(value)')
	Map value=evaluateExpression(rtD,params[iZ])
	Boolean result=value.v==null || (value.v instanceof List ? value.v==[null] || value.v==[] || value.v==[sSNULL] : false) || (String)value.t==sERROR || value.v==sSNULL || (String)cast(rtD,value.v,sSTR)==sBLK || "$value.v".toString()==sBLK
	rtnMap(sBOOLN,result)
}

/** datetime returns the value as a datetime type				**/
/** Usage: datetime([value])							**/
private Map func_datetime(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,iZ) || sz>i1) return rtnErr('datetime([value])')
	Long value=sz>iZ ? (Long)evaluateExpression(rtD,params[iZ],sDTIME).v:(Long)now()
	rtnMap(sDTIME,value)
}

/** date returns the value as a date type					**/
/** Usage: date([value])							**/
private Map func_date(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,iZ) || sz>i1) return rtnErr('date([value])')
	Long value=sz>iZ ? (Long)evaluateExpression(rtD,params[iZ],sDATE).v:(Long)cast(rtD,(Long)now(),sDATE,sDTIME)
	rtnMap(sDATE,value)
}

/** time returns the value as a time type					**/
/** Usage: time([value])							**/
private Map func_time(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,iZ) || sz>i1) return rtnErr('time([value])')
	Long value=sz>iZ ? (Long)evaluateExpression(rtD,params[iZ],sTIME).v:(Long)cast(rtD,(Long)now(),sTIME,sDTIME)
	rtnMap(sTIME,value)
}

private Map addtimeHelper(Map rtD,List<Map> params,Long mulp,String msg){
	Integer sz=params.size()
	if(!checkParams(rtD,params,i1) || sz>i2) return rtnErr(msg)
	Long value=sz==i2 ? (Long)evaluateExpression(rtD,params[iZ],sDTIME).v:(Long)now()
	Long delta=(Long)evaluateExpression(rtD,(sz==i2 ? params[i1]:params[iZ]),sLONG).v*mulp
	rtnMap(sDTIME,value+delta)
}

/** addSeconds returns the value as a dateTime type						**/
/** Usage: addSeconds([dateTime,]seconds)						**/
private Map func_addseconds(Map rtD,List<Map> params){
	return addtimeHelper(rtD,params,lTHOUS,'addSeconds([dateTime,]seconds)')
}

/** addMinutes returns the value as a dateTime type						**/
/** Usage: addMinutes([dateTime,]minutes)						**/
private Map func_addminutes(Map rtD,List<Map> params){
	return addtimeHelper(rtD,params,dMSMINT.toLong(),'addMinutes([dateTime,]minutes)')
}

/** addHours returns the value as a dateTime type						**/
/** Usage: addHours([dateTime,]hours)							**/
private Map func_addhours(Map rtD,List<Map> params){
	return addtimeHelper(rtD,params,dMSECHR.toLong(),'addHours([dateTime,]hours)')
}

/** addDays returns the value as a dateTime type						**/
/** Usage: addDays([dateTime,]days)							**/
private Map func_adddays(Map rtD,List<Map> params){
	return addtimeHelper(rtD,params,lMSDAY,'addDays([dateTime,]days)')
}

/** addWeeks returns the value as a dateTime type						**/
/** Usage: addWeeks([dateTime,]weeks)							**/
private Map func_addweeks(Map rtD,List<Map> params){
	return addtimeHelper(rtD,params,604800000L,'addWeeks([dateTime,]weeks)')
}

/** weekDayName returns the name of the week day					**/
/** Usage: weekDayName(dateTimeOrWeekDayIndex)						**/
private Map func_weekdayname(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('weekDayName(dateTimeOrWeekDayIndex)')
	Long value=(Long)evaluateExpression(rtD,params[iZ],sLONG).v
	Integer index=((value>=lMSDAY)? utcToLocalDate(value).day:value.toInteger()) % 7
	rtnMap(sSTR,weekDaysFLD[index])
}

/** monthName returns the name of the month						**/
/** Usage: monthName(dateTimeOrMonthNumber)						**/
private Map func_monthname(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('monthName(dateTimeOrMonthNumber)')
	Long value=(Long)evaluateExpression(rtD,params[iZ],sLONG).v
	Integer index=((value>=lMSDAY)? utcToLocalDate(value).month: (value-1L).toInteger())%12+i1
	rtnMap(sSTR,yearMonthsFLD[index])
}

/** arrayItem returns the nth item in the parameter list				**/
/** Usage: arrayItem(index, item0[, item1[, .., itemN]])				**/
private Map func_arrayitem(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i2)) return rtnErr('arrayItem(index, item0[, item1[, .., itemN]])')
	Map serr=rtnMap(sERROR,'Array item index is outside of bounds.')
	Integer index=(Integer)evaluateExpression(rtD,params[iZ],sINT).v
	Integer sz=params.size()
	if(sz==i2 && ((String)params[i1].t in [sSTR,sDYN])){
		String[] list=((String)evaluateExpression(rtD,params[i1],sSTR).v).split(sCOMMA)
		if(index<iZ || index>=list.size()) return serr
		return rtnMap(sSTR,list[index])
	}
	if(index<iZ || index>=sz-i1) return serr
	return params[index+i1]
}

/** isBetween returns true if value>=startValue and value<=endValue		**/
/** Usage: isBetween(value,startValue,endValue)				**/
private Map func_isbetween(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i3)) return rtnErr('isBetween(value,startValue,endValue)')
	Map value=evaluateExpression(rtD,params[iZ])
	Map startValue=evaluateExpression(rtD,params[i1],(String)value.t)
	Map endValue=evaluateExpression(rtD,params[i2],(String)value.t)
	rtnMap(sBOOLN,(value.v>=startValue.v && value.v<=endValue.v))
}

/** formatDuration returns a duration in a readable format					**/
/** Usage: formatDuration(value[, friendly=false[, granularity='s'[, showAdverbs=false]]])	**/
private Map func_formatduration(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,i1) || sz>i4) return rtnErr("formatDuration(value[, friendly=false[, granularity='s'[, showAdverbs=false]]])")
	Long value=(Long)evaluateExpression(rtD,params[iZ],sLONG).v
	Boolean friendly=sz>i1 ? (Boolean)evaluateExpression(rtD,params[i1],sBOOLN).v:false
	String granularity=sz>i2 ? (String)evaluateExpression(rtD,params[i2],sSTR).v:sS
	Boolean showAdverbs=sz>i3 ? (Boolean)evaluateExpression(rtD,params[i3],sBOOLN).v:false

	Integer sign=(value>=iZ)? i1:iN1
	if(sign<iZ)value=-value
	Integer ms=(value%1000).toInteger()
	value=Math.floor((value-ms)/d1000).toLong()
	Integer s=(value%60).toInteger()
	value=Math.floor((value-s)/d60).toLong()
	Integer m=(value%60).toInteger()
	value=Math.floor((value-m)/d60).toLong()
	Integer h=(value%24).toInteger()
	value=Math.floor((value-h)/24.0D).toLong()
	Integer d=value.toInteger()

	Integer parts
	String partName
	switch(granularity){
		case sD: parts=i1; partName='day'; break
		case sH: parts=i2; partName='hour'; break
		case sM: parts=i3; partName='minute'; break
		case sMS: parts=i5; partName='millisecond'; break
		default:parts=i4; partName='second'; break
	}
	parts=friendly ? parts:(parts<i3 ? i3:parts)
	String result
	if(friendly){
		List p=[]
		if(d)Boolean a=p.push("$d day"+(d>i1 ? sS:sBLK))
		if(parts>i1 && h)Boolean a=p.push("$h hour"+(h>i1 ? sS:sBLK))
		if(parts>i2 && m)Boolean a=p.push("$m minute"+(m>i1 ? sS:sBLK))
		if(parts>i3 && s)Boolean a=p.push("$s second"+(s>i1 ? sS:sBLK))
		if(parts>4 && ms)Boolean a=p.push("$ms millisecond"+(ms>i1 ? sS:sBLK))
		sz=p.size()
		switch(sz){
			case iZ:
				result=showAdverbs ? 'now':'0 '+partName+sS
				break
			case i1:
				result=p[iZ]
				break
			default:
				result=sBLK
				for(Integer i=iZ; i<sz; i++){
					result+=(i ? (sz>i2 ? sCOMMA:sSPC):sBLK)+(i==sz-i1 ? sAND+sSPC:sBLK)+p[i]
				}
				result=(showAdverbs && (sign>iZ)? 'in ':sBLK)+result+(showAdverbs && (sign<iZ)? ' ago':sBLK)
				break
		}
	}else{
		result=(sign<iZ ? sMINUS:sBLK)+(d>iZ ? sprintf("%dd ",d):sBLK)+sprintf("%02d:%02d",h,m)+(parts>i3 ? sprintf(":%02d",s):sBLK)+(parts>4 ? sprintf(".%03d",ms):sBLK)
	}
	rtnMap(sSTR,result)
}

/** formatDateTime returns a datetime in a readable format				**/
/** Usage: formatDateTime(value[, format])						**/
private Map func_formatdatetime(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,i1) || sz>i2) return rtnErr('formatDateTime(value[, format])')
	Long value=(Long)evaluateExpression(rtD,params[iZ],sDTIME).v
	String format=sz>i1 ? (String)evaluateExpression(rtD,params[i1],sSTR).v:sNULL
	rtnMap(sSTR,(format ? formatLocalTime(value,format):formatLocalTime(value)))
}

/** random returns a random value						**/
/** Usage: random([range | value1, value2[, ..,valueN]])			**/
private Map func_random(Map rtD,List<Map> params){
	Integer sz=params!=null && (params instanceof List) ? params.size():iZ
	switch(sz){
		case iZ:
			return rtnMap(sDEC,Math.random())
		case i1:
			Double range=(Double)evaluateExpression(rtD,params[iZ],sDEC).v
			return rtnMap(sINT,(Integer)Math.round(range*Math.random()))
		case i2:
			List<String> n=[sINT,sDEC]
			if(((String)params[iZ].t in n) && ((String)params[i1].t in n)){
				Double min=(Double)evaluateExpression(rtD,params[iZ],sDEC).v
				Double max=(Double)evaluateExpression(rtD,params[i1],sDEC).v
				if(min>max){
					Double swap=min
					min=max
					max=swap
				}
				return rtnMap(sINT,(Integer)Math.round(min+(max-min)*Math.random()))
			}
	}
	Integer choice=(Integer)Math.round((sz-i1)*Math.random())
	if(choice>=sz)choice=sz-i1
	return params[choice]
}

/** distance returns a distance measurement							**/
/** Usage: distance((device | latitude,longitude),(device | latitude,longitude)[, unit])	**/
@SuppressWarnings(['GroovyVariableNotAssigned', 'GroovyFallthrough'])
private Map func_distance(Map rtD,List<Map> params){
	Integer sz=params.size()
	if(!checkParams(rtD,params,i2) || sz>i5) return rtnErr('distance((device | latitude,longitude),(device | latitude,longitude)[, unit])')
	Double lat1,lng1,lat2,lng2
	String unit
	Integer idx=iZ
	Integer pidx=iZ
	String errMsg=sBLK
	while (pidx<sz){
		if((String)params[pidx].t!=sDEV || ((String)params[pidx].t==sDEV && !!params[pidx].a)){
			//a decimal or device attribute is provided
			switch(idx){
			case iZ:
				lat1=(Double)evaluateExpression(rtD,params[pidx],sDEC).v
				break
			case i1:
				lng1=(Double)evaluateExpression(rtD,params[pidx],sDEC).v
				break
			case i2:
				lat2=(Double)evaluateExpression(rtD,params[pidx],sDEC).v
				break
			case i3:
				lng2=(Double)evaluateExpression(rtD,params[pidx],sDEC).v
				break
			case i4:
				unit=(String)evaluateExpression(rtD,params[pidx],sSTR).v
			}
			idx+=i1
			pidx+=i1
			continue
		}else{
			switch(idx){
				case iZ:
				case i2:
					params[pidx].a='latitude'
					Double lat=(Double)evaluateExpression(rtD,params[pidx],sDEC).v
					params[pidx].a='longitude'
					Double lng=(Double)evaluateExpression(rtD,params[pidx],sDEC).v
					if(idx==iZ){
						lat1=lat
						lng1=lng
					}else{
						lat2=lat
						lng2=lng
					}
					idx+=i2
					pidx+=i1
					continue
				default:
					errMsg="Invalid parameter order. Expecting parameter #${idx+i1} to be a decimal,not a device."
					pidx=iN1
					break
			}
		}
		if(pidx==iN1)break
	}
	if(errMsg!=sBLK)return rtnMap(sERROR,errMsg)
	if(idx<i4 || idx>i5)return rtnMap(sERROR,'Invalid parameter combination. Expecting either two devices,a device and two decimals,or four decimals,followed by an optional unit.')
	Double earthRadius=6371000.0D //meters
	Double dLat=Math.toRadians(lat2-lat1)
	Double dLng=Math.toRadians(lng2-lng1)
	Double a=Math.sin(dLat/d2)*Math.sin(dLat/d2)+
		Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))*
		Math.sin(dLng/d2)*Math.sin(dLng/d2)
	Double c=d2*Math.atan2(Math.sqrt(a),Math.sqrt(d1-a))
	Double dist=earthRadius*c
	switch(unit!=null ? unit:sM){
		case 'km':
		case 'kilometer':
		case 'kilometers':
			return rtnMap(sDEC,dist/d1000)
		case 'mi':
		case 'mile':
		case 'miles':
			return rtnMap(sDEC,dist/1609.3440D)
		case 'ft':
		case 'foot':
		case 'feet':
			return rtnMap(sDEC,dist/0.3048D)
		case 'yd':
		case 'yard':
		case 'yards':
			return rtnMap(sDEC,dist/0.9144D)
	}
	rtnMap(sDEC,dist)
}

/** json encodes data as a JSON string							**/
/** Usage: json(value[, pretty])							**/
private static Map func_json(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1) || params.size()>i2) return rtnErr('json(value[, format])')
	JsonBuilder builder=new JsonBuilder([((Map)params[iZ]).v])
	String op=params[i1] ? 'toPrettyString':'toString'
	String json=builder."${op}"()
	rtnMap(sSTR,json[1..-2].trim())
}

/** urlencode encodes data for use in a URL						**/
/** Usage: urlencode(value)								**/
private Map func_urlencode(Map rtD,List<Map> params){
	if(!checkParams(rtD,params,i1)) return rtnErr('urlencode(value])')
	String t0=(String)evaluateExpression(rtD,params[iZ],sSTR).v
	String value=(t0!=sNULL ? t0:sBLK)
	rtnMap(sSTR,encodeURIComponent(value))
}
private Map func_encodeuricomponent(Map rtD,List params){ return func_urlencode(rtD,params)}

/** COMMON PUBLISHED METHODS							**/

private String mem(Boolean showBytes=true){
	String mbytes=new JsonOutput().toJson((Map)state)
	Integer bytes=mbytes.length()
	return Math.round(d100*(bytes/100000.0D))+"%${showBytes ? " ($bytes bytes)".toString() : sBLK}"
}

private static String runTimeHis(Map rtD){
	String myId=(String)rtD.id
	return 'Total run history: '+((List)theCacheVFLD[myId].runTimeHis).toString()+'<br>' +
		'Last run details: '+((Map)theCacheVFLD[myId].runStats).toString()
}

/** UTILITIES									**/

private static String encodeURIComponent(value){
	// URLEncoder converts spaces to + which is then indistinguishable from any
	// actual + characters in the value. Match encodeURIComponent in ECMAScript
	// which encodes "a+b c" as "a+b%20c" rather than URLEncoder's "a+b+c"
	String holder='__wc_plus__'
	return URLEncoder.encode(
		"${value}".toString().replaceAll('\\+',holder),
		'UTF-8'
	).replaceAll('\\+','%20').replaceAll(holder,'+')
}

private static String getThreeAxisOrientation(Map m /*, Boolean getIndex=false */){
	if(m.x!=null && m.y!=null && m.z!=null){
		Integer x=Math.abs(m.x.toDouble()).toInteger()
		Integer y=Math.abs(m.y.toDouble()).toInteger()
		Integer z=Math.abs(m.z.toDouble()).toInteger()
		Integer side=(x>y ? (x>z ? iZ:i2):(y>z ? i1:i2))
		side+= (side==iZ && m.x<iZ) || (side==i1 && m.y<iZ) || (side==i2 && m.z<iZ) ? i3:iZ
//		if(getIndex){ return side }
		List<String> orientations=['rear','down','left','front','up','right']
		return orientations[side]+' side up'
	}
	return sNULL
}

private Long getWCTimeToday(Long time){
	Long t0=getMidnightTime()
	Long result=time+t0
	//we need to adjust for time overlapping during DST changes
	return Math.round(result+(((TimeZone)location.timeZone).getOffset(t0)-((TimeZone)location.timeZone).getOffset(result))*d1)
}

@Field static final List<String> trueStrings= [ '1','true', "on", "open",  "locked",  "active",  "wet",           "detected",    "present",    "occupied",    "muted",  "sleeping"]
@Field static final List<String> falseStrings=[ '0','false',"off","closed","unlocked","inactive","dry","clear",   "not detected","not present","not occupied","unmuted","not sleeping","null"]

@SuppressWarnings('GroovyFallthrough')
private cast(Map rtD,ival,String dataT,String isrcDT=sNULL){
	//if((Boolean)rtD.eric)myDetail rtD,"cast $isrcDT $ival as $dataT",-2
	if(dataT==sDYN)return ival

	String dataType=dataT
	String srcDataType=isrcDT
	def value=ival

	if(value==null){
		value=sBLK
		srcDataType=sSTR
	}
	Boolean isfbd=false
	value=(value instanceof GString)? "$value".toString():value //get rid of GStrings
	if(srcDataType==sNULL || srcDataType.length()==iZ || srcDataType==sBOOLN || srcDataType==sDYN){
		if(value instanceof List){srcDataType=sDEV}
		else if(value instanceof Boolean){srcDataType=sBOOLN}
			else if(value instanceof String){srcDataType=sSTR}
				else if(value instanceof Integer){srcDataType=sINT}
					else if(value instanceof Long || value instanceof BigInteger){srcDataType=sLONG}
						else if(value instanceof Double){srcDataType=sDEC}
							else if(value instanceof BigDecimal || value instanceof Float){srcDataType=sDEC; isfbd=true}
								else if(value instanceof Map && value.x!=null && value.y!=null && value.z!=null){srcDataType='vector3'}
									else{
										value="$value".toString()
										srcDataType=sSTR
									}
	}
	//overrides
	switch(srcDataType){
		case sBOOL: srcDataType=sBOOLN; break
		case sNUMBER: srcDataType=sDEC; break
		case sENUM: srcDataType=sSTR; break
	}
	switch(dataType){
		case sBOOL: dataType=sBOOLN; break
		case sNUMBER: dataType=sDEC; break
		case sENUM: dataType=sSTR; break
	}
	if((Boolean)rtD.eric)myDetail rtD,"cast $srcDataType ${isfbd ? 'bigDF':sBLK} $value as $dataType",iN2
	switch(dataType){
		case sSTR:
		case sTEXT:
			switch(srcDataType){
				case sBOOLN: return value ? sTRUE:sFALSE
				case sDEC:
					// strip trailing zeroes (e.g. 5.00 to 5 and 5.030 to 5.03)
					return value.toString().replaceFirst(/(?:\.|(\.\d*?))0+$/,'$1')
				case sINT:
				case sLONG: break
				case sTIME: return formatLocalTime(value,'h:mm:ss a z')
				case sDATE: return formatLocalTime(value,'EEE, MMM d yyyy')
				case sDTIME: return formatLocalTime(value)
				case sDEV: return buildDeviceList(rtD,value)
			}
			return "$value".toString()
		case sINT:
			switch(srcDataType){
				case sSTR:
					String s=value.replaceAll(/[^-\d.-E]/,sBLK)
					if(s.isInteger())
						return s.toInteger()
					if(s.isFloat())
						return Math.floor(s.toDouble()).toInteger()
					if(s in trueStrings)
						return i1
					break
				case sBOOLN: return (Integer)(value ? i1:iZ)
			}
			Integer result
			try{
				result=(Integer)value.toInteger()
			}catch(ignored){
				result=iZ
			}
			return result
		case sLONG:
			switch(srcDataType){
				case sSTR:
					String s=value.replaceAll(/[^-\d.-E]/,sBLK)
					if(s.isLong())
						return s.toLong()
					if(s.isInteger())
						return s.toLong()
					if(s.isFloat())
						return Math.floor(s.toDouble()).toLong()
					if(s in trueStrings)
						return 1L
					break
				case sBOOLN: return (value ? 1L:lZ)
			}
			Long result
			try{
				result=value.toLong()
			}catch(ignored){
				result=lZ
			}
			return result
		case sDEC:
			switch(srcDataType){
				case sSTR:
					String s=value.replaceAll(/[^-\d.-E]/,sBLK)
					if(s.isDouble())
						return s.toDouble()
					if(s.isFloat())
						return s.toDouble()
					if(s.isLong())
						return s.toLong().toDouble()
					if(s.isInteger())
						return s.toInteger().toDouble()
					if(s in trueStrings)
						return d1
					break
				case sBOOLN: return (Double)(value ? d1:dZ)
			}
			Double result=dZ
			try{
				result=(Double)value.toDouble()
			}catch(ignored){}
			return result
		case sBOOLN:
			switch(srcDataType){
				case sINT:
				case sDEC:
				case sBOOLN:
					return !!value
				case sDEV:
					return value instanceof List && ((List)value).size()>iZ
			}
			if(value){
				String s= "$value".toLowerCase().trim()
				if(s in falseStrings)return false
				if(s in trueStrings)return true
			}
			return !!value
		case sTIME:
			Long d= srcDataType==sSTR ? stringToTime(value):value.toLong()
			if(d<lMSDAY) return d
			Date t1=new Date(d)
			d=Math.round((t1.hours*dSECHR+(Integer)t1.minutes*d60+t1.seconds)*d1000)
			return d
		case sDATE:
		case sDTIME:
			Long d
			if(srcDataType in [sTIME,sLONG,sINT,sDEC]){
				d=value.toLong()
				if(d<lMSDAY) value=getWCTimeToday(d)
				else value=d
			}
			d= srcDataType==sSTR ? stringToTime(value):(Long)value
			if(dataType==sDATE){
				Date t1= new Date(d)
				// take ms off and first guess at midnight (could be earlier/later depending if DST change day
				d= Math.round((Math.floor(d/d1000)*d1000) - ((t1.hours*dSECHR + t1.minutes*d60 + t1.seconds)*d1000) )
			}
			return d
		case 'vector3':
			return value instanceof Map && value.x!=null && value.y!=null && value.z!=null ? value : [(sX):iZ,y:iZ,(sZ):iZ]
		case sORIENT:
			return value instanceof Map ? getThreeAxisOrientation(value):value
		case sMS:
		case sS:
		case sM:
		case sH:
		case sD:
		case 'w':
		case sN: // months
		case 'y': // years
			Long t1
			switch(srcDataType){
				case sINT:
				case sLONG:
					t1=value.toLong(); break
				default:
					t1=(Long)cast(rtD,value,sLONG)
			}
			switch(dataType){
				case sMS: return t1
				case sS: return Math.round(t1*d1000)
				case sM: return Math.round(t1*dMSMINT)
				case sH: return Math.round(t1*dMSECHR)
				case sD: return Math.round(t1*dMSDAY)
				case 'w': return Math.round(t1*604800000.0D)
				case sN: return Math.round(t1*2592000000.0D)
				case 'y': return Math.round(t1*31536000000.0D)
			}
			break
		case sDEV:
		//device type is an array of device Ids
			if(value instanceof List){
				Boolean a=((List<String>)value).removeAll{ String it -> !it }
				return (List)value
			}
			String v=(String)cast(rtD,value,sSTR)
			if(v!=sNULL)return [v]
			return []
	}
	//anything else
	return value
}

private Long elapseT(Long st){
	return Math.round(d1*(Long)now()-st)
}

private Date utcToLocalDate(dateOrTimeOrString=null){ // this is really cast to Date
	def ldate=dateOrTimeOrString
	if(!(ldate instanceof Long)){
		if(ldate instanceof String){
			ldate=stringToTime((String)ldate)
		}
		if(ldate instanceof Date){
			//get unix time
			ldate=((Date)ldate).getTime()
		}
	}
	if(ldate==null || ldate==lZ){
		ldate=(Long)now()
	}
	if(ldate instanceof Long){
		//HE is set to local timezone of hub
		return new Date((Long)ldate)
	}
	return null
}

private Date localDate(){ return utcToLocalDate((Long)now())}

//private Long localTime(){ return now()} //utcToLocalTime()}

private Long stringToTime(dateOrTimeOrString){ // this is convert to time
	Long lnull=(Long)null
	Long result=lnull
	Integer cnt=iZ
	def a= dateOrTimeOrString
	Double aa
	Boolean fnd=false
	try{ // isNumber() does not deal with some double values
		aa= a as Double
		fnd=true
	} catch(ignored){ }
	try{
		if(fnd || "$a".isNumber()){
			Long tt= fnd ? aa.toLong() : a.toLong()
			if(tt<lMSDAY){
				result=getWCTimeToday(tt)
				cnt=i1
			}else{
// deal with a time in sec (vs. ms)
				Long span=63072000L // Math.round(730*(dMSDAY/d1000)) // 2 years in secs
				Long nowInsecs=Math.round(((Long)now())/lTHOUS)
				if(tt<(nowInsecs+span) && tt>(nowInsecs-span)){
					result=tt*lTHOUS
					cnt=i2
				}
			}
			if(result==lnull){
				result=tt
				cnt=i3
			}
		}
	}catch(ignored){}

	if(result==lnull && dateOrTimeOrString instanceof String){
		String sdate=dateOrTimeOrString
		cnt=i4
		try{
			Date tt1=(Date)toDateTime(sdate)
			result=tt1.getTime()
		}catch(ignored){ result=lnull }


		// additional ISO 8601 that Hubitat does not parse
		if(result==lnull){
			cnt=i5
			try{
				String tt=sdate
				def regex1=/Z/
				String tt0=tt.replaceAll(regex1," -0000")
				result=(new Date()).parse("yyyy-MM-dd'T'HH:mm z",tt0).getTime()
			}catch(ignored){ result=lnull }
		}

		if(result==lnull){
			cnt=i6
			try{
				result=(new Date()).parse(sdate)
			}catch(ignored){ result=lnull }
		}

		if(result==lnull){
			cnt=7
			try{
				//get unix time
				if(!(sdate =~ /(\s[A-Z]{3}([+\-][0-9]{2}:[0-9]{2}|\s[0-9]{4})?$)/)){
					Long newDate=(new Date()).parse(sdate+sSPC+formatLocalTime((Long)now(),'Z'))
					result=newDate
				}
			}catch(ignored){ result=lnull }
		}

		if(result==lnull){
			cnt=8
			try{
				TimeZone tz=(TimeZone) location.timeZone
				if(sdate =~ /\s[A-Z]{3}$/){ // this is not the timezone... strings like CET are not unique.
					try{
						tz=TimeZone.getTimeZone(sdate[-3..-1])
						///sdate=sdate.take(sdate.size()-3).trim()
						sdate=sdate[0..sdate.size()-3].trim()
					}catch(ignored){}
				}

				String t0=sdate?.trim() ?: sBLK
				t0=t0.toLowerCase()
				Boolean hasMeridian=false
				Boolean hasAM=false
				Boolean hasPM=false
				if(t0.endsWith('a.m.')){
					t0=t0.replaceAll('a\\.m\\.','am')
				}
				if(t0.endsWith('p.m.')){
					t0=t0.replaceAll('p\\.m\\.','pm')
				}
				if(t0.endsWith('am')){
					hasMeridian=true
					hasAM=true
				}
				if(t0.endsWith('pm')){
					hasMeridian=true
					hasPM=true
				}
				Long time=lnull
				if(hasMeridian)t0=t0[0..-3].trim()

				try{
					if(t0.length()==8){
						cnt=9
						String tt=t0
						time=(new Date()).parse('HH:mm:ss',tt).getTime()
						time=getWCTimeToday(time)
					}else{
						cnt=10
						time=((Date)timeToday(t0,tz)).getTime()
					}
				}catch(ignored){}

				if(hasMeridian && time){
					cnt=11
					Date t1=new Date(time)
					Integer hr=t1.hours
					Integer min=t1.minutes
					Integer sec=t1.seconds
					Boolean twelve=hr>=12
					if(twelve && hasAM)hr-=12
					if(!twelve && hasPM)hr+=12
					String str1="${hr}".toString()
					String str2="${min}".toString()
					//String str3="${sec}".toString()
					if(hr<10)str1=String.format('%02d',hr)
					if(min<10)str2=String.format('%02d',min)
					String str=str1+sCOLON+str2
					time=((Date)timeToday(str,tz)).getTime()
					if(sec!=iZ)time+=sec*1000
				}
				result=time ?: lZ
			}catch(ignored){ result=lnull }
		}
	}

	if(result==lnull){
		if(dateOrTimeOrString instanceof Date){
			cnt=12
			result=((Date)dateOrTimeOrString).getTime()
		}
	}
	if(result==lnull){
		cnt=13
		result=lZ
	}
	//if(eric())log.warn "stringToTime ${dateOrTimeOrString} result: ${result} cnt: ${cnt}"
	return result
}

private String formatLocalTime(time,String format='EEE, MMM d yyyy @ h:mm:ss a z'){
	def nTime=time
	Double aa
	Boolean fnd=false
	try{
		aa= nTime as Double
		fnd=true
	} catch(ignored){ }
	if(fnd || time instanceof Long || "${time}".isNumber()){
		Long lt=fnd ? aa.toLong() : time.toLong()
		if(lt<lMSDAY)lt=getWCTimeToday(lt)
// deal with a time in sec (vs. ms)
		if(lt<Math.round((Long)now()/d1000+86400.0D*365.0D))lt=Math.round(lt*d1000)
		nTime=new Date(lt)
	}else if(time instanceof String){
		nTime=new Date(stringToTime((String)time))
	}
	if(!(nTime instanceof Date)){
		return sNULL
	}
	Date d=nTime
	SimpleDateFormat formatter=new SimpleDateFormat(format)
	formatter.setTimeZone((TimeZone)location.timeZone)
	return formatter.format(d)
}

private static Map hexToColor(String hex){
	String mhex=hex!=sNULL ? hex:sZEROS
	if(mhex.startsWith('#'))mhex=mhex.substring(1)
	if(mhex.size()!=i6)mhex=sZEROS
	List<Integer> myHsl=hexToHsl(mhex)
	return [
		(sHUE): myHsl[iZ],
		(sSATUR): myHsl[i1],
		(sLVL): myHsl[i2],
		hex: '#'+mhex
	]
}

private static Double _hue2rgb(Double p,Double q,Double t){
	Double d6=6.0D
	if(t<dZ)t+= d1
	if(t>=d1)t-= d1
	if(t<d1/d6)return p+(q-p)*d6*t
	if(t<d1/d2)return q
	if(t<d2/3.0D)return p+(q-p)*(d2/3.0D-t)*d6
	return p
}

private static String hslToHex(hue,saturation,level){
	Double h=hue/360.0D
	Double s=saturation/d100
	Double l=level/d100
// argument checking for user calls
	if(h<dZ)h=dZ
	if(h>d1)h=d1
	if(s<dZ)s=dZ
	if(s>d1)s=d1
	if(l<dZ)l=dZ
	if(l>d1)l=d1

	Double r,g,b
	if(s==dZ){
		r=g=b=l // achromatic
	}else{
		Double q=l<0.5D ? l*(d1+s):l+s-(l*s)
		Double p=d2*l-q
		r=_hue2rgb(p,q,h+d1/3.0D)
		g=_hue2rgb(p,q,h)
		b=_hue2rgb(p,q,h-d1/3.0D)
	}

	return sprintf('#%02X%02X%02X',Math.round(r*255.0D),Math.round(g*255.0D),Math.round(b*255.0D))
}
/*
private static Map<String,Integer> hexToRgb(String hex){
	hex=hex!=sNULL ? hex:sZEROS
	if(hex.startsWith('#'))hex=hex.substring(1)
	if(hex.size()!=i6)hex=sZEROS
	Integer r1=Integer.parseInt(hex.substring(0,2),16)
	Integer g1=Integer.parseInt(hex.substring(2,4),16)
	Integer b1=Integer.parseInt(hex.substring(4,6),16)
	return [r:r1,g:g1,b:b1]
}*/

private static List<Integer> hexToHsl(String hex){
	String mhex=hex!=sNULL ? hex:sZEROS
	if(mhex.startsWith('#'))mhex=mhex.substring(1)
	if(mhex.size()!=i6)mhex=sZEROS
	Double r=Integer.parseInt(mhex.substring(0,2),16)/255.0D
	Double g=Integer.parseInt(mhex.substring(2,4),16)/255.0D
	Double b=Integer.parseInt(mhex.substring(4,6),16)/255.0D

	Double max=Math.max(Math.max(r,g),b)
	Double min=Math.min(Math.min(r,g),b)
	Double h=dZ
	Double s=dZ
	Double l=(max+min)/d2

	if(max==min){
		h=s=dZ // achromatic
	}else{
		Double d=max-min
		s=l>0.5D ? d/(d2-max-min):d/(max+min)
		switch(max){
			case r: h=(g-b)/d+(g<b ? 6.0D:dZ); break
			case g: h=(b-r)/d+d2; break
			case b: h=(r-g)/d+4.0D; break
		}
		h /= 6.0D
	}
	return [Math.round(h*360.0D).toInteger(),Math.round(s*d100).toInteger(),Math.round(l*d100).toInteger()]
}

//hubitat device ids can be the same as the location id
private Boolean isDeviceLocation(device){
	if(device.id.toString()==location.id.toString()){
		Integer tt0=device.hubs?.size()
		if((tt0!=null?tt0:iZ)>iZ)return true
	}
	return false
}

/**							**/
/** DEBUG FUNCTIONS					**/
/**							**/

private void myDetail(Map rtD,String msg,Integer shift=iN1){
	Map a=log(msg,rtD,shift,null,sWARN,true,false)
}

@SuppressWarnings('GroovyFallthrough')
private Map log(message,Map rtD,Integer shift=iN2,err=null,String cmd=sNULL,Boolean force=false,Boolean svLog=true){
	if(cmd=='timer'){
		return [(sM):message.toString(),(sT):(Long)now(),(sS):shift,(sE):err]
	}
	String myMsg=sNULL
	def merr=err
	Integer mshift=shift
	if(message instanceof Map){
		mshift=(Integer)message.s
		merr=message.e
		myMsg=(String)message.m+" (${elapseT((Long)message.t)}ms)".toString()
	} else myMsg=message.toString()
	String mcmd=cmd!=sNULL ? cmd:sDBG
	//shift is
	// 0 initialize level,level set to 1
	// 1 start of routine,level up
	// -1 end of routine,level down
	// anything else: nothing happens
//	Integer maxLevel=4
	Integer level=rtD?.debugLevel ? (Integer)rtD.debugLevel:iZ
	String prefix="║"
	String prefix2="║"
//	String pad=sBLK //"░"
	switch(mshift){
		case iZ:
			level=iZ
		case i1:
			level+=i1
			prefix="╚"
			prefix2="╔"
//			pad="═"
			break
		case iN1:
			level-=i1
//			pad="═"
			prefix="╔"
			prefix2="╚"
			break
	}

	if(level>iZ){
		prefix=prefix.padLeft(level+(mshift==iN1 ? i1:iZ),"║")
		prefix2=prefix2.padLeft(level+(mshift==iN1 ? i1:iZ),"║")
	}

	rtD.debugLevel=level
	Boolean hasErr=(merr!=null && !!merr)

	if(svLog && rtD!=null && rtD instanceof Map && rtD.logs instanceof List){
		myMsg=myMsg.replaceAll(/(\r\n|\r|\n|\\r\\n|\\r|\\n)+/,"\r")
		if(myMsg.size()>1024){
			myMsg=myMsg[0..1023]+'...[TRUNCATED]'
		}
		List msgs=!hasErr ? myMsg.tokenize("\r"):[myMsg]
		for(msg in msgs){
			Boolean a=((List)rtD.logs).push([(sO):elapseT((Long)rtD.timestamp),(sP):prefix2,(sM):msg+(hasErr ? " $merr".toString():sBLK),(sC):mcmd])
		}
	}
	String myPad=sSPC
	switch(mcmd){
		case sDBG:
			break
		case 'info':
			myPad=" ░"
			break
		case 'trace':
		case sERROR:
		case sWARN:
			myPad="░"
			break
		default:
			break
	}
	if(hasErr) myMsg+="$merr".toString()
	if((mcmd in [sERROR,sWARN]) || hasErr || force || !svLog || (Boolean)rtD.logsToHE || (Boolean)rtD.eric)log."$mcmd" myPad+prefix+sSPC+myMsg
	return [:]
}

private void info(message,Map rtD,Integer shift=iN2,err=null){ Map a=log(message,rtD,shift,err,'info')}
private void trace(message,Map rtD,Integer shift=iN2,err=null){ Map a=log(message,rtD,shift,err,'trace')}
private void debug(message,Map rtD,Integer shift=iN2,err=null){ Map a=log(message,rtD,shift,err,sDBG)}
private void warn(message,Map rtD,Integer shift=iN2,err=null){ Map a=log(message,rtD,shift,err,sWARN)}
private void error(message,Map rtD,Integer shift=iN2,err=null){
	Map a=log(message,rtD,shift,err,sERROR)
	String aa=sNULL
	String bb=sNULL
	try{
		if(err){
			aa=getExceptionMessageWithLine(err)
			bb=getStackTrace(err)
		}
	}catch(ignored){}
	if(aa || bb) log.error "webCoRE exception: "+aa +" \n"+bb
}

private Map timer(String message,Map rtD,Integer shift=iN2,err=null){ log(message,rtD,shift,err,'timer')}

private void tracePoint(Map rtD,String objectId,Long duration,value){
	if(objectId!=sNULL && rtD!=null && (Map)rtD.trace!=null){
		rtD.trace.points[objectId]=[(sO):elapseT((Long)rtD.trace.t)-duration,(sD):duration,(sV):value]
	}else error "Invalid object ID $objectId for trace point",rtD
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
	Long t=(Long)now()
	if(t0!=null){
		if(t<(Long)t0.nextM){
			rtD.sunTimes=[:]+t0
		}else{ t0=null; svSunTFLD=null; mb() }
	}
	if(t0==null){
		Map sunTimes=app.getSunriseAndSunset()
		if(sunTimes.sunrise==null){
			warn 'Actual sunrise and sunset times are unavailable; please reset the location for your hub',rtD
			Long t1=getMidnightTime()
			sunTimes.sunrise=new Date(Math.round(t1+7.0D*dMSECHR))
			sunTimes.sunset=new Date(Math.round(t1+19.0D*dMSECHR))
			t=lZ
		}
		Long a=((Date)sunTimes.sunrise).getTime()
		Long b=((Date)sunTimes.sunset).getTime()
		Long nmnght=getNextMidnightTime()
		Long c,d=lZ
		Long a1
		Long b1
		Boolean good=true
		try{
			a1=((Date)todaysSunrise).getTime() // requires FW 2.2.3.132 or later
			b1=((Date)todaysSunset).getTime()
			c=((Date)tomorrowsSunrise).getTime()
			d=((Date)tomorrowsSunset).getTime()
		}catch(ignored){
			good=false
			Boolean agtr= a>nmnght
			Boolean bgtr= b>nmnght
			Long srSkew= getSkew(a,'Sunrise')
			Long ssSkew= getSkew(b,'Sunset')
			a1= agtr ? Math.round(a-dMSDAY-srSkew):a
			b1= bgtr ? Math.round(b-dMSDAY-ssSkew):b
			c= agtr ? a : Math.round(a+dMSDAY+srSkew)
			d= bgtr ? b : Math.round(b+dMSDAY+ssSkew)
		}
		Long c1=Math.round(c-dMSDAY)
		Long db1=Math.round(d-dMSDAY)
		t0=[
			sunrise: a,
			sunset:b,
			todayssunrise: a1,
			calcsunrise: (a>c1 ? a:c1),
			todayssunset:b1,
			calcsunset:(b>db1 ? b:db1),
			tomorrowssunrise: c,
			tomorrowssunset:d,
			updated: t,
			good: good,
			nextM: nmnght
		]
		if(!good) warn 'Please update HE firmware to improve time handling',rtD
		rtD.sunTimes=t0
		if(t!=lZ){
			svSunTFLD=t0
			mb()
			if(eric())log.debug "updating global sunrise ${t0}"
		}
	}
}

private Long getSunriseTime(Map rtD){
	initSunriseAndSunset(rtD)
	return (Long)rtD.sunTimes.sunrise
}

private Long getSunsetTime(Map rtD){
	initSunriseAndSunset(rtD)
	return (Long)rtD.sunTimes.sunset
}

private Long getNextSunriseTime(Map rtD){
	initSunriseAndSunset(rtD)
	return (Long)rtD.sunTimes.tomorrowssunrise
}

private Long getNextSunsetTime(Map rtD){
	initSunriseAndSunset(rtD)
	return (Long)rtD.sunTimes.tomorrowssunset
}

// This is trying to ensure to not fire sunsets or sunrises twice in same day by ensuring we fire a bit later than actual sunrise or sunset
Long getSkew(Long t4,String ttyp){
	Date t1=new Date(t4)
	Integer curMon=t1.month
	curMon=(BigDecimal)location.latitude>0.0 ? curMon:((curMon+i6)%12) // normalize for southern hemisphere
	Integer day=t1.date

	Integer addr
	Boolean shorteningDays= (curMon==i5 && day>20) || (curMon>i5 && !(curMon==11 && day>20))

	if( (shorteningDays && ttyp=='Sunset') || (!shorteningDays && ttyp=='Sunrise') ) addr=1000 // minimize skew when sunrise or sunset moving earlier in day
	else{
		Integer t2=Math.abs((BigDecimal)location.latitude).toInteger()
		Integer t3=curMon%i6
		Integer t5=(Integer)Math.round(t3*(365.0D/12.0D)+day).toInteger() // days into period
		addr=Math.round((t5>37 && t5<(182-37) ? t2*2.8D:t2*1.9D)*d1000).toInteger()
	}
	return addr.toLong()
}

private Long getMidnightTime(){
	return ((Date)timeToday('00:00',(TimeZone)location.timeZone)).getTime()
}

private Long getNextMidnightTime(){
	return ((Date)timeTodayAfter('23:59','00:00',(TimeZone)location.timeZone)).getTime()
}

private Long getNoonTime(){
	return ((Date)timeToday('12:00',(TimeZone)location.timeZone)).getTime()
}

private Long getNextNoonTime(){
	return ((Date)timeTodayAfter('23:59','12:00',(TimeZone)location.timeZone)).getTime()
}

private void getLocalVariables(Map rtD,Map atomState){
	rtD.localVars=[:]
	Map<String,Object> values=(Map<String,Object>)atomState.vars
	for(Map var in (List<Map>)rtD.piston.v){
//		if(eric())log.debug "getLocalVariables ${var}"
		String t=(String)var.t
		String n=(String)var.n
		def v=values[n]
		Map<String,Object> variable=[
			(sT):t,
			(sV):var.v!=null ? var.v: t.endsWith(sRB) ? (v instanceof Map ? v:[:]) : (matchCast(rtD,v,t) ? v:cast(rtD,v,t)),
			//f means fixed value; do not save this to the state
			f: !!var.v
		]
		if(var.v!=null && (String)var.a==sS && !t.endsWith(sRB))
			variable.v=evaluateExpression(rtD,(Map)evaluateOperand(rtD,null,(Map)var.v),t).v
		rtD.localVars[n]=variable
	}
//	if(eric())log.debug "getLocalVariables ${rtD.localVars}"
}

private Map<String,LinkedHashMap> getSystemVariablesAndValues(Map rtD){
	LinkedHashMap<String,LinkedHashMap> result=getSystemVariables()
	LinkedHashMap<String,LinkedHashMap<String,Object>> c=(LinkedHashMap<String,LinkedHashMap<String,Object>>)rtD.cachePersist
	rtD.args=c[sDOLARGS]
	for(variable in result){
		String keyt1=(String)variable.key
		if(variable.value.d!=null && (Boolean)variable.value.d) variable.value.v=getSystemVariableValue(rtD,keyt1)
		else if(c[keyt1]!=null)variable.value.v=c[keyt1].v
	}
	return result.sort{ (String)it.key }
}

// UI will not display anything that starts with $current or $previous; variables without d:true will not display variable value
private static LinkedHashMap<String,LinkedHashMap> getSystemVariables(){
	LinkedHashMap dynT=[(sT):sDYN,(sD):true]
	LinkedHashMap strT=[(sT):sSTR,(sD):true]
	LinkedHashMap strN=rtnMap(sSTR,null)
	LinkedHashMap intT=[(sT):sINT,(sD):true]
	LinkedHashMap dtimeT=[(sT):sDTIME,(sD):true]
	LinkedHashMap t=[:]
	String shsm=sDLR+sHSMSTS
	return [
		(sDOLARGS):t+dynT,
		(sDOLJSON):t+dynT,
		'$places':t+dynT,
		(sDOLRESP):t+dynT,
		'$nfl':t+dynT,
		'$weather':t+dynT,
		'$incidents':t+dynT,
		'$hsmTripped':[(sT):sBOOLN,(sD):true],
		(shsm):t+strT,
		(sHTTPCONTENT):t+strN,
		(sHTTPSTSCODE):rtnMap(sINT,null),
		(sHTTPSTSOK):rtnMap(sBOOLN,null),
		(sCURATTR):t+strN,
		(sCURDESC):t+strN,
		(sCURDATE):rtnMap(sDTIME,null),
		(sCURDELAY):rtnMap(sINT,null),
		(sCURDEV):rtnMap(sDEV,null),
		(sCURDEVINDX):rtnMap(sINT,null),
		(sCURPHYS):rtnMap(sBOOLN,null),
//		'$currentEventReceived':[(sT):sDTIME,(sV):null],
		(sCURVALUE):rtnMap(sDYN,null),
		(sCURUNIT):t+strN,
//		'$currentState':t+strN,
//		'$currentStateDuration':t+strN,
//		'$currentStateSince':rtnMap(sDTIME,null),
//		'$nextScheduledTime':rtnMap(sDTIME,null),
		'$name':t+strT,
		'$state':t+strT,
		(sDLLRDEVICE):rtnMap(sDEV,null),
		(sDLLRDEVS):rtnMap(sDEV,null),
		(sDLLRINDX):rtnMap(sDEC,null),
		(sIFTTTSTSCODE):rtnMap(sINT,null),
		(sIFTTTSTSOK):rtnMap(sBOOLN,null),
		'$location':rtnMap(sDEV,null),
		'$locationMode':t+strT,
		'$localNow':t+dtimeT,
		'$now':t+dtimeT,
		'$hour':t+intT,
		'$hour24':t+intT,
		'$minute':t+intT,
		'$second':t+intT,
		'$zipCode':t+strT,
		'$latitude':t+strT,
		'$longitude':t+strT,
		'$meridian':t+strT,
		'$meridianWithDots':t+strT,
		'$day':t+intT,
		'$dayOfWeek':t+intT,
		'$dayOfWeekName':t+strT,
		'$month':t+intT,
		'$monthName':t+strT,
		'$year':t+intT,
		'$midnight':t+dtimeT,
		'$noon':t+dtimeT,
		'$sunrise':t+dtimeT,
		'$sunset':t+dtimeT,
		'$nextMidnight':t+dtimeT,
		'$nextNoon':t+dtimeT,
		'$nextSunrise':t+dtimeT,
		'$nextSunset':t+dtimeT,
		'$time':t+strT,
		'$time24':t+strT,
		'$utc':t+dtimeT,
		'$mediaId':t+strT,
		'$mediaUrl':t+strT,
		'$mediaType':t+strT,
		'$mediaSize':t+intT,
		(sPEVATTR):t+strN,
		(sPEVDESC):t+strN,
		(sPEVDATE):rtnMap(sDTIME,null),
		(sPEVDELAY):rtnMap(sINT,null),
		(sPEVDEV):rtnMap(sDEV,null),
		(sPEVDEVINDX):rtnMap(sINT,null),
		(sPEVPHYS):rtnMap(sBOOLN,null),
//		'$previousEventExecutionTime':rtnMap(sINT,null),
//		'$previousEventReceived':rtnMap(sDTIME,null),
		(sPEVVALUE):rtnMap(sDYN,null),
		(sPEVUNIT):t+strN,
//		'$previousState':t+strN,
//		'$previousStateDuration':t+strN,
//		'$previousStateSince':rtnMap(sDTIME,null),
		'$random':[(sT):sDEC,(sD):true],
		'$randomColor':t+strT,
		'$randomColorName':t+strT,
		'$randomLevel':t+intT,
		'$randomSaturation':t+intT,
		'$randomHue':t+intT,
		'$temperatureScale':t+strT,
		'$tzName':t+strT,
		'$tzId':t+strT,
		'$tzOffset':t+intT,
		'$version':t+strT,
		'$versionH':t+strT
	] as LinkedHashMap<String,LinkedHashMap>
}

@SuppressWarnings('GroovyFallthrough')
private getSystemVariableValue(Map rtD,String name){
	String shsm=sDLR+sHSMSTS
	switch(name){
	case sDOLARGS: return "${rtD.args}".toString()
	case sDOLJSON: return "${rtD.json}".toString()
	case '$places': return "${rtD.settings?.places}".toString()
	case sDOLRESP: return "${rtD.response}".toString()
	case '$weather': return "${rtD.weather}".toString()
	case '$nfl': return "${rtD.nfl}".toString()
	case '$incidents': return "${rtD.incidents}".toString()
	case '$hsmTripped': return rtD.incidents instanceof List && ((List)rtD.incidents).size()>iZ
	case (shsm): return (String)location.hsmStatus
	case '$mediaId': return rtD.mediaId
	case '$mediaUrl': return (String)rtD.mediaUrl
	case '$mediaType': return (String)rtD.mediaType
	case '$mediaSize': return (rtD.mediaData!=null ? (Integer)rtD.mediaData.size():iZ)
	case '$name': return (String)app.label
	case '$state': return (String)rtD.state?.new
	case '$tzName': return ((TimeZone)location.timeZone).displayName
	case '$tzId': return ((TimeZone)location.timeZone).getID()
	case '$tzOffset': return ((TimeZone)location.timeZone).rawOffset
	case '$version': return sVER
	case '$versionH': return sHVER
	case '$localNow': //return (Long)localTime()
	case '$now':
	case '$utc': return (Long)now()
	case '$hour': Integer h=localDate().hours; return (h==iZ ? 12:(h>12 ? h-12:h))
	case '$hour24': return localDate().hours
	case '$minute': return localDate().minutes
	case '$second': return localDate().seconds
	case '$zipCode': return location.zipCode
	case '$latitude': return ((BigDecimal)location.latitude).toString()
	case '$longitude': return ((BigDecimal)location.longitude).toString()
	case '$meridian': Integer h=localDate().hours; return (h<12 ? 'AM':'PM')
	case '$meridianWithDots': Integer h=localDate().hours; return (h<12 ? 'A.M.':'P.M.')
	case '$day': return localDate().date
	case '$dayOfWeek': return localDate().day
	case '$dayOfWeekName': return weekDaysFLD[localDate().day]
	case '$month': return localDate().month+i1
	case '$monthName': return yearMonthsFLD[localDate().month+i1]
	case '$year': return localDate().year+1900
	case '$midnight': return getMidnightTime()
	case '$noon': return getNoonTime()
	case '$sunrise': return getSunriseTime(rtD)
	case '$sunset': return getSunsetTime(rtD)
	case '$nextMidnight': return getNextMidnightTime()
	case '$nextNoon': return getNextNoonTime()
	case '$nextSunrise': return getNextSunriseTime(rtD)
	case '$nextSunset': return getNextSunsetTime(rtD)
	case '$time': Date t=localDate(); Integer h=t.hours; Integer m=t.minutes; return ((h==iZ ? 12:(h>12 ? h-12:h))+sCOLON+(m<10 ? "0$m":"$m")+sSPC+(h<12 ? 'A.M.':'P.M.')).toString()
	case '$time24': Date t=localDate(); Integer h=t.hours; Integer m=t.minutes; return (h+sCOLON+(m<10 ? "0$m":"$m")).toString()
	case '$random':
		def tresult=getRandomValue(rtD,name)
		Double result
		if(tresult!=null)result=(Double)tresult
		else{
			result=(Double)Math.random()
			setRandomValue(rtD,name,result)
		}
		return result
	case '$randomColor':
		def tresult=getRandomValue(rtD,name)
		String result
		if(tresult!=null)result=(String)tresult
		else{
			result=(String)getRandomColor().rgb
			setRandomValue(rtD,name,result)
		}
		return result
	case '$randomColorName':
		def tresult=getRandomValue(rtD,name)
		String result
		if(tresult!=null)result=(String)tresult
		else{
			result=(String)getRandomColor().name
			setRandomValue(rtD,name,result)
		}
		return result
	case '$randomLevel':
		def tresult=getRandomValue(rtD,name)
		Integer result
		if(tresult!=null)result=(Integer)tresult
		else{
			result=Math.round(d100*Math.random()).toInteger()
			setRandomValue(rtD,name,result)
		}
		return result
	case '$randomSaturation':
		def tresult=getRandomValue(rtD,name)
		Integer result
		if(tresult!=null)result=(Integer)tresult
		else{
			result=Math.round(50.0D+50.0D*Math.random()).toInteger()
			setRandomValue(rtD,name,result)
		}
		return result
	case '$randomHue':
		def tresult=getRandomValue(rtD,name)
		Integer result
		if(tresult!=null)result=(Integer)tresult
		else{
			result=Math.round(360.0D*Math.random()).toInteger()
			setRandomValue(rtD,name,result)
		}
		return result
	case '$locationMode':return (String)location.getMode()
	case '$temperatureScale':return (String)location.getTemperatureScale()
	}
	return null
}

private static void setSystemVariableValue(Map rtD,String name,value,Boolean cachePersist=true){
	Map var=(Map)rtD.systemVars[name]
	if(var==null)return
	if(cachePersist && name in [sDOLARGS,sHTTPCONTENT,sHTTPSTSCODE,sHTTPSTSOK,sIFTTTSTSCODE,sIFTTTSTSOK]){
		LinkedHashMap<String,Map> c=(LinkedHashMap<String,Map>)rtD.cachePersist
		c[name]=([:]+var+[(sV):value])
		rtD.cachePersist=c
	}
	if(var.d!=null)return
	((Map)rtD.systemVars[name]).v=value
}

private static getRandomValue(Map rtD,String name){
	return rtD.temp.randoms[name]
}

private static void setRandomValue(Map rtD,String name,value){
	rtD.temp.randoms[name]=value
}

private static void resetRandomValues(Map rtD){
	rtD.temp=[randoms:[:]]
}

private Map getColorByName(String name){
	Map t1=getColors().find{ Map<String,Object> it -> (String)it.name==name }
	return t1
}

private Map getRandomColor(){
	Integer random=Math.round(Math.random()*(getColors().size()-i1)*d1).toInteger()
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

//uses i,p,t,m
private Map<String,Map<String,Object>> Attributes(){
	Map result=theAttributesFLD
	if(result==null){
		theAttributesFLD=(Map)parent.getChildAttributes()
		mb()
	}
	return theAttributesFLD
}

@Field static Map<String,Map> theComparisonsFLD

//uses p,t
private Map<String,Map<String,Map<String,Object>>> Comparisons(){
	Map result=theComparisonsFLD
	if(result==null){
		theComparisonsFLD=(Map)parent.getChildComparisons()
		mb()
	}
	return theComparisonsFLD
}

@Field static Map<String,Map> theVirtCommandsFLD

//uses o (override phys command),a (aggregate commands)
private Map<String,Map<String,Object>> VirtualCommands(){
	Map result=theVirtCommandsFLD
	if(result==null){
		theVirtCommandsFLD=(Map)parent.getChildVirtCommands()
		mb()
	}
	return theVirtCommandsFLD
}

//uses c and r
// the command r: is replaced with command c.
// If the VirtualCommand c exists and has o: true we will use that virtual command; otherwise it will be replaced with a physical command
@Field static final Map CommandsOverrides=[
		push:[c:"push",	s:null,r:"pushMomentary"],
		flash:[c:"flash",	s:null,r:"flashNative"] //flash native command conflicts with flash emulated command. Also needs "o" option on command described later
]

@Field static Map<String,Map> theVirtDevicesFLD

//uses ac,o
private Map<String,Map<String,Object>> VirtualDevices(){
	Map result=theVirtDevicesFLD
	if(result==null){
		theVirtDevicesFLD=(Map)parent.getChildVirtDevices()
		mb()
	}
	return theVirtDevicesFLD
}

@Field static Map<String,Map> thePhysCommandsFLD

//uses a,v
private Map<String,Map<String,Object>> PhysicalCommands(){
	Map result=thePhysCommandsFLD
	if(result==null){
		thePhysCommandsFLD=(Map)parent.getChildCommands()
		mb()
	}
	return thePhysCommandsFLD
}

@Field static List<Map> theColorsFLD

private List<Map<String,Object>> getColors(){
	List result=theColorsFLD
	if(result==null){
		theColorsFLD=(List)parent.getColors()
		mb()
	}
	return theColorsFLD
}

private static String sectionTitleStr(String title)	{ return '<h3>'+title+'</h3>' }
private static String inputTitleStr(String title)	{ return '<u>'+title+'</u>' }
//private static String pageTitleStr(String title)	{ return '<h1>'+title+'</h1>' }
//private static String paraTitleStr(String title)	{ return '<b>'+title+'</b>' }

private static String imgTitle(String imgSrc,String titleStr,String color=sNULL,Integer imgWidth=30,Integer imgHeight=iZ){
	String imgStyle=sBLK
	String myImgSrc='https://raw.githubusercontent.com/ady624/webCoRE/master/resources/icons/'+imgSrc
	imgStyle+= imgWidth>iZ ? 'width: '+imgWidth.toString()+'px !important;':sBLK
	imgStyle+= imgHeight>iZ ? imgWidth!=iZ ? sSPC:sBLK+'height:'+imgHeight.toString()+'px !important;':sBLK
	if(color!=sNULL){ return """<div style="color: ${color}; font-weight:bold;"><img style="${imgStyle}" src="${myImgSrc}"> ${titleStr}</img></div>""".toString() }
	else{ return """<img style="${imgStyle}" src="${myImgSrc}"> ${titleStr}</img>""".toString() }
}

static String myObj(obj){
	if(obj instanceof String){return 'String'}
	else if(obj instanceof Map){return 'Map'}
	else if(obj instanceof List){return 'List'}
	else if(obj instanceof ArrayList){return 'ArrayList'}
	else if(obj instanceof BigInteger){return 'BigInt'}
	else if(obj instanceof Long){return 'Long'}
	else if(obj instanceof Integer){return 'Int'}
	else if(obj instanceof Boolean){return 'Bool'}
	else if(obj instanceof BigDecimal){return 'BigDec'}
	else if(obj instanceof Double){return 'Double'}
	else if(obj instanceof Float){return 'Float'}
	else if(obj instanceof Byte){return 'Byte'}
	else{ return 'unknown'}
}

private static Boolean isWcDev(String dev){
	return (dev && dev.size()==34 && dev.startsWith(sCOLON) && dev.endsWith(sCOLON))
}

@SuppressWarnings('GroovyAssignabilityCheck')
Map<String,Object> fixHeGType(Boolean toHubV,String typ,v,String dtyp){
	Map ret=[:]
	def myv=v
	if(toHubV){ // from webcore(9 types) -> global(5 types + 3 overloads + sDYN becomes sSTR)
		//noinspection GroovyFallthrough
		switch(typ){
			case sINT:
				ret=[(sINT):v]
				break
			case sBOOLN:
				ret=[(sBOOLN):v]
				break
			case sDEC:
				ret=['bigdecimal':v]
				break
			case sDEV:
				// HE this is a List<String> -> String of words separated by a space (can split())
				List<String> dL= v instanceof List ? (List<String>)v:(v ? (List<String>)[v]:[])
				String res=sNULL
				Boolean ok=true
				dL.each{ String it->
					if(ok && isWcDev(it)){
						res= res ? res+sSPC+it:it
					} else ok=false
				}
				if(ok){
					ret=[(sSTR):res]
					break
				}
			case sDYN:
			case sSTR:
				ret=[(sSTR):v]
				break
			case sTIME:
				if(eric())log.warn "got time $v"
				Double aa
				Boolean fnd=false
				try{
					aa= v as Double
					fnd=true
				} catch(ignored){ }
				Long aaa= fnd ? aa.toLong() : ("$v".isNumber() ? v as Long: null)
				if(aaa!=null){
					if(aaa<lMSDAY && aaa>=lZ){
						Long t0=getMidnightTime()
						Long a1=t0+aaa
						TimeZone tz=(TimeZone)location.timeZone
						myv=a1+(tz.getOffset(t0)-tz.getOffset(a1))
						if(eric())log.warn "extended midnight time by $aaa +($t0) $myv"
					}else{
						Date t1=new Date(aaa)
						Long t2=Math.round((t1.hours*dSECHR+t1.minutes*d60+t1.seconds)*d1000)
						myv=t2
						if(eric())log.warn "strange time $aaa new myv is $myv"
					}
				} else if(eric()) warn "trying to convert nonnumber time"
			case sDATE:
			case sDTIME: //@@
				//if(eric())log.warn "found myv is $myv"
				Date nTime=new Date((Long)myv)
				String format="yyyy-MM-dd'T'HH:mm:ss.sssXX"
				SimpleDateFormat formatter=new SimpleDateFormat(format)
				formatter.setTimeZone((TimeZone)location.timeZone)
				String tt=formatter.format(nTime)
				if(eric())log.warn "found time tt is $tt"
				String[] t1=tt.split('T')

				if(typ==sDATE){
					// comes in long format should be string -> 2021-10-13T99:99:99:999-9999
					String t2=t1[iZ]+'T99:99:99:999-9999'
					ret=[(sDTIME):t2]
					break
				}
				if(typ==sTIME){
					//comes in long format should be string -> 9999-99-99T14:25:09.009-0700
					String t2='9999-99-99T'+t1[i1]
					ret=[(sDTIME):t2]
					break
				}
				//	if(typ==sDTIME){
				// this comes in long needs to be string -> 2021-10-13T14:25:09.009-0700
				ret=[(sDTIME):tt]
				break
				//	}
		}
	}else{ // from global(5 types + 3 overloads ) -> to webcore(8 (cannot restore sDYN)
		switch(typ){
			case sINT:
				ret=[(sINT):v]
				break
			case sBOOLN:
				ret=[(sBOOLN):v]
				break
				// these match
			case 'bigdecimal':
				ret=[(sDEC):v]
				break
			case sSTR:
				// if(dtyp==sDEV)
				List<String> dvL=[]
				Boolean ok=true
				String[] t1=((String)v).split(sSPC)
				t1.each{ String it ->
					// sDEV is a string in hub need to detect if it is really devices :xxxxx:
					if(ok && isWcDev(it)){
						dvL.push(it)
					} else ok=false
				}
				if(ok){ ret=[(sDEV):dvL]}
				else ret=[(sSTR):v]
				break
				// cannot really return a string to dynamic type here res=sDYN
			case sDTIME: // global times: everything is datetime -> these come in string and needs to be a long of appropriate type
				String iD=v
				String mtyp=sDTIME
				String res=v
				if(iD.endsWith("9999") || iD.startsWith("9999")){
					Date nTime=new Date()
					String format="yyyy-MM-dd'T'HH:mm:ss.sssXX"
					SimpleDateFormat formatter=new SimpleDateFormat(format)
					formatter.setTimeZone((TimeZone)location.timeZone)
					String tt= formatter.format(nTime)
					String[] mystart=tt.split('T')

					String[] t1= iD.split('T')

					if(iD.endsWith("9999")){
						mtyp=sDATE
						res= t1[iZ]+'T'+mystart[i1] // 00:15:00.000'+myend //'-9999'
					} else if(iD.startsWith("9999")){
						mtyp=sTIME
						// we are ignoring the -0000 offset at end and using our current one
						String withOutEnd=t1[i1][0..-6]
						String myend=tt[-5..-1]
						//if(eric())log.warn "tt: ${tt} myend: ${myend} iD: ${iD} mystart: ${mystart} withOutEnd: ${withOutEnd}"
						res= mystart[iZ]+'T'+withOutEnd+myend
					}
				}
				Date tt1=(Date)toDateTime(res)
				Long lres=tt1.getTime()
				if(mtyp==sTIME){
					Date m1=new Date(lres)
					Long m2=Math.round((m1.hours*dSECHR+m1.minutes*d60+m1.seconds)*d1000)
					//if(eric())log.warn "fixing $res $lres to $m2"
					lres=m2
				}
				//if(eric())log.warn "returning $lres"
				ret=[(mtyp):lres]
		}
	}
	return ret
}

private static String md5(String md5){
	MessageDigest md= MessageDigest.getInstance('MD5')
	byte[] array=md.digest(md5.getBytes())
	String result=sBLK
	Integer l=array.size()
	for(Integer i=iZ; i<l; ++i){
		result+=Integer.toHexString((array[i] & 0xFF)| 0x100).substring(1,3)
	}
	return result
}

@Field volatile static Map<String,Map<String,String>> theHashMapVFLD=[:]

static void clearHashMap(String wName){
	theHashMapVFLD[wName]=[:] as Map<String,String>
	theHashMapVFLD=theHashMapVFLD
}

private String sAppId(){
	return ((Long)app.id).toString()
}

private String hashId(id,Boolean updateCache=true){
	//enabled hash caching for faster processing
	String result
	String myId=id.toString()
	String wName= parent ? ((Long)parent.id).toString():sAppId()
	if(theHashMapVFLD[wName]==null) clearHashMap(wName)
	result=theHashMapVFLD[wName][myId]
	if(result==sNULL){
		result=sCOLON+md5('core.'+myId)+sCOLON
		theHashMapVFLD[wName][myId]=result
		theHashMapVFLD=theHashMapVFLD
		mb()
	}
	return result
}

@Field static Semaphore theMBLockFLD=new Semaphore(0)

// Memory Barrier
static void mb(String meth=sNULL){
	if(theMBLockFLD.tryAcquire()){
		theMBLockFLD.release()
	}
}
